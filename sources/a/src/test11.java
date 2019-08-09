class Static_15{
	public static int S_NUM;

	static {
		S_NUM=101;
		System.out.printf("S_NUM = %d\n", S_NUM);
	}
}


public class test11 {

	public static void main(String[] args) {
		System.out.println("b");
		System.out.println(Static_15.S_NUM);

	}

}
