package tje.jdbc;

import java.sql.*;
import java.util.ArrayList;

import tje.jdbc.dao.CityDAO;
import tje.jdbc.model.City;
import tje.jdbc.util.*;

public class JDBC_Basic {
	public static void main(String[] args) {
		// 1. ����̹� Ŭ���� �ε�
		// - JDBC ����̹� Ŭ������ �ε� ������
		// 	  ���α׷��� ���� ��, �� �ѹ��� �����ϸ� �ȴ�.

		// 2. DBMS ���� ��ü ����
		Connection conn = JDBCConnection.getConnection();
		
//		// 3. ����(SQL) ���� ��ü ����
//		String sql = "select * from city";
//		
//		Statement stmt = JDBCObjectManager.getStatement(conn);
//		PreparedStatement pstmt = JDBCObjectManager.getStatement(conn, sql);

		// CityDAO dao = new CityDAO();
		CityDAO dao = CityDAO.getInstance();
		// 4. ������ ���� �� ��� Ȯ��
		ArrayList<City> result = dao.select(conn);
		for( int i = 0 ; i < result.size() ; i++ ) {
			System.out.printf("%d, %s, %s, %s, %d\n", 
									result.get(i).getId(), 
									result.get(i).getName(), 
									result.get(i).getCountryCode(), 
									result.get(i).getDistrict(), 
									result.get(i).getPopulation());
		}
		
//		ResultSet rs = null;
//		try {
//			rs = pstmt.executeQuery();
//			
//			while( rs.next() ) {
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				String countrycode = rs.getString(3);
//				String district = rs.getString(4);
//				int population = rs.getInt(5);
//				
//				System.out.printf("%d, %s, %s, %s, %d\n", id, name, countrycode, district, population);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		// 4. ���� ó��
//		JDBCObjectManager.close(rs);
//		JDBCObjectManager.close(stmt);
//		JDBCObjectManager.close(pstmt);
		JDBCObjectManager.close(conn);
	}
}

// 1. ����̹� Ŭ���� �ε�
// - JDBC ����̹� Ŭ������ �ε� ������
// 	  ���α׷��� ���� ��, �� �ѹ��� �����ϸ� �ȴ�.
//////////////////////////////////////////////////////////////////
//String JDBCDriverClass = "com.mysql.cj.jdbc.Driver";			//
//	try {														//
//		Class.forName(JDBCDriverClass);							//
//	} catch (ClassNotFoundException e) {						//
//		e.printStackTrace();									//
//	}															//
//////////////////////////////////////////////////////////////////

// �Ʒ��� static �޼ҵ��̹Ƿ� ��ü�������� �ٷ� �θ� �� �ִ�.
// JDBCDriverLoader.init();
// �׷��� �̰� Connection ���ʷ� ���� �� �� �ѹ��� �Ҹ��� �ǹǷ�
// JDBCConnection Ŭ�������� static���� �ҷ��ش�.


// 2. DBMS ���� ��ü ����
//////////////////////////////////////////////////////////////////////////////
//	Connection conn = null;													//
//																			//
//	String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";	//
//	String user = "root";													//
//	String password = "SystemManager304";									//
//																			//
//	try {																	//
//		conn = DriverManager.getConnection(url, user, password);			//
//		System.out.println("DBMS ���� �Ϸ� !");									//
//	} catch (SQLException e) {												//
//		e.printStackTrace();												//
//	}																		//
//////////////////////////////////////////////////////////////////////////////	


// 3. ����(SQL) ���� ��ü ����
//////////////////////////////////////////////////
//	Statement stmt = null;						//
//	PreparedStatement pstmt = null;				//
//	try {										//
//		stmt = conn.createStatement();			//
//		pstmt = conn.prepareStatement(sql);		//
//	} catch (SQLException e) {					//
//		e.printStackTrace();					//
//	}											//
//////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////
// 4. ������ ���� �� ������ ���� �Ѱ�																		//
//		try {																						//
//			rs = stmt.executeQuery(sql);															//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//	
//		try {																						//
//			while( rs.next() ) {																	//
//				String name = rs.getString(2);														//
//				String countryCode = rs.getString(3);												//
//				String district = rs.getString(4);													//
//				int population = rs.getInt(5);														//
//																									//
//				String table = String.format(														//
//						"%s - %s - %s - %d\n", name, countryCode, district, population);			//
//																									//
//				System.out.println(table);															//
//			}																						//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//
//		String sql_p = "select * from ?";															//
//		try {																						//
//			pstmt.setString(1, "city");																//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//
//		try {																						//
//			rs = pstmt.executeQuery();																//
//		} catch (SQLException e) {																	//
//			e.printStackTrace();																	//
//		}																							//
//																									//
//		try {																						//
//			while( rs.next() ) {																	//
//				String name_p = rs.getString(2);													//
//				String countryCode_p = rs.getString(3);												//
//				String district_p = rs.getString(4);												//
//				int population_p = rs.getInt(5);													//
//																									//
//				String table = String.format(														//
//						"%s - %s - %s - %d\n", name_p, countryCode_p, district_p, population_p);	//
																			
//				
//				System.out.println(table);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////

// 4. ���� ó��
//////////////////////////////////////
//	try {							//
//		stmt.close();				//
//		pstmt.close();				//
//		conn.close();				//
//	} catch (SQLException e) {		//
//		e.printStackTrace();		//
//	}								//
//////////////////////////////////////
