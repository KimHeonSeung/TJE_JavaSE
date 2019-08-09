package tje.thread;

import java.util.*;

class ThreadGameWithJoin extends Thread {
	public ThreadGameWithJoin(String name) { // name ����Ʈ�� ����. �� ������ �޾ƾ� ��ü�� �������.
		super(name);
	}
	public void run() {
		Random random = new Random();
		for( int i = 1 ; i <= 10 ; i++ ) {
			try {
				// 0 ~ 4999 ������ ���� ����Ͽ�
				// ������ ��ü�� ��� ������.
				// (int)(Math.random() * 5000)
				Thread.sleep(random.nextInt(5000)); // �� �����带 ��� �����.
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
			System.out.printf("%s ���� %d ������ ����߽��ϴ�.\n", 
					this.getName(), i);
		}		
		System.out.printf("%s ���� �����߽��ϴ�.\n", this.getName()); 
	} // �����尡 ���� �� �ϰ� ���� �������.
}

public class Thread_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ThreadGameWithJoin> list = new ArrayList<>();
		
		System.out.print("���� �ο����� �Է��ϼ��� : ");
		int count = sc.nextInt();
		
		for( int i = 1 ; i <= count ; i++ ) {
			System.out.printf("%d ��° �������� �̸��� �Է��ϼ��� : ", i);
			list.add(new ThreadGameWithJoin(sc.next()));
		}
		
		for( int i = 0 ; i < count ; i++ )
			list.get(i).start();
		
		// main ������� ���� �������� �����ϴ� ���¿���(main ���� ������ ������ ��ü��)����
		// �����ϴ� ���¿��� ���� ����� �� �ִ�.
		// ���� ����� �� �ֽ��ϴ�.
		// ���� main ������� �ٸ� ���� ��������� ��� ����� �� ����
		// ����ϰ� �ִ� ��� join �޼ҵ� ���
		
		// Thread Ŭ������ join �޼ҵ�
		// Ư�� �����尡 �ٸ� �����忡 ���ӵǾ�
		// �ٸ� �����尡 ������ �� ���� ����ϴ� �޼ҵ�
		for( int i = 0 ; i < count ; i++ )
			try {
				// main ������� ����Ʈ ���ο� �����ϴ� 
				// ������ �����尡 ����� �� ���� 
				// ���� �ڵ忡�� ����մϴ�.
				list.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		// ��� ������ ��ü���� run �޼ҵ尡 ����� ����
		// ����Ǵ� �ڵ�
		System.out.println("���α׷� ����");
	}
}
