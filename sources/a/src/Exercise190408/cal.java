package Exercise190408;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class cal {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy��MM��dd��  HH�� mm�� ss��");
		
		System.out.println(sdf.format(now));
	}
}
