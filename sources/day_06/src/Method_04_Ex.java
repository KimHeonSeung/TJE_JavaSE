
public class Method_04_Ex {

	public static void gugudanByNumber(int dan, int[][] gugudan) {
		// �������� ����� 2���� �迭�� ����
		for (int i = 0; i < gugudan.length; i++) {
			// �ܼ��� ����
			gugudan[i][0] = dan;
			gugudan[i][1] = i + 1;
			gugudan[i][2] = dan * (i + 1);
		}

//		System.out.printf("%d�� ���� ���� ����\n", i);
//		for ( int k = 1 ; k <= gugudan[i].length ; k++ ) {
//		gugudan[k][k]=i*k;
//		}
//		System.out.printf("%d�� ���� ���� �Ϸ�\n", i);

	}

	public static void main(String[] args) {
		// �������� ����� ������ �� �ִ� �迭�� �����ϼ���.
		// EX) 2, 1, 2
		// 2, 2, 4
		// main �޼ҵ忡 ����� ������ �迭�� gugudanByNumber ��� �޼ҵ忡 �����Ͽ�
		// �� �������� ����� �����ϰ� main �޼ҵ忡�� ����ϵ��� �����ϼ���.

		int[][] gugudan;

		for (int i = 2; i < 10; i++) {
			gugudan = new int[9][3];
			gugudanByNumber(i, gugudan);
			for (int j = 0; j < gugudan.length; j++) {
				System.out.printf("%d * %d = %d\n", gugudan[j][0], gugudan[j][1], gugudan[j][2]);
			}
		}

	}

}
