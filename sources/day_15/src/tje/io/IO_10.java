package tje.io;

import java.io.*;

public class IO_10 {
	public static void main(String[] args) throws Exception {
		// ���� ó��
		// File�κ��� �����͸� �Է¹޴� ���
		// FileInputStream(����������), FileReader(���ڵ�����)

		String dirPath = "D:\\dev\\java_se\\temp\\file_test";
		File dir = new File(dirPath);

		if (!dir.exists())
			dir.mkdirs();

		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");

		// ���Ͽ��κ��� �Է¹��� �� �ִ� ��Ʈ�� ��ü ����
		// ���ǻ��� : ���� ��� ��Ʈ���� ��� ������ �������� ������
		// ������ �� ��Ʈ���� ����
		// �ݸ�, �Է½�Ʈ���� ������ �������� ������ ���ܰ� �߻�.

		// 1. ���������͸� �Է¹��� �� �ִ� ��Ʈ�� ��ü ����
		FileInputStream fis = new FileInputStream(file_binary);

		// 2. ���ڵ����͸� ����� �� �ִ� ��Ʈ�� ��ü ����
		FileReader fr = new FileReader(file_text);

		// ���Ϸκ��� ������ �Է¹޴� �ڵ�

//		int data_binary = fis.read();
//		System.out.println(data_binary);
//		data_binary = fis.read();
//		System.out.println(data_binary);
//		data_binary = fis.read();
//		// ������ ���� �����ϸ� -1���� ��ȯ
//		System.out.println(data_binary);

		// ����Ʈ ��Ʈ���� ����Ͽ� ������ ������ 1byte �� �о���� �ڵ�
		int data_binary;
		while ((data_binary = fis.read()) != -1)
			System.out.println(data_binary);

		// ���� ��Ʈ���� ����Ͽ� ������ ������ 2byte �� �о���� �ڵ�
		
		
		// ���ǻ���
		// ���� �ؽ�Ʈ ������ ������ �� ���ھ� �о���̴� ���
		// �ݵ�� int Ÿ������ ���ڰ��� ���� �޾ƾ��մϴ�.
		// ���Ͽ� ���� �����ϸ� -1 ���� ��ȯ������
		// char �� ��ȣ�� ���� �ڷ����̹Ƿ� -���� ó���� �� ����
		// ������ ����θ� ����Ͽ� �ݺ��� �������� �� �����ϴ�.
		int data_text;
		while ((data_text = fr.read()) != -1)
			System.out.println((char) data_text);

		fis.close();
		fr.close();

		System.out.println("���α׷� ����");

	}
}
