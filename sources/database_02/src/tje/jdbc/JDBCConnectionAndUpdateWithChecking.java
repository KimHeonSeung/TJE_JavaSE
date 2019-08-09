package tje.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

// users ���̺��� �̸�, ����, ����ó ������ �����ϴ� ���α׷� �ۼ�
// ������ ���̵� �Է� : 123
// �������� �ʴ� ���̵��Դϴ�.
// ������ ���̵� �Է� : tje
// ������ �̸� ( ������ �̸��� '�Ͽ��0' ) : ��������ǻ���п�
// ������ ���� ( ������ ���̴� '30' ) : 22
// ������ ����ó ( ������ ����ó�� '010-1234-5678' ) : 010-1234-5678
// ������ �Ϸ�Ǿ����ϴ�.

public class JDBCConnectionAndUpdateWithChecking {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
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
		String url = "jdbc:mysql://localhost:3306/hr?serverTimezone=UTC";
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

		// ID ������ ����Ͽ� Select ������ ������ ��ü
		PreparedStatement selectPstmt = null;
		// ������ ������ �Է¹޾� Update ������ ������ ��ü
		PreparedStatement updatePstmt = null;

		String select_sql = "select * from users where user_id = ?";
		String update_sql = "update users" +
					" set user_name = ?, user_age = ?, user_tel = ?" + 
					" where user_id = ?"; 

		ResultSet rs = null;
		int recordCount = 0;
		
		try {
			selectPstmt = conn.prepareStatement(select_sql);		
			updatePstmt = conn.prepareStatement(update_sql);
			
			String user_id = null;
			String prevUserName = null;
			int prevUserAge = 0;
			String prevUserTel = null;
			
			while( true ) {
				System.out.print("������ ���̵� �Է��ϼ��� : ");
				user_id = in.readLine();
				// select * from users where user_id
				selectPstmt.setString(1, user_id);
				rs = selectPstmt.executeQuery();
				if( rs.next() ) {
					prevUserName = rs.getString("user_name");
					prevUserAge = rs.getInt("user_age");
					prevUserTel = rs.getString("user_tel");
					break;
				} else {
					System.out.println("�������� �ʴ� ID �Դϴ�.");
				}
			}
			
			System.out.printf("������ �̸�( ������ �̸��� -> %s ) : ", prevUserName);			
			updatePstmt.setString(1, in.readLine());
			System.out.printf("������ ����( ������ ���̴� -> %d ) : ", prevUserAge);			
			updatePstmt.setInt(2, Integer.parseInt(in.readLine()));
			System.out.printf("������ ����ó( ������ ����ó�� -> %s ) : ", prevUserTel);			
			updatePstmt.setString(3, in.readLine());
			
			updatePstmt.setString(4, user_id);
						
			recordCount = updatePstmt.executeUpdate();
			
			if( recordCount == 1 )
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			else
				System.out.println("���� ����!!!");
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		
		try {
			in.close();
			
			if( rs != null )
				rs.close();
			
			if( selectPstmt != null )
				selectPstmt.close();
			
			if( updatePstmt != null )
				updatePstmt.close();
			
			if( conn != null )
				conn.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		// �� ���̵��. 
//		PreparedStatement pstmt = null;
//		PreparedStatement pstmt_check = null;
//		
//		
//		// Insert ������ �ۼ� ��, values�� �߰��Ǵ� ����
//		// ? �� ��ü�Ͽ� �ս��� ���� �Է��� �� �ִ�.
//		String sql = "update users" +
//					" set user_name = ?, user_age = ?, user_tel = ?" +
//					" where user_id = ?";
//		String sql_check = "select * from users" +
//						" where user_id = ?";
//	
//		// Insert, Update, Delete ������ �����ϴ� ���
//		// ���� Ÿ���� ���� ��ȯ�Ǹ�, ����� ���ڵ��� ������ ��ȯ
//		// Insert : �Էµ� ���ڵ��� ������ ��ȯ
//		// Update : ������ ���ڵ��� ������ ��ȯ
//		// Delete : ������ ���ڵ��� ������ ��ȯ
//		int recordCount = 0;
//		ResultSet rs = null;
//		String upId;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			do {
//				pstmt_check = conn.prepareStatement(sql_check);
//				System.out.print("������ ���̵� �Է��ϼ��� : ");
//				upId = in.readLine();
//				pstmt_check.setString(1, upId);
//				rs = pstmt_check.executeQuery();
//			} while ( !rs.next() );
//			// ?�� ������ �ڸ��� ���� ����.
//			
//			System.out.print("������ �̸� : ");
//			pstmt.setString(1, in.readLine());
//			System.out.print("������ ���� : ");
//			pstmt.setInt(2, Integer.parseInt(in.readLine()));
//			System.out.print("������ ����ó : ");
//			pstmt.setString(3, in.readLine());
//			pstmt.setString(4, upId);
//			
//			// Insert, Update, Delete ������ �����ϴ� ��쿡��
//			// executeUpdate �޼ҵ带 ����Ͽ� ������ ����
//			// (������ ���� ����� ����� ���ڵ��� ������ ��ȯ�ϴ� �޼ҵ�)
//			recordCount = pstmt.executeUpdate();
//			if( recordCount == 1 )
//				System.out.println("ȸ�� ���� ���� ���� !");
//			else 
//				System.out.println("ȸ�� ���� ���� ���� !");
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			
//			if( pstmt != null )
//				pstmt.close();
//			if( conn != null )
//				conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
}
