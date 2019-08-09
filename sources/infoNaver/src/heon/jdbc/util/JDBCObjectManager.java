package heon.jdbc.util;

import java.sql.*;

// ������ �޼ҵ��� ����ó������ ���ִ� Ŭ����
public class JDBCObjectManager {
	
	public static Statement getStatement (Connection conn) {
		// ��ȯ�� Statement ��ü�� null�� �ʱ�ȭ
		Statement obj = null;
		
		// ������ �������� �غ�� ����ó��
		try {
			obj = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	// Statement ������ ���� �����ε�
	public static PreparedStatement getStatement (Connection conn, String sql) {
		PreparedStatement obj = null;
		
		try {
			obj = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	// ����ó���� ���� close �޼ҵ���� �����Ѵ�. (connection, statement, preparedstatement, resultset�� ���� ��
	public static void close (Connection obj) {
		// Connection�� ������ �ƹ��͵� ���� �ʴ´�.
		if( obj == null ) {
			return;
		}
		
		// Connection�� ���� �� �ݾ��ش�.
		try {
			obj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close (PreparedStatement obj) {
		if( obj == null ) {
			return;
		}
		
		try {
			obj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close (ResultSet obj) {
		if( obj == null ) {
			return;
		}
		
		try {
			obj.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// ����Ŀ�԰� Ŀ��, �ѹ��� ����ó��
	public static void setAutoCommit (Connection conn, boolean flag) {
		try {
			conn.setAutoCommit(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit (Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback (Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
