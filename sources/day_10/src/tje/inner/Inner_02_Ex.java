package tje.inner;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

// ����ڿ��� ������ �ϳ��� �Է¹��� �� �ִ� UI ȭ���� �����ϼ���.
// JButton�� Ȱ���Ͽ� Ŭ�� �̺�Ʈ�� �߻��ϴ� ���
// JTextField Ÿ�Կ� �Էµ� ������ �̿��Ͽ� �������� ȭ�鿡 ����ϼ���.(JLabel Ȱ��)

// ������ ����� ���� �̺�Ʈ ó�� Ŭ������ ����
//class GuGudanBtnHandlerOut extends MouseAdapter {
//	public void mouseClicked(MouseEvent e) {
//		// �̺�Ʈ ó���� ���� Ŭ������ ��ü��
//		// �̺�Ʈ�� �߻��� �������� �� UI ��ҿ� 
//		// ������ �� �־�� �Ѵ�.
//		// �̷��� Ŭ������ ��øŬ������ �ƴ� 
//		// �Ϲ� Ŭ������ �����ϴ� ���
//		// ������ Ŭ������ �� ��ҿ� ������ �Ұ����ϴ�.
//		int dan = Integer.parseInt(tfGuGuDan.getText());
//		for ( int i = 1 ; i <= 9 ; i++ )
//			output += "<br>" + dan + " * " + i + " = " + (dan * i);
//		
//		output += "</html>";
//	
//		lbResult.setText(output);
//	}
//}

public class Inner_02_Ex extends JFrame {

	private JTextField tfGuGuDan;
	private JButton btnGuGudan;
	private JLabel lbResult;

	class GuGudanBtnHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			// ��ø�� Ŭ������ Ȱ���Ͽ� �̺�Ʈ ó���� ó���ϴ� ����
			// ������ Ŭ������ ���� Ŭ������ ���ǵǾ��� ������
			// ��� UI ������ҿ� �����Ӱ� ������ �� �ִ�.
			String output = "<html>";
			int dan = Integer.parseInt(tfGuGuDan.getText());
			for (int i = 1; i <= 9; i++)
				output += "<br>" + dan + " * " + i + " = " + (dan * i);

			output += "</html>";

			lbResult.setText(output);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Inner_02_Ex(String title) {
		// ������ �������� �����ư ����� ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������ �������� ������ ����
		this.setTitle(title);

		// ���̾ƿ��� ����
		this.setLayout(new FlowLayout());

		this.tfGuGuDan = new JTextField(5);
		this.btnGuGudan = new JButton("������ ���");
		this.lbResult = new JLabel();
		// ��ø�� ���� Ŭ������ ��ü�� ����Ͽ� �̺�Ʈ�� ó���ϴ� ����
		this.btnGuGudan.addMouseListener(new GuGudanBtnHandler());

		this.add(tfGuGuDan);
		this.add(btnGuGudan);
		this.add(lbResult);

		// ������ �������� ũ�⸦ ����
		this.setSize(1000, 300);
		// ������ �������� ȭ�鿡 ���
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Inner_02_Ex ex = new Inner_02_Ex("�������̽� ����");
	}

}
