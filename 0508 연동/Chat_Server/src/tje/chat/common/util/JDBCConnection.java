package tje.chat.common.util;

import java.sql.*;

// JDCB ����̹� Ŭ������ �ε��ϰ� DBMS�� ����, ����ó�� �ϴ� ��ü
public class JDBCConnection {
	
	// Ŭ���� ��ü�� �����ɶ� �� �ѹ� ����Ǹ� ����̹��ε��� �����ϴ� �κ�
	static {
		JDBCDriverLoader.init();
	}
	
	// DBMS�� ������ �������ִ� getConnection �޼ҵ�
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(JDBCConstraints.JDBC_URL,
												JDBCConstraints.JDBC_USER,
												JDBCConstraints.JDBC_PASSWORD);
			System.out.println("DBMS ���� �Ϸ� !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
