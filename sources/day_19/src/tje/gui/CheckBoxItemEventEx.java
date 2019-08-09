package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox[] foods = new JCheckBox[3];
	String[] names = {"����", "�ܹ���", "ġŲ"};
	JLabel sumLabel;
	int sum = 0;
	
	CheckBoxItemEventEx() {
		setTitle("üũ�ڽ��� �������̺�Ʈ ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("���� 14,000��, �ܹ��� ��Ʈ 7,000��, ����ġŲ 17,000��"));
		for(int i = 0 ; i < foods.length ; i++) {
			foods[i] = new JCheckBox(names[i]);
			foods[i].setBorderPainted(true);
			contentPane.add(foods[i]);
			foods[i].addItemListener(new MyItemListener());
		}
		sumLabel = new JLabel("���� 0 �� �Դϴ�.");
		contentPane.add(sumLabel);
		setSize(500, 500);
		setVisible(true);
	}
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int selected = 1;
			if(e.getStateChange() == ItemEvent.SELECTED)
				selected = 1;
			else
				selected = -1;
			
			if(e.getItem() == foods[0])
				sum = sum + selected*14000;
			else if(e.getItem() == foods[1])
				sum = sum + selected*7000;
			else if(e.getItem() == foods[2])
				sum = sum + selected*17000;
			
			sumLabel.setText("����" + sum + " �� �Դϴ�.");
		}
	}

	public static void main(String[] args) {
		new CheckBoxItemEventEx();

	}

}
