import java.util.Scanner;

public class ControlStatement_SWITCH_01 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int menu;
		System.out.println("1.���  2.���  3.����");
		System.out.print("���ϴ� �޴��� �����ϼ��� : ");
		menu = kb.nextInt();
		kb.close();
		
		
		// break Ű����
		// if ���� ������ ù ��° ������ ���������� ����. ù��° ��� ���� �극��ũ Ű���带 ���ΰ� �ִ� ���� �ǹ�. if ���� ���ð� �ȴ�.
		// switch, �ݺ������� ���
		// switch �������� �ش� case ������ ��, switch ���� �����ϱ� ���� ���
		
		// switch ���� �Էµ� ������ ���� �� case ���ǵ� ���� ���ϸ鼭 ������ ���� ���ǵ� case�� ���๮�� ����
		// �� ��, break Ű���带 �����ų� switch���� ����� �� ���� ����
		switch ( menu ) {
			case 1: 
				System.out.println("������ ����� �Ŷ��");
				if( true ) {
				break;
				}
			case 2: 
				System.out.println("������ ����� ġ����");
				
			case 3: 
				System.out.println("������ ���δ� ���񸸵�");
				
			default : 
				System.out.println("�߸��� ��ȣ�� �����߽��ϴ�.");
		}

	}

}