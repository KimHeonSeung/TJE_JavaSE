package tje.inner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Inner_01_Ex_01 extends JFrame {
	
	private JTextField tfN1;
	private JTextField tfN2;
	private JLabel lbResult;
	private JButton btnPlus;

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Inner_01_Ex_01(String title) {
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

		// �͸� Ŭ������ Ȱ���� ������ �̺�Ʈ ó�� ���
		// �̺�Ʈ ó���� ������ �ڵ尡 ���Ե��� �ʴ� ���
		// �Ʒ��� ���� �����ϰ� �̺�Ʈ�� ó���� �� �ִ� ��ü��
		// �����Ͽ� Ȱ���� �� �ֽ��ϴ�.
		// (�͸� Ŭ������ �ܺ��� Ŭ���� ��� ����� ���Ѿ���
		// ������ �� �ֽ��ϴ�.)
		// (private ������� ������ ����)
		this.btnPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // Ŭ���� ���� Ŭ������ �ٱ��� Ŭ������ �ʵ带 �ٷ� ������ ��� �����ϴ�.
				String strN1;
				String strN2;
				int nN1 = Integer.parseInt(tfN1.getText());
				int nN2 = Integer.parseInt(tfN2.getText());
				lbResult.setText(nN1 + nN2 + "");
			}
		});

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
		Inner_01_Ex_01 ex = new Inner_01_Ex_01("�������̽� ����");

	}

}
