package tje.chat.client.net;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.*;

import tje.chat.client.ClientFrame;
import tje.chat.common.ClientInfo;
import tje.chat.common.Packet;
import tje.chat.common.jdbc.model.User;
import tje.chat.model.*;


// ip�� ��Ʈ��ȣ, ��Ī�� ������ ���� Ŭ�����̴�. 
// ���� ���� Ŭ������ ����ȭ(Serializable)�� �ؾ��ϴµ�, �� ������ 
// ��� �ʵ���� ��Ʈ��ũ�� ������ �� �ֵ��� ����ƮŸ������ ��ȯ�Ͽ� ��Ʈ���� �̿��� �� �ֵ��� �ϱ� �����̴�.
public class ClientSocket extends Thread {
	private ClientFrame frame;
	private ServerInfo serverInfo;
	private Socket socket;
	private User user;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public ClientSocket(ClientFrame frame, ServerInfo serverInfo) {
		this.frame = frame;
		this.serverInfo = serverInfo;
		this.user = serverInfo.getUser();
		try {
			// Ŭ���̾�Ʈ���� ������Ʈ �ƿ�ǲ ��Ʈ�� ���� �ƿ�ǲ��Ʈ������ �����ϰ� �ٷ� �÷��ø� �����. �����ʵ� ��������
			// �� ������ serverInfo�� �ִ� ip�� ��Ʈ��ȣ�� �ʵ带 �ʱ�ȭ�Ѵ�.
			this.socket = new Socket(serverInfo.getIp(), serverInfo.getPort());
			System.out.println("ClientSocket�� ���� ���� �Ϸ�");
			out = new ObjectOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
			System.out.println("out �����Ϸ�");
			out.writeObject(this.user);
			out.flush();
			System.out.println("user�� out�� ���޿Ϸ� (ClientSocket �κ�)");
			
			in = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));
			System.out.println("in ���� �Ϸ�");
			// ������ �����ͺ��̽��� user ������ �ִ��� Ȯ���ϱ� ���� user�� ���� ���� �����ش�..

			JOptionPane.showMessageDialog(null, "������ ����Ǿ����ϴ�");
			
			// ������ ����Ÿ���� �޾ƿ´�.
			// ������ ���� Ÿ���� ������ Ŭ���̾�Ʈ�� ip�� �г���, ���ӵ� �ð��� �����ϴ� ��ü�̴�.
			// �������� �޾ƿ��� ��ü( �������� ������ accept �Ǹ� ip�� Ŭ���̾�Ʈ���� ���� ��Ī, �ð��� ���۹޴´� )
			// �װ��� �������� Ŭ���̾�Ʈ�� ���̺� �� �Ӽ����� �߰��Ѵ�.
			ArrayList<ClientInfo> connected_list = (ArrayList<ClientInfo>)in.readObject();
			
			this.frame.setConnectedTable(connected_list);
			
		} catch (Exception e) {
			this.socket = null;
			JOptionPane.showMessageDialog(null, "������ ���� �������� ������ �߻��߽��ϴ�.");
			return;
		}
	}
	
	// ������ �����带 ���� �ʿ䰡 ����. �޴°Ÿ� �ʿ�
	// �޼����� ���� ���� Ŭ���̾�Ʈ�鿡�� �����°Ŵ�.
	public void send(String targetIp, Object data, String sourceIp, String sourceID) {
		Packet packet = new Packet(Packet.TYPE_CLIENT_MSG, data, targetIp, sourceIp, sourceID);
		try {
			this.out.writeObject(packet);
			this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		if( this.socket == null )
			return;
		
		while(true) {
			try {
				// ��Ŷ�� ������ ���� �� ���� ����.
				Packet packet = (Packet)in.readObject();
				
				switch(packet.getPacketType()) {
					case Packet.TYPE_NOTICE: 
						this.frame.addNoticeMessage((String)packet.getPacketData());
						break;
					case Packet.TYPE_NEW_CLIENT:
						this.frame.addConnectedTable((ClientInfo)packet.getPacketData());
						break;
					case Packet.TYPE_DISCONECT_CLIENT:
						this.frame.delConnectedTable((ClientInfo)packet.getPacketData());
						break;
					case Packet.TYPE_CLIENT_MSG:
						this.frame.receiveMessage(packet.getSourceIp(), packet.getSourceID(), (String)packet.getPacketData());
						break;
				}
				
				
			} catch (Exception e) {
				//e.printStackTrace();
				//JOptionPane.showMessageDialog(null, "���������� ������ ������ �߻��߽��ϴ�.");
				break;
			}
		}
	}
	
	

	public void close() {
		try {
			this.socket.close();
			JOptionPane.showMessageDialog(null, "������ ����Ǿ����ϴ�");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "������ ���� �������� ������ �߻��߽��ϴ�.");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
