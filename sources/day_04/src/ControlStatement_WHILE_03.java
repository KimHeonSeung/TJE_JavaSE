
public class ControlStatement_WHILE_03 {

	public static void main(String[] args) {
		// while ���� ����Ͽ� ������ ���


		int i = 2;
		int j = 1;

		while (i <= 9) {
			System.out.printf("%d���� �����մϴ�.\n", i);
			while (j <= 9) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
				j++;
			}
			j = 1;
			System.out.println();
			i++;
		}
		
		System.out.println("������ ����");

	}

}
