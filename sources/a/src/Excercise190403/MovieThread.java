package Excercise190403;

public class MovieThread extends Thread {
	@Override
	public void run() {
		while(true) {
		System.out.println("�������� ����մϴ�.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
		
		
		
		
		
		
		
//		while(true) {
//			System.out.println("�������� ����մϴ�.");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				break;
//			}
//		}
		
		
		
		
		
		
		
//		for (int i = 0; i < 3; i++) {
//			System.out.println("������ ����� �մϴ�.");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//
//			}
//		}
	}
}
