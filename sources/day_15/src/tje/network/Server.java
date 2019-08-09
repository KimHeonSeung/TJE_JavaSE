package tje.network;

import java.net.*;
import java.io.*;

class Receiver extends Thread {
	private Socket socket;
	private BufferedReader in;
	
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			this.in = 
					new BufferedReader(
						new InputStreamReader(
							this.socket.getInputStream()));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void run() {
		String msg = null;
		while(true) {
			try {
				msg = this.in.readLine();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
			if( msg.equals("bye") )
				break;
			
			System.out.printf("%s ���� �޼��� : %s\n", 
					this.socket.getInetAddress().getHostAddress(), msg);
		}
		System.out.printf("%s���� ������ ����Ǿ����ϴ�.\n", 
				this.socket.getInetAddress().getHostAddress());
	}	
}
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(5555);
		
		System.out.println("���α׷� ����");
		
		while(true) {
			Socket client = ss.accept();
			new Receiver(client).start();
		}
	}
}