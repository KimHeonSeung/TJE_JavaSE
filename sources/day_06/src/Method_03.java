
public class Method_03 {
	
	// Call By Value ����� �޼ҵ� ȣ��
	// �޼ҵ带 ȣ���� �� �����ϴ� �Ű������� ���� ��츦 �ǹ� ( int, float, double ...)
	// �Ʒ��� setNum �޼ҵ带 �����ϱ� ���� main �޼ҵ��� num ������ ���� 10�� ����ְ�,
	// setNum �޼ҵ忡�� �ش� ���� 777���� ����������,
	// main �޼ҵ��� num ������ ���� ������� �ʴ´�.
	// ���� �����ϴ� �޼ҵ� ȣ���̾��� ������ .. (Stack �޸��� ���� ����)
	
	// 1. �޼ҵ��� �Ű������� ����������.
	// 2. ���� �ٸ� �޼ҵ忡�� ������ �̸��� ������ �����ϴ� ���� �����ϴ�.	
	public static void setNum(int num) {
		num = 777;
		System.out.printf("(setNum) num = %d\n",num);
	}

	public static void main(String[] args) {
		
		int num = 10;
		
		System.out.printf("(main) num = %d\n",num);
		
		setNum(num);
		
		System.out.printf("(main) num = %d\n",num);
		
		System.out.println("���α׷� ����");
		

	}

}
