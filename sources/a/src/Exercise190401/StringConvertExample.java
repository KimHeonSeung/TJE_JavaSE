package Exercise190401;

public class StringConvertExample {

	public static void main(String[] args) {
		String strData1 = "200";
		int intData1 = Integer.parseInt(strData1);
		
		int intData2 = 150;
		String strData2 = null;
		strData2 = strData2.valueOf(intData2);
		
		System.out.println(intData1);
		System.out.println(strData2);
	}


}
