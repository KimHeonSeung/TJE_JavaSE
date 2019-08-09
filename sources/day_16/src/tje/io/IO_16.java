package tje.io;

import java.io.*;
import java.util.*;

// ��ü ������� ���ؼ� ���Ǵ�
// ObjectInputStream, ObjectOutputStream Ŭ����
// Ư�� ��ü ��ü�� �ܺη� ����ϰų� �Է¹��� �� �ִ� Ŭ����
// ObjectInputStream, ObjectOutputStream Ŭ������ ����Ͽ�
// ����� �Ǵ� Ŭ������ �ݵ�� Serializable �������̽��� �����ؾ� �Ѵ�.

public class IO_16 {
	public static void main(String[] args) throws Exception {
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		File file = new File(dir, "object_01.dat");
		
		// ���Ϸκ��� ��ü�� �Է¹��� �� �ִ� ��Ʈ�� ����
		ObjectInputStream in =
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(file)));
		
		// ��ü ��ü�� �Է¹��� �� �ִ� readObject �޼ҵ�
		// Object Ÿ���� ��ȯ�ϱ� ������
		// �ݵ�� ���� ����ȯ�� ���� ��ü�� ���Թ޾ƾ� �Ѵ�.
		ArrayList<Integer> list = (ArrayList<Integer>) in.readObject();
		
		for( int i = 0 ; i < list.size() ; i++ )
			System.out.printf("list.get(%d) -> %d\n", i, list.get(i));
		
		
		System.out.println("���α׷� ����");
		
	}
}
