class MemberService {
	public boolean login(String id, String password) {
		if ( id == "hong" && password == "12345")
			return true;
		else
			return false;
	}
	
	public void logout(String id) {
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}
}



public class Exercise_MemberService {

	public static void main(String[] args) {
		
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		
		if(result) {
			System.out.println("�α��� �Ǿ����ϴ�.");
			memberService.logout("hong");
		} else {
			System.out.println("id �Ǵ� password�� �ùٸ��� �ʽ��ϴ�.");
		}
		

	}

}