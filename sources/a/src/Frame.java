import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Frame extends JFrame {
	
	private String [] labelText = {"ID(*)", "PW(*)", "NAME(*)", "AGE", "TEL"};
	private JLabel [] labels = new JLabel[labelText.length];
	private JTextField [] fields = new JTextField[labelText.length];
	private JButton btnRegist = new JButton("����");
	private JButton btnReset = new JButton("�ʱ�ȭ");
	private Font f = new Font("���ü", Font.ITALIC, 30);
	private Font f1 = new Font("���ü", Font.ITALIC, 20);
	private Font f2 = new Font("���ü", Font.BOLD, 30);
	
	public Frame(String title) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setLayout(new GridLayout(6, 2, 10, 10));
		
		for( int i = 0 ; i < labelText.length ; i++ ) {
			labels[i] = new JLabel(labelText[i], SwingConstants.CENTER);
			labels[i].setFont(f);
			fields[i] = new JTextField(20);
			fields[i].setFont(f1);
			
			this.add(labels[i]);
			this.add(fields[i]);
		}
		
		btnRegist.setFont(f2);
		btnReset.setFont(f2);
		
		this.add(btnRegist);
		this.add(btnReset);
		
		setEvents();
		
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	
	private void setEvents() {
		this.btnRegist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( userRegist() ) {
					JOptionPane.showMessageDialog(null, "ȸ������ ����!");
					componentsReset();
				} else
					JOptionPane.showMessageDialog(null, "ȸ������ ����..");
					
			}
		});
	}
	
	private boolean userRegist() {
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().isEmpty() ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length()-3) + "�� �ʼ� �Է»����Դϴ�.");
				return false;
			}
		}
		
		boolean result = false;
		
		
		// 1. JDBC ����̹� Ŭ���� �ε�
				String strDriverClassName = "com.mysql.cj.jdbc.Driver";
				try {
					Class.forName(strDriverClassName);
					System.out.println("����̹� Ŭ���� �ε� �Ϸ�");
				} catch (ClassNotFoundException e) {
					System.out.println("����̹� Ŭ���� �ε� ����");
					e.printStackTrace();
					return false;
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
					return false;
				}
				
				// ID ������ ����Ͽ� Select ������ ������ ��ü
				PreparedStatement selectPstmt = null;
				// ������ ������ �Է¹޾� Insert ������ ������ ��ü
				PreparedStatement insertPstmt = null;
				
				String select_sql = "select * from users where user_id = ?";
				String insert_sql = "insert into users values (0, ?, ?, ?, ?, ?)";
				
				ResultSet rs = null;
				int recordCount = 0;
				
				try {
					selectPstmt = conn.prepareStatement(select_sql);
					insertPstmt = conn.prepareStatement(insert_sql);
					
					String user_id = this.fields[0].getText().trim();
					selectPstmt.setString(1, user_id);
					
					rs = selectPstmt.executeQuery();
					
					if( rs.next() )
						return false;
					
					insertPstmt.setString(1, this.fields[0].getText().trim());
					insertPstmt.setString(2, this.fields[1].getText().trim());
					insertPstmt.setString(3, this.fields[2].getText().trim());
					
					if( fields[3].getText().trim().length() > 0 ) {
						int age = 0;
						
						try {
							age = Integer.parseInt(this.fields[3].getText().trim());
							insertPstmt.setInt(4, age);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "AGE �ʵ忡�� ���ڸ� �Է��ϼ���");
							return false;
						} 
					} else
						insertPstmt.setNull(4, java.sql.Types.NULL);
					
					if( fields[4].getText().trim().length() > 0 ) 
						insertPstmt.setString(5, this.fields[4].getText().trim());
					else
						insertPstmt.setNull(5, java.sql.Types.NULL);
					
					recordCount = insertPstmt.executeUpdate();
					
					if( recordCount == 1 )
						result = true;
					else
						result = false;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					if( rs != null )
						rs.close();
					if( selectPstmt != null )
						selectPstmt.close();
					if( insertPstmt != null )
						insertPstmt.close();
					if( conn != null )
						conn.close();
					System.out.println("DBMS ���� ����");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
	}
	
	
	private void componentsReset() {
		for( int i = 0 ; i < fields.length ; i++ )
			fields[i].setText("");
	}
	
	public static void main(String[] args) {
		new Frame("ȸ������");
	}
	
}
