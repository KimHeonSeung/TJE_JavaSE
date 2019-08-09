package tje.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_07 {
	public static void main(String[] args) throws IOException {
		// �ټ����� ��Ʈ�� Ŭ�������� ���յ� ��Ʈ�� ��ü ����
		// BufferedReader ��ü ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;

		// BufferedReader Ŭ������ ��ü�� ����Ͽ�
		// �⺻ �ڷ����� Ÿ���� �о�� ��, ����ȯ�� �ϴ� ����
		System.out.print("���� �Է� : ");
		input = br.readLine();

		// �Էµ� ���ڿ��� ������ ��ȯ
		int num = Integer.parseInt(input);
		System.out.printf("�Էµ� ���� : %d\n", num);
		
		System.out.print("�Ǽ� �Է� : ");
		input = br.readLine();
		// �Էµ� ���ڿ��� �Ǽ��� ��ȯ
		double num_double = Double.parseDouble(input);
		System.out.printf("�Էµ� �Ǽ� : %.2f\n", num_double);
		
		System.out.println("���� �Է� : ");
//		input = br.readLine();
//		// �Էµ� ���ڿ��� ���ڷ� ��ȯ
//		char single_ch = input.charAt(0);
		char single_ch = (char)br.read();
		// ����Ű�� �ش�Ǵ� 2���� ���� (\r\n)�� ����
		br.skip(2);
		System.out.printf("�Էµ� ���� : %c\n", single_ch);
		
		// ��Ʈ���� ����� ����Ǹ� �ݵ�� close �޼ҵ带 ȣ���մϴ�.
		br.close();
		

	}
}
