package tje.thread;

import java.util.*;

class ThreadGame extends Thread {
	public ThreadGame(String name) { // name 디폴트가 없음. 꼭 네임을 받아야 객체가 만들어짐.
		super(name);
	}
	public void run() {
		Random random = new Random();
		for( int i = 1 ; i <= 10 ; i++ ) {
			try {
				// 0 ~ 2999 까지의 값을 사용하여
				// 쓰레드 객체를 잠시 중지함.
				// (int)(Math.random() * 5000)
				Thread.sleep(random.nextInt(5000)); // 이 쓰레드를 잠깐 멈춰라.
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
			System.out.printf("%s 님이 %d 바퀴를 통과했습니다.\n", 
					this.getName(), i);
		}		
		System.out.printf("%s 님이 도착했습니다.\n", this.getName()); 
	} // 쓰레드가 할일 다 하고 이제 사라진다.
}

public class Thread_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<ThreadGame> list = new ArrayList<>();
		
		System.out.print("참가 인원수를 입력하세요 : ");
		int count = sc.nextInt();
		
		for( int i = 1 ; i <= count ; i++ ) {
			System.out.printf("%d 번째 참가자의 이름을 입력하세요 : ", i);
			list.add(new ThreadGame(sc.next()));
		}
		
		for( int i = 0 ; i < count ; i++ )
			list.get(i).start();
		
		// main 쓰레드는 하위 쓰레들이 동작하는 상태에서
		// 먼저 종료될 수 있습니다.
		System.out.println("프로그램 종료");
	}
}





// 내가 한것

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
//				System.out.printf("%s 님이  %d 바퀴를 통과했습니다.\n", this.getName(), i);
//
//			} else
//				System.out.printf("%s 님이 통과했습니다.\n", this.getName());
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
//				System.out.printf("%s 님이  %d 바퀴를 통과했습니다.\n", this.getName(), i);
//
//				
//			} else
//				System.out.printf("%s 님이 통과했습니다.\n", this.getName());
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
//				System.out.printf("%s 님이  %d 바퀴를 통과했습니다.\n", this.getName(), i);
//
//			} else
//				System.out.printf("%s 님이 통과했습니다.\n", this.getName());
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
