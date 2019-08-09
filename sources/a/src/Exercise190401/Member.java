package Exercise190401;

public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		String result;
		result = this.id + " : " + this.name;
		return result;
	}
}
