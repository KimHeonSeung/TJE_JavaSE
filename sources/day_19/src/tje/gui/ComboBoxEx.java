package tje.gui;

import java.awt.*;
import javax.swing.*;

public class ComboBoxEx extends JFrame {
	Container contentPane;
	String[] fruits = {"���", "�ٳ���", "Ű��", "����", "��", "������", "����", "������"};
	String[] names = {"����", "����", "�ٿ�", "�ƿ�"};
	
	ComboBoxEx() {
		setTitle("�޺��ڽ� ����� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JComboBox strCombo = new JComboBox(fruits);
		contentPane.add(strCombo);
		
		JComboBox nameCombo = new JComboBox();
		for(int i = 0 ; i < names.length ; i++)
			nameCombo.addItem(names[i]);
		contentPane.add(nameCombo);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBoxEx();
	}
}
