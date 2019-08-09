package tje.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_06 {

	public static void main(String[] args) {
		// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ�.
		Scanner kb = new Scanner(System.in);

		System.out.print("������ �Է��ϼ��� : ");
		
		// try �������� ������ ������ try ������ ����� �� ������ �� ����.
		// try ������ ���������� ������ ��� ¦��/Ȧ���� ����ϱ� ���� ������ ����
		// try ���� ���ο��� �ʱ�ȭ �ϴ� �ڵ�� ������� ���� ���ɼ��� �ֱ� ������ �ʱ�ȭ�� ����
		int num = 0;
		
		try {
			num = kb.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("InputMismatchException ���ܰ� �߻��Ͽ� ó����");
			System.out.println("���α׷� ����");
			return;
		}
		
		if( num % 2 == 0 )
			System.out.println("¦���Դϴ�.");
		else 
			System.out.println("Ȧ���Դϴ�.");

		System.out.println("���α׷� ����");
		kb.close();

	}

}
