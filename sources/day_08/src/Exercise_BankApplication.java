
import java.util.Scanner;

public class Exercise_BankApplication {
	
	private static Account_Exa [] accountArray = new Account_Exa[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1. ���»��� | 2. ���¸�� | 3. ���� | 4. ��� | 5. ����");
			System.out.println("----------------------------------------------");
			System.out.print("����> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}

		}

		System.out.println("���α׷� ����");
	}

	// ���� �����ϱ�
	private static void createAccount() {
		
		System.out.println("-------");
		System.out.println("���»���");
		System.out.println("-------");
		System.out.print("���¹�ȣ : ");
		String s = scanner.next();
		System.out.print("������ : ");
		String n = scanner.next();
		System.out.print("�ʱ� �Աݾ� : ");
		int b = scanner.nextInt();
		
		Account_Exa member = new Account_Exa(s,n,b);
		for ( int i = 0 ; i < accountArray.length ; i++) {
			if ( accountArray[i] == null) {
				accountArray[i] = member;
				System.out.println("��� : ���°� �����Ǿ����ϴ�.");
				break;
			} 
		} 
	}

	// ���� ��Ϻ���
	private static void accountList() {
		System.out.println("-------");
		System.out.println("���¸��");
		System.out.println("-------");
		for ( int i = 0 ; accountArray[i]!= null ; i++) {
			Account_Exa member = accountArray[i];
			String member_ano = member.getAno();
			String member_nam = member.getOwner();
			int member_bal = member.getBalance();
			System.out.printf("%9s       %5s       %d11\n", member_ano, member_nam, member_bal);
		}
		
	}

	// �����ϱ�
	private static void deposit() {
		System.out.println("-------");
		System.out.println("����");
		System.out.println("-------");
		System.out.print("���¹�ȣ : ");
		String s = scanner.next();
		System.out.print("���ݾ� : ");
		int b = scanner.nextInt();
		
		for ( int i = 0 ; accountArray[i] != null ; i++ ) {
			Account_Exa member = accountArray[i];
			String member_ano = member.getAno();
			int member_bal = member.getBalance();
			if(s.equals(member_ano)) {
				member_bal += b;
				member.setBalance(member_bal);
				System.out.println("������ �����Ǿ����ϴ�.");
			} else
				continue;
		}
	}

	// ����ϱ�
	private static void withdraw() {
		System.out.println("-------");
		System.out.println("���");
		System.out.println("-------");
		System.out.print("���¹�ȣ : ");
		String s = scanner.next();
		System.out.print("��ݾ� : ");
		int b = scanner.nextInt();
		
		for ( int i = 0 ; accountArray[i] != null; i++ ) {
			Account_Exa member = accountArray[i];
			String member_ano = member.getAno();
			int member_bal = member.getBalance();
			if(s.equals(member_ano)) {
				member_bal -= b;
				member.setBalance(member_bal);
				System.out.println("����� �����Ǿ����ϴ�.");
			} else
				continue;
		}
	}
}
