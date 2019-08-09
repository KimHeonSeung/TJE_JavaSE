package tje.chat.server.net;

import java.net.*;

import javax.swing.JOptionPane;

import tje.chat.common.Packet;
import tje.chat.common.jdbc.model.User;
import tje.chat.server.ServerFrame;

import java.io.*;

// Ŭ���̾�Ʈ���� �����ϴ� �޼����� �����س��� ���� �����尡 �ʿ�
// Ŭ���̾�Ʈ�� ���ϰ� ip, nickname, ��Ʈ���� �����ϴ� ��ü�̴�.
public class ClientSocket extends Thread {
	// ������������ ��������
	private ServerFrame frame;
	// Ŭ���̾�Ʈ ������ ��������
	private Socket socket;
	// Ŭ���̾�Ʈ�� ip �ּ�
	private String ip;
	// Ŭ���̾�Ʈ ��Ī
	private String ID;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	private User inUser;
	
	// �� �����ӿ��� socket�� ip�� �ʱ�ȭ.
	public ClientSocket(ServerFrame frame, Socket client, User user) {
		this.frame = frame;
		this.socket = client;
		this.inUser = user;
		this.ip = this.socket.getInetAddress().getHostAddress();
		
		//this.frame.writeLog(ip + " ����");
	}
	
	// �Ȱ��� ip�� �ι� ������ ��Ʈ���� �ѹ��� ��������� ���� ������.
	// �׷��� Ŭ���̾�Ʈ�ʰ��� �� �ٸ��� ��Ʈ������
	public void initStream(ObjectInputStream ois) {
		try {
			// ������Ʈ �ƿ�ǲ ��Ʈ�� ���� �ƿ�ǲ��Ʈ�� �����ϰ� �ٷ� �÷��ø� �����. �����ʵ� ��������
			System.out.println("initstream ����");
			out = new ObjectOutputStream(
					new BufferedOutputStream(this.socket.getOutputStream()));
			this.in = ois;
			out.flush();

			this.ID = this.inUser.getId();
			// �α� ���
			this.frame.writeLog(ip + " / " + ID +  " �� ����");
			// ���� ������ ��� Ŭ���̾�Ʈ ����� ����
			out.writeObject(ClientSaver.getInfo_list());
			out.flush();
			
		} catch (Exception e) {
			this.socket = null;
			this.frame.writeLog(ip + " / " + ID +  " �԰� ���ӿ� ������ �߻��߽��ϴ�.");
			return;
		}
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public User getInUser() {
		return inUser;
	}

	public void setInUser(User inUser) {
		this.inUser = inUser;
	}

	public void close() {
		try {
			this.socket.close();
			this.frame.writeLog(ip + " ���� ����");
		} catch (IOException e) {
			this.frame.writeLog(ip + " ���� ���� �������� ������ �߻��Ͽ����ϴ�.");
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof ClientSocket) )
			return false;
		
		ClientSocket target = (ClientSocket) obj;
		boolean flag = this.ip.equals(target.ip);
		
		return flag;
	}
	
	// �� Ŭ���̾�Ʈ�鿡�� �޼����� ������ ���.
	public void send(Packet packet) {
		try {
			this.out.writeObject(packet);
			this.out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		if(this.socket == null) {
			ClientSaver.delete(this);
			return;
		}
		while(true) {
			
			Packet packet = null;
			try {
				// Ŭ���̾�Ʈ�� ����� �Է¹޴� �������� �� �� �ִ�.
				// ���ܰ� �߻��ϰų�(������ ����), �ΰ��� �Էµɶ�
				packet = (Packet)this.in.readObject();
				
				if(packet == null)
					// Ŭ���̾�Ʈ�� ���� ����
					break;
				
				// ������ ó��
				switch( packet.getPacketType() ) {
					case Packet.TYPE_CLIENT_MSG:
						BroadCaster.broadCast(packet, packet.getTargetIp());
						break;
				}
				
			} catch (Exception e) {
				// ���⼭ ���ܰ� �߻��ѰŴ� Ŭ���̾�Ʈ�ʿ��� ������ ���ų� �� �׷�����.
				break;
				
			}
			
		}
		ClientSaver.delete(this);
		this.frame.writeLog(ip + " ���� ����");
	}
}
