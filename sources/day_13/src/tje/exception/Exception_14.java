package tje.exception;

// �޼ҵ� �������̵�
// �θ�Ŭ������ �޼ҵ带 �ڽ�Ŭ�������� �������ϴ� ����
// ��Ģ
// 1. �޼ҵ��� ������ �����ؾ� �Ѵ�. (���ϰ��� Ÿ��, �޼ҵ��, �Ű�����)
// 2. ������������ ������ ��ҵ� �� ����.
//	  (�θ�Ŭ������ ���۷����� ����Ͽ� ���ٵ� �� �ֱ� ������
//	      �θ�Ŭ������ ���۷����� �����ϰ� �ִ� ���ٹ����� ����� �� ����.)
// 3. �θ�Ŭ������ �޼ҵ忡�� throws �ϴ� ����ó�� Ŭ��������
//	    ���� Ŭ������ throws �� �� ����.

class Super {
	public void print() throws NullPointerException {}
}

class Sub extends Super {
	// public void print() throws Exception {}
}

public class Exception_14 {

	public static void main(String[] args) {
		Super s = new Sub();
		
		s.print();
		// �θ�Ŭ������ ���۷��� ������ �����ϴ� ���
		// NullPointerException e = s.print();
		// NullPointerException e = throws new NullPointerException();
		// ���� ����Ǵ� ���
		// �ڽ�Ŭ������ ���۷����� �θ�Ŭ������ ��ü�� �����ϴ� ���°� �ǹǷ� 
		// �ڽ�Ŭ�������� �������̵��ϴ� �޼ҵ�� �θ�Ŭ�������� throws �ϴ� 
		// ����Ŭ�������� ����Ŭ������ throws �� �� ����.
		// NullPointerException e = throws new Exception();
	}

}