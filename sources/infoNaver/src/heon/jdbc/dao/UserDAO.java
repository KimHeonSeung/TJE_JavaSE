package heon.jdbc.dao;

import java.sql.*;
import java.util.*;

import heon.jdbc.model.*;
import heon.jdbc.util.*;

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
		String name = rs.getString(3);
		String birth = rs.getString(4);
		String gender = rs.getString(5);
		String mail = rs.getString(6);
		String tel = rs.getString(7);
		
		return new User(id, pw, name, birth, gender, mail, tel);
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
		String sql = "insert into info values (?, ?, ?, ?, ?, ?, ?)";
		
		// ������ �غ�
		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);
		
		// �������� ? ������ ����
		try {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getBirth());
			pstmt.setString(5, user.getGender());
			// ������ �ΰ��� ����ϹǷ� �Ʒ��� ���� ����. ( �Է��� ������ �� null�� ���̺� �Է� )
			if ( user.getMail().length() > 0 ) {
				pstmt.setString(6, user.getId());
			} else {
				pstmt.setNull(6, Types.NULL);
			}
			pstmt.setString(7, user.getTel());
			
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
}
