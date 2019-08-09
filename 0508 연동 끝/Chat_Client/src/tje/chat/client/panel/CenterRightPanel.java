package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class CenterRightPanel extends JPanel {
	private JTextArea taChatMsg = new JTextArea();
	private JTextField tfSendMsg = new JTextField();
	private JButton btSend = new JButton("����");
	
	private Font f_25 = new Font("�÷���", Font.PLAIN, 25);
	private Font f_30 = new Font("�÷���", Font.PLAIN, 30);
	
	public CenterRightPanel() {
		this.setLayout(new BorderLayout());
		
		taChatMsg.setFont(f_25);
		JScrollPane sp = new JScrollPane(taChatMsg);
		this.add(sp, BorderLayout.CENTER);

		// �ϴ��� ���ۺκ��� ���� �г� ����
		JPanel panel = new JPanel(new BorderLayout());
		tfSendMsg.setFont(f_30);
		panel.add(tfSendMsg, BorderLayout.CENTER);
		btSend.setFont(f_25);
		panel.add(btSend, BorderLayout.EAST);

		this.add(panel, BorderLayout.SOUTH);
	}

	// �ܺο��� ���ٰ����ϵ��� ���͸� ����
	public JTextArea getTaChatMsg() {
		return taChatMsg;
	}

	public JTextField getTfSendMsg() {
		return tfSendMsg;
	}

	public JButton getBtSend() {
		return btSend;
	}
}
