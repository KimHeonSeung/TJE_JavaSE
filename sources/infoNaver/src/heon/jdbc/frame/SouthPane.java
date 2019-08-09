package heon.jdbc.frame;

import java.awt.*;

import javax.swing.*;

public class SouthPane extends JPanel {
	private JButton btnReg = new JButton("가입하기");
	
	private Font f = new Font("네이버", Font.BOLD, 30);
	private Color naverGreen = new Color(0, 228, 97);
	
	private JLabel space1 = new JLabel("                                ");
	private JLabel space2 = new JLabel("                                ");
	private JLabel space3 = new JLabel(" ");
	
	public SouthPane() {
		this.setLayout(new BorderLayout());
		
		this.btnReg.setBackground(naverGreen);
		this.btnReg.setForeground(Color.WHITE);
		this.btnReg.setFont(f);
		
		this.add(btnReg, BorderLayout.CENTER);
		this.add(space1, BorderLayout.WEST);
		this.add(space2, BorderLayout.EAST);
		this.add(space3, BorderLayout.SOUTH);
	}

	
	
	
	public JButton getBtnReg() {
		return btnReg;
	}

	public void setBtnReg(JButton btnReg) {
		this.btnReg = btnReg;
	}
	
}
