package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerAllEx extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la;
	
	MouseListenerAllEx() {
		setTitle("���콺 �����ʿ� ���콺 ��Ǹ����� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(contentPane);
		
		contentPane.addMouseListener(new MyMouseListener());
		contentPane.addMouseMotionListener(new MyMouseListener());
		
		la = new JLabel("���콺 �̺�Ʈ ����");
		contentPane.add(la);
		setSize(500,500);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("���콺 �巡�� (" + e.getX() + "," + e.getY() + ")");
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();
			p.setBackground(Color.GREEN);
			// �Ʒ�ó�� ����ص� �ȴ�.
//			contentPane.setBackground(Color.GREEN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			contentPane.setBackground(Color.pink);
			// �Ʒ�ó�� ����ص� �ȴ�.
//			JPanel p = (JPanel) e.getSource();
//			p.setBackground(Color.pink);
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("���콺 ������ (" + e.getX() + "," + e.getY() + ")");
		}
		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("���콺 ���� (" + e.getX() + "," + e.getY() + ")");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("���콺 ���� (" + e.getX() + "," + e.getY() + ")");
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e) {}
	}

	public static void main(String[] args) {
		new MouseListenerAllEx();
	}
}
