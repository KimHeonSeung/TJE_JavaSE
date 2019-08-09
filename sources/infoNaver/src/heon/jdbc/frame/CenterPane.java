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
	private String [] strLabels = {"아이디 ( 소문자 영어, 숫자 혼용 4 ~ 8자 )", "비밀번호 ( 영어(대, 소문자 구분)와 숫자 혼용 8 ~ 16 자리 )", "비밀번호 재확인", 
									"이름 ( 한글 1 ~ 10자 )", "생년월일 ( 4자리 년도, 1 또는 2자리 일 )", "본인 확인 이메일", "휴대전화 ( - 제외 )"}; 
	private String [] month = {"월", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
								"9월", "10월", "11월", "12월"};
	private String [] gender = {"성별", "남", "여"};
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
	
	private JLabel must_id = new JLabel("필수 정보입니다.");
	private JLabel must_pw = new JLabel("필수 정보입니다.");
	private JLabel must_name = new JLabel("필수 정보입니다.");
	private JLabel must_birth = new JLabel("필수 정보입니다.");
	private JLabel must_gender = new JLabel("필수 정보입니다.");
	private JLabel must_phone = new JLabel("필수 정보입니다.");
	private JLabel equalPw = new JLabel("필수 정보입니다.");
	
	private JPanel idPane = new JPanel(new GridLayout(3, 1, 5, 5));
	private JPanel idMid = new JPanel(new GridLayout(1,2));
	private JPanel idMid_LabelButton = new JPanel(new GridLayout(1,2));
	private JButton btnIdExist = new JButton("중복 확인");
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
	
	
	private Font f = new Font("네이버", Font.PLAIN, 15);
	private Font font_Label = new Font("네이버", Font.PLAIN, 15);
	private Font font_Must = new Font("네이버", Font.PLAIN, 13);
	private Font font_Combo = new Font("네이버", Font.PLAIN, 13);

	public CenterPane() {
		this.setLayout(new GridLayout(8, 1, 10, 10));
		
		// 라벨 배열에 객체 대입
		for(int i = 0 ; i <strLabels.length ; i++) {
			labels[i] = new JLabel(strLabels[i]);
			labels[i].setFont(f);
		}
		
		// idPane 설정
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
		
		// pwPane 설정
		pwPane.add(labels[1]);
		pwPane.add(pwField);
		pwField.setEchoChar('*');
		must_pw.setFont(font_Must);
		must_pw.setForeground(Color.RED);
		pwPane.add(must_pw);
		must_pw.setVisible(true);

		
		// pwcPane 설정
		pwcPane.add(labels[2]);
		pwcField.setEchoChar('*');
		pwcPane.add(pwcField);
		equalPw.setFont(font_Must);
		equalPw.setForeground(Color.RED);
		pwcPane.add(equalPw);
		equalPw.setVisible(true);
		
		// namePane 설정
		namePane.add(labels[3]);
		namePane.add(nameField);
		must_name.setFont(font_Must);
		must_name.setForeground(Color.RED);
		namePane.add(must_name);
		must_name.setVisible(true);
		
		// birthPane 설정
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
		
		// genderPane 설정
		JLabel genderLabel = new JLabel("성별");
		genderLabel.setFont(f);
		genderPane.add(genderLabel);
		genderCombo.setFont(font_Combo);
		genderPane.add(genderCombo);
		must_gender.setFont(font_Must);
		must_gender.setForeground(Color.RED);
		genderPane.add(must_gender);
		must_gender.setVisible(true);
		
		
		// mailPane 설정
		mailPane.add(labels[5]);
		mailPane.add(mailField);
		JLabel mail_Label = new JLabel("선택사항입니다.");
		mail_Label.setFont(font_Must);
		mail_Label.setForeground(Color.MAGENTA);
		mailPane.add(mail_Label);
		
		// phonePane 설정
		phonePane.add(labels[6]);
		phonePane.add(phoneField);
		must_phone.setVisible(false);
		must_phone.setFont(font_Must);
		must_phone.setForeground(Color.RED);
		phonePane.add(must_phone);
		must_phone.setVisible(true);
		
		// 패널 삽입
		this.add(idPane);
		this.add(pwPane);
		this.add(pwcPane);
		this.add(namePane);
		this.add(birthPane);
		this.add(genderPane);
		this.add(mailPane);
		this.add(phonePane);
		
		
		// 텍스트필드 이벤트처리
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
					equalPw.setText("비밀번호가 일치합니다.");
				} else {
					if( pwcField.getText().length() == 0 ) {
						equalPw.setForeground(Color.RED);
						equalPw.setText("필수 정보입니다.");
					} else {
						equalPw.setForeground(Color.RED);
						equalPw.setText("비밀번호가 일치하지 않습니다.");
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
