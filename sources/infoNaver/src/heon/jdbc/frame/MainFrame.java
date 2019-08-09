package heon.jdbc.frame;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.*;

import heon.jdbc.dao.UserDAO;
import heon.jdbc.model.*;
import heon.jdbc.util.JDBCConnection;
import heon.jdbc.util.JDBCObjectManager;

public class MainFrame extends JFrame {
	
	private UserDAO dao = UserDAO.getInstance();
	
	private NorthPane np = new NorthPane();
	private CenterPane cp = new CenterPane();
	private SouthPane sp = new SouthPane();
	
	private JLabel space1 = new JLabel("                               ");
	private JLabel space2 = new JLabel("                               ");
	
	
	private String id_pattern = "^[a-z0-9_-]{4,8}$";
	private String pw_pattern = "^[a-zA-Z0-9_-]{8,16}$";
	private String day_pattern = "^[0-9_-]{1,2}$";
	private String year_pattern = "^[0-9_-]{4,4}$";
	private String name_pattern = "^[��-�R]*{1,10}$";
	private String phone_pattern = "^[0-9_-]{2,13}$";
	

	
	public MainFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ȸ������");
		this.setLayout(new BorderLayout());
		
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);
		
		this.add(space1, BorderLayout.WEST);
		this.add(space2, BorderLayout.EAST);
		
		// ��� �̺�Ʈ ó���� ���� �޼ҵ�
		setEvents();
		
		this.setSize(600, 900);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	
	
	// �̺�Ʈ ó������ ���� �޼ҵ� ����
	private void setEvents() {
		
		// id �ߺ�Ȯ�� ��ư �̺�Ʈ ó��
		cp.getBtnIdExist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = cp.getIdField().getText().trim();
				Connection conn = JDBCConnection.getConnection();
				boolean idExist = dao.isIdExist(conn, id);
				if( idExist ) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ��˴ϴ�.");
					cp.getIdField().setText("");
				} else if ( cp.getIdField().getText().trim().equals("") ) {
					JOptionPane.showMessageDialog(null, "������ ��� �Ұ����մϴ�.");
				} else if ( cp.getIdField().getText().trim().length() <= 3 || cp.getIdField().getText().trim().length() > 8 ) {
					JOptionPane.showMessageDialog(null, "���̵� ���� ������ Ȯ�����ּ���.");
				} else if ( !idExist ) {
					JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.");
				}
			}
		});
		
		// �����ϱ� ��ư�� �̺�Ʈó��
		sp.getBtnReg().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 1. �ؽ�Ʈ�ʵ忡�� ���� ���Ե� ������ �����´�.
				String id = cp.getIdField().getText().trim();
				String pw = cp.getPwcField().getText().trim();
				String name = cp.getNameField().getText().trim();
				
				String birthYear = cp.getBirthYearField().getText().trim();
				String birthMonth = cp.getMonthCombo().getItemAt(cp.getMonthCombo().getSelectedIndex()).trim();
				String birthDay = cp.getBirthDayField().getText().trim();
				String birth = birthYear + "�� " + birthMonth + " " + birthDay + "��";
				
				String gender = cp.getGenderCombo().getItemAt(cp.getGenderCombo().getSelectedIndex()).trim();
				String mail = cp.getMailField().getText().trim();

				String tel = cp.getPhoneField().getText().trim();
				
				
				// 2. �ʼ� �Է»��� üũ
				boolean emptyCheck;
				emptyCheck = id.length() == 0;
				emptyCheck = emptyCheck || pw.length() == 0;
				emptyCheck = emptyCheck || name.length() == 0;
				emptyCheck = emptyCheck || birth.length() == 0;
				emptyCheck = emptyCheck || gender.length() == 0;
				emptyCheck = emptyCheck || tel.length() == 0;
				
				if( emptyCheck ) {
					JOptionPane.showMessageDialog(null, "�ʼ� �Է»����� �����Ǿ����ϴ�.");
					return;
				}
				
				// 2-1 id üũ
				boolean idCheck;				
				idCheck = Pattern.matches(id_pattern, cp.getIdField().getText().trim());
				if( ! idCheck ) {
					JOptionPane.showMessageDialog(null, "���̵� Ȯ���ϼ���. ( ����� ���� ȥ�� 4 ~ 8 �ڸ� )");
					return;
				}

				
				// 2-2. pw�� ������ üũ
				boolean pwCheck;
				pwCheck = Pattern.matches(pw_pattern, cp.getPwField().getText().trim());
				if( ! pwCheck ) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ȯ���ϼ���. ( ����(��, �ҹ��� ����)�� ���� ȥ�� 8 ~ 16 �ڸ� )");
					return;
				}
				
				if( !cp.getPwField().getText().equals(cp.getPwcField().getText()) ) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					return;
				}
				

				// 2-3. ������� üũ (�⵵)
				boolean byCheck;				
				byCheck = Pattern.matches(year_pattern, cp.getBirthYearField().getText().trim());
				if( ! byCheck ) {
					JOptionPane.showMessageDialog(null, "��������� Ȯ���ϼ���. ( 4�ڸ� �⵵ )");
					return;
				}
				
				// 2-4. ������� üũ (��)
				boolean bdCheck;				
				bdCheck = Pattern.matches(day_pattern, cp.getBirthDayField().getText().trim());
				if( ! bdCheck ) {
					JOptionPane.showMessageDialog(null, "��������� Ȯ���ϼ���. ( 1�ڸ� �Ǵ� 2�ڸ� �� )");
					return;
				}
				
				// 2-5. �̸� üũ
				boolean nameCheck;				
				nameCheck = Pattern.matches(name_pattern, cp.getNameField().getText().trim());
				if( ! nameCheck ) {
					JOptionPane.showMessageDialog(null, "�̸��� Ȯ���ϼ���. ( �ѱ� 1 ~ 10 �� )");
					return;
				}
				
				// 2-6. ���� üũ
				boolean genderCheck;
				genderCheck = cp.getGenderCombo().getSelectedIndex() != 0 ;
				if( ! genderCheck ) {
					JOptionPane.showMessageDialog(null, "������ Ȯ���ϼ���. ( �ʼ� ���� )");
					return;
				}
				
				// 2-7. �޴���ȭ üũ
				boolean phonCheck;
				phonCheck = Pattern.matches(phone_pattern, cp.getPhoneField().getText().trim());
				if( ! phonCheck ) {
					JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� Ȯ���ϼ���. ( - �� ������ ���ڸ� �Է� )");
					return;
				}
				
				// 3. �ؽ�Ʈ �ʵ忡�� ���Ե� ������ ������ User ��ü ����
				User user = new User(id, pw, name, birth, gender, mail, tel);
				
				// 4. �����ͺ��̽� ���̺� User��ü�� ���� ������ �Ѱ��ش�.
				Connection conn = JDBCConnection.getConnection();
				// 4-1. �ߺ��� id�� ������ ������ ���ƾ� �Ѵ�.
				boolean idExist = dao.isIdExist(conn, id);
				if( idExist ) {
					JOptionPane.showMessageDialog(null, "���̵� �ߺ��˴ϴ�.");
					cp.getIdField().setText("");
					return;
				} 
				// DAO�� Ȱ���� ���̺� ������ �Է��� �� ������ ���� ������ ���ϵ� ���� result�� ����
				int result = dao.insert(conn, user);
				if( result == 1) {
					JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "ȸ�������� �����Ͽ����ϴ�.");
				}
				
				// �ؽ�Ʈ�ʵ带 �ʱ�ȭ �� �� ������ ����
				resetTextFields();
				cp.getMust_id().setVisible(true);
				cp.getMust_pw().setVisible(true);
				cp.getMust_name().setVisible(true);
				cp.getMust_birth().setVisible(true);
				cp.getMust_gender().setVisible(true);
				cp.getMust_phone().setVisible(true);
				cp.getEqualPw().setVisible(false);
				JDBCObjectManager.close(conn);
			}
		});
	}	
	
	// ���� �� ��� �ؽ�Ʈ�ʵ� �ʱ�ȭ�ϴ� �޼ҵ�
	private void resetTextFields () {
		cp.getIdField().setText("");
		cp.getPwField().setText("");
		cp.getPwcField().setText("");
		cp.getNameField().setText("");
		cp.getBirthYearField().setText("");
		cp.getMonthCombo().setSelectedIndex(0);
		cp.getBirthDayField().setText("");
		cp.getGenderCombo().setSelectedIndex(0);
		cp.getMailField().setText("");
		cp.getPhoneField().setText("");
	}
}
