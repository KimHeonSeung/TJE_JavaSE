
class Second {
	// Ŭ������ ����ʵ� ����
	String name;
	int age;
	
	// Ŭ������ ����޼ҵ� ����
	// �ش� Ŭ������ ������ �� �ִ� ����� �����ϱ� ���� �޼ҵ� ����
	void input(String input_name, int input_age) {
		// Ŭ������ ����޼ҵ忡���� ����ʵ忡 ������ �� �ִ�.
		name = input_name;
		age = input_age;
	}
	
	void output() {
		System.out.printf("�̸��� %s, ���̴� %d �Դϴ�. \n", name, age);
	}
}


public class Class_02_Define {

	public static void main(String[] args) {
		Second s = new Second();
		
		s.input("�ƹ���", 22);
		s.output();

	}

}
