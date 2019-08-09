package Exercise190408;

import java.io.*;
import java.net.*;


public class client {

	public static void main(String[] args) throws Exception {
		String ip = "192.168.0.68";
		
		int port = 5050;
		Socket client = new Socket(ip, port);
		
		System.out.println("���� ���� �Ϸ�");
		
		// Ű���� �Է� ��Ʈ��
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		// �Է� ��Ʈ��
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		// ��� ��Ʈ�� ( �����÷��� ����)
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
		
		String input_kb;
		String input_server;
		
		do {
			System.out.print("�������� : ");
			input_kb = kb.readLine();
			out.println(input_kb);
			
			if( input_kb.equals("bye") )
				break;
			
			input_server = in.readLine();
			System.out.printf("���� : %s\n", input_server);
		} while( !input_server.equals("bye") );
		
		kb.close();
		in.close();
		out.close();
		client.close();
		
		

	}

}
