package tje.exception;

import java.util.*;

public class Exception_09 {

	public static void main(String[] args) {
		// Ű���� �Է� �۾��� ó���ϱ� ��ȯ Scanner ��ü�� ����
		Scanner kb = new Scanner(System.in);

		String name; // �л� �̸�
		int age; // �л� ����

		try {
			System.out.print("�̸��� �Է��ϼ��� : ");
			name = kb.next();
	
			System.out.print("���̸� �Է��ϼ��� : ");
			age = kb.nextInt();
	
			System.out.printf("�̸� : %s, ���� : %d �Դϴ�.\n", name, age);
			
			// try ���������� �����ڵ�� �Ϲ������� ����¿� ���õ� �۾��� ����.
			// �ڹٿ����� ������� ��Ʈ���� ������ ����ϰ� ������
			// ��� ����� �۾� ��, ��Ʈ���� �����ϴ� �ڵ尡 �ʿ��ϴ�.
			// �Ʒ��� ���� try �������� close �޼ҵ带 ȣ���ϴ� ���
			// ���ܰ� �߻��� �� ������� ���ϴ� ������ �����Ƿ�
			// catch �������� close�� �����ؾ� �Ѵ�.
			
			// ���ܰ� �߻����� ���� ��� close ó��
			// kb.close();
			
		} catch(Exception e) {
			// ���ܰ� �߻��� ��� close ó��
			// kb.close();
			e.printStackTrace();
		} finally {
			// ������ �߻� ���ο� ������� �׻� ����Ǵ� ����
			// �Ϲ������� ����¿� ���õ� ��Ʈ���� �����ϴ� �ڵ带 �ۼ�.
			System.out.println("finally ����");
			kb.close();
		}
		// Scanner Ŭ������ Ȱ���Ͽ� Ű���� �Է��� ó���ϴ� ���
		// �ݵ�� ����� �� �� close �޼ҵ带 ȣ���Ͽ�
		// �����ؾ߸� �մϴ�.
		// kb.close();
		System.out.println("���α׷� ����");
	}

}
