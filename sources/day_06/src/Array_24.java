import java.util.Scanner;

public class Array_24 {

	public static void main(String[] args) {
		// ����ڿ��� ������ ���� 5���� �Է¹޾� �迭�� �����ϱ�.
		// �迭�� �����Ͽ� �Էµ� ������ ������������ ������ ��, �����迭�� ���ĵ� �迭�� ���� ����ϱ�.

		Scanner kb = new Scanner(System.in);

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d��° ������ �Է��ϼ���. : ", i + 1);
			arr[i] = kb.nextInt();
		}

		System.out.println("");

		// ���� �迭�� �и��� ���ο� �迭 ����
		int[] arr_copy = arr.clone();

		// ��ø�� �ݺ����� Ȱ���Ͽ� ������ ����
		for (int i = 0; i < arr_copy.length - 1; i++) {
			for (int j = i + 1; j < arr_copy.length; j++) {
				if (arr_copy[i] > arr_copy[j]) { // ���ҷ���. ���������� �ε�ȣ�� �ٲٸ� ��
					int temp = arr_copy[j];
					arr_copy[j] = arr_copy[i];
					arr_copy[i] = temp;
				}
			}
		}
		
		// �ΰ��� �迭�� ���

		System.out.println("���� �迭�� ������ �����ϴ�.");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
		System.out.println("");
		System.out.println("����� �迭�� ������ �����ϴ�.");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr_copy[%d] = %d\n", i, arr_copy[i]);
		}
		kb.close();

	}

}
