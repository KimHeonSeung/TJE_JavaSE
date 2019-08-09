package tje.jdbc.dao;

// JDBC ���α׷��ֿ���  DAO Ŭ����
// ������ ���̺��� �˻�, �Է�, ����, ���� ����� 
// �����ϰ� �ִ� Ŭ����
// Ư�� ���̺� ���� ��� �۾��� �����Ͽ�
// ��Ȱ�뼺�� �ش�ȭ�� �� �ִ�.
// �Ϲ����� �۸� ��Ģ�� ���̺��DAO

import java.sql.*;
import tje.jdbc.util.*;
// Select ���� ���� ����� �ټ����� ��� �÷��� Ŭ������ Ȱ���ϱ� ���� import ����
import java.util.*;
// Select ���� ���� ����� �����ϱ� ���� �� Ŭ������ ��Ű��
import tje.jdbc.model.*;

public class CityDAO {
	// static ��� �ʵ�� ���� DAO Ŭ������ ��ü�� 1�� ����
	private static CityDAO instance = new CityDAO();
	
	// ������ DAO Ŭ������ ��ü�� ��ȯ�� �� �ִ� static �޼ҵ带 ����
	public static CityDAO getInstance() {
		return instance;
	}
	// DAO Ŭ�������� ������ ����� �����ϴ� Ŭ�����̹Ƿ�
	// �̱��� ������ �����Ͽ� ��ü�� 1���� �����ǵ��� �����Ѵ�.
	
	// DAO Ŭ������ �ܺο��� ��ü�� ������ �� ������ 
	// �����ڸ� private���� ����
	private CityDAO() {}
	
	// DAO Ŭ������ �˻���� �޼ҵ��
	// �� Ŭ������ ��ü �Ǵ� ����Ʈ�� ��ȯ�ϴ� ���� �Ϲ����̴�.
	// - select ���� ���� ����� 
	//   �� Ŭ������ ��ü�� ��ȯ�Ͽ�
	//   ResultSet ��ü�� ��ȸ�ϴ� �ڵ��� �ߺ��� �����ϱ� ���ؼ�
	// - �� Ŭ���� : Ư�� ���̺��� �÷���� ���ε� ����ʵ带 �����ϴ� Ŭ����.
	// - �� Ŭ������ ��ü�� Ư�� ���̺��� ���ڵ��� ������ �����Ѵ�.
	
	public ArrayList<City> select(Connection conn) {
		ArrayList<City> result = new ArrayList<City>();
		String sql = "select * from city";
		
		Statement stmt = JDBCObjectManager.getStatement(conn);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			while( rs.next() ) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String countryCode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				
				City city = new City(id, 
									name, 
									countryCode, 
									district, 
									population);
				result.add(city);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCObjectManager.close(rs);
		JDBCObjectManager.close(stmt);
		return result;
	}
	
	// DAO Ŭ������ �Է�, ����, ���� �����
	// �Ϲ������� ���� Ÿ���� ��ȯ�Ѵ�.
	// - executeUpdate �޼ҵ��� ���� �����
	//   SQL ���� ���� ���ڵ��� ���� ��ȯ�ϱ� ���ؼ�
	
//	public int insert() {
//		
//	}
//	
//	public int update() {
//		
//	}
//	
//	public int delete() {
//		
//	}
}
