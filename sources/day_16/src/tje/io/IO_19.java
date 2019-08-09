package tje.io;

import java.io.*;
import java.util.*;

// ��ü ������� ���ؼ� ���Ǵ� 
// ObjectInputStream, ObjectOutputStream Ŭ����
// Ư�� ��ü ��ü�� �ܺη� ����ϰų� �Է¹��� �� �ִ� Ŭ����
// ObjectInputStream, ObjectOutputStream Ŭ������ ����Ͽ�
// ����µǴ� Ŭ������ �ݵ�� Serializable �������̽��� �����ؾ��մϴ�.
// Serializable �������̽��� ��� �߻�޼ҵ嵵 �������� �ʴ´�. (���� �ʿ�)
class Point implements Serializable{
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("X : %d, Y : %d\n", this.x, this.y);
	}
	
}

public class IO_19 {
	public static void main(String[] args) throws Exception {
		
		ArrayList<Point> list = new ArrayList<>();
		
		Random random = new Random();
		for( int i = 500 ; i < 100000 ; i++ ) {
			Point p = new Point(random.nextInt(i), random.nextInt(i));
			System.out.println(p);
			list.add(p);
		}
		
		String dirPath = "D:\\dev\\java_se\\file_test";
		File dir = new File(dirPath);
		
		File file = new File(dir, "object_03.dat");
		
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		// ��ü ��ü�� ����� �� �ִ� writeObject �޼ҵ�
		// Object Ÿ���� �Ű������� ���޹޾�
		// �ش� ��ü�� ��Ʈ���� ���ؼ� ����ϴ� ����� ����
		out.writeObject(list);
		// flush�� ȣ���Ͽ� ��ü�� ���
		out.flush();
		// ��Ʈ�� ����
		out.close();
		
		
//		X : 684971757, Y : 1248562288
//
//		X : 2130423896, Y : 278696092
//
//		X : 1104229774, Y : -1163789370
//
//		X : -1341377195, Y : -1963136281
		
		System.out.println("���α׷� ����");
		
	}
}









