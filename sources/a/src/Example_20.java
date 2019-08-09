class Super_20 {
	public void Display() {
		System.out.println("Super_20.Display");
	}
}

class Sub_20 extends Super_20 {
	public void Display() {
		System.out.println("Sub_20.Display");
	}
}

public class Example_20 {

	public static void main(String[] args) {
		Super_20 obj = new Sub_20();
		// obj.Display(

	}

}
