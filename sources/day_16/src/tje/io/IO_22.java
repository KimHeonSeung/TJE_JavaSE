package tje.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class IO_22 {
	public static void main(String[] args) throws Exception {
		// D:\\\\dev\\\\java_se\\\\file_log ��ο� �����
		// ��� ���Ͽ� ���ؼ� �� ���Ϻ� ��� ������ ���

		// 2019�� 3�� 15�� 13�� 16�п� ��ϵ� ����
		// 1. ...
		// 2. ...
		// 2019�� 3�� 15�� 13�� 16�п� ��ϵ� ����
		// 1. ...
		// 2. ...
		// 2019�� 3�� 15�� 13�� 17�п� ��ϵ� ����
		// 1. ...
		// 2. ...

		// File Ŭ������ list �޼ҵ带 Ȱ��
		// list �޼ҵ�� ���丮�� �����ϰ� �ִ� File ��ü�� ����� ��
		// ������, �ش� ���丮�� ���ο� �����ϴ� ��� ����/���丮���� ��ȯ
		// (�迭�� ��ȯ)

		String dirPath = "D:\\dev\\java_se\\file_log";
		File dir = new File(dirPath);

		if (!dir.exists())
			dir.mkdirs();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�п� ��ϵ� ����");
		
		String [] file_list = dir.list();
		for( String fn : file_list ) {
			// System.out.println(file);
			
			// ���ϸ� ��ϵ� ��¥�� �ش�Ǵ� Date ��ü ����
			// SimpleDateFormat Ŭ������ parse �޼ҵ�
			// �Ű������� ���޵� ���ڿ��� ����Ͽ� Date��ü ��ȯ
			// �Ű������� ���ڿ��� SimpleDateFormat Ŭ������ �����ڿ��� ������
			// �������� �Ǿ��־����
			Date date = sdf1.parse(fn.substring(0, fn.indexOf(".dat")));
			String title = sdf2.format(date);
			System.out.println(title);
			
			File file = new File(dir, fn);
			ObjectInputStream in =
					new ObjectInputStream(
							new BufferedInputStream(
									new FileInputStream(file)));
			
			ArrayList<CalculatorResult> list = 
					(ArrayList<CalculatorResult>) in.readObject();
			
			for( int i = 0 ; i < list.size() ; i++ )
				System.out.printf("%2d. %s\n", i + 1, list.get(i));
			System.out.println();
			
			in.close();
		}
	}
}
