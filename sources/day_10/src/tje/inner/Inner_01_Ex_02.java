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

public class Inner_01_Ex_02 extends JFrame {
	
	private JTextField tfGuGuDan;

	private JButton btnGuGudan;
	private JLabel lbResult;
	

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public Inner_01_Ex_02(String title) {
		// ������ �������� �����ư ����� ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������ �������� ������ ����
		this.setTitle(title);

		// ���̾ƿ��� ����
		this.setLayout(new FlowLayout());

		this.tfGuGuDan = new JTextField(5);

		this.btnGuGudan = new JButton("������ ���");
		
		this.lbResult = new JLabel();


		// �͸� Ŭ������ Ȱ���� ������ �̺�Ʈ ó�� ���
		// �̺�Ʈ ó���� ������ �ڵ尡 ���Ե��� �ʴ� ���
		// �Ʒ��� ���� �����ϰ� �̺�Ʈ�� ó���� �� �ִ� ��ü��
		// �����Ͽ� Ȱ���� �� �ֽ��ϴ�.
		// (�͸� Ŭ������ �ܺ��� Ŭ���� ��� ����� ���Ѿ���
		// ������ �� �ֽ��ϴ�.)
		// (private ������� ������ ����)
		this.btnGuGudan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // Ŭ���� ���� Ŭ������ �ٱ��� Ŭ������ �ʵ带 �ٷ� ������ ��� �����ϴ�.
				String output = "<html>";
				int dan = Integer.parseInt(tfGuGuDan.getText());
				for ( int i = 1 ; i <= 9 ; i++ )
					output += "<br>" + dan + " * " + i + " = " + (dan * i);
				
				output += "</html>";
			
				lbResult.setText(output);
				
//				int dan = Integer.parseInt(tfGuGuDan.getText());
//				for ( int i = 1 ; i <= 9 ; i++ ) {
//					lbResult.setText(dan + " * " + i + " = " + (dan*i));
//					System.out.println("");}
//			}
		}});

		this.add(tfGuGuDan);

		this.add(btnGuGudan);
		
		this.add(lbResult);

		// ������ �������� ũ�⸦ ����
		this.setSize(1000, 300);
		// ������ �������� ȭ�鿡 ���
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Inner_01_Ex_02 ex = new Inner_01_Ex_02("�������̽� ����");

	}

}
