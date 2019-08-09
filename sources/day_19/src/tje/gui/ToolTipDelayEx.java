package tje.gui;

import javax.swing.*;
import java.awt.*;

public class ToolTipDelayEx extends JFrame {
	Container contentPane;
	
	ToolTipDelayEx() {
		setTitle("���� �����ð� ���� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel chickLabel = new JLabel(new ImageIcon("selChick.jpg"));
		chickLabel.setToolTipText("4�� �ڿ� ������� ����");
		
		JLabel pizzaLabel = new JLabel(new ImageIcon("pizza.jpg"));
		pizzaLabel.setToolTipText("4�ʵڿ� ������� ����");
		
		contentPane.add(chickLabel);
		contentPane.add(pizzaLabel);
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(600);
		m.setDismissDelay(4000);
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ToolTipDelayEx();
	}
}
