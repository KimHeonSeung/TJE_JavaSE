


class ThisA {
	private int num;
	public void setNum(ThisA this, int input_num) { // this ��� ������ �Ű�����. �����ϴ� �޼ҵ�� ���� ���� ��ü�� ��� �ʵ忡 ����.
		// Ŭ������ ����ʵ���� ������ ��ü���� �����˴ϴ�.(���� �ٸ� ����)
		// �ݸ�, ��� �޼ҵ�� �ϳ��� �����ϸ� ��� ��ü���� �����ϰ� �˴ϴ�.
		// �̶�, �Ʒ��� ���� Ư�� ����ʵ带 �����ϴ� �ڵ尡 
		// ������ ��ü���� ����� �� �ֵ��� this��� ������ Ű���带 �����մϴ�.
		// �Ʒ��� �ڵ尡 �����ϵ� ���� ������ �ɶ���
		// this.num = input_num;
		// ��ȯ�Ǿ� ����˴ϴ�.
		// this : ���� �޼ҵ带 �����ϰ� �ִ� ��ü�� ������
		num = input_num;
		
		// ���� �ڵ尡 ������ �� ���Ŀ� �����Ǵ� ����� this.num input_num; ���� ����ȴ�.
	}
	
	public void showInfo(ThisA this) {
		System.out.printf("num = %d\n",num);
		// ���� �ڵ尡 ������ �Ȥ� ���Ŀ� �����Ǵ� �����  System.out.printf("num = %d\n",this.num);
		}
}

public class Class_13_This {

	public static void main(String[] args) {
		ThisA a1 = new ThisA();
		ThisA a2 = new ThisA();
		ThisA a3 = new ThisA();
		
		a1.setNum(10); a2.setNum(20); a3.setNum(30);
		a1.showInfo(); a2.showInfo(); a3.showInfo();

	}

}
