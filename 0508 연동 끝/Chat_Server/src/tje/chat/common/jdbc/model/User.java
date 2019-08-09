package tje.chat.common.jdbc.model;

import java.io.Serializable;

// ȸ������ �� �ۼ��� ������ �޾ƿ� �������� �ʱ�ȭ�ϰ� �������� ���͸� �����ϴ� Ŭ����
// ȸ������ ������ ���� �����Ƿ� ���ʹ� �������� �ʴ´�.
public class User implements Serializable {
	private String id, pw;
	
	// User �����ε�
	// �ƹ� ���� ���� ������ �ƹ��͵� ���� �ʴ´�.
	public User () {}

	// ��������� �Է����� �� 
	// ��, mail �� �ΰ��� ����Ѵ�.
	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
	// ����
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
	
}
