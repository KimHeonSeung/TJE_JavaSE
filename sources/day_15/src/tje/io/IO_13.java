package tje.io;

import java.io.*;

public class IO_13 {

	public static void main(String[] args) throws IOException {
		String dirPath = "D:\\dev\\java_se\\tools\\eclipse\\readme";
		File dir = new File(dirPath);
		
		
		String fileName = "readme_eclipse.html";
		File file = new File(dir, fileName);
		
		// ������ �о���� ���� ���� ��Ʈ�� ��ü ����
		// ���ڽ�Ʈ������ ���� ��� ���� ��ǲ��Ʈ������ �ٲ� �ʿ䰡 ����.
		BufferedReader in =
				new BufferedReader(
						new FileReader(file));
		
		String input;
		while( (input = in.readLine()) != null )
			System.out.println(input);
		
		in.close();
		System.out.println("���α׷� ����");
		
		
//		BufferedReader in =
//				new BufferedReader(
//						new InputStreamReader(
//								new FileInputStream(file)));
				

	}

}
