package tje.chat.client; // 209����������, 291dsfseg ���⿡ ��ũ�ѱ�� �߰�(�����޼��� �����)

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;

import tje.chat.client.net.ClientBinarySocket;
import tje.chat.client.net.ClientSocket;
import tje.chat.client.net.UserSignThread;
import tje.chat.client.panel.*;
import tje.chat.common.ClientInfo;
import tje.chat.common.Packet;
import tje.chat.common.jdbc.UserDAO;
import tje.chat.common.jdbc.model.User;
import tje.chat.common.util.JDBCConnection;
import tje.chat.model.*;

public class ClientFrame extends JFrame {
	// �̳�Ŭ�������� �� Ŭ������ ����ʵ忡 �����ϱ� ���� ��å
	// �̳�Ŭ���������� �� Ŭ������ private ����� ������ �����ϴ�.
	private ClientFrame frame = this;
	
	// ȸ������ ���̾�α�
	private ClientSignInDialog SignDial = new ClientSignInDialog(this, "ȸ������");
	
	UserDAO dao = UserDAO.getInstance();
	
	// ���� ������ ���� ���� ��� �� File ��ü ����
	// ./�� �� Ŭ������ �������ִ� ��� ���ĸ� ����.
	private static final String CLIENT_DIR_PATH = "./client";
	private static final String SERVER_INFO_FILE_PATH = "server_info.dat";
	private static File CLIENT_DIR;
	private static File SERVER_INFO_SAVE_FILE;

	// �� ClientFrame ��ü�� �����ɶ� ���� �켱������ ����Ǵ� ���� ����.
	// ���������� �ʿ��� ��ΰ� �ִ��� Ȯ���ϰ� ������ �����ϸ� save.dat ���� ��ü ����
	static {
		CLIENT_DIR = new File(CLIENT_DIR_PATH);
		if (!CLIENT_DIR.exists())
			CLIENT_DIR.mkdirs();

		SERVER_INFO_SAVE_FILE = new File(CLIENT_DIR, SERVER_INFO_FILE_PATH);
	}
	
	// Ŭ���̾�Ʈ ���� Ŭ������ package tje.chat.client.net ������ Ŭ������
	// �ڱ� �ڽ��� ������(���� ����Ǵ� ������)�� ��������, ���ϰ� ��ü ��Ʈ���� ������ ���´�
	// ���� ���� Ŭ������ package tje.chat.model ������ Ŭ������ 
	// ip�� ��Ʈ��ȣ, ��Ī�� ������ ���� Ŭ�����̴�. 
	// ���� ���� Ŭ������ ����ȭ(Serializable)�� �ؾ��ϴµ�, �� ������ 
	// ��� �ʵ���� ��Ʈ��ũ�� ������ �� �ֵ��� ����ƮŸ������ ��ȯ�Ͽ� ��Ʈ���� �̿��� �� �ֵ��� �ϱ� �����̴�.
	private ClientSocket clientSocket;
	// ���� ������ ���� ���� ��ü
	private ClientBinarySocket clientBinarySocket;
	
	// ���õ� �����
	private String selectedChatIp;
	// ChatMessage Ŭ������ tje.chat.model ��Ű�� ������ Ŭ������
	// ��Ī�� ip, ���ϰ��� �ϴ� ��Ī�� ���۵� �޼����� history��� �̸��� ��̸���Ʈ�� �ʵ�� ���� Ŭ�����̴�.
	private HashMap<String, ChatMessage> chatMap = new HashMap<>();

	private NorthPanel np = new NorthPanel();
	private CenterPanel cp = new CenterPanel();

	public ClientFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Chat Client - Ver 0.1");

		// ȭ�� ��ġ
		this.setLayout(new BorderLayout(0, 10));
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);

		// ����� ������ Ȯ���� ��, ȭ�� ������Ʈ�� ���̳� ���¸� ����
		// ������ �����ϸ� �����Ͽ� �����س��� ���� ������ �ؽ�Ʈ�ʵ忡 �ε��Ѵ�.
		if (SERVER_INFO_SAVE_FILE.exists())
			loadServerInfo();

		// �޽��� Area ���� ����
		cp.getTaChatMsg().setEditable(false);
		cp.getTaNoticeMsg().setCaretPosition(cp.getTaChatMsg().getDocument().getLength());
		// �����޼��� Area ��� ����
		cp.getTaNoticeMsg().setEditable(false);
		
		// ������Ʈ���� �̺�Ʈ ó��
		// ȸ������ 1. ��ư �̺�Ʈ ó�� ( ���̾�α� â�� ���� )
		this.np.getBtSignIn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignDial.setVisible(true);
			}
		});
		// ȸ������ 2. ������ ������ �޾� id, pw�� �ʱ�ȭ
		SignDial.getBtSignConfirm().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = SignDial.getTfSignID().getText().trim();
				String pw = SignDial.getTfSignPW().getText().trim();
				User user = new User(id, pw);
				UserSignThread ust = new UserSignThread(user, np.getTfIP().getText(), frame);
				ust.start();
			}
		});
		
		// ����Ű�� ġ�� ���۵ǵ��� (�׼Ǹ������� �⺻�׼��� ����Ű�̴�) ( ��ưó���� �Ȱ����ڵ�� )
		this.cp.getTfSendMsg().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		
		// Ŭ���̾�Ʈ ���� ä���� ���� �޼��� ���� (��ưó��)
		this.cp.getBtSend().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		
		// �������� üũ�ڽ��� �̺�Ʈ ó��
		// �̳� Ŭ������ ���� ó���Ѵ�.
		np.getCbSaveInfo().addActionListener(new SaveClientInfoHanddler());
		
		// �����ư�� �̺�Ʈó��
		// Ŭ���̾�Ʈ ���� ä���� �����ϱ� ���� ����Ŭ�� �̺�Ʈó��
		this.cp.getTbAllClient().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				// ���� ���õ� ���� �ε����� ��ȯ
				int row = cp.getTbAllClient().getSelectedRow();
				if(row == -1)
					return;
				
				// test��
//				String msg = String.format("%s - %s ����", cp.getDtmAllClientModel().getValueAt(row, 0), cp.getDtmAllClientModel().getValueAt(row, 1));
//				JOptionPane.showMessageDialog(null, msg);
				
				// �ؽ��ʿ� Ŭ���� ����ڸ� �Է�
				String targetNickName = (String)cp.getDtmAllClientModel().getValueAt(row, 0);
				String targetIp = (String)cp.getDtmAllClientModel().getValueAt(row, 1);
				String msg = String.format("%s �԰� ��ȭ�� �����Ͻðڽ��ϱ�?", targetNickName);
				int r = JOptionPane.showConfirmDialog(frame, msg);
				if(r == JOptionPane.OK_OPTION) {
					
					// ������ �޼����� ���۵Ǵ� �κ�. ���⿡ 3��° �гο� �� �۾��� �ۼ��Ѵ�.
					if(!chatMap.containsKey(targetIp)) {
						ChatMessage cm = new ChatMessage(np.getTfID().getText(), targetIp, targetNickName);
						chatMap.put(targetIp, cm);
						
						// ���̺� �߰�
						Vector<String> rowData = new Vector<>();
						
						rowData.add(targetNickName);
						rowData.add(targetIp);
						rowData.add(cm.getHistory().get(0));
						
						cp.getDtmChatClientModel().addRow(rowData);
						
					}
					
					msg = String.format("%s �԰� ��ȭ�� �����մϴ�.", targetNickName);
					JOptionPane.showMessageDialog(null, msg);
					
					selectedChatIp = targetIp;
					
					changeChatContents(chatMap.get(targetIp));
				}
			}
		});
		
		// �α��� ��ư�� Ŭ���Ǵ� ��� ����Ǵ� �ڵ�
		// �͸�Ŭ������ ����Ͽ� �̺�Ʈó���� �Ѵ�.
		np.getBtConnect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("�α���")) {
					String strIP = np.getTfIP().getText().trim();
					String strPort = np.getTfPORT().getText().trim();
					String strID = np.getTfID().getText().trim();
					String strPW = np.getTfPassword().getText();
					
					// �ƹ��͵� �Է��� �ȵǾ����� ��
					if (strIP.length() == 0 || strPort.length() == 0 || strID.length() == 0 || strPW.length() == 0) {
						JOptionPane.showMessageDialog(null, "������ ��� �Է��ؾ߸� �մϴ�.");
						np.getCbSaveInfo().setSelected(false);
						return;
					}
					User user = new User(strID, strPW);
					// port ��ȣ�� ���ڿ����� ������ ��ȯ
					int nPort = Integer.parseInt(strPort);
					// Ŭ���̾�Ʈ�� ������ �����ϴ� ��ü ����
					ServerInfo serverInfo = new ServerInfo(strIP, nPort, strID, user);
					System.out.println("serverInfo ���� ����");
					// ����� Ŭ���̾�Ʈ ������ �������� Ŭ���̾�Ʈ ���ϰ�ü�� �����ϰ� ������ ����
					clientSocket = new ClientSocket(frame, serverInfo);
					clientSocket.start();
					
					// �������� �����ͼ����� ��ٸ��� ��ü������ ������ ����
					// ����ó���� ���� �ؾ���
					clientBinarySocket = new ClientBinarySocket(frame);
					clientBinarySocket.start();
					np.getBtConnect().setText("����");
					
					
//					// Ŀ�ؼ��� ���� �ȵ�..
//					Connection conn = JDBCConnection.getConnection();
//					if ( dao.login(conn, user) == 1 ) {
//						JOptionPane.showMessageDialog(null, "�α��� ���� !");
//					} else {
//						JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ȯ�����ּ���.");
//					}
					
				} else {
					np.getBtConnect().setText("����");
					clientSocket.close();
				}

				
			}
		});


		setSize(1300, 500);
		setVisible(true);
	}
	
	private void sendMsg() {
		String msg = cp.getTfSendMsg().getText().trim();
		if(msg.length() == 0) {
			JOptionPane.showMessageDialog(null, "�޼����� �Է��ؾ� �մϴ�.");
			return;
		} else if ( selectedChatIp == null ) {
			JOptionPane.showMessageDialog(null, "��ȭ ��븦 �����ؾ� �մϴ�.");
			return;
		}
		
		// �ؽ�Ʈ �ʵ忡 �ִ� ���� ���õ� ip�� Ű������ ���� chatMap�� chatMessage ���� history�� �����Ѵ�.
		String output = chatMap.get(selectedChatIp).addHistory(msg);
		cp.getTaChatMsg().append(output);
		// �޽��� Area ��ũ���� �ֱ� �Է��� �޼����� ���� ���� ������ �̵��ϴ� �ڵ�
		cp.getTaChatMsg().setCaretPosition(cp.getTaChatMsg().getDocument().getLength());
		
		String myNickName = np.getTfID().getText();				
		String myIp = null;
		int size = cp.getDtmAllClientModel().getRowCount();		
		// ���̺��� ��ȸ�ϸ� �ؽ�Ʈ�ʵ忡�� ������ ���� �г����̶� ���� ���� �����Ǹ� ������
		for( int i = 0 ; i < size ; i++ ) {
			String nickName = (String)cp.getDtmAllClientModel().getValueAt(i, 0);
			
			if( nickName.equals(myNickName) ) {
				myIp = (String)cp.getDtmAllClientModel().getValueAt(i, 1);						
				break;
			}
		}		
				
		// send �޼ҵ� ������ ���� ���� ������ �ʿ��ߴ�.
		clientSocket.send(selectedChatIp, output, myIp, myNickName);
		// ���� �� �������� �ؽ�Ʈ�ʵ带 ��ġ
		cp.getTfSendMsg().setText("");
		
		// ->�� �����ε����� ã�� 2ĭ ��(�޼����� ���ۺκ�)�� ������ �ؽ�Ʈ�� buf�� ��Ƽ�
		// �ش� ���̺��� ���� �����Ѵ�.
		String buf = output.substring(output.indexOf("->") + 2);
		updateChatTable(selectedChatIp, buf.trim());
	}
	//����������
	
	public void updateChatTable(String ip, String output) {
		int size = cp.getDtmChatClientModel().getRowCount();		
		// ���̺��� ��ȸ�ϸ� �ؽ�Ʈ�ʵ忡�� ������ �г����̶� ���� ���� �����Ǹ� ������
		for( int i = 0 ; i < size ; i++ ) {
			// ���� ���� ��� ip�� ������ 2��°�ݷ��̹Ƿ� 1
			String targetIp = (String)cp.getDtmChatClientModel().getValueAt(i, 1);
			// �����°� ���� �Է��Ѱſ� ������ i��° ���� 2��° �÷��� output���� �ٲ�ġ��
			if( ip.equals(targetIp) ) {
				cp.getDtmChatClientModel().setValueAt(output, i, 2);
				break;
			}
		}	
	}
	

	// ���嵵�� ���� ��ü�� �Է½�Ʈ������ �����ͼ� ServerInfo ��ü�� ��ȯ�Ͽ� ����� ip,port,��Ī�� 
	// �ؽ�Ʈ �ʵ� ĭ�� �ڵ����� �Է��س��� �޼ҵ�.
	private void loadServerInfo() {
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(SERVER_INFO_SAVE_FILE)))) {
			ServerInfo si = (ServerInfo) in.readObject();

			if (si == null)
				return;

			np.getTfIP().setText(si.getIp());
			np.getTfPORT().setText(si.getPort() + ""); // ���ڰ��̿��� �ٲ���
			np.getTfID().setText(si.getID());

			np.getCbSaveInfo().setSelected(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "������ �ε��ϴ� �������� ������ �߻��߽��ϴ�.");
		}
	}
	
	// ClientSocket ��ü�� ���Ǵ� �޼ҵ�.
	// ClientInfo(ip�� ��Ī, ���ӽð��� �ʵ�� ����) ��ü�� �����ϴ� �迭�� �޾ƿͼ�
	// Table�� ����� �޼ҵ��̴�.
	// �������� �޾ƿ��� ��ü( �������� ������ accept �Ǹ� ip�� Ŭ���̾�Ʈ���� ���� ��Ī, �ð��� ���۹޴´� )
	// �װ��� �������� Ŭ���̾�Ʈ�� ���̺� �� �Ӽ����� �߰��Ѵ�.
	public void setConnectedTable(ArrayList<ClientInfo> list) {
		
		// list�� �迭 ������ŭ ���鼭 
		// list�� �ִ� ������ ������ info�� �־��ְ�
		// �� info���� �г��Ӱ� ip, ������ �ð��� ���͹迭�� �־��ش�.
		// �� �� CenterPane�� �ִ� AllClient ���̺� rowData�� �־� ���̺��� �ϼ����ش�.
		for( ClientInfo info : list ) {
			Vector<String> rowData = new Vector<>();
			
			rowData.add(info.getID());
			rowData.add(info.getIp());
			rowData.add(info.getConnectedTime().toString());
			
			this.cp.getDtmAllClientModel().addRow(rowData);
		}
	}
	
	
	public void addConnectedTable(ClientInfo info) {
		Vector<String> rowData = new Vector<>();
		
		rowData.add(info.getID());
		rowData.add(info.getIp());
		rowData.add(info.getConnectedTime().toString());
		
		this.cp.getDtmAllClientModel().addRow(rowData);
	}
	
	public void delConnectedTable(ClientInfo info) {
		// ���� ������� ���̺��� ��� ��
		int size = this.cp.getDtmAllClientModel().getRowCount();
		
		// ip�� �������� ã�ƺ���.
		for(int i = 0 ; i < size ; i++) {
			// i�� 2���� �ִ� ip���� ��������
			String ip = (String)this.cp.getDtmAllClientModel().getValueAt(i, 1);
			
			if(ip.equals(info.getIp())) {
				this.cp.getDtmAllClientModel().removeRow(i);
				break;
			}
		}
	}
	
	// �����޼��� ���� �޾ƿ� ��Ŷ�����͸� ��Ʈ������ ��ȯ�Ͽ� append ��Ų��.
	public void addNoticeMessage(String msg) {
		
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss  : ");
		String output = String.format("%s%s\n", sdf.format(now), msg);
		
		this.cp.getTaNoticeMsg().append(output);
		// dsfseg ���⿡ ��ũ�ѱ�� �߰�(�����޼��� �����)
	}

	
	// chatMap�� ����� chatMessage�� history�� ����� �޼����� TextArea�� �߰�
	public void changeChatContents(ChatMessage cm) {
		
		ArrayList<String> history = cm.getHistory();
		// cp.getTaChatMsg().setText(""); ���� �� �ʿ�� ����.

		// ���� ��Ƽ������ȯ���� �ƴϹǷ� ���� ��Ʈ�����۸� ���ʿ�� ����.
		StringBuilder sb = new StringBuilder();
		for(String msg : history) {
			sb.append(msg);
		}
		
		cp.getTaChatMsg().setText(sb.toString());
		
	}
	
	// ��Ŷ���� �޾ƿ� �޼����� ���̺� �ش� ipŰ���� �����Ǵ� ������ ��ġ�� ��
	// �ؽ�Ʈ ���� append �Ѵ�.
	public void receiveMessage(String sourceIp, String sourceNickName, String msg) {
		
		// ��¥�� ����� ���� �ڵ� ( 3��° ���̺� )
		String buf = msg.substring(msg.indexOf("->") + 2);
		
		// ä�� ��Ͽ� �ִ��� Ȯ���� �� ���� �޼����� ����
		if( !chatMap.containsKey(sourceIp) ) {
			ChatMessage cm = new ChatMessage(np.getTfID().getText(), sourceIp, sourceNickName);
			cm.getHistory().add(msg);
			
			chatMap.put(sourceIp, cm);
			
			// ���̺� ���� �߰�
			Vector<String> rowData = new Vector<>();
			
			rowData.add(sourceNickName);
			rowData.add(sourceIp);
			rowData.add(buf.trim());
			
			cp.getDtmChatClientModel().addRow(rowData);
		} else {
			chatMap.get(sourceIp).getHistory().add(msg);
			updateChatTable(sourceIp, buf.trim());
		}
		
		if( selectedChatIp == null ) {
			selectedChatIp = sourceIp;
			// ���õ� ����� �������� �ٲ�.
			changeChatContents(chatMap.get(sourceIp));
			JOptionPane.showMessageDialog(null, String.format("%s ���� �޼����� �����߽��ϴ�.", sourceNickName));
		} else if( selectedChatIp.equals(sourceIp) ) {      // ���� ä������ ip�� ���
			cp.getTaChatMsg().append(msg);
		}
		
	}
	
	
	public static void main(String[] args) {
		new ClientFrame();
	}

	
	// ���������� üũ���� �� ����Ǵ� ������ Ŭ����
	class SaveClientInfoHanddler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// üũ�ڽ��� ������ �����Ǹ� ������ �����ϴ� ���ǹ�
			// üũ�ڽ��� ���õ��� �ʾҴٸ�
			if (!np.getCbSaveInfo().isSelected()) {
				// ������ �ִ��� Ȯ���ϰ� �ִٸ�
				if (SERVER_INFO_SAVE_FILE.exists())
					// ������ �����Ѵ�.
					SERVER_INFO_SAVE_FILE.delete();
				// ������ �ڿ� �����ߴٴ� ���̾�α׸� ���� ����������.
				JOptionPane.showMessageDialog(null, "����� ������ �����߽��ϴ�.");
				return;
			}

			// üũ�ڽ��� ���õǾ��ٸ� ������ �����ϴ� ���
			// Ʈ���� ���� ������ �����.
			// ��� ������ �ٲ� �� �����Ƿ� ���� tje.chat.model ��Ű���� ��
			String strIp = np.getTfIP().getText().trim();
			String strPort = np.getTfPORT().getText().trim();
			String strID = np.getTfID().getText().trim();

			// �ƹ��͵� �Է��� �ȵǾ����� ��
			if (strIp.length() == 0 || strPort.length() == 0 || strID.length() == 0) {
				JOptionPane.showMessageDialog(null, "������ ��� �Է��ؾ߸� �մϴ�.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}

			User user = new User(strID, "");
			// port ��ȣ�� ���ڿ����� ������ ��ȯ
			int nPort = Integer.parseInt(strPort);
			// Ŭ���̾�Ʈ�� ������ �����ϴ� ��ü ����
			// ������ �ʱ�ȭ�� strIp,strPort,strNickName ������ si ��ü�� �����Ѵ�.
			ServerInfo si = new ServerInfo(strIp, nPort, strID, user);

			// �Ʒ�ó�� try() ���� ��ȣ�ȿ� ��Ʈ���� �����ϸ� close�� �Ź� �����൵ ��
			// ��ü ��½�Ʈ���� �����Ͽ� SERVER_INFO_SAVE_FILE�� si�� ����� �������� �����ͷ� �����ϱ� ���� ��½�Ʈ��.
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(SERVER_INFO_SAVE_FILE)));) {
				// si ��ü�� ��½�Ʈ������ ����.
				out.writeObject(si);
			} catch (Exception ex) { // �ͼ��� �ϳ��θ� ����
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "���� ���� �������� ������ �߻��Ͽ����ϴ�.");
				np.getCbSaveInfo().setSelected(false);
				return;
			}
			JOptionPane.showMessageDialog(null, "���� ������ �Ϸ��߽��ϴ�.");
		}
	}


	public ClientSignInDialog getSignDial() {
		return SignDial;
	}

	public void setSignDial(ClientSignInDialog signDial) {
		SignDial = signDial;
	}
}
