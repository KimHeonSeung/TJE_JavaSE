package heon.jdbc.model;

// ȸ������ �� �ۼ��� ������ �޾ƿ� �������� �ʱ�ȭ�ϰ� �������� ���͸� �����ϴ� Ŭ����
// ȸ������ ������ ���� �����Ƿ� ���ʹ� �������� �ʴ´�.
public class User {
	private String id, pw, name, birth, gender, mail, tel;
	
	// User �����ε�
	// �ƹ� ���� ���� ������ �ƹ��͵� ���� �ʴ´�.
	public User () {}

	// ��������� �Է����� �� 
	// ��, mail �� �ΰ��� ����Ѵ�.
	public User(String id, String pw, String name, String birth, String gender, String mail, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.tel = tel;
	}
	
	
	// ����
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}

	public String getMail() {
		return mail;
	}

	public String getTel() {
		return tel;
	}
	
	
	
	
}
