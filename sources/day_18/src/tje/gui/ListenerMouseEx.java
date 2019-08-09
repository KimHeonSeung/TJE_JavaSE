package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// �������̽� ����� �߻�޼ҵ带 ���� �����ؾ���
// �̰� ������ Adaptor�� �ϸ� ��.
class MyMouseListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.RED);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.GREEN);
	}
}

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx() {
		setTitle("��ư�� ���콺 �̺�Ʈ ������ �ۼ�");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton btn = new JButton("���콺 �̺�Ʈ �׽�Ʈ ��ư");
		btn.setBackground(Color.GREEN);
		MyMouseListener listener = new MyMouseListener();
		btn.addMouseListener(listener);
		add(btn);
		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerMouseEx();
	}
}


