package heon.jdbc.util;

// JDBC ����̹� Ŭ���� �ε��ϰ� ����ó���ϴ� ��ü
public class JDBCDriverLoader {
	public static void init() {
		try {
			Class.forName(JDBCConstraints.JDBC_DRIVER);
			System.out.println("JDBC ����̹� Ŭ���� �ε� �Ϸ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
