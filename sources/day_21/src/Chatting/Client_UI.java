package Chatting;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.*;

import Chatting.Client_UI.Client.NoticeReceiverThread;

public class Client_UI extends JFrame {
	
	Container clientPane;
	
	JTextField ipText;
	JTextField portText;
	JTextField nickText;
	JCheckBox remember;
	JButton conBtn;
	String [] saved = new String[3];
	JButton msgOut;
	JTextArea cliListArea;
	JTextArea notice;
	
	int cliPort;
	String cliIp;
	String cliNick;
	Socket socket;
	InputStreamReader isr;
	public ArrayList<String> msgArray;
	
	Client client;
	
	public Client_UI() {
		setTitle("Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		clientPane = getContentPane();
		clientPane.setLayout(new BorderLayout(15, 30));
		
		// ����� ���� (������ ����)
		JPanel upperPane = new JPanel(new GridLayout(1, 5, 2, 2));
		JLabel serverInfo = new JLabel("���� ����");
		serverInfo.setFont(new Font("����ü", Font.BOLD, 30));
		// IP ����
		JPanel ipPane = new JPanel(new FlowLayout());
		JLabel ip = new JLabel("IP");
		ip.setFont(new Font("����ü", Font.BOLD, 30));
		// saved �迭�� ����� ������ ���� �� �ڵ����� �ҷ����ֱ�.
		ipText = new JTextField(saved[0], 20);
//		ipText = new JTextField(20);
		ipPane.add(ip);			ipPane.add(ipText);
		// PORT ����
		JPanel portPane = new JPanel(new FlowLayout());
		JLabel port = new JLabel("PORT");
		port.setFont(new Font("����ü", Font.BOLD, 30));
		portText = new JTextField(20);
		portPane.add(port);		portPane.add(portText);
		// �г��� ����
		JPanel nickPane = new JPanel(new FlowLayout());
		JLabel nickName = new JLabel("�г���");
		nickName.setFont(new Font("����ü", Font.BOLD, 30));
		nickText = new JTextField(20);
		nickPane.add(nickName);		nickPane.add(nickText);
		// ��ư�� ���� ���� ����
		JPanel btnPane = new JPanel(new FlowLayout());
		remember = new JCheckBox("���� ����       ", false);
		RememberListen rememLi = new RememberListen();
		remember.addItemListener(rememLi);
		remember.setFont(new Font("����ü", Font.BOLD, 30));
		conBtn = new JButton("����");
		conBtn.setFont(new Font("����ü", Font.BOLD, 30));
		ChangeListen change = new ChangeListen();
		conBtn.addActionListener(change);
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
		JLabel listClient = new JLabel("�������� Ŭ���̾�Ʈ ���");
		listClient.setFont(new Font("����ü", Font.BOLD, 30));
		cliListArea = new JTextArea();
		ConList cl = new ConList(cliListArea);
		firstPane.add(listClient, BorderLayout.NORTH);
		firstPane.add(cliListArea, BorderLayout.CENTER);
		// 2��° �� (���� �޼��� ���)
		JPanel secondPane = new JPanel(new BorderLayout());
		JLabel noticeOut = new JLabel("�����޼��� ���");
		noticeOut.setFont(new Font("����ü", Font.BOLD, 30));
		notice = new JTextArea();
		secondPane.add(noticeOut, BorderLayout.NORTH);
		secondPane.add(notice, BorderLayout.CENTER);
		// 3��° �� (���� ��ȭ��)
		JPanel thirdPane = new JPanel(new BorderLayout());
		JLabel listChat = new JLabel("���� ��ȭ���� ���");
		listChat.setFont(new Font("����ü", Font.BOLD, 30));
		JList chatList = new JList();
		thirdPane.add(listChat);
		thirdPane.add(chatList);
		// 4��° �� ( ä�ù� )
		JPanel fourthPane = new JPanel(new BorderLayout());
		JTextArea enteredChat = new JTextArea();
		JPanel outPane = new JPanel(new FlowLayout());
		JTextField msgText = new JTextField(20);
		msgOut = new JButton("����");
		ButtonListener send = new ButtonListener(msgText, enteredChat, nickText);
		msgOut.addActionListener(send);
		msgOut.setFont(new Font("����ü", Font.BOLD, 30));
		JButton fileOut = new JButton("���� ����");
		FileListener fileListen = new FileListener();
		fileOut.addActionListener(fileListen);
		fileOut.setFont(new Font("����ü", Font.BOLD, 30));
		outPane.add(msgText);
		outPane.add(msgOut);
		outPane.add(fileOut);
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
		
		setSize(800, 1300);
		setVisible(true);
	}
	
	
	
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
	
	class ChangeListen implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("����")) {
				b.setText("����");
				// Ŭ���̾�Ʈ ��ü�� �����Ͽ� ��Ʈ������ ����
				cliIp = ipText.getText();
				cliPort = Integer.parseInt(portText.getText());
				cliNick = nickText.getText();
				client = new Client(cliIp, cliPort, cliNick);
				
				// ���� �޼����� ���
				for(int i = 0 ; i < msgArray.size() ; i++) {
					notice.append(msgArray.get(i));
				}
				
				// cliListArea �������� Ŭ���̾�Ʈ ���
				
				
			}
			else
				b.setText("����");
		}
	}
	
	// �̳�Ŭ���� Ȱ��
	
	class Client extends Thread {
		private String ip, nick, host;
		private int port;
		private Socket socket;
		private BufferedReader socket_in;
		private PrintWriter socket_out;
		public NoticeReceiverThread nrt;

		Client(String ip, int port, String nick) {
			this.ip = ip;
			this.port = port;
			this.nick = nick;
			this.host = this.socket.getInetAddress().getHostAddress();

			try {
				socket = new Socket(ip, port);
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "������ ã�� �� �����ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "������ ���ῡ �����߽��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
				return;
			}

			try {
				socket_out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

				socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			} catch (IOException e) {
				e.printStackTrace();
			}

			nrt = new NoticeReceiverThread("����", socket_in);
			

		}
		
		class NoticeReceiverThread extends Thread{
			private String title;
			private BufferedReader in;
			
			
			public NoticeReceiverThread(String title, BufferedReader in) {
				this.in = in;
				this.title = title;
			}
			public void run() {
				String msg;
				while(true) {
					try {
						while( (msg = in.readLine()) != null ) {
							msgArray.add(msg);
						}

					} catch (IOException e) {
						break;
					}
				}
				try {
					this.in.close();
				} catch (IOException e) {
					System.out.println("�Է� ��Ʈ�� ����������� ���ܰ� �߻��߽��ϴ�.");
				}
			}
			
			public ArrayList getList() {
				return msgArray;
			}
		}
		
	}

	public static void main(String[] args) {
		new Client_UI();
	}
}
