
class SuperA {
	private int n1;
	public int n2;
	// ����Ʈ ���� ������
	// �⺻�����δ� public ó�� ����
	int n3;
}
class SubA extends SuperA {
	public void printInfo() {
		// �θ� Ŭ������ private ����� �ڽ�Ŭ�������� ������ �� ���� ����̴�.
		// System.out.printf("n1 = %d\n", n1);
		// �θ� Ŭ������ public, ����Ʈ ���� �����ڷ� ����� ����� �ڽ�Ŭ�������� ������ �� �ִ� ����̴�.
		System.out.printf("n1 = %d\n", n2);
		System.out.printf("n1 = %d\n", n3);
	}
}

public class Class_28_Extends {

	public static void main(String[] args) {
	}
}
