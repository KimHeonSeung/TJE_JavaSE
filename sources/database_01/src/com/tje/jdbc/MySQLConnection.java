package com.tje.jdbc;

// ����� ��������
// java �� ����Ͽ� ������ ���̽� ���� �� 
// �۾�(�˻�, �Է�, ����, ����)�� ������ �� �ֵ���
// �����ϴ� Ŭ������ ����� ��Ű��
import java.sql.*;

public class MySQLConnection {
	public static void main(String[] args) {
		// JDBC ���α׷����� ����
		
		// 0. JDBC���� ����� DBMS�� ����̹� Ŭ���� �ε�
		// - �� �����ͺ��̽� �������� �����ϴ� JAVAŬ������ �޸𸮿� �ε��ϴ� ����
		// - JDBC ����̹� Ŭ������ ������ �����ͺ��̽��� ���� �� �۾��� �� �� �ֵ��� ������ Ŭ����
		
		// ���������� MySQL ����̹� Ŭ����
		// String JDBCClassName = "com.mysql.jdbc.Driver";
		String JDBCClassName = "com.mysql.cj.jdbc.Driver";
		System.out.println("JDBC ����̹� Ŭ���� �ε� ����");
		
		try {
			// ���ڿ��ε� ��θ� �����ͼ� Ŭ���� �ε�
			// Class.forName �޼ҵ�
			// - ���α׷��� ���� �߿� �ܺ��� ���̺귯�� Ŭ������
			//   ����� �� �ֵ��� �޸𸮿� �����ϴ� �޼ҵ�
			// - JDBC ����̹� Ŭ������ �ܺο��� ������ Ŭ�����̹Ƿ�
			//   Class.forName �޼ҵ忡 ���ؼ� �޸𸮿� ����Ǿ�߸� ���� �� �ִ�.
			// - JDBC ����̹� ������ �����н��� ����ؾ߸� ���ܰ� �߻����� �ʴ´�.
			// - JDBC ����̹� Ŭ������ �� �������� �����ϸ� 
			//   �������� Ȩ�������� Ȯ���ؾ���.
			Class.forName(JDBCClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� Ŭ���� �ε� ����");
			return;
		}
		
		// 1. JDBC Ŀ�ؼ� ��ü�� ����
		// java.sql.Connection Ŭ����
		// - �����ͺ��̽��� �����Ͽ� SQL���� ������ �� �ִ� ��ü�� ��ȯ�ϴ� Ŭ����
		// - DBMS�� ������ �� �ִ� ��ü ���� �� DBMS ����
		// - DriverManager.getConnection �޼ҵ��� ���� ����� ��ü�� ��ȯ���� �� �ִ�.
		Connection conn = null;
		
		// ������ ���̽��� �����ϱ� ���� ����
		// 1. URL ����
		// - �����ͺ��̽��� �����ϱ� ���� �ּ� �� ������
		// - �����ͺ��̽����� URL�ۼ����� �����ϹǷ� �޴����� �����ؾ���.
		String url = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";
		// - ���� ����
		String id = "root";
		// - �н����� ����
		String pw = "SystemManager304";
		try {
			// DriverManager.getConnection �޼ҵ�
			// - �����ͺ��̽��� �����ϱ� ���� �������� �Ű������� ����Ͽ�
			//   �����ͺ��̽� ���� ��ü�� ��ȯ�ϴ� �޼ҵ�
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("JDBC ���� ����");
		} catch (SQLException e) {
			System.out.println("JDBC ���� ����");
			e.printStackTrace();
		}
		
		try {
			// java.sql.Connection Ŭ������ close �޼ҵ�
			// JDBC ���α׷��ֿ��� ���� �߿��� ����
			// JDBC�� Ȱ���� ���α׷� ���ο����� �� Ŀ�ؼ� ��ü���� 
			// ��Ʈ��ũ ����� ����Ͽ� DBMS�� �����Ѵ�.
			// �� �� ����� ����� Connection ��ü�� ���ؼ� 
			// close �޼ҵ带 �� Ŀ�ؼ� ��ü�� ȣ������ ������
			// �޸� ���� ������ �߻��� �� �ְ�, DBMS�� ���� ������ ���ܵ� �� �ִ�.
			conn.close();
			System.out.println("JDBC ����");
		} catch (SQLException e) {
			System.out.println("JDBC ���� ����");
			e.printStackTrace();
		}
	}
}
