package Exercise190401;

public class IntegerCompareExample {

	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		
		// int 타입은 -128 ~ 127 내의 범위만 박싱 내부의 값을 바로 비교 가능하다.
		// obj3과 obj4는 범위 외의 값이므로 박싱된 값을 비교하면 같지 않다.
	}

}
