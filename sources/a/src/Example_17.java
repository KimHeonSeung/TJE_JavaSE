class Super_17 {
	public Super_17(String name) {
		System.out.println("Super_17 : " + name);
	}
}

class Sub_17 extends Super_17 {
	public Sub_17(String name) {
		super(name);
		System.out.println("Sub_17 : " + name);
	}
}


public class Example_17 {

	public static void main(String[] args) {
		new Sub_17("Extends Example");

	}

}
