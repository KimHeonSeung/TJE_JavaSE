package tje.exception;

// ����� ���� ����ó�� Ŭ������ ����
// throw �� throws Ű���带 ����Ͽ� Ư�� ��ɿ�
// ������ ������ �߻��� ��� ������ ���ܸ� �߻���ų �� �ִ�. // ���ϰ��� ���������� ��ȯ�� �� �ִ�.
// �Ϲ������� Exception, RuntimeException �����
// �ٸ�, �̷� ��� ��� ������ ���ܰ� �߻��ƴ��� ���������� �Ǵ��� �� ����.
// �̷� ������ �ذ��ϱ� ���� �������� �̸��� ����� 
// ����� ���� ����ó�� Ŭ������ �ۼ��Ͽ�
// ��������� � ������ �߻��Ǿ����� ������ �� �ִ�.


// ����� ���� ����ó�� Ŭ���� ����
// Exception, RuntimeException Ŭ������ ��ӹ޴� Ŭ����
// Exception�� ��ӹ޴� ��� �ݵ�� ����ó���� �ؾ��ϴ� Ŭ����
// RuntimeException�� ��ӹ޴� ��� ����ó���� ���������� �� �� �ִ�.
class LoginFailException extends RuntimeException {
	private String id;
	private String pw;
	public LoginFailException(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public String getMessage() {
		return String.format("�α��ο� �����߽��ϴ�. (%s, %s)", this.id, this.pw);
	}
}

public class Exception_15 {
	
	// ����� ���� ����ó�� Ŭ������ throws �� �� �ִ�.
	public static void login(String id, String pw) throws LoginFailException {
		// �α��� ó��
		if( id.equals(pw) )
			System.out.println("�α��� ���� !");
		else 
			// �α��ο� �����ϴ� ��� ���ܸ� �߻�����
			// ���� �޼ҵ带 ȣ���� �������� ��ȯ��
			throw new LoginFailException(id, pw);
	}

	public static void main(String[] args) {
		try {
			login("Hello", "Hello1");
		} catch (LoginFailException e) {
			System.out.println(e.getMessage());
		}
	}

}
