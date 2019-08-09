package Exercise190408;

import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args) throws Exception {
		
		int port = 5050;
		ServerSocket ss = new ServerSocket(port);
		
		System.out.println("서버 시작.");
		System.out.println("클라이언트 대기중.");
		
		Socket client = ss.accept();
		
		System.out.println("클라이언트 접속");
		
		// 키보드 입력 스트림
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 스트림 
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		// 출력 스트림(오토 플ㄹ쉬)
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
		
		String input_kb;
		String input_client;
		
		do {
			// 클라이언트 측의 메세지 수신
			input_kb = in.readLine();
			System.out.printf("접속자 : %s\n", input_kb);
			
			if( input_kb.equals("bye") )
				break;
			
			System.out.print("접속자에게 : ");
			input_client = kb.readLine();
			// 클라이언트 측에 데이터 전송
			out.println(input_client);
		} while( !input_client.equals("bye") );
		
		kb.close();
		in.close();
		out.close();
		client.close();
		
	}
}
