package Chatting;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
	ServerSocket ss;
	Socket client;
	ArrayList<String> selectedFile = new ArrayList<String>();
	StartNotice sn;
	
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�п� ��ϵ� ����");
	Date now = cal.getTime();
	
	public Server_UI() {
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(10, 50));
		
		// ����� ����
		JPanel upperPane = new JPanel(new FlowLayout());
		// ��ܿ� �󺧰� �ؽ�Ʈ�ʵ�, ��ư ��ġ
		JLabel portNum = new JLabel("��Ʈ ��ȣ");
		portNum.setFont(new Font("����ü", Font.BOLD, 30));
		portText = new JTextField(30);
		// ���� �ʿ���
		//Server_Run_Clients sr = new Server_Run_Clients("ip�ּ�", Integer.parseInt(portText.getText()));
		startEnd = new JButton("����");
		startEnd.setFont(new Font("����ü", Font.BOLD, 30));
		ChangeListen change = new ChangeListen();
		startEnd.addActionListener(change);
		upperPane.add(portNum);
		upperPane.add(portText);
		upperPane.add(startEnd);
		
		// �ߴ��� ����
		JPanel midPane = new JPanel(new BorderLayout());
		noticeArea = new JTextArea();
		midPane.add(noticeArea);
		
		// �ϴ��� ����
		JPanel underPane = new JPanel(new GridLayout(2, 1, 1, 1));
		// üũ�ڽ��� �޼��� ��� �г� ����
		JPanel checkPane = new JPanel(new FlowLayout());
		logWrite = new JCheckBox("�α� �޼��� ���");
		logWrite.setFont(new Font("����ü", Font.BOLD, 30));
		CheckListen logListen = new CheckListen();
		logWrite.addItemListener(logListen);
		checkPane.add(logWrite);
		// ���� �޼��� ����
		JPanel noticePane = new JPanel(new BorderLayout());
		JLabel noticeLabel = new JLabel("�����޼���");
		noticeLabel.setFont(new Font("����ü", Font.BOLD, 30));
		noticeText = new JTextField();
		JPanel btnPane = new JPanel(new FlowLayout());
		noticeBtn = new JButton("����");
		noticeBtn.setFont(new Font("����ü", Font.BOLD, 30));
		ButtonListener send = new ButtonListener(noticeText, noticeArea, "����");
		noticeBtn.addActionListener(send);
		fileBtn = new JButton("���� ����");
		FileListener fileListen = new FileListener();
		fileBtn.addActionListener(fileListen);
		fileBtn.setFont(new Font("����ü", Font.BOLD, 30));
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
					e1.printStackTrace();
				}
			}
			else 
				sel = -1;
			}
		}
	
		
	
	class ChangeListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
//			noticeArea.setText(null);
			if(b.getText().equals("����")) {
				b.setText("����");
				port = Integer.parseInt(portText.getText());
				// ���� ��ư�� ������ �� ������ �����ϴ� ��ü ����
				sn = new StartNotice(port, noticeArea);
			}
			else {
				b.setText("����");
				noticeArea.setText("������ �����߽��ϴ�."); 
				try {
					ss.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new Server_UI();
	}
}
