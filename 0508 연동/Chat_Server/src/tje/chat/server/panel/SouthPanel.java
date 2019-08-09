package tje.chat.server.panel;

import java.awt.*;
import javax.swing.*;

public class SouthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("���� �޼���");
	private JTextField tfNoticeMsg = new JTextField();
	private JButton btnSend = new JButton("����");

	public SouthPanel() {
		this.setLayout(new BorderLayout());

		this.add(lbMsg, BorderLayout.WEST);
		this.add(tfNoticeMsg, BorderLayout.CENTER);
		this.add(btnSend, BorderLayout.EAST);

	}

	// �� Ŭ������ �ʵ����� �����ϱ� ���� ���͸� ����.
	public JTextField getTfNoticeMsg() {
		return tfNoticeMsg;
	}

	public JButton getBtnSend() {
		return btnSend;
	}
}
