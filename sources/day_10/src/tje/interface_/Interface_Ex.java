package tje.interface_;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

class MouseHandler implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

}

// ������ ���α׷��� �����ϱ� ���� JFrame Ŭ������ ���
// JFrame Ŭ������ ��ӹ޴� Ŭ������ ������ �����ӿ� ���õ�
// ��ɵ��� Ȱ���� �� �ִ�.
// (����, ũ��, ...)
public class Interface_Ex extends JFrame implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	private JButton btn;

	public Interface_Ex(String title) {
		// ������ �������� �����ư ����� ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������ �������� ������ ����
		this.setTitle(title);

		// ���̾ƿ��� ����
		this.setLayout(new FlowLayout());

		// ��ư ��ü�� ����
		this.btn = new JButton("Ŭ���ϼ���~!");
		this.btn.setSize(100, 100);
		// ��ư ��ü�� ������ �����̳ʿ� ���
		this.add(btn);

		// ��ư ��ü�� ���� ���콺 �̺�Ʈ�� ó���� �� �ִ�
		// ��ü�� ���
		// this.btn.addMouseListener(new MouseHandler());
		this.btn.addMouseListener(this); // this : ���� �� �޼ҵ带 �����ϰ� �ִ� ��ü

		// ������ �������� ũ�⸦ ����
		this.setSize(300, 300);
		// ������ �������� ȭ�鿡 ���
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Interface_Ex ex = new Interface_Ex("�������̽� ����");

	}

}