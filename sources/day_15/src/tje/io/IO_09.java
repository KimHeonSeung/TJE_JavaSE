package tje.io;

import java.io.*;

public class IO_09 {
	public static void main(String[] args) throws Exception {
		// ���� ó��
		// File�� �����͸� ����ϴ� ���
		// FileOutputStream(����������), FileWriter(���ڵ�����)

		String dirPath = "D:\\dev\\java_se\\temp\\file_test";
		File dir = new File(dirPath);

		if (!dir.exists())
			dir.mkdirs();

		// ���� ��� ��Ʈ�� ��ü�� �ش� ������ �������� �ʴ� ���
		// ������ �����Ͽ� ��Ʈ���� ������.

		File file_binary = new File(dir, "binary_data.dat");
		File file_text = new File(dir, "text_data.txt");

		// ���Ͽ� ����� �� �ִ� ��Ʈ�� ��ü ����
		// 1. ���������͸� ����� �� �ִ� ��Ʈ�� ��ü ����
		FileOutputStream fos = new FileOutputStream(file_binary);

		// 2. ���ڵ����͸� ����� �� �ִ� ��Ʈ�� ��ü ����
		FileWriter fw = new FileWriter(file_text);

		// ���Ͽ� ������ ���
		// 1. ����Ʈ ��Ʈ���� ���ؼ� ���
		fos.write(11);
		fos.write(22);

		// 2. ����Ʈ ��Ʈ���� ���ؼ� ���
		fw.write(11);
		fw.write(22);
		fw.write("Hello~");
		fw.write("Java~");
		
		// ��Ʈ���� ����
		fos.close();
		fw.close();
	}
}
