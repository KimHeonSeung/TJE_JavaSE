
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
			System.out.println("������ ã�� �� ����");
		} catch (IOException e) {
			System.out.println("���� ���ῡ ����");
			return;
		}
		
		System.out.println("������ �����");
		
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
