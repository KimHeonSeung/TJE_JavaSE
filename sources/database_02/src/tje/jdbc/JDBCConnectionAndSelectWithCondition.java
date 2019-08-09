package tje.jdbc;

import java.sql.*;

// �����, �μ���, ��å, �ٹ��� ���ø��� ����ϼ���.
// (�޿��� ������ 7000 �̻�, 15000 ������ �����)

public class JDBCConnectionAndSelectWithCondition {
	public static void main(String[] args) {
		// 1. JDBC ����̹� Ŭ���� �ε�
		String strDriverClassName = "oracle.jdbc.driver.OracleDriver";
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
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "hr";
		String password = "hr";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DBMS ���� ����");
		} catch (SQLException e) {
			System.out.println("DBMS ���� ����");
			e.printStackTrace();
			return;
		}
		
		// ����� DBMS�� �������� ������ �� �ִ� ����
		// java.sql.PreparedStatement Ŭ����
		// - java.sql.Connection Ŭ������ ��ü�κ��� �����Ǵ� ��ü Ÿ��
		// - ����� DBMS�� �������� ������ �� �ִ� Ŭ����
		// - ���ǽĿ� ���Ǵ� ������ ���� �ս��� �߰��� �� �ִ� ���� ����� ����
		// - Statement Ŭ������ �ٸ��� ��ü�� ������ �������� �����ؾ���
		PreparedStatement pstmt = null;
		int startSalary = 10000;
		int endSalary = 20000;
		String targetName = "a";
		
		// ���� �������� ������ SQL ���� �ۼ��ϴ� ���
		// ���� ������ ����� ���� ���������� ������ �߻��� �� �ִ�.
		// �̷� ������ �� �������� ���� �κп� ������ ���Ƿ� �߰��Ͽ� �ذ��� �� �ִ�.
		// ? : ���� ������ ���ߴ�. �߰��߰� �� ���� ������ �� ����.
		String sql = "select first_name || ' ' || last_name as \"e_name\", department_name as \"d_name\", job_title as \"j_title\", city, salary" + 
				" from EMPLOYEES inner join DEPARTMENTS using(DEPARTMENT_ID)" + 
				"  inner join Locations using(location_id)" + 
				"  inner join jobs using(job_id)" + 
				" where salary BETWEEN ? AND ?" +
				" and lower(first_name || ' ' || last_name) like ?"; 
	
		ResultSet rs = null;
		
		try {
			// where ���� �Ű������� �ʿ��� �������� ����Ͽ�
			// PrepareStatement Ŭ������ ��ü�� ��ȯ
			// �� �� sql���� ����־����Ƿ� ���߿� executeQuery()���� ��������.
			pstmt = conn.prepareStatement(sql);
			
			// ?�� ������ ������ ���� ����.
			// 1��° ? ������ startSalary ������ ���� ����Ͽ� ����
			pstmt.setInt(1, startSalary);
			// 2��° ? ������ endSalary ������ ���� ����Ͽ� ����
			pstmt.setInt(2, endSalary);
			// 3��° ? ������ targetName ������ ���� ����Ͽ� ����
			// (���ڿ��� �����ϴ� ��� �յ��� ' �Ǵ� "�� �������� �ʾƵ� �ڵ����� ���Ե�)
			// setString���� �ϸ� �ڵ����� �յڿ� '�� �ٴ´�
			pstmt.setString(3, "%" + targetName + "%");
			// java.sql.Statement Ŭ������ execute XXX �޼ҵ�
			// ���ڿ� ���� �Ű������� ���޹޾� �ش� ���ڿ��� SQL��
			// DBMS�� ���� ������ ��, ������ ����� ��ȯ�޴� �޼ҵ�
			
			// PreparedStatement Ŭ���� ��ü�� ����Ͽ�
			// excuteQuery �޼ҵ带 �����ϴ� ���
			// ������ ���ǵ� �������� ����ϹǷ� �Ű������� �������� �ʴ´�.
			rs = pstmt.executeQuery();
			
			// rs.next �ϸ� �״����ٿ� ������ �ִ��� Ȯ���Ͽ� T/F ��ȯ
			while( rs.next() ) {
				String e_name = rs.getString(1);
				String d_name = rs.getString(2);
				String j_title= rs.getString(3);
				String city = rs.getString(4);
				int salary = rs.getInt(5);
				
				String record = String.format("%s - %s - %s - %s - %d", 
						e_name, d_name, j_title, city, salary);
				System.out.println(record);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if( rs != null )
				rs.close();
			if( pstmt != null )
				pstmt.close();
			if( conn != null )
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
