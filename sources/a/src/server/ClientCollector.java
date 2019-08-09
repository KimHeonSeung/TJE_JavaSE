package server;

import java.io.IOException;
import java.net.*;

public class ClientCollector extends Thread {
	private ServerSocket server;
	
	public ClientCollector(int port) {
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("다른 프로세스에서 동일한 포트 번호 사용중");
		}
	}
	
	@Override
	public void run() {
		while(true) {
			Socket socket;
			
			try {
				socket = this.server.accept();
				Client client = new Client(socket);
				
				if( !ClientSaver.checkClient(client) ) {
					ClientSaver.addClient(client);
					client.activate();
				} else {
					client.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
