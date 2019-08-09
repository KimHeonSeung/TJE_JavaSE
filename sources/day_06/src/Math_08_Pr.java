import java.util.Scanner;

public class Math_08_Pr {

	public static int getStNum(Scanner kb) {
		System.out.print("�л� �� : ");
		return kb.nextInt();
	}

	public static int getStSc(Scanner kb) {
		System.out.print("���� �� : ");
		return kb.nextInt();
	}

	public static void input(Scanner kb, int[][] scores) {
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d��° �л��� ���� �Է�\n", i + 1);
			inputSc(kb, scores[i]);
		}
	}

	public static void inputSc(Scanner kb, int[] sc) {
		for (int i = 0; i < sc.length; i++) {
			do {
				System.out.printf("%d��° ���� ( 0 ~ 100 ) : ", i + 1);
				sc[i] = kb.nextInt();
			} while (sc[i] < 0 || sc[i] > 100);

		}
	}

	public static void output(int[][] scores) {
		System.out.println("----------------");
		System.out.println("���� ����� �����մϴ�.");
		System.out.println("----------------");

		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d��° �л��� ���� : %d, ��� : %.2f, ��� : %c\n", i + 1, getTot(scores[i]), getAvg(scores[i]),
					getDeg(scores[i]));
		}
	}

	public static int getTot(int[] scores) {
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return sum;
	}

	public static double getAvg(int[] scores) {
		return (double) getTot(scores) / scores.length;
	}

	public static char getDeg(int[] scores) {
		if (getAvg(scores) >= 90)
			return 'A';
		else if (getAvg(scores) >= 80)
			return 'B';
		else if (getAvg(scores) >= 70)
			return 'C';
		else if (getAvg(scores) >= 60)
			return 'D';
		else
			return 'F';
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[][] scores;

		scores = new int[getStNum(kb)][getStSc(kb)];

		input(kb, scores);

		output(scores);

		
		// ������ �迭 ���� Ȯ��
		System.out.println();
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				System.out.printf("scores[%d][%d] = %d\n", i, j, scores[i][j]);
			}
		}
		kb.close();

	}
}
