import java.util.Scanner;

class Student_my {
	Scanner kb = new Scanner(System.in);
	int sum = 0;
	double avg;
	private String s;
	private char d;
	int a;

	public Student_my(String name) {
		s = name;
	}

	public void input() {
		do {
			System.out.printf("���� ������ �Է� (0 ~ 100) : ");
			a = kb.nextInt();
		} while (a < 0 || a > 100);
		sum += a;
		do {
			System.out.printf("���� ������ �Է� (0 ~ 100) : ");
			a = kb.nextInt();
		} while (a < 0 || a > 100);
		sum += a;
		do {
			System.out.printf("���� ������ �Է� (0 ~ 100) : ");
			a = kb.nextInt();
		} while (a < 0 || a > 100);
		sum += a;
		avg = (double) sum / 3;
		if (avg >= 90)
			d = 'A';
		else if (avg >= 80)
			d = 'B';
		else if (avg >= 70)
			d = 'B';
		else if (avg >= 60)
			d = 'B';
		else
			d = 'F';
	}

	public void output() {
		System.out.println("--------------------------");
		System.out.printf("%s �л��� ���� ������ ����մϴ�.\n", s);
		System.out.printf("���� : %d ��, ��� : %.2f ��\n", sum, avg);
		System.out.printf("��� : %c\n", d);
		System.out.println("--------------------------");
	}
}

public class Class_12_Construcktor_my {

	public static void main(String[] args) {
		// �Ʒ��� �ڵ尡 ����� �� �ֵ��� Ŭ������ �ۼ��ϼ���.
		// ���� ���
		// ���� ������ �Է� : 100
		// ���� ������ �Է� : 100
		// ���� ������ �Է� : 100
		// ----------------------------
		// �ƹ��� �л��� ���� ������ ����մϴ�.
		// ���� : 300 ��, ��� 100.00 ��
		// ��� : A
		// ----------------------------

		Student_my s = new Student_my("�ƹ���");
		s.input();
		s.output();

	}

}
