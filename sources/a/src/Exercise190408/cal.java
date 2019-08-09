package Exercise190408;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class cal {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년MM월dd일  HH시 mm분 ss초");
		
		System.out.println(sdf.format(now));
	}
}
