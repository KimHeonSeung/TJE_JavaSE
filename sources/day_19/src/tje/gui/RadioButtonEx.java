package tje.gui;

import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
	Container contentPane;
	RadioButtonEx() {
		setTitle("���� ��ư ����� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon chick = new ImageIcon("chick.jpg");
		ImageIcon selChick = new ImageIcon("selChick.jpg");
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton pizz = new JRadioButton("����");
		JRadioButton burg = new JRadioButton("�ܹ���");
		JRadioButton chic = new JRadioButton("ġŲ", chick);
		chic.setBorderPainted(true);
		chic.setSelectedIcon(selChick);
		
		g.add(pizz);
		g.add(burg);
		g.add(chic);
		
		contentPane.add(pizz);
		contentPane.add(burg);
		contentPane.add(chic);
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RadioButtonEx();
	}
}
