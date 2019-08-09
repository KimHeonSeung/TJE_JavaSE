package tje.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboActionEx extends JFrame {
	Container contentPane;
	String[] fruits = {"���", "�ٳ���", "Ű��", "����"};
	ImageIcon[] images = {
			new ImageIcon("pizza.jpg"),
			new ImageIcon("burg.jpg"),
			new ImageIcon("chick.jpg"),
			new ImageIcon("selChick.jpg"),
	};
	JLabel imgLabel = new JLabel(images[0]);
	
	ComboActionEx() {
		setTitle("�޺��׼� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox strCombo = new JComboBox(fruits);
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
		contentPane.add(strCombo);
		contentPane.add(imgLabel);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboActionEx();
	}
}
