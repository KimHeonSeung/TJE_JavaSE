class Static_15_1 {
	public static int S_NUM;
	static {
		S_NUM = 707;
		System.out.printf("먼저 %d\n", S_NUM);
	}
}
public class Example_15 {

	public static void main(String[] args) {
		System.out.println("시작");
		System.out.println(Static_15_1.S_NUM);

	}

}
