package tje.collection;

// LinkedList Ŭ����
// ��ũ �� ����Ʈ�� �����ϰ� �ִ� Ŭ����
// - �����͸� ���������� �����Ͽ� ������ �� �ִ� Ŭ����
// - ������ ������� ������ �� ����
// - �������� ���԰� ������ ����ȭ�Ǿ� �ִ� Ŭ����
// - ������ �ߺ��� ���
// - ������ �Է� ������ ����
// - �˻��� ���
// - ������ ���� ��, �������� ���� ����Ǳ� ������
//   �޸� ���� �߻�

import java.util.*;

public class Collection_05 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		
		for( int i = 0 ; i < list.size() ; i++ )
			System.out.println(list.get(i));
	}

}
