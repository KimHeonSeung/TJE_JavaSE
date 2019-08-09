package tje.chat.client.net;

import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.*;

import tje.chat.client.ClientFrame;
import tje.chat.common.ClientInfo;
import tje.chat.common.Packet;
import tje.chat.model.*;

public class ClientSocket extends Thread {
	private ClientFrame frame;
	private ServerInfo serverInfo;
	private Socket socket;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ClientSocket(ClientFrame frame, ServerInfo serverInfo) {
		this.frame = frame;
		this.serverInfo = serverInfo;
		
		try {			
			this.socket = new Socket(serverInfo.getIp(), serverInfo.getPort());
			
			out = new ObjectOutputStream(
					new BufferedOutputStream(this.socket.getOutputStream()));
			out.flush();
			
			in = new ObjectInputStream(
					new BufferedInputStream(this.socket.getInputStream()));	
			
			out.writeObject(this.serverInfo.getNickName());		
			out.flush();			
			
			JOptionPane.showMessageDialog(null, "서버와 연결되었습니다.");
			
			ArrayList<ClientInfo> connected_list = (ArrayList<ClientInfo>)in.readObject();			
			this.frame.setConnectedTable(connected_list);
			
		} catch (Exception e) {
			this.socket = null;
			JOptionPane.showMessageDialog(null, "서버와 연결 과정에서 문제가 발생했습니다.");
			return;
		}
	}
	
	public void send(String targetIp, Object data, String sourceIp, String sourceNickName) {
		Packet packet = new Packet(
				Packet.TYPE_CLIENT_MSG, data, targetIp, sourceIp, sourceNickName);
		
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
			Packet packet = null;
			try {
				packet = (Packet)in.readObject();
				
				switch( packet.getPacketType() ) {
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
						this.frame.receiveMessage(
								packet.getSourceIp(), packet.getSourceNickName(), 
								(String)packet.getPacketData());
						break;
				}
				
			} catch ( Exception e ) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "서버의 데이터 수신중 문제가 발생했습니다.");
				break;
			}
		}
	}
	
	public void close() {
		try {
			this.socket.close();
			JOptionPane.showMessageDialog(null, "서버와 연결이 종료 되었습니다.");
		} catch (IOException e) {			
			JOptionPane.showMessageDialog(null, "서버와 종료 과정에서 문제가 발생했습니다.");
		}
	}
}












