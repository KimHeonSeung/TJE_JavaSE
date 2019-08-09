package Exercise190408;

import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args) throws Exception {
		
		int port = 5050;
		ServerSocket ss = new ServerSocket(port);
		
		System.out.println("���� ����.");
		System.out.println("Ŭ���̾�Ʈ �����.");
		
		Socket client = ss.accept();
		
		System.out.println("Ŭ���̾�Ʈ ����");
		
		// Ű���� �Է� ��Ʈ��
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		// �Է� ��Ʈ�� 
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		// ��� ��Ʈ��(���� �ä���)
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
		
		String input_kb;
		String input_client;
		
		do {
			// Ŭ���̾�Ʈ ���� �޼��� ����
			input_kb = in.readLine();
			System.out.printf("������ : %s\n", input_kb);
			
			if( input_kb.equals("bye") )
				break;
			
			System.out.print("�����ڿ��� : ");
			input_client = kb.readLine();
			// Ŭ���̾�Ʈ ���� ������ ����
			out.println(input_client);
		} while( !input_client.equals("bye") );
		
		kb.close();
		in.close();
		out.close();
		client.close();
		
	}
}
