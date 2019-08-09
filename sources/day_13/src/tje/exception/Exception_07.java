package tje.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_07 {

	public static void main(String[] args) {
		// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ�.
		Scanner kb = new Scanner(System.in);
		
		// try �������� ������ ������ try ������ ����� �� ������ �� ����.
		// try ������ ���������� ������ ��� ¦��/Ȧ���� ����ϱ� ���� ������ ����
		// try ���� ���ο��� �ʱ�ȭ �ϴ� �ڵ�� ������� ���� ���ɼ��� �ֱ� ������ �ʱ�ȭ�� ����
		int num = 0;
		
		// �ùٸ��� ������ �Էµ� ������ ���� �Է��� ��û�� ��
		// ¦��, Ȧ�� ���θ� ���.
		while(true) {
			try {
				System.out.print("������ �Է��ϼ��� : ");
				num = kb.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("InputMismatchException ���ܰ� �߻��Ͽ� ó����");
				kb.next();
				continue;
			}
			break;
		}
		
		if( num % 2 == 0 )
			System.out.println("¦���Դϴ�.");
		else 
			System.out.println("Ȧ���Դϴ�.");

		System.out.println("���α׷� ����");
		kb.close();

	}

}
