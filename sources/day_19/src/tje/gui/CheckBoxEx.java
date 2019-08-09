package tje.gui;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx extends JFrame {
	Container contentPane;
	CheckBoxEx() {
		setTitle("üũ�ڽ� ����� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon chick = new ImageIcon("chick.jpg");
		ImageIcon selChick = new ImageIcon("selChick.jpg");
		
		JCheckBox pizz = new JCheckBox("����");
		JCheckBox burg = new JCheckBox("�ܹ���");
		JCheckBox dak = new JCheckBox("ġŲ", chick);
		dak.setBorderPainted(true);
		dak.setSelectedIcon(selChick);
		
		contentPane.add(pizz);
		contentPane.add(burg);
		contentPane.add(dak);
		
		setSize(800, 800);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new CheckBoxEx();

	}

}
