package Exercise190408;

import java.io.*;
import java.net.*;


public class client {

	public static void main(String[] args) throws Exception {
		String ip = "192.168.0.68";
		
		int port = 5050;
		Socket client = new Socket(ip, port);
		
		System.out.println("서버 연결 완료");
		
		// 키보드 입력 스트림
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 스트림
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		// 출력 스트림 ( 오토플러쉬 지정)
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
		
		String input_kb;
		String input_server;
		
		do {
			System.out.print("서버에게 : ");
			input_kb = kb.readLine();
			out.println(input_kb);
			
			if( input_kb.equals("bye") )
				break;
			
			input_server = in.readLine();
			System.out.printf("서버 : %s\n", input_server);
		} while( !input_server.equals("bye") );
		
		kb.close();
		in.close();
		out.close();
		client.close();
		
		

	}

}
