package tje.network;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.0.70", 5555);
		
		System.out.println("���� ���� ����~!");
		
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(System.in));
				
		
		// PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new OutputStreamWriter(
								socket.getOutputStream())));
		
		System.out.println("ä���� �����մϴ�.");

		while(true) {
			System.out.print("������ ������ �޼����� �Է� : ");
			String msg = in.readLine();
			
			if( msg.equals("bye") )
				break;
			
			out.println(msg);
			out.flush();
		}
		
		System.out.println("���α׷� ����");
	}

}
