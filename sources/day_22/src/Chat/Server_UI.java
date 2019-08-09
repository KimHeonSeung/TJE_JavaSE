package Chat;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server_UI extends JFrame {
	public int port;
	
	Container contentPane;
	JTextField portText;
	JButton startEnd;
	JTextArea noticeArea;
	JCheckBox logWrite;
	JButton noticeBtn;
	JButton fileBtn;
	JTextField noticeText;
	ServerSocket ss, ss1;
	Socket client, client1;
	BufferedReader br;
	PrintWriter pw;
	PrintWriter listWriter;
	ClientSocketStr clientInfo, clientInfo1;
	ArrayList<String> selectedFile = new ArrayList<String>();
	
//	ArrayList<ClientSocketStr> ClientSockets = new ArrayList<ClientSocketStr>();
//	StartNotice sn;
	
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분에 기록된 내용");
	Date now = cal.getTime();
	
	Font f = new Font("볼드체", Font.BOLD, 30);
	Font f1 = new Font("볼드체", Font.PLAIN, 30);
	Font f2 = new Font("볼드체", Font.PLAIN, 25);
	
	public Server_UI() {
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 50));
		
		// 상단의 구성
		JPanel upperPane = new JPanel(new FlowLayout());
		// 상단에 라벨과 텍스트필드, 버튼 배치
		JLabel portNum = new JLabel("포트 번호", JLabel.CENTER);
		portNum.setFont(f);
		portText = new JTextField("5050", 30);
		portText.setFont(f1);
		// 수정 필요함
		//Server_Run_Clients sr = new Server_Run_Clients("ip주소", Integer.parseInt(portText.getText()));
		startEnd = new JButton("시작");
		startEnd.setFont(f);
		StartListen change = new StartListen();
		startEnd.addActionListener(change);
		upperPane.add(portNum);
		upperPane.add(portText);
		upperPane.add(startEnd);
		
		// 중단의 구성
		JPanel midPane = new JPanel(new BorderLayout());
		noticeArea = new JTextArea();
		noticeArea.setEditable(false);
		noticeArea.setFont(f1);
		midPane.add(new JScrollPane(noticeArea));
		
		// 하단의 구성
		JPanel underPane = new JPanel(new GridLayout(2, 1, 1, 1));
		// 체크박스와 메세지 출력 패널 생성
		JPanel checkPane = new JPanel(new FlowLayout());
		logWrite = new JCheckBox("로그 메세지 출력");
		logWrite.setFont(f);
		CheckListen logListen = new CheckListen();
		logWrite.addItemListener(logListen);
		checkPane.add(logWrite);
		// 공지 메세지 전송
		JPanel noticePane = new JPanel(new BorderLayout());
		JLabel noticeLabel = new JLabel("공지메세지", JLabel.CENTER);
		noticeLabel.setFont(f);
		noticeText = new JTextField();
		noticeText.setFont(f1);
		JPanel btnPane = new JPanel(new FlowLayout());
		noticeBtn = new JButton("전송");
		noticeBtn.setFont(f);
		ButtonListener send = new ButtonListener(noticeText, noticeArea, "서버");
		noticeBtn.addActionListener(send);
		fileBtn = new JButton("파일 전송");
//		FileListener fileListen = new FileListener();
//		fileBtn.addActionListener(fileListen);
		fileBtn.setFont(f);
		btnPane.add(noticeBtn);
		btnPane.add(fileBtn);
		noticePane.add(noticeLabel, BorderLayout.WEST);
		noticePane.add(noticeText);
		noticePane.add(btnPane, BorderLayout.EAST);
		underPane.add(checkPane);
		underPane.add(noticePane);
		
		// 컨테이너에 상단 중단 하단 팬을 삽입
		contentPane.add(upperPane, BorderLayout.NORTH);
		contentPane.add(midPane, BorderLayout.CENTER);
		contentPane.add(underPane, BorderLayout.SOUTH);
		
		setSize(1300, 800);
		setVisible(true);
	}
	
	
	class CheckListen implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int sel = -1;
			if(e.getStateChange() == ItemEvent.SELECTED) {
				sel = 1;
				// 로그 메세지 출력이 체크되었을 때 파일 경로를 만들고 txt를 만든다.
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "log.txt");
				// 출력을 위한 out스트림
				try {
					PrintWriter out = 
							new PrintWriter(
									new BufferedWriter(
											new FileWriter(file, true)), true);
					out.println("------------시작----------------");
					out.println(noticeArea.getText());
					out.println(sdf.format(now));
					out.println("------------종료----------------");
				} catch (IOException e1) {
					noticeArea.append("IOException e 발생. CheckListen 객체의 이벤트처리 if 속의 if 부분\n");
				}
			}
			else 
				sel = -1;
			}
		}
	
//////////////////////////////////////////////////////////////////////////////////////////
	
	// 클라이언트 소켓과 스트림을 가진 객체를 ArrayList로 관리하는 객체
	

	
	
	
//////////////////////////////////////////////////////////////////////////////////////////	
	
	// 시작을 누르면 입력한 포트번호를 통해 서버소켓을 생성하고 접속한 클라이언트들을 어레이리스트로 저장한다.
	class StartListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("시작")) {
				b.setText("종료");
				noticeArea.append("서버를 시작합니다.\n"); 
				port = Integer.parseInt(portText.getText());
				// 접속한 클라이언트들의 소켓을 어레이리스트에 저장하는 객체 생성
				RunServer rs = new RunServer(port);
				rs.start();
//				ListOutput lo = new ListOutput();
				SendList sl = new SendList();
			}
			else {
				b.setText("시작");
				try {
					ss.close();
				} catch (IOException e1) {
					noticeArea.append("IOException e 발생. StartListen 객체의 이벤트처리 else 부분\n");
				}
				// 서버 소켓과 정보를 모두 지우기
				
				CS.clearClient();
				noticeArea.append("서버를 종료했습니다.\n"); 
			}
		}
	}
	
	// 접속중인 목록을 출력하는 객체
	class SendList {
		
	}
	
	
	// 포트를 매개변수로 받아와 스레드로 클라이언트 객체들을 생성한다.
	class RunServer extends Thread {
		private int port;
		private int port1;
		public String toString() {
			return String.format("사용자가 접속함 (현재 %d 명)\n", CS.getClientSize());
		}
		
		RunServer(int port) {
			this.port = port;
			this.port1 = port + 1010;
			try {
				ss = new ServerSocket(this.port);
				//ss1 = new ServerSocket(this.port1);
			} catch (IOException e) {
				noticeArea.append("IOException e 발생. RunServer 객체의 생성자 부분\n");
			}
		}
		
		public void run() {
			while(true) {
				try {
					client = ss.accept();
					//client1 = ss1.accept();
				} catch (IOException e) {
					noticeArea.append("IOException e 발생. RunServer 객체의 run() 부분 = 와일문 빠져나감\n");
					break;
				}
				// 클라이언트 소켓이 생성될때마다 객체를 만들어서 어레이리스트에 저장
				clientInfo = new ClientSocketStr(client);
				//clientInfo1 = new ClientSocketStr(client1);
				//clientInfo1.start();
				if( !CS.checkClient(clientInfo) ) { // contains메소드는 equals를 통해 오버라이딩해야함.
					CS.addClient(clientInfo);
					noticeArea.append(toString());
				} 
//				if( !CS.checkClient(clientInfo1) ) {
//					CS.addClient(clientInfo1);
//				}
			}
		}
	}
	
	class ClientSocketStr extends Thread {
		private Socket socket;
		private PrintWriter pw;
		ClientSocketStr(Socket socket) {
			this.socket = socket;
			try {
				this.pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			} catch (IOException e) {
				noticeArea.append("IOException e 발생. ClientSocketStr 객체의 생성자 부분\n");
			}
		}
		public void close() {
			try {
				socket.close();
			} catch (IOException e) {
				noticeArea.append("IOException e 발생. ClientSocketStr 객체의 close메소드 부분\n");
			}
		}
		
		public String getID() {
			return socket.getInetAddress().getHostAddress();
		}
		
		public Socket getSocket() {
			return socket;
		}
		
		public void run() {
			for(int i = 0 ; i < CS.getClientSize() ; i++)
				this.pw.println(CS.getSocket(i).getLocalAddress().getHostAddress());
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 전송 버튼을 눌렀을 때 이벤트 처리
	class ButtonListener implements ActionListener {
		
		private JTextField Field;
		private JTextArea Area;
		private String nick;

		ButtonListener(JTextField Field, JTextArea Area, JTextField nick) {
			this.Field = Field;
			this.Area = Area;
			this.nick = nick.getText();
		}
		
		ButtonListener(JTextField Field, JTextArea Area, String nick) {
			this.Field = Field;
			this.Area = Area;
			this.nick = nick;
		}
		
		public String toString() {
			return String.format("%s   :  %s\n", this.nick, Field.getText());
		}
		

		public void actionPerformed(ActionEvent e) {
			
			// 전송 버튼이 눌릴 때 마다 텍스트 에어리어에 적힌 글을 추가
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("전송")) {
				// 전송 버튼이 눌릴 때 마다 텍스트 에어리어에 적힌 글을 추가
				Area.append(toString());
				// 텍스트 필드에 적힌 글을 클라이언트들에게 전송
				SendToClients stc = new SendToClients(noticeText);
				stc.start();
				}
			}
		}
	
	class SendToClients extends Thread {
		private JTextField Field;
		//private PrintWriter pw;
		
		SendToClients(JTextField Field) {
			this.Field = Field;
		}
		
		public void run() {
				for(int i = 0 ; i < CS.getClientSize() ; i++) {
					CS.getClient(i).pw.println(noticeText.getText());
				Field.setText("");
			}
		}
	}

	
		
	
	
/////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		new Server_UI();
	}
}
