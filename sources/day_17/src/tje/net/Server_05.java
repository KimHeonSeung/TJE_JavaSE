package tje.net;

import java.net.*;
import java.io.*;

public class Server_05 {
	public static void main(String[] args) {
		// Ŭ���̾�Ʈ�� ���ӵǸ� D:\dev\java_se\tools ���丮�� �����
		// eclipse-java-2018-12-R-win32-x86_64.zip ������ Ŭ���̾�Ʈ���� ������ �� �ִ� ������ �ۼ�.
		// Ŭ���̾�Ʈ�� ������ �����ϴ� ������ �����͸� ���Ź޾�
		// ���Ϸ� �����ϵ��� �ۼ�

		String dirPath = "D:\\dev\\java_se\\tools";
		File dir = new File(dirPath);
		String fileName = "eclipse-java-2018-12-R-win32-x86_64.zip";
		File file = new File(dir, fileName);
		
		BufferedInputStream in_file = null;
		
		try {
			in_file = new BufferedInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			return;
		}
		
		ServerSocket server = null;

		int port = 7070;

		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.printf("�ٸ� ���μ������� ��Ʈ��ȣ(%d)�� ����ϰ� �ֽ��ϴ�.\n", port);
			return;
		}

		System.out.println("Ŭ���̾�Ʈ�� ������ �����...");
		Socket socket = null;
		try {
			socket = server.accept();
		} catch (IOException e) {
			System.out.println("accept �޼ҵ忡�� ���ܰ� �߻�");
			try {
				server.close();
			} catch (IOException e1) {
				System.out.println("������ ���� �������� ���ܰ� �߻�");
			}
			return;
		}

		System.out.println("Ŭ���̾�Ʈ�� ���ӵ�");
		
		PrintWriter socket_out = null;
		// ������ �����͸� ����ϱ� ���� ����Ʈ��Ʈ�� ����
		BufferedOutputStream socket_byte_out = null;

		try {
			socket_out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
			socket_byte_out = new BufferedOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ���� ��Ʈ�� ���� ����");
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("���� ���ῡ�� ���ܰ� �߻��Ͽ����ϴ�.");
			}
			return;
		}

		// 1. �����̸��� Ŭ���̾�Ʈ���� ����
		socket_out.println(file.getName());
		
		// 2. ������ �����͸� Ŭ���̾�Ʈ���� ����
		byte [] data = new byte[1024];
		int size;
		try {
		while( (size = in_file.read(data)) != -1 ) {
			socket_byte_out.write(data, 0, size);
			socket_byte_out.flush();
			}
		} catch (IOException e1) {
			System.out.println("���� ���� �������� ������ �߻��߽��ϴ�");
		}

		
		
		try {
			socket_out.close();
			socket_byte_out.close();
			server.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("���� ����������� ���ܰ� �߻��߽��ϴ�.");
		}
		
		
		// ���� �Ѱ�
		
//		ServerSocket server = null;
//
//		int port = 7070;
//
//		try {
//			server = new ServerSocket(port);
//		} catch (IOException e) {
//			System.out.printf("�ٸ� ���μ������� ��Ʈ��ȣ(%d)�� ����ϰ� �ֽ��ϴ�.\n", port);
//			return;
//		}
//
//		System.out.println("Ŭ���̾�Ʈ�� ������ �����...");
//		Socket socket = null;
//		try {
//			socket = server.accept();
//		} catch (IOException e) {
//			System.out.println("accept �޼ҵ忡�� ���ܰ� �߻�");
//			try {
//				server.close();
//			} catch (IOException e1) {
//				System.out.println("������ ���� �������� ���ܰ� �߻�");
//			}
//			return;
//		}
//
//		System.out.println("Ŭ���̾�Ʈ�� ���ӵ�");
//
//		String dir_source_Path = "D:\\dev\\java_se\\tools";
//		
//		File dirSource = new File(dir_source_Path);
//		
//		File fileSource = new File(dirSource, "eclipse-java-2018-12-R-win32-x86_64.zip");
//
//		BufferedReader bis;
//		try {
//			bis = new BufferedReader(
//					new FileReader(fileSource));
//		} catch (FileNotFoundException e2) {
//			System.out.println("FileNotFound ���ܰ� �߻�");
//			return;
//		}
//		
//		PrintWriter socket_out = null;
//
//		
//
//		// Ŭ���̾�Ʈ�� �����͸� �ְ�ޱ� ���� �غ� �Ϸ�
//
//		// Ŭ���̾�Ʈ�� �����͸� �ְ�޴� ���������� ���ǻ���
//		// ����½� ��ŷ ������ �߻�
//		// �Ϲ������� �Է�(�������� ������ �����͸� �޴� ����)��
//		// ������� ó��
//		new SimpleReceiverThread("Ŭ���̾�Ʈ", bis).start();
//
//		System.out.print("Ŭ���̾�Ʈ�� ����... ");
//		
//		try {
//			String msg = bis.readLine();
//		} catch (IOException e1) {
//			System.out.println("���� ���� �� ���� �߻�");
//		}
//
//		socket_out.close();
//		try {
//			server.close();
//			socket.close();
//		} catch (IOException e) {
//			System.out.println("���� ����������� ���ܰ� �߻��߽��ϴ�.");
//		}

	}
}
