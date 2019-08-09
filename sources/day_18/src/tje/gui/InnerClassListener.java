package tje.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassListener extends JFrame {
	JButton btn = new JButton("Action");
	InnerClassListener() {
		setTitle("�׼� �̺�Ʈ ������ �ۼ�");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
		
		
		// �͸� Ŭ���� ��� ver2 ( ���� Ŭ������ ����ʵ带 ��� )
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn.getText().equals("Action")) 
					btn.setText("�׼�");
				else 
					btn.setText("Action");
					// AnonymousClassListener�� ����� 
					// JFrame�� ����� ȣ���� �� ����
					setTitle(btn.getText());
			}
		}
		);
		
		
		// �͸� Ŭ���� ��� ver1
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JButton b = (JButton)e.getSource();
//				if(b.getText().equals("Action")) 
//					b.setText("�׼�");
//				else 
//					b.setText("Action");
//					// AnonymousClassListener�� ����� 
//					// JFrame�� ����� ȣ���� �� ����
//					setTitle(b.getText());
//			}
//		}
//		);

		// btn.setSize(700, 700);
		add(btn);
	}
	
//	private class MyActionListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			// InnerClassListener�� ����� JFrame�� ����� ȣ���� �� �ִ�.
//			if(btn.getText().equals("Action"))
//				btn.setText("�׼�");
//			else
//				btn.setText("Action");
//			
//			// JFrame.setTitle() ȣ��
//			setTitle(btn.getText());
//		}
//	}
//	

	public static void main(String[] args) {
		new InnerClassListener();
	}
}
