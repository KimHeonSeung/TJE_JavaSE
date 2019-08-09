package Exercise190402;

public class Student {
	public int studentNum;
	public String name;
	
	public Student (int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return this.studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof Student) ) 
			return false;
		Student target = (Student) obj;
		boolean flag_studentNum = this.studentNum == target.studentNum;
		return  flag_studentNum;
		
	}
	

}
