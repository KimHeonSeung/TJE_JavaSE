package Chatting;

import java.awt.event.*;
import javax.swing.*;


public class ButtonListener implements ActionListener {
	
	private JTextField Field;
	private JTextArea Area;
	private String nick;

	ButtonListener(JTextField Field, JTextArea Area, JTextField nick) {
		this.Field = Field;
		this.Area = Area;
		this.nick = nick.getText();
	}
	
	ButtonListener(JTextField Field, JTextArea Area, String nick) {
		this.Field = Field;
		this.Area = Area;
		this.nick = nick;
	}
	
	public String toString() {
		return String.format("%s   :  %s\n", this.nick, Field.getText());
	}
	

	public void actionPerformed(ActionEvent e) {
		
		// ���� ��ư�� ���� �� ���� �ؽ�Ʈ �ʵ忡 ���� ���� �߰�
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("����")) {
			Area.append(toString());
			Field.setText("");
			//Area.append("\n");
		}
	}
}
