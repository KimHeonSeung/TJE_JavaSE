package tje.thread;

import java.util.*;

class ThreadGame extends Thread {
	public ThreadGame(String name) { // name ����Ʈ�� ����. �� ������ �޾ƾ� ��ü�� �������.
		super(name);
	}
	public void run() {
		Random random = new Random();
		for( int i = 1 ; i <= 10 ; i++ ) {
			try {
				// 0 ~ 2999 ������ ���� ����Ͽ�
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

public class Thread_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ThreadGame> list = new ArrayList<>();
		
		System.out.print("���� �ο����� �Է��ϼ��� : ");
		int count = sc.nextInt();
		
		for( int i = 1 ; i <= count ; i++ ) {
			System.out.printf("%d ��° �������� �̸��� �Է��ϼ��� : ", i);
			list.add(new ThreadGame(sc.next()));
		}
		
		for( int i = 0 ; i < count ; i++ )
			list.get(i).start();
		
		// main ������� ���� �������� �����ϴ� ���¿���
		// ���� ����� �� �ֽ��ϴ�.
		System.out.println("���α׷� ����");
	}
}





// ���� �Ѱ�

//package tje.thread;
//
//import java.util.*;
//
//class Thread_As extends Thread {
//	public Thread_As(String name) {
//		super(name);
//	}
//
//	public void run() {
//		double num = 1000 + (Math.random() * 5000) + 1;
//		int sec = (int) num;
//
//		for (int i = 1; i < 11; i++) {
//			try {
//				Thread.sleep(sec);
//			} catch (InterruptedException e) {
//
//			}
//
//			if (i != 10) {
//				System.out.printf("%s ����  %d ������ ����߽��ϴ�.\n", this.getName(), i);
//
//			} else
//				System.out.printf("%s ���� ����߽��ϴ�.\n", this.getName());
//		}
//	}
//}
//
//class Thread_Bs extends Thread {
//	public Thread_Bs(String name) {
//		super(name);
//	}
//
//	public void run() {
//		double num = 1500 + (Math.random() * 5000) + 1;
//		int sec = (int) num;
//
//		for (int i = 1; i < 11; i++) {
//			try {
//				Thread.sleep(sec);
//			} catch (InterruptedException e) {
//
//			}
//			
//			if (i != 10) {
//				System.out.printf("%s ����  %d ������ ����߽��ϴ�.\n", this.getName(), i);
//
//				
//			} else
//				System.out.printf("%s ���� ����߽��ϴ�.\n", this.getName());
//
//		}
//	}
//}
//
//class Thread_Cs extends Thread {
//	public Thread_Cs(String name) {
//		super(name);
//	}
//
//	public void run() {
//		double num = 1700 + (Math.random() * 5000);
//		int sec = (int) num;
//
//		for (int i = 1; i < 11; i++) {
//			if (i != 10) {
//				
//				try {
//					Thread.sleep(sec);
//				} catch (InterruptedException e) {
//
//				}
//				System.out.printf("%s ����  %d ������ ����߽��ϴ�.\n", this.getName(), i);
//
//			} else
//				System.out.printf("%s ���� ����߽��ϴ�.\n", this.getName());
//		}
//	}
//}
//
//public class Thread_10 {
//
//	public static void main(String[] args) {
//		
//		
//		Thread_As t1 = new Thread_As("A");
//		Thread_Bs t2 = new Thread_Bs("B");
//		Thread_Cs t3 = new Thread_Cs("C");
//		
//		t1.start();
//		t2.start();
//		t3.start();
//
////		try {
////			Thread.sleep(6000);
////		} catch (InterruptedException e) {
////		}
//
////		t1.interrupt();
////		t2.interrupt();
////		t3.interrupt();
//
//	}
//
//}
