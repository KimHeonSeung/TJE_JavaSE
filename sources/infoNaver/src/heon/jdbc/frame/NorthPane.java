package heon.jdbc.frame;

import java.awt.*;

import javax.swing.*;

public class NorthPane extends JPanel {
	private JLabel naver = new JLabel("NAVER", SwingConstants.CENTER);
	private Font f = new Font("³×ÀÌ¹ö", Font.BOLD, 70);
	private Color naverGreen = new Color(0, 228, 97);
	
	public NorthPane() {
		this.setLayout(new BorderLayout());
		this.naver.setFont(f);
		this.naver.setForeground(naverGreen);
		this.add(naver, BorderLayout.CENTER);
	}
}
