// 반복문
// 특정 영역의 실행문을 반복해서 실행할 수 있는 문법
// for, while, do ~ while

public class ControlStatement_FOR_01 {

	public static void main(String[] args) {
		// for 반복문
		// - 기준 변수의 값을 조건식의 기준으로 활용하여 반복을 수행하는 문법
		// 형식 : 
		// for( 초기화문 ; 조건문 ; 증감문 )
		//		반복해서 실행할 실행문
		// 실행과정:
		// 1. 초기화문
		//  - for 문의 시작시 최초로 실행되는 영역
		//	- 단 한번만 실행
		// 2. 조건문
		//  - true / false를 반환하는 조건식으로 구성
		//  - 조건문에 정의된 조건식이 true인 경우 실행문이 실행
		// 3. 실행문
		// 4. 증감문
		//	- 기준 변수의 값을 증가, 감소시키는 영역
		//	- 조건문의 조건이 false가 되도록 조정하는 역할
		// 5. 조건문
		// 6. 실행문
		// ...
		
		for (int i = 1; i < 11 ; i++)
			System.out.printf("i = %d\n", i); // i = 11이 되면 끝난다.
		
	}

}
