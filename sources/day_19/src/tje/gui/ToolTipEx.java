package tje.gui;

import javax.swing.*;
import java.awt.*;

public class ToolTipEx extends JFrame {
	Container contentPane;
	
	ToolTipEx() {
		setTitle("���� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400, 300);
		setVisible(true);
	}
	
	void createToolBar() {
		JToolBar bar = new JToolBar("My Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("������ �����մϴ�.");
		bar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon("chick.jpg"));
		openBtn.setToolTipText("������ ���ϴ�.");
		bar.add(openBtn);
		
		bar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon("selChick.jpg"));
		saveBtn.setToolTipText("������ �����մϴ�.");
		bar.add(saveBtn);
		
		bar.add(new JLabel("Search"));
		
		JTextField tf = new JTextField("Text Field");
		tf.setToolTipText("ã���� �ϴ� ���ڿ��� �Է��ϼ���");
		bar.add(tf);
		
		contentPane.add(bar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new ToolTipEx();
	}
}
