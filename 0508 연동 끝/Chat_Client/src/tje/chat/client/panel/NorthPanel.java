package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;

public class NorthPanel extends JPanel {
	private JLabel lbServerInfo = new JLabel("��������", SwingConstants.CENTER);
	private JLabel lbIP = new JLabel("IP", SwingConstants.CENTER);
	private JTextField tfIP = new JTextField();
	private JLabel lbPORT = new JLabel("PORT", SwingConstants.CENTER);
	private JTextField tfPORT = new JTextField();
	private JLabel lbID = new JLabel("ID", SwingConstants.CENTER);
	private JTextField tfID = new JTextField();
	private JLabel lbPassword = new JLabel("PW", SwingConstants.CENTER);
	private TextField tfPassword = new TextField();
	private JCheckBox cbSaveInfo = new JCheckBox("��������", false);
	private JButton btSignIn = new JButton("ȸ������");
	private JButton btConnect = new JButton("�α���");

	private Font f_30 = new Font("�÷���", Font.PLAIN, 30);
	
	public NorthPanel() {
		this.setLayout(new GridLayout(1, 12));

		fontSet(f_30);
		
		this.add(lbServerInfo);
		this.add(lbIP);
		this.add(tfIP);
		this.add(lbPORT);
		this.add(tfPORT);
		this.add(lbID);
		this.add(tfID);
		this.add(lbPassword);
		tfPassword.setEchoChar('*');
		this.add(tfPassword);
		this.add(cbSaveInfo);
		this.add(btSignIn);
		this.add(btConnect);

	}
	
	public void fontSet (Font f) {
		lbServerInfo.setFont(f);
		lbIP.setFont(f);
		tfIP.setFont(f);
		lbPORT.setFont(f);
		tfPORT.setFont(f);
		lbID.setFont(f);
		tfID.setFont(f);
		lbPassword.setFont(f);
		tfPassword.setFont(f);
		cbSaveInfo.setFont(f);
		btSignIn.setFont(f);
		btConnect.setFont(f);
	}

	// �ܺο��� ������ ���� ���� ����
	public JTextField getTfIP() {
		return tfIP;
	}

	public JTextField getTfPORT() {
		return tfPORT;
	}

	public JTextField getTfID() {
		return tfID;
	}

	public JCheckBox getCbSaveInfo() {
		return cbSaveInfo;
	}

	public JButton getBtConnect() {
		return btConnect;
	}

	public TextField getTfPassword() {
		return tfPassword;
	}

	public JButton getBtSignIn() {
		return btSignIn;
	}
	
	
}
