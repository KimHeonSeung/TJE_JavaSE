
class C {
	private int age;
	
	// ���� Ŭ������ �����ϸ鼭 '�����ڸ� �ۼ����� ���� ���'
	// �ڹ� �����Ϸ��� ���ؼ� �Ʒ��� ���� ������ �ڵ尡 �߰��ȴ�.
	// ����Ʈ ������ : �Ű������� ����, �����ڵ尡 ���� �⺻ ������
	// public C() {}
	
	public int getAge() {
		return age;
	}

	public void setAge(int input_age) {
		age = input_age;
	}
}

public class Class_08_Constructor {
	public static void main(String[] args) {
		// ����Ʈ �����ڸ� ���ؼ� ��ü�� �����Ǵ� ����
		C c = new C();

	}

}
