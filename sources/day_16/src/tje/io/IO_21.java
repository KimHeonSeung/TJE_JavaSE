package tje.io;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

// ��Ģ������ ����� ������ �� �ִ� 
// CalculatorResult Ŭ������ �ۼ��ϼ���
// CalculatorResult Ŭ������ ���꿡 ���� ����, ������ ����
// ������ ��ȣ, ������ ����� ������ �� �ֽ��ϴ�.
// CalculatorResult Ŭ������ toString �޼ҵ带 ���ؼ�
// ����İ� ����� ����� �� �ֽ��ϴ�.

class CalculatorResult implements Serializable{
	private int leftValue;
	private int rightValue;
	private String operator;
	private double result;
	
	public CalculatorResult(int leftValue, int rightValue, String operator, double result) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.operator = operator;
		this.result = result;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %d = %.2f", this.leftValue, this.operator, this.rightValue, this.result);
		}
	
	// ���� �Ѱ�
//	public int n1;
//	public int n2;
//	public char sign;
//	public int result;
//	
//	public String lhs = "" + n1 + sign + n2;
//	public String rhs = "" + result;
//	
//	public CalculatorResult (int n1, int n2, char sign) {
//		n1 = this.n1;
//		n2 = this.n2;
//		sign = this.sign;
//	}
//	
//	@Override
//	public String toString() {
//		return String.format("%d %c %d = %d\nlhs = %s, rhs = %s\n", n1, sign, n2, result, lhs, rhs); 
//	}
}

public class IO_21 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// ����ڿ��� ���� 2���� ���Ŀ� ���� ��ȣ�� �Է¹޾� ����� ����ϱ�.
		// ����� CalculatorResult Ŭ������ ��ü�� �����Ͽ�
		// ������ ��, toString �޼ҵ带 ����Ͽ� ���.
		
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		int leftValue, rightValue;
		String operator;
		double result = 0;
		String isExit;
		
		// �ݺ����� Ȱ���Ͽ� ����ڰ� ���Ḧ ���� ������ ����� �����ϰ�
		// �Ʒ��� history �÷��ǿ�
		// ������ ����� �����ϴ� CalculatorResult ��ü�� �����ϼ���.
		ArrayList<CalculatorResult> history = new ArrayList<>();
		
		do {
			System.out.print("1��° ���� : ");
			leftValue = Integer.parseInt(in.readLine());
			
			System.out.print("���� ��ȣ : ");
			operator = in.readLine();
			
			System.out.print("2��° ���� : ");
			rightValue = Integer.parseInt(in.readLine());
			
			if ( operator.equals("+") )
				result = leftValue + rightValue;
			else if ( operator.equals("-") )
				result = leftValue - rightValue;
			else if ( operator.equals("*") )
				result = leftValue * rightValue;
			else if ( operator.equals("/") )
				result = (double)leftValue / rightValue;
			
			CalculatorResult cr = new CalculatorResult(leftValue, rightValue, operator, result);
			System.out.println(cr);
			history.add(cr);
			
			System.out.print("�����Ͻðڽ��ϱ� ? (y/n) : ");
			isExit = in.readLine();
		} while ( isExit.equals("n") || isExit.equals("N") );
		
		
		System.out.println("��� ���� ���");
		for( int i = 0 ; i < history.size() ; i++ )
			System.out.printf("%d -> %s\n", i+1, history.get(i));
		
		// history�� ��ϵ� ��ü�� ����.
		// ���ϸ��� �⵵_��_��_�ð�_��.dat�� ����
		// D:\\dev\\java_se\\file_log ��ο�
		
		// ���� �ð��� ���õ� ��¥ ��ü ��ȯ
		Date now = Calendar.getInstance().getTime();
		// ���ϸ��� �����ϱ� ���� SimpleDateFormat ��ü ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		// Ȯ���ڸ� ������ ���ϸ� ����
		String fileName = sdf.format(now) + ".dat";
		
		String dirPath = "D:\\\\dev\\\\java_se\\\\file_log";
		File dir = new File(dirPath);
		if( !dir.exists() ) { 
			dir.mkdirs();
		}
		
		File file = new File(dir, fileName);
		
		// ��� ��Ʈ�� ����
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		// ��ü�� ���Ͽ� ���
		out.writeObject(history);
		out.flush();
		out.close();
		
		System.out.println("���α׷� ����");

		// ������Ʈ �ٽ� ��������
//		ObjectInputStream inn =
//				new ObjectInputStream(
//						new BufferedInputStream(
//								new FileInputStream(file)));
//		
//		ArrayList<CalculatorResult> list = (ArrayList<CalculatorResult>) inn.readObject();
//		
//		for( int i = 0 ; i < history.size() ; i++ )
//			System.out.println(history.get(i));
		
		


		
		// ���� �Ѱ�
//		String dirPath = "D:\\dev\\java_se\\file_test";
//		File dir = new File(dirPath);
//		
//		File file = new File(dir, "object_07.txt");
//		
//		
//		
//		BufferedReader in = 
//				new BufferedReader(
//						new InputStreamReader(System.in));
//		String inp;
//		
//		System.out.print("ù��° ���� : ");
//		int n1 = (int) in.read() - '0';
//		in.skip(2);
//		System.out.print("�ι�° ���� : ");
//		int n2 = (int) in.read() - '0';
//		in.skip(2);
//		System.out.print("��ȣ : ");
//		String op = in.readLine();
//		
//		double result;
//		
//		if( op.equals("+") )
//			result = n1 + n2;
//		else if ( op.equals("-") )
//			result = n1 - n2;
//		else if ( op.equals("*") )
//			result = n1 * n2;
//		else if ( op.equals("/") )
//			result = n1 / n2;
//		else if ( op.equals("%") )
//			result = n1 % n2;
//		else result = -0000;
//
//		
//		CalculatorResult a = new CalculatorResult(n1,n2,op,result);
//		
//		System.out.println(a);
		
		

	}
}
