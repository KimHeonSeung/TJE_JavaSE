import java.util.Scanner;

public class Method_05 {
	// ���ϵǴ� ���� �����ϴ� �޼ҵ��� ����
	// ���ϰ� : �޼ҵ��� ���� ���� ���� ȣ���� �������� ��ȯ�ϴ� ��
	// �޼ҵ��� ����ο� ��ȯ�ϰ��� �ϴ� ���� Ÿ���� ������ �� �ִ�.

	// ���ϰ��� Ÿ���� ������ �޼ҵ�� �޼ҵ��� ���ο��� �ݵ�� return Ű����� �Բ� ��ȯ�� ���� �����ؾ߸� �Ѵ�.

	// ���� �Ѱ��� �Ű������� ���޹޾� ������ ���� ��ȯ�ϴ� squar �޼ҵ� ����
	public static int squar(int num) {
		// return Ű����
		// �޼ҵ��� ������ ������ �� �ִ� ���
		// �޼ҵ��� ���ο��� return Ű���尡 ���Ǹ� �ش� ��ġ���� �޼ҵ��� ������ ����ȴ�.
		// ���ϰ��� �����ϴ� �޼ҵ��� ��� return Ű����� �Բ� ��ȯ�� ���� ������ �� �ִ�.
		// ������ �� : ���ϰ��� Ÿ�Կ� ���ǵ� �ڷ������θ� ��ȯ�� �� �ִ�.
		return num * num;
	}

	public static void returnTest(int num) {
		// Ư�� �޼ҵ��� ���ฦ �����ϰ� ȣ���� �������� ���ư��� ���� return Ű����.
		// ��ȯ���� ��� ����� �� �ִ�.
		if (num % 2 == 1) {
			return;
		}
		System.out.println("returnTest �޼ҵ� ����~!");
		System.out.printf("�Ű����� num�� ���� %d �Դϴ�.\n", num);

	}

	// 3���� ������ �Ű������� ���޹޾� ���� ū ���� ��ȯ�ϴ� max �޼ҵ带 �����ϰ�
	// main �޼ҵ忡�� �׽�Ʈ �ϼ���.

	public static int max(int n1, int n2, int n3) {

		int r;

		if (n1 > n2)
			r = n1;
		else
			r = n2;

		if (n3 > r)
			r = n3;

		return r;
	}

	public static int max_my(int n1, int n2, int n3) {
		int m;
		if (n1 >= n2 && n1 >= n3)
			m = n1;
		else if (n2 >= n1 && n2 >= n3)
			m = n2;
		else
			m = n3;
		return m;
	}

	// �������� 1���� �迭�� �Ű������� ���޹޾� �ش� �迭�� ��� ��Ҹ� ������ �迭�� ��ȯ�ϴ� �޼ҵ�
	public static int[] squar_array(int[] source) {
		int[] result = new int[source.length];
		for (int i = 0; i < source.length; i++) {
			result[i] = source[i] * source[i];
		}
		return result;
	}

	public static void main(String[] args) {

		int[] source_main = { 10, 20, 30 };
		// 100, 400, 900
		int[] squar_result = squar_array(source_main);
		for (int i = 0; i < squar_result.length; i++) {
			System.out.println(squar_result[i]);
		}

		int num = 14;

		// ������ ���� ��ȯ�ϱ� ���� �޼ҵ带 ȣ���� ��, ������ ����� ��ȯ����.
		// ���ϰ��� Ÿ���� ����� �޼ҵ�� ������ ����� ȣ���� �������� ��ȯ�� �� �ִ�.
		int num_squar = squar(num);
		System.out.printf("num_squar = %d\n", num_squar);

		returnTest(num);

		int max_r = max(10, 5, 17);
		int max_my_r = max_my(11, 62, 53);

		System.out.printf("max_r = %d\n", max_r);
		System.out.printf("max_my_r = %d\n", max_my_r);

	}

}
