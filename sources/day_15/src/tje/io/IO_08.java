package tje.io;

import java.io.*;



public class IO_08 {
	public static void main(String[] args) throws IOException {
		// ����ó��
		// File Ŭ����
		// ���� �Ǵ� ���丮�� ���õ� ��Ÿ ������ �����ϴ� Ŭ����
		// ������ ����, ���丮�� ���� �� �߰����� ����� ����
		
		// ���丮�� ��θ� ����
		// ���ǻ��� - \ ���ڴ� �ڹٿ��� Ư�����ڸ� �����ϴ� �����̹Ƿ�
		// 		   \ ��ü�� ����ϱ� ���ؼ��� \\�� �����ؾ� �Ѵ�. 
		
		// D:\dev\java_se\temp ���丮�� ��θ� ����
		// File.separator : �� �ü������ ����� ���� ���ڰ� �ٸ��Ƿ� 
		// 					File.Separator�� ����Ͽ� ���丮�� ��� ���й��ڸ�
		//					�������� �ʰ� ���� �������� ȯ�濡 ���缭 ���۽�ų �� �ִ�.
		String dirPath = "D:\\dev\\java_se" + File.separator + "temp";
		// System.out.println(dirPath);
		
		// D:\dev\java_se\temp ���丮�� �����ϴ� File ��ü ����
		// (File ��ü�� ���丮 �Ǵ� ������ ������ �� �ִ�.)
		File dir = new File(dirPath);
		
		// File ��ü�� �����ϰ� �ִ� ����� ���� ������ ��ȯ
		if( !dir.exists() )
			
			// ���丮�� �����ϴ� �޼ҵ�
			// mkdir : ���� Ÿ�� ������ ��ΰ� �����ؾ߸� ����
			// mkdirs : ���� Ÿ�� ������ ��ΰ� �������� �ʾƵ�
			//          ��ü ��θ� ����
			dir.mkdirs();
		
		if( dir.exists() )
			System.out.println("temp ���丮 �߰� ~ !");
		else
			System.out.println("temp ���丮�� ���� ... ");
		
		
		// D:\dev\java_se\temp\log.txt ������ �����ϴ� File ��ü ����
		
		// ��ü ��θ� ����ϴ� ����� ��ü ���� �ڵ�
		// File file = new File("D:\\dev\\java_se\\temp\\log.txt");
		
		// ������ ����� ���丮�� �����ϴ� File ��ü�� ����Ͽ�  ��ü�� �����ϴ� �ڵ�
		File file = new File(dir, "log.txt");
		
		if( !file.exists() )
			file.createNewFile();
		
		if( file.exists() )
			System.out.println("log.txt ���� �߰� ~ !");
		else
			System.out.println("log.txt ���� ���� ... ");
		
		System.out.printf("���ϸ�                      : %s\n", file.getName());
		System.out.printf("������ ��ü ���        : %s\n", file.getAbsolutePath());
		System.out.printf("������ ũ�� (byte) : %d\n", file.length());
	}
}
