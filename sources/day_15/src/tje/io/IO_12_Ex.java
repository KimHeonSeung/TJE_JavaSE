package tje.io;

import java.io.*;

public class IO_12_Ex {
	public static void main(String[] args) throws Exception {
		// tools ���丮�� ��Ŭ���� ����������
		// tools_copy ���丮�� �����ϱ�.
		
		String dir_source_Path = "D:\\dev\\java_se\\tools";
		String dir_target_Path = "D:\\dev\\java_se\\tools_copy";
		
		File dirSource = new File(dir_source_Path);
		File dirTarget = new File(dir_target_Path);
		
		if( !dirTarget.exists() )
			dirTarget.mkdirs();
		
		File fileSource = new File(dirSource, "eclipse-java-2018-12-R-win32-x86_64.zip");
		File fileTarget = new File(dirTarget, fileSource.getName());
		
		BufferedInputStream bis =
				new BufferedInputStream(
						new FileInputStream(fileSource));
		
		BufferedOutputStream bos =
				new BufferedOutputStream(
						new FileOutputStream(fileTarget));
		
		// �Ʒ��� ���� �ϸ� ������
//		int data;1
//		long startTime = System.nanoTime();
//		while( (data = bis.read()) != -1 )
//			bos.write(data);
//		long endTime = System.nanoTime();
		
		// �Ʒ��� ���� �ϸ� �迭�� ����Ͽ� �� ������.
		int size;
		byte [] data = new byte[2048];
		long startTime = System.nanoTime();
		while( (size = bis.read(data)) != -1 ) {
			System.out.println(size);
			bos.write(data, 0, size);
			bos.flush(); // ���� ������ ���Ѵ밡 �ƴ϶� �ݵ�� flush�� �������� ������ ����.
		}
		long endTime = System.nanoTime();
		
		
//		// ���� ũ�⸸ŭ �迭�� ����� ��ƮŸ������ �޸𸮿� �ø�
//		// ��õ�ϴ� ����� �ƴ�.
//		int size;
//		long startTime = System.nanoTime();
//		byte [] data = new byte[(int) fileSource.length()];
//		bis.read(data);
//		bos.write(data);
//		long endTime = System.nanoTime();
		
		
		
		System.out.printf("���� ���� �Ϸ� : (%d ns)\n", endTime-startTime);
		System.out.printf("���� ���� ũ�� : %d bytes\n", fileSource.length());
		System.out.printf("���� ���� ũ�� : %d bytes\n", fileTarget.length());
		bos.close();
		
		bis.close();
		
		
		
		
		
		
		
		
		
		// ���� �õ�
//		String dirOri = "D:\\dev\\java_se\\tools";
//		
//		File Ori = new File(dirOri, "eclipse-java-2018-12-R-win32-x86_64.zip");
//		
//		BufferedInputStream fis = 
//				new BufferedInputStream(
//						new FileInputStream(Ori));
//		
////		BufferedOutputStream bos =
////				new BufferedOutputStream(
////						new FileOutputStream(Ori));
//				
//	
//		if( Ori.exists() ) {
//			System.out.println("������ �����մϴ�. ���縦 �����մϴ�.");
//			
//		
//		}
//		else
//			System.out.println("������ �������� �ʽ��ϴ�.");
//
//		
//		String dirPath = "D:\\dev\\java_se\\tools_copy";
//		
//		File dirCp = new File(dirPath);
//		
//		if( !dirCp.exists() )
//			dirCp.mkdirs();
//		
//		
//		BufferedOutputStream bos =
//				new BufferedOutputStream(
//						new FileOutputStream(Ori));
		
		
		
		
		
	}
}