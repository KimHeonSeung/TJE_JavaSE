class Static_15_1 {
	public static int S_NUM;
	static {
		S_NUM = 707;
		System.out.printf("���� %d\n", S_NUM);
	}
}
public class Example_15 {

	public static void main(String[] args) {
		System.out.println("����");
		System.out.println(Static_15_1.S_NUM);

	}

}
