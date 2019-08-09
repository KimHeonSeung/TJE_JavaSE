package tje.exception;

import java.util.Scanner;

public class Exception_05 {

	public static void main(String[] args) {
		// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ�.
		Scanner kb = new Scanner(System.in);

		System.out.print("�޼����� �Է��ϼ���. (5���� �̻�) : ");
		String msg = kb.next();

		if( msg.length() < 5 )
			msg = null;
		
		try {
			// java.lang.NullPointException ���� �߻� ���ɼ��� �ִ�.
			// ���۷��� ������ null ���� ���Ե� ���¿��� ���� ������ �����ϴ� ��� �߻��Ǵ� ����
			System.out.printf("�Էµ� ���ڿ��� ���̴� %d �Դϴ�.\n", msg.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException ���ܰ� �߻��Ͽ� ó����");
		}
		
		System.out.println("���α׷� ����");

		kb.close();

	}

}
