// ���� ������
// ��� Ŭ������ ����� ���ǿ� �����ϴ� ����� �����μ�, �������� ������ ���Ǵ� �Ͱ� ���Ǹ� �ȵǴ� ������ �ִ�.
// ���� �����ڴ� Ŭ������ ����鿡 ���� ������ �����ϴ� Ű�����̴�.
// private : Ŭ���� ���ο����� ��� ������ ����� �����ϴ� Ű����
// public : ���ٿ� ������ ���� ����� �����ϴ� Ű����

class AccountWithPermission {
		// ���� ����
		// Ŭ���� ���ο� ����� ����ʵ���� ���ǿ��� �����ϴ� ����� ������ �����Ѵ�.
		// �Ϲ������� �̷��� �������� ���������� �����ؼ� �ȵȴ�.
		// �̷��� ������ ��� ����ʵ���� private���� �����ϰ�,
		// ����ʵ���� ������ �� �ִ� �޼ҵ���� public���� �����Ѵ�.
	
		// Ŭ���� �ܺο����� ������ ���ܵ� �ܾ� ������ �����ϴ� ����ʵ�
		private double balance;

		public void initBalance(double money) {
			balance = money;
		}

		public void withraw(double money) {
			// ���������� �����ϴ� �ڵ� ( ���������� ���� )
			if ( balance < money ) {
				System.out.println("�ܾ��� �����մϴ�.");
				return;
			}
			balance -= money;
		}

		public void deposit(double money) {
			// ���������� �����ϴ� �ڵ� ( ���������� ���� )
			if (money<0) {
				System.out.println("�Ա� �ݾ׿� ������ �߻��߽��ϴ�.");
				System.out.println("�����ڿ��� �����ϼ���");
				return;
			}
			balance += money;
		}

		public void display() {
			System.out.printf("���� �ܾ��� %.2f �� �Դϴ�.\n", balance);
		}
}

public class Class_04_Access {
	public static void main(String[] args) {
		AccountWithPermission a = new AccountWithPermission();
		
		// public ���� �����ڰ� ����� ����ʵ�/�޼ҵ�� Ŭ������ �ܺο��� ������ �� �ִ� ����̴�.
		a.initBalance(10000);
		a.display();
		
		a.withraw(5000);
		a.display();
		
		a.deposit(500000);
		a.display();
		
		a.withraw(10000000);
		a.display();
		
		// private ������ ����� Ŭ���� �ܺο����� ������ ���ܵȴ�.
		// a.balance = 100000000;
		
	}

}
