package tje.exception;

import java.util.Scanner;

public class Exception_03 {

	public static void main(String[] args) {
		// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ�.
		Scanner kb = new Scanner(System.in);

		System.out.print("������ �Է��ϼ��� : ");
		int num = kb.nextInt();

		if( num % 2 == 0 )
			System.out.println("¦���Դϴ�.");
		else 
			System.out.println("Ȧ���Դϴ�.");

		kb.close();

	}

}
