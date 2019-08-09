package tje.chat.server.panel;

import java.awt.*;
import javax.swing.*;

// ��ܿ� ��ġ�� �г��� ����.
public class NorthPanel extends JPanel {
	private JLabel lbMsg = new JLabel("��Ʈ��ȣ");
	private JTextField tfPortNumber = new JTextField();
	private JButton btnStartAndStop = new JButton("����");

	private JCheckBox cbSavePortNum = new JCheckBox("��Ʈ��ȣ ����");

	private Font f_30 = new Font("�÷���", Font.PLAIN, 30);
	
	public NorthPanel() {
		this.setLayout(new BorderLayout());
		
		this.lbMsg.setFont(f_30);
		this.btnStartAndStop.setFont(f_30);
		this.tfPortNumber.setFont(f_30);
		this.cbSavePortNum.setFont(f_30);
		
		this.add(lbMsg, BorderLayout.WEST);

		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.add(tfPortNumber, 0);
		panel.add(btnStartAndStop, 1);
		panel.add(cbSavePortNum, 2);

		this.add(panel, BorderLayout.CENTER);
	}

	// �� Ŭ������ �ʵ����� �����ϱ� ���� ���͸� ����.
	public JTextField getTfPortNumber() {
		return tfPortNumber;
	}

	public JButton getBtnStartAndStop() {
		return btnStartAndStop;
	}

	public JCheckBox getCbSavePortNum() {
		return cbSavePortNum;
	}

	public void setCbSavePortNum(JCheckBox cbSavePortNum) {
		this.cbSavePortNum = cbSavePortNum;
	}
}
