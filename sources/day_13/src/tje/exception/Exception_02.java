package tje.exception;

import java.util.Scanner;

public class Exception_02 {

	public static void main(String[] args) {
		// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ�.
		Scanner kb = new Scanner(System.in);

		System.out.print("�޼����� �Է��ϼ���. (5���� �̻�) : ");
		String msg = kb.next();

		if( msg.length() < 5 )
			msg = null;
		
		// java.lang.NullPointException ���� �߻� ���ɼ��� �ִ�.
		// ���۷��� ������ null ���� ���Ե� ���¿��� ���� ������ �����ϴ� ��� �߻��Ǵ� ����
		System.out.printf("�Էµ� ���ڿ��� ���̴� %d �Դϴ�.\n", msg.length());

		kb.close();

	}

}
