
public class Exercise_Child extends Exercise_Parent {
	private int studentNo;
	
	public Exercise_Child(String name, int studentNo) {
		// �θ� Ŭ������ �����ڸ� ȣ���ؾ��Ѵ�. (5�� ������ ����)
		super(name);
		// this.name = name;
		this.studentNo = studentNo;
	}
}
