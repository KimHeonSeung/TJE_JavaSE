package tje.io;

import java.io.IOException;

public class IO_04_Ex_2 {

	public static void main(String[] args) throws IOException {
		// System.in ��ü�� ����Ͽ� ���ϱ� ������ �����ϴ�
		// ���α׷��� �ۼ��ϼ���.
		// ù��° ���� : 123
		// �ι�° ���� : 2
		// ��� : 123 + 2 = 125
		
		// ù��° ���ڿ� ���� ���ڰ��� �����ϱ� ���� byte �迭
		byte [] num1 = new byte[10];
		// �ι�° ���ڿ� ���� ���ڰ��� �����ϱ� ���� byte �迭
		byte [] num2 = new byte[10];
		
		int size;
		
		System.out.print("ù��° ���� : ");
		size = System.in.read(num1);
		// 0	1	2
		// 1	2	3
		// 49	50	51	13	10
		int n1 = 0;
		for( int i = size - 3, multiple = 1 ; i >= 0 ; i--, multiple *= 10 ) {
			n1 += (num1[i] - '0') * multiple;
		}
		
		System.out.print("�ι�° ���� : ");
		size = System.in.read(num2);
		int n2 = 0;
		for( int i = size - 3, multiple = 1 ; i >= 0 ; i--, multiple *= 10 ) {
			n2 += (num2[i] - '0') * multiple;
		}
		
		
		System.out.printf("��� : %d + %d = %d\n", n1, n2, n1 + n2);

		
		
		// �� �õ�
		
//		byte[] input = new byte[10];
//		int n1, n2, result;
//				
//		
//		System.out.print("ù��° ���� : ");
//		n1 = System.in.read(input);
//		System.out.print("�ι�° ���� : ");
//		n2 = System.in.read(input, 5, 3);
//
//		for (int i = 0; i < input.length; i++)
//			System.out.printf("%d ", input[i]);
//		
	}

}
