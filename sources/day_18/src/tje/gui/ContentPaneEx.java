package tje.gui;

import javax.swing.*;
import java.awt.*;


// JFrame : �̺�Ʈ �����带 ����
// �̺�Ʈ�� ��ٸ��� â ����.
public class ContentPaneEx extends JFrame {
	
	ContentPaneEx() {
		setTitle("ContentPane�� JFrame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.PINK);
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("Ȯ��"));
		contentPane.add(new JButton("���"));
		contentPane.add(new JButton("����"));
		
		setSize(1000,800);
		setVisible(true);
		
		
		
	}
	

	public static void main(String[] args) {
		new ContentPaneEx();

	}

}
