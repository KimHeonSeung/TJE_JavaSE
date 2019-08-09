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
	
	Font f = new Font("����ü", Font.BOLD, 30);
	Font f1 = new Font("����ü", Font.PLAIN, 20);
	Font f2 = new Font("����ü", Font.PLAIN, 25);
	
	public Client_UI() {
		setTitle("Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		clientPane = getContentPane();
		clientPane.setLayout(new BorderLayout(15, 30));
		
		// ����� ���� (������ ����)
		JPanel upperPane = new JPanel(new GridLayout(1, 5, 2, 2));
		upperPane.setBackground(Color.WHITE);
		JLabel serverInfo = new JLabel("���� ����", JLabel.CENTER);
		serverInfo.setFont(f);
		// IP ����
		JPanel ipPane = new JPanel(new FlowLayout());
		JLabel ip = new JLabel("IP", JLabel.CENTER);
		ip.setFont(f);
		// saved �迭�� ����� ������ ���� �� �ڵ����� �ҷ����ֱ�.
		ipText = new JTextField("192.168.0.68", 20);
		ipText.setFont(f1);
		ipPane.add(ip);			ipPane.add(ipText);
		// PORT ����
		JPanel portPane = new JPanel(new FlowLayout());
		JLabel port = new JLabel("PORT", JLabel.CENTER);
		port.setFont(f);
		portText = new JTextField("5050", 20);
		portText.setFont(f1);
		portPane.add(port);		portPane.add(portText);
		// �г��� ����
		JPanel nickPane = new JPanel(new FlowLayout());
		JLabel nickName = new JLabel("�г���", JLabel.CENTER);
		nickName.setFont(f);
		nickText = new JTextField("aa", 20);
		nickText.setFont(f1);
		nickPane.add(nickName);		nickPane.add(nickText);
		// ��ư�� ���� ���� ����
		JPanel btnPane = new JPanel(new FlowLayout());
		remember = new JCheckBox("���� ����       ", false);
		RememberListen rememLi = new RememberListen();
		remember.addItemListener(rememLi);
		remember.setFont(f);
		conBtn = new JButton("����");
		conBtn.setFont(f);
		ConnectListen connect = new ConnectListen();
		conBtn.addActionListener(connect);
		btnPane.add(remember);		btnPane.add(conBtn);		
		// ��� �ҿ� �߰�
		upperPane.add(serverInfo);
		upperPane.add(ipPane);
		upperPane.add(portPane);
		upperPane.add(nickPane);
		upperPane.add(btnPane);
		
		// �ϴ��� ���� (������ ����)
		JPanel underPane = new JPanel(new GridLayout(1, 4, 15, 15));
		// 1��° �� (�������� Ŭ���̾�Ʈ ���)
		JPanel firstPane = new JPanel(new BorderLayout());
		JLabel listClient = new JLabel("�������� Ŭ���̾�Ʈ ���", JLabel.CENTER);
		listClient.setFont(f);
		cliListArea = new JTextArea();
		cliListArea.setFont(f2);
		cliListArea.setBackground(Color.PINK);
//		ConList cl = new ConList(cliListArea);
		firstPane.add(listClient, BorderLayout.NORTH);
		firstPane.add(cliListArea, BorderLayout.CENTER);
		// 2��° �� (���� �޼��� ���)
		JPanel secondPane = new JPanel(new BorderLayout());
		JLabel noticeOut = new JLabel("�����޼��� ���", JLabel.CENTER);
		noticeOut.setFont(f);
		notice = new JTextArea();
		notice.setFont(f2);
		notice.setBackground(Color.LIGHT_GRAY);
		secondPane.add(noticeOut, BorderLayout.NORTH);
		secondPane.add(notice, BorderLayout.CENTER);
		// 3��° �� (���� ��ȭ��)
		JPanel thirdPane = new JPanel(new BorderLayout());
		JLabel listChat = new JLabel("���� ��ȭ���� ���", JLabel.CENTER);
		listChat.setFont(f);
		JList chatList = new JList();
		chatList.setFont(f2);
		chatList.setBackground(Color.PINK);
		thirdPane.add(listChat, BorderLayout.NORTH);
		thirdPane.add(chatList);
		// 4��° �� ( ä�ù� )
		JPanel fourthPane = new JPanel(new BorderLayout());
		JTextArea enteredChat = new JTextArea();
		JLabel nowChat = new JLabel("���� �������� ä�ù�", JLabel.CENTER);
		nowChat.setFont(f);
		enteredChat.setFont(f1);
		enteredChat.setBackground(Color.LIGHT_GRAY);
		JPanel outPane = new JPanel(new FlowLayout());
		JTextField msgText = new JTextField(20);
		msgText.setFont(f1);
		msgOut = new JButton("����");
//		ButtonListener send = new ButtonListener(msgText, enteredChat, nickText);
//		msgOut.addActionListener(send);
		msgOut.setFont(f);
		JButton fileOut = new JButton("���� ����");
//		FileListener fileListen = new FileListener();
//		fileOut.addActionListener(fileListen);
		fileOut.setFont(f);
		outPane.add(msgText);
		outPane.add(msgOut);
		outPane.add(fileOut);
		fourthPane.add(nowChat, BorderLayout.NORTH);
		fourthPane.add(enteredChat, BorderLayout.CENTER);
		fourthPane.add(outPane, BorderLayout.SOUTH);
		// �ϴ� �ҿ� 1,2,3,4 ��° �� �߰�
		underPane.add(firstPane);
		underPane.add(secondPane);
		underPane.add(thirdPane);
		underPane.add(fourthPane);
		
		// Ŭ���̾�Ʈ �ҿ� �������� ���� �߰�
		clientPane.add(upperPane, BorderLayout.NORTH);
		clientPane.add(underPane, BorderLayout.CENTER);
		
		setSize(2600, 1300);
		setVisible(true);
	}
	
///////////////////////////////////////////////////////////////////////////////////////	
	
	// �������� ��ư�� �������� �̺�Ʈ ó��
	class RememberListen implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				// üũ�Ǿ��� �� ������ ����
				// 1. IP ����
				saved[0] = ipText.getText();
				// 2. PORT ����
				saved[1] = portText.getText();
				// 3. �г��� ����
				saved[2] = nickText.getText();
				// ������ ���� ������ ���Ͽ� ���
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
	
	// ���� ��ư�� ������ �� �̺�Ʈ ó��
	class ConnectListen implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("����")) {
				b.setText("����");
				// Ŭ���̾�Ʈ ��ü�� �����Ͽ� ��Ʈ������ ����
				cliIp = ipText.getText();
				cliPort = Integer.parseInt(portText.getText());
				cliPort1 = cliPort + 1010;
				cliNick = nickText.getText();
				client = new Client(cliIp, cliPort, cliNick);
				//client1 = new Client1(cliIp, cliPort1, cliNick);
				client.start();
				//client1.start();
				
			} else {
				b.setText("����");
				try {
					client.br.close();				//client1.br.close();
					client.pw.close();				//client1.pw.close();
					client.socket.close();			//client1.socket.close();
				} catch (IOException e1) {
					notice.append("IOException e �߻�. ConnectListen ��ü�� �̺�Ʈ ó���� ���� �κ�\n");
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
//				JOptionPane.showMessageDialog(null, "������ ã�� �� �����ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
//				return;
//			} catch (IOException e) {
//				JOptionPane.showMessageDialog(null, "������ ���ῡ �����߽��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//			
//			try {
//				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
//			} catch (IOException e) {
//				cliListArea.append("IOException e �߻�. Client ��ü�� ������ �޼ҵ� br,pw �κ�\n");
//			}
//
//		}
//		
//		@Override
//		public void run() {
//			while(true) {
//				try {
//					// ������ ������ ������ ��¿� null���� �����Ƿ� ��ǲ��Ʈ���� null �� ��ȯ�ȴ�.
//					String brCome = br.readLine();
//					if( brCome != null ) {
//						cliListArea.append(String.format("%s   :  %s\n", "������ IP : ", brCome));
//					} else if ( brCome == null ) {
//						break;
//					}
//
//				} catch (IOException e) {
//					cliListArea.append("IOException e �߻�. Client ��ü�� run()�޼ҵ� = ���Ϲ��� ��������\n");
//					break;
//				}
//				}
//
//			
//			// ���� ������ ������ �� ���Ϲ��� �������ͼ� ����� �´�.
//			try {
//				br.close();
//				pw.close();
//				socket.close();
//				cliListArea.append("������ �����մϴ�.(������ ����)\n");
//			} catch (IOException e) {
//				cliListArea.append("IOException e �߻�. Client ��ü�� run() �޼ҵ� �ϴ�\n");
//			}
//		}
//	}
	
	// ���� ��ư�� ������ �� Ŭ���̾�Ʈ ��ü ó��
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
				JOptionPane.showMessageDialog(null, "������ ã�� �� �����ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "������ ���ῡ �����߽��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			try {
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
			} catch (IOException e) {
				notice.append("IOException e �߻�. Client ��ü�� ������ �޼ҵ� br,pw �κ�\n");
			}
//			li = new ListInput();
//			li.start();
			notice.append("���� ���� ����\n");

		}
		
		public void run() {

			while(true) {
				try {
					// ������ ������ ������ ��¿� null���� �����Ƿ� ��ǲ��Ʈ���� null �� ��ȯ�ȴ�.
					pw.println();
					String brCome = br.readLine();
					if( brCome != null ) {
						notice.append(String.format("%s   :  %s\n", "���� ����", brCome));
					} else if ( brCome == null ) {
						notice.append("������ ���� �����");
						break;
					}

				} catch (IOException e) {
					notice.append("IOException e �߻�. Client ��ü�� run()�޼ҵ� = ���Ϲ��� ��������\n");
					break;
				}
				}
			
			// ���� ������ ������ �� ���Ϲ��� �������ͼ� ����� �´�.
			try {
				br.close();
				pw.close();
				socket.close();
				notice.append("������ �����մϴ�.(������ ����)\n");
			} catch (IOException e) {
				notice.append("IOException e �߻�. Client ��ü�� run() �޼ҵ� �ϴ�\n");
			}
			
				
		}
	}


//////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new Client_UI();
	}
}
