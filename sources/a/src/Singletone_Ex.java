class SingletonEx {

	private SingletonEx() {
		System.out.println("SingletonEx 클래스의 객체 생성");
	}
	
	// 현재 클래스의 객체를 저장하는 변수
	private static SingletonEx instance = null;
	
	// 현재 클래스의 객체를 반환할 수 있는 static 메소드의 선언
	public static SingletonEx getInstance() {
		if ( instance == null )
			instance = new SingletonEx();
		return instance;
	}
}

public class Singletone_Ex {
	public static void main(String[] args) {
		
		// static 메소드를 통해 객체를 제공받는 코드
		SingletonEx s1 = SingletonEx.getInstance();
		SingletonEx s2 = SingletonEx.getInstance();
		SingletonEx s3 = SingletonEx.getInstance();
		
		
		// 결과
		// Singleton Ex 클래스 객체 생성 1줄 출력
	}
}
