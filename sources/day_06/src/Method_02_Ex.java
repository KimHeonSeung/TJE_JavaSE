import java.util.Scanner;

public class Method_02_Ex {
	
	
	public static void gugudan_one(int dan) {
		System.out.println("");

			System.out.printf("%d���� ����մϴ�.\n", dan);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\n", dan, j, dan * j);
			}
			System.out.println("");
		}

	public static void main(String[] args) {
		// ���� �Ѱ��� �Ű������� ���޹޾� �ش� ������ �������� ����� �� �ִ� �޼ҵ带 �����ϱ�.
		// (�޼ҵ�� : gugudan_one)
		// ����ڿ��� ������ �Է¹޾� �ռ� ������ gugudan_one �޼ҵ带 ����Ͽ�
		// �ش� ������ �������� ����ϼ���.
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("����ϰ��� �ϴ� �ܼ��� �Է��ϼ��� : ");
		int input = kb.nextInt();
		
		gugudan_one(input);
		
		System.out.println("���α׷� ����");
		
		kb.close();
		

	}

}
