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
	private String name_pattern = "^[°¡-ÆR]*{1,10}$";
	private String phone_pattern = "^[0-9_-]{2,13}$";
	

	
	public MainFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("È¸¿ø°¡ÀÔ");
		this.setLayout(new BorderLayout());
		
		this.add(np, BorderLayout.NORTH);
		this.add(cp, BorderLayout.CENTER);
		this.add(sp, BorderLayout.SOUTH);
		
		this.add(space1, BorderLayout.WEST);
		this.add(space2, BorderLayout.EAST);
		
		// ¸ðµç ÀÌº¥Æ® Ã³¸®¸¦ À§ÇÑ ¸Þ¼Òµå
		setEvents();
		
		this.setSize(600, 900);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	
	
	// ÀÌº¥Æ® Ã³¸®µéÀ» À§ÇÑ ¸Þ¼Òµå Á¤ÀÇ
	private void setEvents() {
		
		// id Áßº¹È®ÀÎ ¹öÆ° ÀÌº¥Æ® Ã³¸®
		cp.getBtnIdExist().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = cp.getIdField().getText().trim();
				Connection conn = JDBCConnection.getConnection();
				boolean idExist = dao.isIdExist(conn, id);
				if( idExist ) {
					JOptionPane.showMessageDialog(null, "¾ÆÀÌµð°¡ Áßº¹µË´Ï´Ù.");
					cp.getIdField().setText("");
				} else if ( cp.getIdField().getText().trim().equals("") ) {
					JOptionPane.showMessageDialog(null, "°ø¹éÀº »ç¿ë ºÒ°¡´ÉÇÕ´Ï´Ù.");
				} else if ( cp.getIdField().getText().trim().length() <= 3 || cp.getIdField().getText().trim().length() > 8 ) {
					JOptionPane.showMessageDialog(null, "¾ÆÀÌµð ±æÀÌ Á¶°ÇÀ» È®ÀÎÇØÁÖ¼¼¿ä.");
				} else if ( !idExist ) {
					JOptionPane.showMessageDialog(null, "»ç¿ë °¡´ÉÇÑ ¾ÆÀÌµðÀÔ´Ï´Ù.");
				}
			}
		});
		
		// °¡ÀÔÇÏ±â ¹öÆ°ÀÇ ÀÌº¥Æ®Ã³¸®
		sp.getBtnReg().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 1. ÅØ½ºÆ®ÇÊµå¿¡¼­ °¢°¢ ±âÀÔµÈ Á¤º¸¸¦ °¡Á®¿Â´Ù.
				String id = cp.getIdField().getText().trim();
				String pw = cp.getPwcField().getText().trim();
				String name = cp.getNameField().getText().trim();
				
				String birthYear = cp.getBirthYearField().getText().trim();
				String birthMonth = cp.getMonthCombo().getItemAt(cp.getMonthCombo().getSelectedIndex()).trim();
				String birthDay = cp.getBirthDayField().getText().trim();
				String birth = birthYear + "³â " + birthMonth + " " + birthDay + "ÀÏ";
				
				String gender = cp.getGenderCombo().getItemAt(cp.getGenderCombo().getSelectedIndex()).trim();
				String mail = cp.getMailField().getText().trim();

				String tel = cp.getPhoneField().getText().trim();
				
				
				// 2. ÇÊ¼ö ÀÔ·Â»çÇ× Ã¼Å©
				boolean emptyCheck;
				emptyCheck = id.length() == 0;
				emptyCheck = emptyCheck || pw.length() == 0;
				emptyCheck = emptyCheck || name.length() == 0;
				emptyCheck = emptyCheck || birth.length() == 0;
				emptyCheck = emptyCheck || gender.length() == 0;
				emptyCheck = emptyCheck || tel.length() == 0;
				
				if( emptyCheck ) {
					JOptionPane.showMessageDialog(null, "ÇÊ¼ö ÀÔ·Â»çÇ×ÀÌ ´©¶ôµÇ¾ú½À´Ï´Ù.");
					return;
				}
				
				// 2-1 id Ã¼Å©
				boolean idCheck;				
				idCheck = Pattern.matches(id_pattern, cp.getIdField().getText().trim());
				if( ! idCheck ) {
					JOptionPane.showMessageDialog(null, "¾ÆÀÌµð¸¦ È®ÀÎÇÏ¼¼¿ä. ( ¿µ¾î¿Í ¼ýÀÚ È¥¿ë 4 ~ 8 ÀÚ¸® )");
					return;
				}

				
				// 2-2. pw°¡ °°ÀºÁö Ã¼Å©
				boolean pwCheck;
				pwCheck = Pattern.matches(pw_pattern, cp.getPwField().getText().trim());
				if( ! pwCheck ) {
					JOptionPane.showMessageDialog(null, "ºñ¹Ð¹øÈ£¸¦ È®ÀÎÇÏ¼¼¿ä. ( ¿µ¾î(´ë, ¼Ò¹®ÀÚ ±¸ºÐ)¿Í ¼ýÀÚ È¥¿ë 8 ~ 16 ÀÚ¸® )");
					return;
				}
				
				if( !cp.getPwField().getText().equals(cp.getPwcField().getText()) ) {
					JOptionPane.showMessageDialog(null, "ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
					return;
				}
				

				// 2-3. »ý³â¿ùÀÏ Ã¼Å© (³âµµ)
				boolean byCheck;				
				byCheck = Pattern.matches(year_pattern, cp.getBirthYearField().getText().trim());
				if( ! byCheck ) {
					JOptionPane.showMessageDialog(null, "»ý³â¿ùÀÏÀ» È®ÀÎÇÏ¼¼¿ä. ( 4ÀÚ¸® ³âµµ )");
					return;
				}
				
				// 2-4. »ý³â¿ùÀÏ Ã¼Å© (ÀÏ)
				boolean bdCheck;				
				bdCheck = Pattern.matches(day_pattern, cp.getBirthDayField().getText().trim());
				if( ! bdCheck ) {
					JOptionPane.showMessageDialog(null, "»ý³â¿ùÀÏÀ» È®ÀÎÇÏ¼¼¿ä. ( 1ÀÚ¸® ¶Ç´Â 2ÀÚ¸® ÀÏ )");
					return;
				}
				
				// 2-5. ÀÌ¸§ Ã¼Å©
				boolean nameCheck;				
				nameCheck = Pattern.matches(name_pattern, cp.getNameField().getText().trim());
				if( ! nameCheck ) {
					JOptionPane.showMessageDialog(null, "ÀÌ¸§À» È®ÀÎÇÏ¼¼¿ä. ( ÇÑ±Û 1 ~ 10 ÀÚ )");
					return;
				}
				
				// 2-6. ¼ºº° Ã¼Å©
				boolean genderCheck;
				genderCheck = cp.getGenderCombo().getSelectedIndex() != 0 ;
				if( ! genderCheck ) {
					JOptionPane.showMessageDialog(null, "¼ºº°À» È®ÀÎÇÏ¼¼¿ä. ( ÇÊ¼ö ¼±ÅÃ )");
					return;
				}
				
				// 2-7. ÈÞ´ëÀüÈ­ Ã¼Å©
				boolean phonCheck;
				phonCheck = Pattern.matches(phone_pattern, cp.getPhoneField().getText().trim());
				if( ! phonCheck ) {
					JOptionPane.showMessageDialog(null, "ÀüÈ­¹øÈ£¸¦ È®ÀÎÇÏ¼¼¿ä. ( - ¸¦ Á¦¿ÜÇÑ ¼ýÀÚ¸¸ ÀÔ·Â )");
					return;
				}
				
				// 3. ÅØ½ºÆ® ÇÊµå¿¡¼­ ±âÀÔµÈ Á¤º¸¸¦ °¡Á®¿Í User °´Ã¼ »ý¼º
				User user = new User(id, pw, name, birth, gender, mail, tel);
				
				// 4. µ¥ÀÌÅÍº£ÀÌ½º Å×ÀÌºí¿¡ User°´Ã¼°¡ °¡Áø Á¤º¸¸¦ ³Ñ°ÜÁØ´Ù.
				Connection conn = JDBCConnection.getConnection();
				// 4-1. Áßº¹µÈ id°¡ ÀÖÀ¸¸é °¡ÀÔÀ» ¸·¾Æ¾ß ÇÑ´Ù.
				boolean idExist = dao.isIdExist(conn, id);
				if( idExist ) {
					JOptionPane.showMessageDialog(null, "¾ÆÀÌµð°¡ Áßº¹µË´Ï´Ù.");
					cp.getIdField().setText("");
					return;
				} 
				// DAO¸¦ È°¿ëÇØ Å×ÀÌºí¿¡ Á¤º¸¸¦ ÀÔ·ÂÇÑ µÚ ¼öÁ¤µÈ ÇàÀÇ °¹¼ö°¡ ¸®ÅÏµÈ °ÍÀ» result¿¡ ´ëÀÔ
				int result = dao.insert(conn, user);
				if( result == 1) {
					JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
				} else {
					JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔÀ» ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				}
				
				// ÅØ½ºÆ®ÇÊµå¸¦ ÃÊ±âÈ­ ÇÑ ÈÄ ¿¬°áÀ» Á¾·á
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
	
	// °¡ÀÔ ÈÄ ¸ðµç ÅØ½ºÆ®ÇÊµå ÃÊ±âÈ­ÇÏ´Â ¸Þ¼Òµå
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
