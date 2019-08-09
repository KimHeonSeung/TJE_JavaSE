package tje.jdbc.frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import tje.jdbc.dao.UserDAO;
import tje.jdbc.model.User;
import tje.jdbc.util.JDBCConnection;
import tje.jdbc.util.JDBCObjectManager;

import java.sql.*;

public class UserRegistFrame_mine extends JFrame {
	
	private String [] labelText = {"ID(*)","PW(*)","NAME(*)","ALIAS","TEL"};
	private JLabel [] labels = new JLabel[labelText.length];
	private JTextField [] fields = new JTextField[labelText.length];
	private JButton btnRegist = new JButton("����");
	private JButton btnEdit = new JButton("����");
	private JButton btnDelete = new JButton("����");
	private JButton btnReset = new JButton("�ʱ�ȭ");
	private Font f = new Font("���ü", Font.ITALIC, 30);
	private Font f1 = new Font("���ü", Font.ITALIC, 20);
	private Font f2 = new Font("���ü", Font.BOLD, 30);
	private Connection conn = null;
	
	public UserRegistFrame_mine(String title) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle(title);
		this.setLayout(new GridLayout(6, 2, 3, 3));
		
		for( int i = 0 ; i < labelText.length ; i++ ) {
			labels[i] = new JLabel(labelText[i], SwingConstants.CENTER);
			labels[i].setFont(f);
			fields[i] = new JTextField(20);
			fields[i].setFont(f1);
			
			this.add(labels[i]);
			this.add(fields[i]);
		}
		JPanel lBtnPane = new JPanel(new GridLayout(1, 2, 3, 3));
		btnRegist.setFont(f2);
		btnEdit.setFont(f2);
		lBtnPane.add(btnRegist);
		lBtnPane.add(btnEdit);
		JPanel rBtnPane = new JPanel(new GridLayout(1, 2, 3, 3));
		btnDelete.setFont(f2);
		btnReset.setFont(f2);
		rBtnPane.add(btnDelete);
		rBtnPane.add(btnReset);
		
		this.add(lBtnPane);
		this.add(rBtnPane);
		setEvents();
		this.conn = JDBCConnection.getConnection();
		
		this.setSize(600, 900);
		this.setVisible(true);		
	}
	
	private void setEvents() {
		this.btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( userRegist() ) {
					JOptionPane.showMessageDialog(null, "ȸ������ ����!");
					componentsReset();
				} else
					JOptionPane.showMessageDialog(null, "ȸ������ ����!");
					
			}
		});
		
		this.btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoEdit(fields[0].getText().trim());
			}
		});
		
		this.btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ʼ� �Է»��� üũ
				for( int i = 0 ; i < 3 ; i++ ) {
					if( fields[i].getText().trim().length() == 0 ) {
						JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "�� �ʼ� �Է»��� �Դϴ�.");
					}
				}
				infoDelete(fields[0].getText().trim());
			}
		});
		
		this.btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				componentsReset();
			}
		});
	}
	
	private void infoDelete(String id) {
		// �ʼ� �Է»��� üũ
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "�� �ʼ� �Է»��� �Դϴ�.");
			}
		}
		
		UserDAO dao = UserDAO.getInstance();
		User user5 = new User(id);

		dao.delete(conn, user5);
		JOptionPane.showMessageDialog(null, "ȸ�� ������ �����Ǿ����ϴ�.");
		JDBCObjectManager.close(conn);
		
	}
	
	private void infoEdit(String id) {
		// �ʼ� �Է»��� üũ
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "�� �ʼ� �Է»��� �Դϴ�.");
			}
		}
		
		UserDAO dao = UserDAO.getInstance();
		User user4 = dao.select(conn, new User(id));
		if( user4 != null ) {
			JDBCObjectManager.setAutoCommit(conn, false);
			
			int recordCount = 0;
			recordCount += dao.updatePassword(conn, user4);
			recordCount += dao.updateName(conn, user4);
			recordCount += dao.updateAlias(conn, user4);
			recordCount += dao.updateTel(conn, user4);
			
			if( recordCount == 4 )
				// ��� ������Ʈ ������ ���������� ����� ���
				// commit �޼ҵ带 ȣ���Ͽ� DB�� ����
				JDBCObjectManager.commit(conn);
			else
				// ��� ������Ʈ ���� �� �ϳ��� ������ �߻��ϴ� ���
				// rollback �޼ҵ带 ȣ���Ͽ� ��������� ��� �۾��� �����
				JDBCObjectManager.rollback(conn);
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �����Ǿ����ϴ�.");
			JDBCObjectManager.close(conn);
		} else {
			JOptionPane.showMessageDialog(null, "ȸ�� ������ �����ϴ�.");
			return;
		}
		JDBCObjectManager.close(conn);
	}
	
	private boolean userRegist() {
		// �ʼ� �Է»��� üũ
		for( int i = 0 ; i < 3 ; i++ ) {
			if( fields[i].getText().trim().length() == 0 ) {
				JOptionPane.showMessageDialog(null, labelText[i].substring(0, labelText[i].length() - 3) + "�� �ʼ� �Է»��� �Դϴ�.");
				return false;
			}
		}
				
		boolean result = false;
				
		
		// chat �����ͺ��̽��� User ���̺� ����
		// JDBC �۾��� �����ϴ� DAO Ŭ����
		UserDAO dao = UserDAO.getInstance();
		
		// 1. �Է� ( �� ��ü Ȱ�� )
		User user1 = new User(fields[0].getText().trim(),
							fields[1].getText().trim(), 
							fields[2].getText().trim(), 
							fields[3].getText().trim(), 
							fields[4].getText().trim());
		dao.insert(conn, user1);
		if( dao.insert(conn, user1) != 0 ) {
			result = true;
		}
		JDBCObjectManager.close(conn);
		return result;
	}
	
	private void componentsReset() {
		for( int i = 0 ; i < fields.length ; i++ )			
			fields[i].setText("");		
	}

	public static void main(String[] args) {
		new UserRegistFrame_mine("ȸ������");
		
	}

}