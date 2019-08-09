package server;

import java.net.*;
import java.io.*;

public class Client {
	private Socket socket;
	private String host;
	private PrintWriter out;
	private BufferedReader in;
	private ClientMessageReceiver receiver;
	
	public Client(Socket socket) {
		this.socket = socket;
		this.host = this.socket.getInetAddress().getHostAddress();
		
		try {
			this.out = 
					new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(
											this.socket.getOutputStream())), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.in = 
					new BufferedReader(
							new InputStreamReader(
									this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void activate() {
		this.receiver = new ClientMessageReceiver(this, this.host, this.in);
		this.receiver.start();
	}
	
	public void send(String msg) {
		this.out.println(msg);
	}
	
	public void close() {
		try {
			this.socket.close();
			this.out.close();
			this.in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof Client) )
			return false;
		
		Client target = (Client)obj;
		boolean flag = this.host.equals(target.host);
		
		return flag;
	}
	
	public String getHost() {
		return this.host;
	}
	
}
