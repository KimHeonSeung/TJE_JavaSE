package tje.chat.server.net.regist;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;

import tje.chat.server.ServerFrame;

import tje.jdbc.util.*;
import tje.jdbc.model.*;
import tje.jdbc.dao.*;


public class RegistClientCollector extends Thread {
	public static final int REGIST_PORT = 7777;
	// ���� �������� ��������
	private ServerFrame frame;
	// ���� ���� ����
	private ServerSocket server;
	
	public RegistClientCollector(ServerFrame frame) {
		this.frame = frame;
		
		try {
			this.server = new ServerSocket(REGIST_PORT);
		} catch (IOException e) {	
			this.server = null;
			this.frame.noticeServerError();
			return;
		}
		
		this.frame.writeLog("ȸ�������� ���� ���� ������ �Ϸ�Ǿ����ϴ�.");
	}
	
	public void run() {
		if( this.server == null ) {
			this.frame.writeLog("ȸ������ ���� ���� - run ���� �κ�");
			return;
		}
		
		while( true ) {
			Socket client = null;
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			Connection conn = null;
			try {
				client = this.server.accept();
				
				out = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
				out.flush();
				
				in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

				Member member = (Member)in.readObject();
				
				conn = JDBCConnection.getConnection();
				
				MemberDAO dao = MemberDAO.getInstance();
				
				Member result = dao.select(conn, member);				
				
				String strAck = "";
				if( result == null ) {
					
					if( dao.insert(conn, member) == 1 )
						strAck = String.format("%s ������ ȸ�������� �Ϸ�Ǿ����ϴ�.", member.getId());
					else 
						strAck = "ȸ�����Կ� �����߽��ϴ�.(�Է������� Ȯ��)";
						
				} else
					strAck = "ȸ�����Կ� �����߽��ϴ�.(���̵� �ߺ�)";
				
				out.writeObject(strAck);
				out.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
				//break;
			} finally {
				
				try {
					in.close();
					out.close();
					client.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}				
				
				JDBCObjectManager.close(conn);
			}
		}
		
		
		//this.frame.writeLog("���� ���� - run ���� �κ�");
	}
	
	public void close() {
		try {
			this.server.close();
			this.frame.writeLog("���� ���ᰡ �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			this.frame.writeLog("���� ���ῡ�� ������ �߻��Ͽ����ϴ�.");
		}
	}
}










