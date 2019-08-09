package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyCodeEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("HELLO");
	
	KeyCodeEx() {
		setTitle("Key Code ���� : F1Ű�� �ʷϻ�, %Ű�� �����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setFocusable(true);
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.add(la);
		la.setSize(500,500);
		setSize(1500,1500);
		setVisible(true);
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			la.setText(e.getKeyText(e.getKeyCode())+"Ű�� �Է��߽��ϴ�.");
			if(e.getKeyChar() == '%')
				contentPane.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1)
				contentPane.setBackground(Color.RED);
			else if(e.getKeyCode() == KeyEvent.VK_F2)
				contentPane.setBackground(Color.ORANGE);
			else if(e.getKeyCode() == KeyEvent.VK_F3)
				contentPane.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F4)
				contentPane.setBackground(Color.GREEN);
			else if(e.getKeyCode() == KeyEvent.VK_F5)
				contentPane.setBackground(Color.BLUE);
			else if(e.getKeyCode() == KeyEvent.VK_F6)
				contentPane.setBackground(Color.CYAN);
			else if(e.getKeyCode() == KeyEvent.VK_F7)
				contentPane.setBackground(Color.PINK);
		}
	}

	public static void main(String[] args) {
		new KeyCodeEx();
	}
}
