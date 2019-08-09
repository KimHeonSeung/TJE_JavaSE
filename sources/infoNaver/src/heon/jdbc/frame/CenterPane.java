package heon.jdbc.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class CenterPane extends JPanel {
	private String [] strLabels = {"���̵� ( �ҹ��� ����, ���� ȥ�� 4 ~ 8�� )", "��й�ȣ ( ����(��, �ҹ��� ����)�� ���� ȥ�� 8 ~ 16 �ڸ� )", "��й�ȣ ��Ȯ��", 
									"�̸� ( �ѱ� 1 ~ 10�� )", "������� ( 4�ڸ� �⵵, 1 �Ǵ� 2�ڸ� �� )", "���� Ȯ�� �̸���", "�޴���ȭ ( - ���� )"}; 
	private String [] month = {"��", "1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��",
								"9��", "10��", "11��", "12��"};
	private String [] gender = {"����", "��", "��"};
	private JLabel [] labels = new JLabel[strLabels.length];
	
	
	private TextField idField = new TextField(20);
	private JLabel idLabel = new JLabel(" @naver.com");
	private TextField pwField = new TextField(20);
	private TextField pwcField = new TextField(20);
	private TextField nameField = new TextField(20);
	private TextField birthYearField = new TextField(20);
	private TextField birthDayField = new TextField(20);
	private TextField mailField = new TextField(20);
	private TextField phoneField = new TextField(20);
	
	private JLabel must_id = new JLabel("�ʼ� �����Դϴ�.");
	private JLabel must_pw = new JLabel("�ʼ� �����Դϴ�.");
	private JLabel must_name = new JLabel("�ʼ� �����Դϴ�.");
	private JLabel must_birth = new JLabel("�ʼ� �����Դϴ�.");
	private JLabel must_gender = new JLabel("�ʼ� �����Դϴ�.");
	private JLabel must_phone = new JLabel("�ʼ� �����Դϴ�.");
	private JLabel equalPw = new JLabel("�ʼ� �����Դϴ�.");
	
	private JPanel idPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel idMid = new JPanel(new GridLayout(1,2));
	private JPanel idMid_LabelButton = new JPanel(new GridLayout(1,2));
	private JButton btnIdExist = new JButton("�ߺ� Ȯ��");
	private JPanel pwPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel pwcPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel namePane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel birthPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel birth = new JPanel(new GridLayout(1, 3, 6, 6));
	private JComboBox<String> monthCombo = new JComboBox<String>(month);
	private JPanel genderPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JComboBox<String> genderCombo = new JComboBox<String>(gender);
	private JPanel mailPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel phonePane = new JPanel(new GridLayout(3, 1, 5, 5));
	
	
	private Font f = new Font("���̹�", Font.PLAIN, 15);
	private Font font_Label = new Font("���̹�", Font.PLAIN, 15);
	private Font font_Must = new Font("���̹�", Font.PLAIN, 13);
	private Font font_Combo = new Font("���̹�", Font.PLAIN, 13);

	public CenterPane() {
		this.setLayout(new GridLayout(8, 1, 10, 10));
		
		// �� �迭�� ��ü ����
		for(int i = 0 ; i <strLabels.length ; i++) {
			labels[i] = new JLabel(strLabels[i]);
			labels[i].setFont(f);
		}
		
		// idPane ����
		idPane.add(labels[0]);
		idLabel.setFont(font_Label);
		idLabel.setForeground(Color.GRAY);
		btnIdExist.setFont(f);
		btnIdExist.setBackground(new Color(0, 228, 97));
		btnIdExist.setForeground(Color.GRAY);
		idMid.add(idField);
		idMid_LabelButton.add(idLabel);
		idMid_LabelButton.add(btnIdExist);
		idMid.add(idMid_LabelButton);
		idPane.add(idMid);
		must_id.setFont(font_Must);
		must_id.setForeground(Color.RED);
		idPane.add(must_id);
		must_id.setVisible(true);
		
		// pwPane ����
		pwPane.add(labels[1]);
		pwPane.add(pwField);
		pwField.setEchoChar('*');
		must_pw.setFont(font_Must);
		must_pw.setForeground(Color.RED);
		pwPane.add(must_pw);
		must_pw.setVisible(true);

		
		// pwcPane ����
		pwcPane.add(labels[2]);
		pwcField.setEchoChar('*');
		pwcPane.add(pwcField);
		equalPw.setFont(font_Must);
		equalPw.setForeground(Color.RED);
		pwcPane.add(equalPw);
		equalPw.setVisible(true);
		
		// namePane ����
		namePane.add(labels[3]);
		namePane.add(nameField);
		must_name.setFont(font_Must);
		must_name.setForeground(Color.RED);
		namePane.add(must_name);
		must_name.setVisible(true);
		
		// birthPane ����
		birthPane.add(labels[4]);
		birth.add(birthYearField);
		monthCombo.setFont(font_Combo);
		birth.add(monthCombo);
		birth.add(birthDayField);
		birthPane.add(birth);
		must_birth.setFont(font_Must);
		must_birth.setForeground(Color.RED);
		birthPane.add(must_birth);		
		must_birth.setVisible(true);
		boolean flag;
		flag = (birthYearField.getText().trim().length() != 0);
		flag = flag && (birthDayField.getText().trim().length() != 0);
		flag = flag && (monthCombo.getSelectedIndex() != 0);
		
		// genderPane ����
		JLabel genderLabel = new JLabel("����");
		genderLabel.setFont(f);
		genderPane.add(genderLabel);
		genderCombo.setFont(font_Combo);
		genderPane.add(genderCombo);
		must_gender.setFont(font_Must);
		must_gender.setForeground(Color.RED);
		genderPane.add(must_gender);
		must_gender.setVisible(true);
		
		
		// mailPane ����
		mailPane.add(labels[5]);
		mailPane.add(mailField);
		JLabel mail_Label = new JLabel("���û����Դϴ�.");
		mail_Label.setFont(font_Must);
		mail_Label.setForeground(Color.MAGENTA);
		mailPane.add(mail_Label);
		
		// phonePane ����
		phonePane.add(labels[6]);
		phonePane.add(phoneField);
		must_phone.setVisible(false);
		must_phone.setFont(font_Must);
		must_phone.setForeground(Color.RED);
		phonePane.add(must_phone);
		must_phone.setVisible(true);
		
		// �г� ����
		this.add(idPane);
		this.add(pwPane);
		this.add(pwcPane);
		this.add(namePane);
		this.add(birthPane);
		this.add(genderPane);
		this.add(mailPane);
		this.add(phonePane);
		
		
		// �ؽ�Ʈ�ʵ� �̺�Ʈó��
		idField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if( idField.getText().length() != 0 ) {
					must_id.setVisible(false);
				} else {
					must_id.setVisible(true);
				}
			}
		});
		
		pwField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if( pwField.getText().length() != 0 ) {
					must_pw.setVisible(false);
				} else {
					must_pw.setVisible(true);
				}
			}
		});
		
		pwcField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				equalPw.setVisible(true);
				if( pwField.getText().equals(pwcField.getText()) ) {
					equalPw.setForeground(Color.BLUE);
					equalPw.setText("��й�ȣ�� ��ġ�մϴ�.");
				} else {
					if( pwcField.getText().length() == 0 ) {
						equalPw.setForeground(Color.RED);
						equalPw.setText("�ʼ� �����Դϴ�.");
					} else {
						equalPw.setForeground(Color.RED);
						equalPw.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					}
				}
			}
		});
		
		nameField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if( nameField.getText().length() != 0 ) {
					must_name.setVisible(false);
				} else {
					must_name.setVisible(true);
				}
			}
		});
		
		birthYearField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				boolean flag;
				flag = (monthCombo.getSelectedIndex() != 0);
				flag = flag && (birthDayField.getText().trim().length() != 0);
				flag = flag && (birthYearField.getText().trim().length() != 0);

				if( flag ) {
					must_birth.setVisible(false);
				} else {
					must_birth.setVisible(true);
				}
				
				boolean isNum;
				char c = e.getKeyChar();
				isNum =(Character.isDigit(c) || 
						(c == KeyEvent.VK_BACK_SPACE) || 
						(c == KeyEvent.VK_DELETE));
				if( !isNum ) {
					birthYearField.setText("");
					must_birth.setVisible(true);
				}
			}
		});
		
		birthDayField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				boolean flag;
				flag = (monthCombo.getSelectedIndex() != 0);
				flag = flag && (birthDayField.getText().trim().length() != 0);
				flag = flag && (birthYearField.getText().trim().length() != 0);

				if( flag ) {
					must_birth.setVisible(false);
				} else {
					must_birth.setVisible(true);
				}
				
				boolean isNum;
				char c = e.getKeyChar();
				isNum =(Character.isDigit(c) || 
						(c == KeyEvent.VK_BACK_SPACE) || 
						(c == KeyEvent.VK_DELETE));
				if( !isNum ) {
					birthDayField.setText("");
				}
			}			
		});
		
		monthCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				boolean flag;
				flag = (monthCombo.getSelectedIndex() != 0);
				flag = flag && (birthDayField.getText().trim().length() != 0);
				flag = flag && (birthYearField.getText().trim().length() != 0);

				if( flag ) {
					must_birth.setVisible(false);
				} else {
					must_birth.setVisible(true);
				}
			}
		});
		
		genderCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( genderCombo.getSelectedIndex() != 0 ) {
					must_gender.setVisible(false);
				} else {
					must_gender.setVisible(true);
				}
			}
		});
		
		phoneField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if( phoneField.getText().length() != 0 ) {
					must_phone.setVisible(false);
				} else {
					must_phone.setVisible(true);
				}
				
				boolean isNum;
				char c = e.getKeyChar();
				isNum =(Character.isDigit(c) || 
						(c == KeyEvent.VK_BACK_SPACE) || 
						(c == KeyEvent.VK_DELETE));
				if( !isNum ) {
					phoneField.setText("");
				}
			}
		});
	}
	
	
	
	

	public JButton getBtnIdExist() {
		return btnIdExist;
	}

	public TextField getIdField() {
		return idField;
	}

	public void setIdField(TextField idField) {
		this.idField = idField;
	}

	public TextField getPwField() {
		return pwField;
	}

	public void setPwField(TextField pwField) {
		this.pwField = pwField;
	}

	public TextField getPwcField() {
		return pwcField;
	}

	public void setPwcField(TextField pwcField) {
		this.pwcField = pwcField;
	}

	public TextField getNameField() {
		return nameField;
	}

	public void setNameField(TextField nameField) {
		this.nameField = nameField;
	}

	public JLabel getMust_birth() {
		return must_birth;
	}

	public TextField getBirthYearField() {
		return birthYearField;
	}

	public void setBirthYearField(TextField birthYearField) {
		this.birthYearField = birthYearField;
	}

	public TextField getBirthDayField() {
		return birthDayField;
	}

	public void setBirthDayField(TextField birthDayField) {
		this.birthDayField = birthDayField;
	}

	public TextField getMailField() {
		return mailField;
	}

	public void setMailField(TextField mailField) {
		this.mailField = mailField;
	}

	public TextField getPhoneField() {
		return phoneField;
	}

	public void setPhoneField(TextField phoneField) {
		this.phoneField = phoneField;
	}


	public JComboBox<String> getMonthCombo() {
		return monthCombo;
	}

	public void setMonthCombo(JComboBox<String> monthCombo) {
		this.monthCombo = monthCombo;
	}


	public JComboBox<String> getGenderCombo() {
		return genderCombo;
	}

	public void setGenderCombo(JComboBox<String> genderCombo) {
		this.genderCombo = genderCombo;
	}

	public JLabel getMust_id() {
		return must_id;
	}
	public JLabel getMust_pw() {
		return must_pw;
	}
	public JLabel getMust_name() {
		return must_name;
	}
	public JLabel getMust_gender() {
		return must_gender;
	}
	public JLabel getMust_phone() {
		return must_phone;
	}
	public JLabel getEqualPw() {
		return equalPw;
	}
}
