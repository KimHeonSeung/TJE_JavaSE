package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickAndDoubleClickEx extends JFrame {
	
	JPanel contentPane = new JPanel();
	
	ClickAndDoubleClickEx() {
		setTitle("Ŭ���� ����Ŭ�� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		setSize(500, 500);
		setVisible(true);		
	}
	
	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				
				JPanel p = (JPanel)e.getSource();
				p.setBackground(new Color(r, g, b));
			}
		}
	}
	
	public static void main(String[] args) {
		new ClickAndDoubleClickEx();
	}
}
