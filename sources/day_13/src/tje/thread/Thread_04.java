package tje.thread;

// ���α׷��� ���� �� ���ÿ� ó���ϰ��� �ϴ� �۾��� ������ ����
// java.lang.Thread Ŭ������ ����� �� �ֽ��ϴ�.

// Thread
// ���α׷� ������ �帧�� �б��� �� �ִ� ����� �����ϴ� Ŭ����
// ex) OS�� ��Ƽ�½�ŷ

// �������
// 2. Runnable �������̽��� �����ϴ� ���
// 2. Runnable �������̽��� �����ϴ� ���
// 2-1. Runnable �������̽��� �����ϴ� Ŭ���� �ۼ�
// 2-2. public void run() �������̵� ����
// 2-3. �ش� Ŭ������ A ��ü ����
// 2-4. A ��ü�� Thread Ŭ������ �����ڷ� �����Ͽ�
//		Thread ��ü ����
// 2-5. ������Ų �������� start �޼ҵ� ȣ��!

class Thread_D_1 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Thread_D_1 -> i = %d\n", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Thread_D_2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Thread_D_2 -> i = %d\n", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Thread_04 {

	public static void main(String[] args) {
		// Runnable �Τ������̽��� ������ ������ ����
		// 1. Runnable �������̽��� ������ Ŭ������ ��ü ����
		Thread_D_1 d1 = new Thread_D_1();
		// Thread_D_2 d2 = new Thread_D_2();

		// 2. 1���� ������ ��ü�� ����Ͽ� Tread ��ü ����
		Thread t1 = new Thread(d1);
		// Thread t2 = new Thread(d2);

		// 3. 2���� ������ Tread ��ü�� ����Ͽ� start �޼ҵ� ȣ��
		t1.start();
		// t2.start();

		// ���� ������ �� �������� �ۼ��� �ڵ�
		new Thread(new Thread_D_2()).start();

		for (int i = 1; i <= 10; i++) {
			System.out.printf("main -> i = %d\n", i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
