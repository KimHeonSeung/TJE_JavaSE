class A {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int input_age) {
		age = input_age;
	}
	
	
}
public class Class_06_Constructor {
	public static void main(String[] args) {
		A a = new A();
		
		// ��ü�� ������ ��, ����ʵ� ���� �����ϸ�
		// HEAP �޸� Ư���� ���� 0(�Ǵ� null) ������ �ʱ�ȭ�ȴ�.
		System.out.println(a.getAge());
		
		// ���� ��ü�� ����ʵ忡 ������ ������ �ʱ�ȭ�� �ϰ��� �Ѵٸ� Ŭ������ ��ü�� ������ ��,
		// ��ü�� �����ϰ� �ִ� ����ʵ��� ���� ������ �� �ִ� setter �޼ҵ带 ȣ���ؾ� �Ѵ�.
		a.setAge(22);
		
		System.out.println(a.getAge());
		
	}

}
