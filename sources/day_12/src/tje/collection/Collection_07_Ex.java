package tje.collection;

import java.util.*;

public class Collection_07_Ex {

	public static void main(String[] args) {
		// �ߺ��� ������ �ζ� ��ȣ�� �����ϴ� ����
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		
		while( lotto.size() < 6 ) 
			// Math.random() * 45
			lotto.add(random.nextInt(45) + 1);
		
		for ( Integer i : lotto ) {
			System.out.printf("%2d ", i);
		}
		
		System.out.println();
		
		
		
		// List Ÿ���� �����͸� ������ �� �ִ� Collections Ŭ������ Ȱ���Ͽ�
		// Hash ������ �����͸� �����ϴ� ���
		// 1. List Ÿ���� ��ü�� �����ϸ鼭 HashSet Ÿ���� ��ü�� �������� �Ű������� ����
		List<Integer> lotto_list = new ArrayList<Integer>(lotto);
		// 2. ���۵� List Ÿ���� ��ü�� Collections Ŭ������ sort �޼ҵ��� �Ű������� ����
		//		(������ �Ϸ��)
		Collections.sort(lotto_list);
		
		// ���ĵ� �ζǹ�ȣ�� ����ϴ� ����
		for ( Integer i : lotto_list ) {
			System.out.printf("%2d ", i);
		}
		
		}

}
