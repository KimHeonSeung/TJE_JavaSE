package tje.chat.common.jdbc;

import java.sql.*;

import java.util.*;

import tje.chat.common.util.*;

import tje.chat.common.jdbc.model.*;

// naver �����ͺ��̽��� info ���̺� ����
// JDBC �۾��� �����ϴ� DAO Ŭ����
public class UserDAO {
	
	// DAO Ŭ������ �ѹ��� �����ϱ� ���� �̱��������� ����
	// �ϳ��� �ν��Ͻ��� ������ ������ �ν��Ͻ��� ��� ����� �� �ֵ��� �Ѵ�.
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO() {}
	
	// ResultSet�� ��� ������ User���� Ȱ���Ͽ� ������ ���������� ���� ��ü�� ��ȯ�ϴ� �޼ҵ�
	private User generateObject (ResultSet rs) throws SQLException {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		
		return new User(id, pw);
	}
	
	// ID �ߺ�üũ�� �ؼ� �Ҹ�Ÿ������ ��ȯ�ϴ� �޼ҵ�
	public boolean isIdExist (Connection conn, String id) {
		String sql = "select id from info where id = ?";
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		try {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				if( rs.getString("id").equals(id) ) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCObjectManager.close(pstmt);
		return false;
	}
	// ���Ե� ������ User��ü�� �޾ƿ� table�� insert�ϴ� �������� �������ִ� �޼ҵ�
	// insert ���� ���� �߰��� ���� ������ int Ÿ������ ��ȯ�Ѵ�.
	public int insert(Connection conn, User user) {
		int result = 0;
		
		// �������� ����
		String sql = "insert into info values (?, ?)";
		
		// ������ �غ�
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		
		// �������� ? ������ ����
		try {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			
			// setString���� �ϼ��� �������� �����ϰ� ���ϰ��� result�� ����
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Statement�� �ݰ� (����ó���� �س��� JDBCObjectManager�� close �޼ҵ��)
		JDBCObjectManager.close(pstmt);
		// ��� ����
		return result;
	}
	
	public int login (Connection conn, User user) {
		int result = 0;
		// �޾ƿ� user �������� id�� �´� id�� pw ���� �˻�
		String sql = "select id, pw from info where id = ? and pw = ?";
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		try {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	
}
