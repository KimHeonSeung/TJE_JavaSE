package tje.util;

// ������ ����Ͽ� ������ ���� ��ȯ�� �� �ִ� Ŭ����
// ���� : 0 ~ 1 ������ ��
// (0 �� 1�� ���Ե��� ����)
import java.util.Random;

public class Random_01 {

	public static void main(String[] args) {
		// Random r1 = new Random();
		// ������ �Ű������� seed ���� �����ϴ� ���
		// ������ ������ ������ �������� ��ȯ��
		
		Random r1 = new Random(10);
		
		double a = Math.random();
		
		System.out.println(a);
		for ( int i = 0 ; i < 10 ; i++ ) {
//			// Random Ŭ������ nextInt �޼ҵ�
//			// ������ ����Ͽ� ������ ������ ��ȯ�ϴ� �޼ҵ�
//			// �Ű������� ������� �ʴ� ��� ������ �������� ����
//			// ������ ���ڰ� ��ȯ
//			// ��ȯ�Ǵ� ���� ���� : ���� * �Ű�����
//			// (int)(Math.random()*45+1)
//			// nextInt(45)+1
			
//			int random_number = r1.nextInt();
//			System.out.printf("%d : %d\n", i+1, random_number);
			
			int random_number = r1.nextInt(7);
			int rea = new Random().nextInt(10);
			System.out.printf("random_number -> %d\n", random_number);
			System.out.printf("rea -> %d\n", rea);
		}
		
		

	}

}
