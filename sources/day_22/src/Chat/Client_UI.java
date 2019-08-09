package Chat;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.Book;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client_UI extends JFrame {
	
	private Container clientPane;
	
	private JTextField ipText;
	private JTextField portText;
	private JTextField nickText;
	private JCheckBox remember;
	private JButton conBtn;
	private String [] saved = new String[3];
	private JButton msgOut;
	private JTextArea cliListArea;
	private JTextArea notice;
	
	private int cliPort, cliPort1;
	private String cliIp;
	private String cliNick;
//	private Socket socket;
	private InputStreamReader isr;
	
	private Client client;
//	private Client1 client1;
	
	Font f = new Font("볼드체", Font.BOLD, 30);
	Font f1 = new Font("볼드체", Font.PLAIN, 20);
	Font f2 = new Font("볼드체", Font.PLAIN, 25);
	
	public Client_UI() {
		setTitle("Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		clientPane = getContentPane();
		clientPane.setLayout(new BorderLayout(15, 30));
		
		// 상단의 구성 (보더의 북쪽)
		JPanel upperPane = new JPanel(new GridLayout(1, 5, 2, 2));
		upperPane.setBackground(Color.WHITE);
		JLabel serverInfo = new JLabel("서버 정보", JLabel.CENTER);
		serverInfo.setFont(f);
		// IP 정보
		JPanel ipPane = new JPanel(new FlowLayout());
		JLabel ip = new JLabel("IP", JLabel.CENTER);
		ip.setFont(f);
		// saved 배열에 저장된 정보가 있을 때 자동으로 불러와주기.
		ipText = new JTextField("192.168.0.68", 20);
		ipText.setFont(f1);
		ipPane.add(ip);			ipPane.add(ipText);
		// PORT 정보
		JPanel portPane = new JPanel(new FlowLayout());
		JLabel port = new JLabel("PORT", JLabel.CENTER);
		port.setFont(f);
		portText = new JTextField("5050", 20);
		portText.setFont(f1);
		portPane.add(port);		portPane.add(portText);
		// 닉네임 정보
		JPanel nickPane = new JPanel(new FlowLayout());
		JLabel nickName = new JLabel("닉네임", JLabel.CENTER);
		nickName.setFont(f);
		nickText = new JTextField("aa", 20);
		nickText.setFont(f1);
		nickPane.add(nickName);		nickPane.add(nickText);
		// 버튼과 정보 유지 정보
		JPanel btnPane = new JPanel(new FlowLayout());
		remember = new JCheckBox("정보 유지       ", false);
		RememberListen rememLi = new RememberListen();
		remember.addItemListener(rememLi);
		remember.setFont(f);
		conBtn = new JButton("연결");
		conBtn.setFont(f);
		ConnectListen connect = new ConnectListen();
		conBtn.addActionListener(connect);
		btnPane.add(remember);		btnPane.add(conBtn);		
		// 상단 팬에 추가
		upperPane.add(serverInfo);
		upperPane.add(ipPane);
		upperPane.add(portPane);
		upperPane.add(nickPane);
		upperPane.add(btnPane);
		
		// 하단의 구성 (보더의 센터)
		JPanel underPane = new JPanel(new GridLayout(1, 4, 15, 15));
		// 1번째 팬 (접속중인 클라이언트 목록)
		JPanel firstPane = new JPanel(new BorderLayout());
		JLabel listClient = new JLabel("접속중인 클라이언트 목록", JLabel.CENTER);
		listClient.setFont(f);
		cliListArea = new JTextArea();
		cliListArea.setFont(f2);
		cliListArea.setBackground(Color.PINK);
//		ConList cl = new ConList(cliListArea);
		firstPane.add(listClient, BorderLayout.NORTH);
		firstPane.add(cliListArea, BorderLayout.CENTER);
		// 2번째 팬 (공지 메세지 출력)
		JPanel secondPane = new JPanel(new BorderLayout());
		JLabel noticeOut = new JLabel("공지메세지 출력", JLabel.CENTER);
		noticeOut.setFont(f);
		notice = new JTextArea();
		notice.setFont(f2);
		notice.setBackground(Color.LIGHT_GRAY);
		secondPane.add(noticeOut, BorderLayout.NORTH);
		secondPane.add(notice, BorderLayout.CENTER);
		// 3번째 팬 (현재 대화방)
		JPanel thirdPane = new JPanel(new BorderLayout());
		JLabel listChat = new JLabel("현재 대화중인 목록", JLabel.CENTER);
		listChat.setFont(f);
		JList chatList = new JList();
		chatList.setFont(f2);
		chatList.setBackground(Color.PINK);
		thirdPane.add(listChat, BorderLayout.NORTH);
		thirdPane.add(chatList);
		// 4번째 팬 ( 채팅방 )
		JPanel fourthPane = new JPanel(new BorderLayout());
		JTextArea enteredChat = new JTextArea();
		JLabel nowChat = new JLabel("현재 접속중인 채팅방", JLabel.CENTER);
		nowChat.setFont(f);
		enteredChat.setFont(f1);
		enteredChat.setBackground(Color.LIGHT_GRAY);
		JPanel outPane = new JPanel(new FlowLayout());
		JTextField msgText = new JTextField(20);
		msgText.setFont(f1);
		msgOut = new JButton("전송");
//		ButtonListener send = new ButtonListener(msgText, enteredChat, nickText);
//		msgOut.addActionListener(send);
		msgOut.setFont(f);
		JButton fileOut = new JButton("파일 전송");
//		FileListener fileListen = new FileListener();
//		fileOut.addActionListener(fileListen);
		fileOut.setFont(f);
		outPane.add(msgText);
		outPane.add(msgOut);
		outPane.add(fileOut);
		fourthPane.add(nowChat, BorderLayout.NORTH);
		fourthPane.add(enteredChat, BorderLayout.CENTER);
		fourthPane.add(outPane, BorderLayout.SOUTH);
		// 하단 팬에 1,2,3,4 번째 팬 추가
		underPane.add(firstPane);
		underPane.add(secondPane);
		underPane.add(thirdPane);
		underPane.add(fourthPane);
		
		// 클라이언트 팬에 만들어놓은 팬을 추가
		clientPane.add(upperPane, BorderLayout.NORTH);
		clientPane.add(underPane, BorderLayout.CENTER);
		
		setSize(2600, 1300);
		setVisible(true);
	}
	
///////////////////////////////////////////////////////////////////////////////////////	
	
	// 정보유지 버튼을 눌렀을때 이벤트 처리
	class RememberListen implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				// 체크되었을 때 정보를 저장
				// 1. IP 저장
				saved[0] = ipText.getText();
				// 2. PORT 저장
				saved[1] = portText.getText();
				// 3. 닉네임 저장
				saved[2] = nickText.getText();
				// 저장한 문자 정보를 파일에 출력
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "savedInfo.txt");
				try {
					PrintWriter out = 
							new PrintWriter(
									new BufferedWriter(
											new FileWriter(file)), true);
					for(int i = 0 ; i < saved.length ; i++)
						out.printf("%s, ", saved[i]);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED) {
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "savedInfo.txt");
				file.delete();
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
	
	// 연결 버튼을 눌렀을 때 이벤트 처리
	class ConnectListen implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("연결")) {
				b.setText("종료");
				// 클라이언트 객체를 생성하여 스트림까지 생성
				cliIp = ipText.getText();
				cliPort = Integer.parseInt(portText.getText());
				cliPort1 = cliPort + 1010;
				cliNick = nickText.getText();
				client = new Client(cliIp, cliPort, cliNick);
				//client1 = new Client1(cliIp, cliPort1, cliNick);
				client.start();
				//client1.start();
				
			} else {
				b.setText("연결");
				try {
					client.br.close();				//client1.br.close();
					client.pw.close();				//client1.pw.close();
					client.socket.close();			//client1.socket.close();
				} catch (IOException e1) {
					notice.append("IOException e 발생. ConnectListen 객체의 이벤트 처리의 엘스 부분\n");
				}
				
			}
		}
	}
	
//	class Client1 extends Client {
//		private String cliIp, cliNick;
//		private int cliPort;
//		private BufferedReader br;
//		private PrintWriter pw;
//		private Socket socket;
//
//		Client1(String cliIp, int cliPort, String cliNick) {
//			super(cliIp, cliPort, cliNick);
//			this.cliIp = cliIp;
//			this.cliPort = cliPort;
//			this.cliNick = cliNick;
//			try {
//				socket = new Socket(cliIp, cliPort);
//			} catch (UnknownHostException e) {
//				JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
//				return;
//			} catch (IOException e) {
//				JOptionPane.showMessageDialog(null, "서버와 연결에 실패했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//			
//			try {
//				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
//			} catch (IOException e) {
//				cliListArea.append("IOException e 발생. Client 객체의 생성자 메소드 br,pw 부분\n");
//			}
//
//		}
//		
//		@Override
//		public void run() {
//			while(true) {
//				try {
//					// 서버의 소켓이 닫히면 출력에 null값이 들어오므로 인풋스트림에 null 이 반환된다.
//					String brCome = br.readLine();
//					if( brCome != null ) {
//						cliListArea.append(String.format("%s   :  %s\n", "접속자 IP : ", brCome));
//					} else if ( brCome == null ) {
//						break;
//					}
//
//				} catch (IOException e) {
//					cliListArea.append("IOException e 발생. Client 객체의 run()메소드 = 와일문을 빠져나감\n");
//					break;
//				}
//				}
//
//			
//			// 서버 소켓이 닫혔을 때 와일문을 빠져나와서 여기로 온다.
//			try {
//				br.close();
//				pw.close();
//				socket.close();
//				cliListArea.append("연결을 종료합니다.(서버가 종료)\n");
//			} catch (IOException e) {
//				cliListArea.append("IOException e 발생. Client 객체의 run() 메소드 하단\n");
//			}
//		}
//	}
	
	// 연결 버튼을 눌렀을 때 클라이언트 객체 처리
	class Client extends Thread {
		private String cliIp, cliNick;
		private int cliPort;
		private BufferedReader br;
		private PrintWriter pw;
		private Socket socket;
		
		Client(String cliIp, int cliPort, String cliNick) {
			this.cliIp = cliIp;
			this.cliPort = cliPort;
			this.cliNick = cliNick;
			try {
				socket = new Socket(cliIp, cliPort);
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "서버와 연결에 실패했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			try {
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
			} catch (IOException e) {
				notice.append("IOException e 발생. Client 객체의 생성자 메소드 br,pw 부분\n");
			}
//			li = new ListInput();
//			li.start();
			notice.append("서버 연결 성공\n");

		}
		
		public void run() {

			while(true) {
				try {
					// 서버의 소켓이 닫히면 출력에 null값이 들어오므로 인풋스트림에 null 이 반환된다.
					pw.println();
					String brCome = br.readLine();
					if( brCome != null ) {
						notice.append(String.format("%s   :  %s\n", "서버 공지", brCome));
					} else if ( brCome == null ) {
						notice.append("서버의 공지 대기중");
						break;
					}

				} catch (IOException e) {
					notice.append("IOException e 발생. Client 객체의 run()메소드 = 와일문을 빠져나감\n");
					break;
				}
				}
			
			// 서버 소켓이 닫혔을 때 와일문을 빠져나와서 여기로 온다.
			try {
				br.close();
				pw.close();
				socket.close();
				notice.append("연결을 종료합니다.(서버가 종료)\n");
			} catch (IOException e) {
				notice.append("IOException e 발생. Client 객체의 run() 메소드 하단\n");
			}
			
				
		}
	}


//////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new Client_UI();
	}
}
