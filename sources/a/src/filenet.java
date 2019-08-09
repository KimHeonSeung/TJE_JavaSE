
import java.io.*;
import java.net.*;

public class filenet {
	public static void main(String[] args) {
		String host = "localhost";
		int port = 7070;
		
		Socket s = null;
		
		try {
			s = new Socket(host,port);
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("서버 연결에 실패");
			return;
		}
		
		System.out.println("서버에 연결됨");
		
		BufferedReader socket_in = null;
		BufferedInputStream socket_byte_in = null;
		
		try {
			socket_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
