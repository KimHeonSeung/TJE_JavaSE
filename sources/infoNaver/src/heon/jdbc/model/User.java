package heon.jdbc.model;

// 회원가입 시 작성한 정보를 받아와 정보들을 초기화하고 정보들의 겟터를 설정하는 클래스
// 회원정보 수정을 하지 않으므로 셋터는 설정하지 않는다.
public class User {
	private String id, pw, name, birth, gender, mail, tel;
	
	// User 오버로딩
	// 아무 정보 없이 생성엔 아무것도 하지 않는다.
	public User () {}

	// 모든정보를 입력했을 때 
	// 단, mail 은 널값을 허용한다.
	public User(String id, String pw, String name, String birth, String gender, String mail, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.tel = tel;
	}
	
	
	// 겟터
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
