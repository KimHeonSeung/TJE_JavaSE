package tje.chat.server.panel;

import java.awt.*;
import javax.swing.*;

public class SouthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("���� �޼���");
	private JTextField tfNoticeMsg = new JTextField();
	private JButton btnSend = new JButton("����");
	private Font f_30 = new Font("���¸�", Font.PLAIN, 30);

	public SouthPanel() {
		this.setLayout(new BorderLayout());
		this.lbMsg.setFont(f_30);
		this.tfNoticeMsg.setFont(f_30);
		this.btnSend.setFont(f_30);

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
