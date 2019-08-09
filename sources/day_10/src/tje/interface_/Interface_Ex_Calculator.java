package tje.interface_;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Interface_Ex_Calculator extends JFrame implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		String strN1 = this.tfN1.getText();
		String strN2 = this.tfN2.getText();
		int nN1 = Integer.parseInt(strN1);
		int nN2 = Integer.parseInt(strN2);
		this.lbResult.setText(nN1 + nN2 + "");
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	private JTextField tfN1;
	private JTextField tfN2;
	private JLabel lbResult;
	private JButton btnPlus;

	public Interface_Ex_Calculator(String title) {
		// ������ �������� �����ư ����� ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������ �������� ������ ����
		this.setTitle(title);

		// ���̾ƿ��� ����
		this.setLayout(new FlowLayout());

		this.tfN1 = new JTextField(10);
		this.tfN2 = new JTextField(10);
		this.lbResult = new JLabel();

		this.btnPlus = new JButton("���ϱ�");
		this.lbResult.setEnabled(false);
		this.btnPlus.addMouseListener(this);

		this.add(tfN1);
		this.add(tfN2);
		this.add(lbResult);
		this.add(btnPlus);

		// ������ �������� ũ�⸦ ����
		this.setSize(1000, 300);
		// ������ �������� ȭ�鿡 ���
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Interface_Ex_Calculator ex = new Interface_Ex_Calculator("�������̽� ����");

	}

}
