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
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�п� ��ϵ� ����");
	Date now = cal.getTime();
	
	Font f = new Font("����ü", Font.BOLD, 30);
	Font f1 = new Font("����ü", Font.PLAIN, 30);
	Font f2 = new Font("����ü", Font.PLAIN, 25);
	
	public Server_UI() {
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 50));
		
		// ����� ����
		JPanel upperPane = new JPanel(new FlowLayout());
		// ��ܿ� �󺧰� �ؽ�Ʈ�ʵ�, ��ư ��ġ
		JLabel portNum = new JLabel("��Ʈ ��ȣ", JLabel.CENTER);
		portNum.setFont(f);
		portText = new JTextField("5050", 30);
		portText.setFont(f1);
		// ���� �ʿ���
		//Server_Run_Clients sr = new Server_Run_Clients("ip�ּ�", Integer.parseInt(portText.getText()));
		startEnd = new JButton("����");
		startEnd.setFont(f);
		StartListen change = new StartListen();
		startEnd.addActionListener(change);
		upperPane.add(portNum);
		upperPane.add(portText);
		upperPane.add(startEnd);
		
		// �ߴ��� ����
		JPanel midPane = new JPanel(new BorderLayout());
		noticeArea = new JTextArea();
		noticeArea.setEditable(false);
		noticeArea.setFont(f1);
		midPane.add(new JScrollPane(noticeArea));
		
		// �ϴ��� ����
		JPanel underPane = new JPanel(new GridLayout(2, 1, 1, 1));
		// üũ�ڽ��� �޼��� ��� �г� ����
		JPanel checkPane = new JPanel(new FlowLayout());
		logWrite = new JCheckBox("�α� �޼��� ���");
		logWrite.setFont(f);
		CheckListen logListen = new CheckListen();
		logWrite.addItemListener(logListen);
		checkPane.add(logWrite);
		// ���� �޼��� ����
		JPanel noticePane = new JPanel(new BorderLayout());
		JLabel noticeLabel = new JLabel("�����޼���", JLabel.CENTER);
		noticeLabel.setFont(f);
		noticeText = new JTextField();
		noticeText.setFont(f1);
		JPanel btnPane = new JPanel(new FlowLayout());
		noticeBtn = new JButton("����");
		noticeBtn.setFont(f);
		ButtonListener send = new ButtonListener(noticeText, noticeArea, "����");
		noticeBtn.addActionListener(send);
		fileBtn = new JButton("���� ����");
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
		
		// �����̳ʿ� ��� �ߴ� �ϴ� ���� ����
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
				// �α� �޼��� ����� üũ�Ǿ��� �� ���� ��θ� ����� txt�� �����.
				String dirPath = "D:\\dev\\java_se\\Chatting";
				File dir = new File(dirPath);
				if ( !dir.exists() ) {
					dir.mkdirs();
				}
				File file = new File(dir, "log.txt");
				// ����� ���� out��Ʈ��
				try {
					PrintWriter out = 
							new PrintWriter(
									new BufferedWriter(
											new FileWriter(file, true)), true);
					out.println("------------����----------------");
					out.println(noticeArea.getText());
					out.println(sdf.format(now));
					out.println("------------����----------------");
				} catch (IOException e1) {
					noticeArea.append("IOException e �߻�. CheckListen ��ü�� �̺�Ʈó�� if ���� if �κ�\n");
				}
			}
			else 
				sel = -1;
			}
		}
	
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Ŭ���̾�Ʈ ���ϰ� ��Ʈ���� ���� ��ü�� ArrayList�� �����ϴ� ��ü
	

	
	
	
//////////////////////////////////////////////////////////////////////////////////////////	
	
	// ������ ������ �Է��� ��Ʈ��ȣ�� ���� ���������� �����ϰ� ������ Ŭ���̾�Ʈ���� ��̸���Ʈ�� �����Ѵ�.
	class StartListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("����")) {
				b.setText("����");
				noticeArea.append("������ �����մϴ�.\n"); 
				port = Integer.parseInt(portText.getText());
				// ������ Ŭ���̾�Ʈ���� ������ ��̸���Ʈ�� �����ϴ� ��ü ����
				RunServer rs = new RunServer(port);
				rs.start();
//				ListOutput lo = new ListOutput();
				SendList sl = new SendList();
			}
			else {
				b.setText("����");
				try {
					ss.close();
				} catch (IOException e1) {
					noticeArea.append("IOException e �߻�. StartListen ��ü�� �̺�Ʈó�� else �κ�\n");
				}
				// ���� ���ϰ� ������ ��� �����
				
				CS.clearClient();
				noticeArea.append("������ �����߽��ϴ�.\n"); 
			}
		}
	}
	
	// �������� ����� ����ϴ� ��ü
	class SendList {
		
	}
	
	
	// ��Ʈ�� �Ű������� �޾ƿ� ������� Ŭ���̾�Ʈ ��ü���� �����Ѵ�.
	class RunServer extends Thread {
		private int port;
		private int port1;
		public String toString() {
			return String.format("����ڰ� ������ (���� %d ��)\n", CS.getClientSize());
		}
		
		RunServer(int port) {
			this.port = port;
			this.port1 = port + 1010;
			try {
				ss = new ServerSocket(this.port);
				//ss1 = new ServerSocket(this.port1);
			} catch (IOException e) {
				noticeArea.append("IOException e �߻�. RunServer ��ü�� ������ �κ�\n");
			}
		}
		
		public void run() {
			while(true) {
				try {
					client = ss.accept();
					//client1 = ss1.accept();
				} catch (IOException e) {
					noticeArea.append("IOException e �߻�. RunServer ��ü�� run() �κ� = ���Ϲ� ��������\n");
					break;
				}
				// Ŭ���̾�Ʈ ������ �����ɶ����� ��ü�� ���� ��̸���Ʈ�� ����
				clientInfo = new ClientSocketStr(client);
				//clientInfo1 = new ClientSocketStr(client1);
				//clientInfo1.start();
				if( !CS.checkClient(clientInfo) ) { // contains�޼ҵ�� equals�� ���� �������̵��ؾ���.
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
				noticeArea.append("IOException e �߻�. ClientSocketStr ��ü�� ������ �κ�\n");
			}
		}
		public void close() {
			try {
				socket.close();
			} catch (IOException e) {
				noticeArea.append("IOException e �߻�. ClientSocketStr ��ü�� close�޼ҵ� �κ�\n");
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
	
	// ���� ��ư�� ������ �� �̺�Ʈ ó��
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
			
			// ���� ��ư�� ���� �� ���� �ؽ�Ʈ ���� ���� ���� �߰�
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("����")) {
				// ���� ��ư�� ���� �� ���� �ؽ�Ʈ ���� ���� ���� �߰�
				Area.append(toString());
				// �ؽ�Ʈ �ʵ忡 ���� ���� Ŭ���̾�Ʈ�鿡�� ����
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
