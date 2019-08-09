package tje.jdbc;

import java.sql.*;
import tje.jdbc.*;
import tje.jdbc.dao.*;
import tje.jdbc.model.*;
import tje.jdbc.util.*;

public class JDBC_Chat {
	public static void main(String[] args) {
		// Chat ������ ���̽��� ���� ��ü�� ��ȯ
		Connection conn = JDBCConnection.getConnection();
		
		// chat �����ͺ��̽��� User ���̺� ����
		// JDBC �۾��� �����ϴ� DAO Ŭ����
		UserDAO dao = UserDAO.getInstance();
		
		// 1. �Է� ( �� ��ü Ȱ�� )
		User user1 = new User("abc", "123", "tje1", "tje1", "010-1111-1111");
		dao.insert(conn, user1);
		
		User user2 = new User("def", "456", "tje2", "tje2", "010-2222-2222");
		dao.insert(conn, user2);
		
//		// 2. ����
//		User user3 = new User("abc", "1234567890");
//		dao.updatePassword(conn, user3);
		
		// 3. �˻�
		User user4 = dao.select(conn, new User("def"));
		System.out.println(user4);
		
		// 4. ����
		User user5 = new User("def");
		dao.delete(conn, user5);
		
		// 5. �ټ����� �÷� ���� ����
		User user = new User("abc", "1234567890", "sf", "sf", "010-68464654564354354");
		
		// Connection Ŭ���� ��ü�� setAutoCommit �޼ҵ�� 
		// �ڵ� Ŀ���� ����/������ �� �ִ� �޼ҵ��.
		// �Ű������� false�� �����ϴ� ���
		// ������ �۾� ���� commit �Ǵ� rollback �޼ҵ带 ȣ���Ͽ�
		// ������ ����� ���� �Ǵ� ����� �� �ִ�.
		// (����ó���� ������ util Ŭ������ ����Ͽ� ó����)
		JDBCObjectManager.setAutoCommit(conn, false);
		
		int recordCount = 0;
		recordCount += dao.updatePassword(conn, user);
		recordCount += dao.updateName(conn, user);
		recordCount += dao.updateAlias(conn, user);
		recordCount += dao.updateTel(conn, user);
		
		if( recordCount == 4 )
			// ��� ������Ʈ ������ ���������� ����� ���
			// commit �޼ҵ带 ȣ���Ͽ� DB�� ����
			JDBCObjectManager.commit(conn);
		else
			// ��� ������Ʈ ���� �� �ϳ��� ������ �߻��ϴ� ���
			// rollback �޼ҵ带 ȣ���Ͽ� ��������� ��� �۾��� �����
			JDBCObjectManager.rollback(conn);
		
		JDBCObjectManager.close(conn);
	}
}
