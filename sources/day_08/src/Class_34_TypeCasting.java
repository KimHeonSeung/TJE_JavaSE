class Casting_A {
	int num;
}

class Casting_B {
	int num;
}

public class Class_34_TypeCasting {
	public static void main(String[] args) {
		// �⺻ �ڷ��� ���� ����ȯ�� �ڷ����� ũ�⿡ ������ �޴´�.
		short s = 10;
		int i = s;

		// 4 Byte ũ���� int Ÿ���� ������
		// 2 Byte ũ���� short Ÿ�� ������ ������ �� ����.
		// s = i;

		i = 10000000;
		// ���� ����ȯ�� ���� ���� ������ ���
		// (���� �������� ������ �� ����.)
		s = (short) i;

		System.out.printf("s = %d, i = %d\n", s, i);

		// Ŭ������ ���۷��� �������� ����ȯ�� �� ���۷����� ���� ������ ������ �޴´�.

		// ���� �ٸ� Ŭ���� ��ü���� �� ��ȯ�� ������ �ʽ��ϴ�.
		// Ŭ������ ���۷����� �ش� Ŭ������ ����� ������ �� �ִ� ������
		// ���� �����Դϴ�.
		// a1 ���۷��� ������ Casting_A Ŭ������ Ÿ���� ��ü���� num ������ ������ �� �ִ� ����
		// b1 ���۷��� ������ Casting_B Ŭ������ Ÿ���� ��ü���� num ������ ������ �� �ִ� ����
		Casting_A a1 = new Casting_A(); // AŬ������ num�� ����
		// Casting_B b1 = a1; // BŬ������ num�� ����
		
		Casting_B b2 = new Casting_B();
		// Casting_A a2 = b2;
	}

}
