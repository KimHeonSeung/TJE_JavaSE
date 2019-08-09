package tje.jdbc;

import java.sql.*;

public class JDBCConnectionAndSelect_MySQL {
	public static void main(String[] args) {
		// 1. JDBC ����̹� Ŭ���� �ε�
		String strDriverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(strDriverClassName);
			System.out.println("����̹� Ŭ���� �ε� �Ϸ�");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� Ŭ���� �ε� ����");
			e.printStackTrace();
			return;
		}
		
		// 2. DBMS ����
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
		String user = "root";
		String password = "SystemManager304";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS ���� ����");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����");
			e.printStackTrace();
			return;
		}
		
		// ����� DBMS�� �������� ������ �� �ִ� ����
		// java.sql.Statement Ŭ����
		// - java.sql.Connection Ŭ������ ��ü�κ��� �����Ǵ� ��ü Ÿ��
		// - ����� DBMS�� �������� ������ �� �ִ� Ŭ����
		Statement stmt = null;
		String sql = "select * from city";
		
		ResultSet rs = null;
		
		try {
			// ����� DBMS�κ��� �������� ������ �� �ִ� ��ü�� ��ȯ�޴� �ڵ�
			stmt = conn.createStatement();
			
			// java.sql.Statement Ŭ������ execute XXX �޼ҵ�
			// ���ڿ� ���� �Ű������� ���޹޾� �ش� ���ڿ��� SQL��
			// DBMS�� ���� ������ ��, ������ ����� ��ȯ�޴� �޼ҵ�
			
			// executeQuery �޼ҵ�� SELECT���� ������ ��,
			// ������ ����� java.sql.ResultSet Ŭ���� Ÿ������ ��ȯ�Ѵ�.
			rs = stmt.executeQuery(sql);
			// rs.next �ϸ� �״����ٿ� ������ �ִ��� Ȯ���Ͽ� T/F ��ȯ
			while( rs.next() ) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String countrycode = rs.getString(3);
				String district = rs.getString("district");
				int population = rs.getInt("population");
				
				String record = 
						String.format(
								"%d - %s - %s - %s - %d\n", 
								id, name, countrycode, district, population);
				System.out.println(record);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if( rs != null )
				rs.close();
			if( stmt != null )
				stmt.close();
			if( conn != null )
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
