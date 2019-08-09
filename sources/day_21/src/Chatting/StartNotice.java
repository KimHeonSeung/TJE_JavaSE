package Chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import javax.swing.*;

public class StartNotice extends Thread {
	private int port;
	private ServerSocket ss;
	private Socket serverSocket;
	private JTextArea Area;
	private BufferedReader socket_in;
	private ClientList CLIST;
	private String noticeMsg;
	
	public StartNotice(int port, JTextArea Area) {
		this.port = port;
		this.Area = Area;
		try {
			ss = new ServerSocket(port);
			serverSocket = ss.accept();
			CLIST.addClient(new ClientSocket(serverSocket));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		noticeMsg = Area.getText();
		if( CLIST.getClientSize() > 0) {
			for(int i = 0 ; i < CLIST.getClientSize() ; i++) {
				CLIST.getClient(i).send(noticeMsg);
			}
		}
	}

}
