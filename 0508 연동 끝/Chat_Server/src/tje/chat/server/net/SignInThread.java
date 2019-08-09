package tje.chat.server.net;


import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.*;

import javax.swing.JOptionPane;

import tje.chat.common.util.*;
import tje.chat.common.ClientInfo;
import tje.chat.common.jdbc.UserDAO;
import tje.chat.common.jdbc.model.User;

public class SignInThread extends Thread {
	public static final int PORT = 50150;
	private ServerSocket ss;
	UserDAO dao = UserDAO.getInstance();
	
	Socket signSocket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	User user;

	String id;
	String pw;
	
	public SignInThread() {
		try {
			this.ss = new ServerSocket(PORT);
		} catch (IOException e) {
			this.ss = null;
		}
	}
	
	public void run() {
		if (this.ss == null) {
			return;
		}
		
		// ���� ������ ���� ���������� ��ٸ���.
		while(true) {
			System.out.println("ȸ������ ������ ù�κ�  (SignInThread run �κ�)");
			try {
				signSocket = this.ss.accept();
				ois = 
					new ObjectInputStream(
							new BufferedInputStream(
									signSocket.getInputStream()));
				try {
					user = (User)ois.readObject();
					id = user.getId();
					pw = user.getPw();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					user = null;
					id = null;
					pw = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				user = null;
				id = null;
				pw = null;
			}
			
			System.out.println("ȸ������ ������ ois ��Ʈ�� ���� ����");
			
			Connection conn = JDBCConnection.getConnection();
			// ������ ���� ��ü�� ���� database�� ���̵� Ȯ���ϰ� ���޼����� �����ְų� ������ �Ѵ�.
			// ��Ʈ���� ���� �����
			try {
				oos = 
						new ObjectOutputStream(
								new BufferedOutputStream(
										signSocket.getOutputStream()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			// 1. �̹� ����� ID���� üũ�� ����� �Ҹ�Ÿ������ ��ȯ
			boolean idExist = dao.isIdExist(conn, id);
			// �����Ѵٸ� ��� �޼����� �Ѱ��ְ�, �������� �ʴ´ٸ� ���̺� �߰��ѵ� �Ϸ�޼����� �Ѱ��ش�.
			if( idExist ) {
					String idExistMessage = "ȸ������ ��� : ���� ( �ߺ��� ID )";
					try {
						oos.writeObject(idExistMessage);
						oos.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
			} else if ( !idExist ) {
				dao.insert(conn, user);
				String completeSign = "ȸ������ ��� : ���� !";
				try {
					oos.writeObject(completeSign);
					oos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				oos.close();
				signSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close() {
		try {
			this.ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
