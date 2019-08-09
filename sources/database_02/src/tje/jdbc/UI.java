package tje.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UI extends JFrame {

	private UI_NorthPane np = new UI_NorthPane();
	private UI_CenterPane cp = new UI_CenterPane();
	private UI_SouthPane sp = new UI_SouthPane();
	
	private static final String USER_INFO_DIR_PATH = "./user";
	private static final String USER_INFO_FILE_PATH = "user_info.dat";
	private static File USER_INFO_DIR;
	private static File USER_INFO_SAVE_FILE;
	// ���� ���� ȸ�����Կ� �ʿ��� ��ο� ������ �������´�.
	static {
		USER_INFO_DIR = new File(USER_INFO_DIR_PATH);
		if ( !USER_INFO_DIR.exists() )
			USER_INFO_DIR.mkdirs();
		
		USER_INFO_SAVE_FILE = new File(USER_INFO_DIR, USER_INFO_FILE_PATH);
	}
	
	
	
	public UI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ȸ������");
		this.add(cp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);
		
		
		
		
		// �̺�Ʈ ó��
		// 1. �ʱ�ȭ��ư
		this.sp.getResetBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		// 2. ���� ��ư
		this.sp.getCompBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// �ʼ� �Է»����� ��� �Է��ߴ��� üũ
				boolean check = cp.getIdField().getText().isEmpty() ||
						cp.getPwField().getText().isEmpty() ||
						cp.getNameField().getText().isEmpty();
				
				if( check ) {
					JOptionPane.showMessageDialog(null, "�ʼ� �Է»����� ��� �Է��ؾ��մϴ�.");
				}
				else {
					
					SaveInfo si = 
							new SaveInfo(cp.getIdField().getText().trim(),
									cp.getPwField().getText().trim(),
									cp.getNameField().getText().trim(),
									cp.getTelField().getText().trim(),
									Integer.parseInt(cp.getAgeField().getText()));
					
					try (ObjectOutputStream out = 
							new ObjectOutputStream(
									new BufferedOutputStream(
											new FileOutputStream(USER_INFO_SAVE_FILE)));) {
						out.writeObject(si);
						out.flush();
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "���� ���� �������� ������ �߻��Ͽ����ϴ�.");
					}
				}
				
				
			}
		});
		
		
		setSize(500, 500);
		setVisible(true);
	}
	
	
	private void reset() {
		this.cp.getIdField().setText("");
		this.cp.getPwField().setText("");
		this.cp.getNameField().setText("");
		this.cp.getAgeField().setText("");
		this.cp.getTelField().setText("");
	}
	
	
	private class SaveInfo {
		private String idInfo, pwInfo, nameInfo, telInfo;
		private int ageInfo;
		
		
		public SaveInfo(String idInfo, String pwInfo, String nameInfo, String telInfo, int ageInfo) {
			super();
			this.idInfo = idInfo;
			this.pwInfo = pwInfo;
			this.nameInfo = nameInfo;
			this.telInfo = telInfo;
			this.ageInfo = ageInfo;
		}

	}
	
	public static void main(String[] args) {
		new UI();
	}
}
