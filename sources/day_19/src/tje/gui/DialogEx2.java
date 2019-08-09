package tje.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyModalDialog extends JDialog {
	JTextField tf = new JTextField(10);
	JButton okBu = new JButton("OK");
	
	public MyModalDialog(JFrame frame, String title) {
		super(frame, title, true);
		setLayout(new FlowLayout());
		add(tf);
		add(okBu);
		setSize(300, 200);
		
		okBu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	String getInput() {
		if(tf.getText().length() == 0)
			return null;
		else return tf.getText();
	}
}

public class DialogEx2 extends JFrame {
	MyModalDialog dialog = new MyModalDialog(this, "Test Modal Dialog");
	
	public DialogEx2() {
		super("DialogEx2 ���� ������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Modal Dialog");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				// ��� ���̾�α� �̹Ƿ� setVisible �޼ҵ��
				// ���̾�αװ� ���� ������ �������� �ʴ´�.
				String text = dialog.getInput();
				if(text == null) 
					return;
				JButton btn = (JButton)e.getSource();
				btn.setText(text);
			}
		});
		
		getContentPane().add(btn);
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogEx2();
	}
}
