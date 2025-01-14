
public class Array_01 {

	public static void main(String[] args) {
		// 지역변수-타입1
		// 메소드 내부에 선언된 모든 변수
		// 메소드가 시작될 때 메모리에 로딩
		// 메소드가 종료되면 메모리에서 해제
		
		// 지역변수의 선언
		// 일반적인 지역변수는 변수가 선언된 이후 해당 메소드의 종료지점까지 어디에서든 접근할 수 있다.
		int local_1 = 10;
		System.out.println(local_1);
		
		// 지역변수-타입2
		// 메소드 내부에 선언된 변수이지만, 특정 영역에서 생성된 변수는 해당 영역에서만 사용할 수 있다.
		// 해당 영역이 실행될 때 메모리에 로딩
		// 해당 영역이 종료되면 메모리에서 해제
		
		// 지역변수 타입2 선언
		// 특정 영역에서 생성된 지역변수는 변수가 선언된 이후 해당 영역의 종료지점까지 어디에서든 접근할 수 있다.
		// 포문 안쪽이라면 자유롭게 사용할 수 있다.
		for ( int local_2 = 1 ; local_2 <= 2 ; local_2++ ) {
			System.out.println(local_2);	
		}
		// 변수가 선언된 영역을 벗어나면 접근할 수 없다.
		// 해당 변수는 메모리에서 해제된 상태이므로 ...
		// System.out.println(local_2);
		
		{
			// 특정 영역에서 생성된 변수는 기존의 이름과 동일한 이름으로 동일한 이름으로 생성할 수 있다.
			int local_2 = 15;
			System.out.printf(" local_2 = %d\n ", local_2);
		}
		// 영역을 벗어나면 변수에 접근할 수 없다.
		// System.out.printf("local_2 = %d\n", local_2);
	}

}
