
class D {
	private int age;

	// �����ڴ� �޼ҵ��̹Ƿ� �Ű������� ����� �� �ִ�.
	// �������� �Ű������� Ȱ���ϴ� ���
	// ������ ��ü���� ���� �ٸ� ���� ���� �� �ִ�.
	public D(int input_age) {
		System.out.println("�Ű������� ����ϴ� ������ ����");
		age = input_age;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int input_age) {
		age = input_age;
	}
}



public class Class_09_Constructor {
	public static void main(String[] args) {

		// ���� Ŭ������ �����ڸ� ����ڰ� ���� �ۼ��ϴ� ��� �����Ϸ��� ����Ʈ �����ڸ� �������� �ʴ´�.
		// D d = new D();

		// �Ű������� ������ �����ڸ� ���� ��ü�� �����ϴ� �ڵ�
		D d1 = new D(10);
		D d2 = new D(22);
		D d3 = new D(33);
		System.out.println(d1.getAge());
		System.out.println(d2.getAge());
		System.out.println(d3.getAge());
	}

}
