
// +, - ����� ������ �ִ� PlusMinusCalculator Ŭ������ ������ ��
// main �޼ҵ忡�� �׽�Ʈ�ϼ���.
// 1��° ������ �Է� : 10
// 2��° ������ �Է� : 5
// ��ȣ�� �Է��ϼ��� : +
// 10 + 5 = 15

import java.util.Scanner;

class PlusMinusCalculator {
	public void plus(int n1, int n2) {
		int r = n1 + n2;
		System.out.printf("%d + %d = %d\n", n1, n2, r);
	}

	public void minus(int n1, int n2) {
		int r = n1 - n2;
		System.out.printf("%d - %d = %d\n", n1, n2, r);
	}
}

//PlusMinusCalculator Ŭ������ ��ӹ޴� Calculator Ŭ������ �����ϼ���.
//Calculator Ŭ������ ��Ģ����� ������ ������ ������ �� �ֵ��� �����ϼ���.

class Calculator extends PlusMinusCalculator {
	public void divide(int n1, int n2) {
		double r = (double)n1 / n2;
		System.out.printf("%d / %d = %.2f\n", n1, n2, r);
	}
	public void multiple(int n1, int n2) {
		int r = n1 * n2;
		System.out.printf("%d * %d = %d\n", n1, n2, r);
	}
	public void moduler(int n1, int n2) {
		int r = n1 % n2;
		System.out.printf("%d %% %d = %d\n", n1, n2, r);
	}
}

public class Class_33_Extends {

	public static void main(String[] args) {
		// PlusMinusCalculator pmc = new PlusMinusCalculator();
		Calculator cal = new Calculator();

		Scanner kb = new Scanner(System.in);

		// �Է°���...
		int n1, n2;
		System.out.print("1��° ������ �Է� : ");
		n1 = kb.nextInt();
		System.out.print("2��° ������ �Է� : ");
		n2 = kb.nextInt();
		// ��ȣ �Է�...
		char operator;
		System.out.print("��ȣ�� �Է��ϼ��� : ");
		operator = kb.next().charAt(0);
		// ��ȣ�� ���� ����
		if (operator == '+') {
			// pmc.plus(n1, n2);
			cal.plus(n1, n2);
		} else if (operator == '-') {
			// pmc.minus(n1, n2);
			cal.minus(n1, n2);
		} else if (operator == '/') {
			// pmc.divide(n1, n2);
			cal.divide(n1, n2);
		} else if (operator == '*') {
			// pmc.multiple(n1, n2);
			cal.multiple(n1, n2);
		} else if (operator == '%') {
			// pmc.moduler(n1, n2);
			cal.moduler(n1, n2);
		}
	}
}
