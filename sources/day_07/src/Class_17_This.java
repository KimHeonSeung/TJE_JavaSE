
class ThisE {
	private int num1;
	private int num2;
	private int num3;

	public ThisE(int num1) {
		this.num1 = num1;
	}

	public ThisE(int num1, int num2) {
		// this Ű���带 ���� �������� ȣ���� ������ ������ ù��° ���๮���θ� �����ϴ�.
		// Ư�� �������� ������ �ѹ����� �����ϱ� ���� ����
		// ��� ������ ������ �ִ�.
		this(num1);
		this.num2 = num2;
		// this(num1);
	}

	public ThisE(int num1, int num2, int num3) {
		// this Ű���带 ���� �������� ȣ���� ������ ������ ù��° ���๮���θ� �����ϴ�.
		this(num1, num2);
		this.num3 = num3;
		// this(num1, num2);
	}

}

public class Class_17_This {
	public static void main(String[] args) {
		ThisB obj = new ThisB(100);
		obj.showInfo();

	}

}
