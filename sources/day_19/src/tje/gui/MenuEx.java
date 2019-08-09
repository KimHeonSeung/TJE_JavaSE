package tje.gui;

import javax.swing.*;
import java.awt.*;

public class MenuEx extends JFrame {
	MenuEx() {
		setTitle("Menu ����� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createMenu();
		setSize(250,200);
		setVisible(true);
	}
	
	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		fileMenu.add(new JMenuItem("���� �����"));
		fileMenu.add(new JMenuItem("����"));
		fileMenu.addSeparator();
		fileMenu.add(new JMenuItem("�����ϱ�"));
		fileMenu.add(new JMenuItem("�ٸ� �̸����� �����ϱ�"));
		
		mb.add(fileMenu);
		
		mb.add(new JMenu("����"));
		mb.add(new JMenu("�ҽ�"));
		mb.add(new JMenu("������Ʈ"));
		mb.add(new JMenu("����"));
		
		this.setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new MenuEx();
	}

}
