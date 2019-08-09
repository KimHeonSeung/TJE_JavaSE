package tje.collection;

import java.util.*;

public class Collection_05_Ex {

	public static void main(String[] args) {
		ArrayList<Integer> list_1 = new ArrayList<Integer>();
		LinkedList<Integer> list_2 = new LinkedList<Integer>();

		long s_time, e_time;

		
		// ������ �Է�
		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_1.add(0, i);
		e_time = System.nanoTime();

		System.out.println("ArrayList�� �Է� �ð� : " + (e_time - s_time));

		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_2.add(0, i);
		e_time = System.nanoTime();

		System.out.println("LinkedList�� �Է� �ð� : " + (e_time - s_time));

		
		
		// ������ ����
		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_1.remove(0);
		e_time = System.nanoTime();

		System.out.println("ArrayList�� ���� �ð� : " + (e_time - s_time));

		s_time = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			list_2.remove(0);
		e_time = System.nanoTime();

		System.out.println("LinkedList�� ���� �ð� : " + (e_time - s_time));

	}

}
