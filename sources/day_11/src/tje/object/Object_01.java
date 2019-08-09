package tje.object;

// ����� ���� Ŭ������ �����ϸ鼭, extends (���) �� �������� ������
// �ڵ����� java.lang.Object Ŭ������ ��ӹ޴´�.

// java.lang.Object Ŭ���� : Java ���� ���Ǵ� ��� Ŭ�������� �ֻ��� �θ�Ŭ����

class Object_A {}

public class Object_01 {

	public static void main(String[] args) {
		Object_A obj = new Object_A();
		
		// getClass �޼ҵ�� �ش� ��ü�� Ŭ���� Ÿ���� ��ȯ (Class Ÿ���� ��ȯ)
		System.out.println(obj.getClass());
		
		// hashCode �޼ҵ�� �ش� ��ü�� �ؽ��ڵ� ���� ��ȯ
		// (�ش� ��ü�� JVM�� ���� �����ǰ� �ִ� ��ȣ)
		System.out.println(obj.hashCode());
		
		// toString �޼ҵ�� �ش� ��ü�� ������ ���ڿ��� ��ȯ
		// ��ü�� Ŭ������ + '@' + �ؽ��ڵ尪(16����)
		System.out.println(obj.toString());
	}

}
