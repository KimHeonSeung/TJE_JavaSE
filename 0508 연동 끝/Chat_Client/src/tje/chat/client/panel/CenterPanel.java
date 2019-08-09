package tje.chat.client.panel;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class CenterPanel extends JPanel {

	// {"��Ī", "IP", "���ӽð�"} ���̺� �����
	private Vector<String> strAllClientHeader = new Vector<String>();
	private DefaultTableModel dtmAllClientModel;
	private JTable tbAllClient;

	private JLabel lbNoticeMsg = new JLabel("�����޼���", SwingConstants.CENTER);
	private JTextArea taNoticeMsg = new JTextArea();

	// {"��Ī", "IP", "������ �޼���"} ���̺� �����
	private Vector<String> strChatClientHeader = new Vector<String>();
	private DefaultTableModel dtmChatClientModel;
	private JTable tbChatClient;

	private CenterRightPanel rp = new CenterRightPanel();

	// �� Ŭ������ ����

	public JTable getTbAllClient() {
		return this.tbAllClient;
	}
	
	public JTable getTbChatClient() {
		return this.tbChatClient;
	}
	
	public DefaultTableModel getDtmAllClientModel() {
		return dtmAllClientModel;
	}

	public JTextArea getTaNoticeMsg() {
		return taNoticeMsg;
	}

	public DefaultTableModel getDtmChatClientModel() {
		return dtmChatClientModel;
	}

	// CenterRightPanel rp �� ���͵� �� �гο��� ������ �� �ֵ��� �ٽ� ����
	public JTextArea getTaChatMsg() {
		return this.rp.getTaChatMsg();
	}

	public JTextField getTfSendMsg() {
		return this.rp.getTfSendMsg();
	}

	public JButton getBtSend() {
		return this.rp.getBtSend();
	}
	
	private Font f_20 = new Font("�÷���", Font.PLAIN, 20);
	private Font f_30 = new Font("�÷���", Font.PLAIN, 30);

	public CenterPanel() {
		this.setLayout(new GridLayout(1, 4, 3, 0));

		// ���̺� ����� ������ Vector Ÿ������ ����
		strAllClientHeader.add("��Ī");
		strAllClientHeader.add("IP");
		strAllClientHeader.add("���ӽð�");

		// ���̺��� ������ �Է� ���� ������ �� �ִ� �� ��ü ����
		dtmAllClientModel = new DefaultTableModel(strAllClientHeader, 0);
		
		// �� ��ü�� ����Ͽ� JTable ��ü�� ����
		tbAllClient = new JTable(dtmAllClientModel);
		tbAllClient.setRowHeight(50);
		tbAllClient.setFont(f_30);
		tbAllClient.getTableHeader().setFont(f_30);
		tbAllClient.getTableHeader().setSize(30, 30);
		// ���̺��� ������ ȭ���� ������ ����� ��츦 ó���ϱ� ���� ��ũ�� �� ��ü ����
		JScrollPane sp1 = new JScrollPane(this.tbAllClient);

		this.add(sp1);

		// �����޼��� �г��� ���� ����
		JPanel panel = new JPanel(new BorderLayout());
		lbNoticeMsg.setFont(f_30);
		panel.add(lbNoticeMsg, BorderLayout.NORTH);
		this.taNoticeMsg.setFont(f_30);
		JScrollPane sp2 = new JScrollPane(this.taNoticeMsg);
		panel.add(sp2, BorderLayout.CENTER);

		this.add(panel);

		// ���̺� ����� ������ Vector Ÿ������ ����
		strChatClientHeader.add("��Ī");
		strChatClientHeader.add("IP");
		strChatClientHeader.add("������ �޼���");
		// ���̺��� ������ �Է� ���� ������ �� �ִ� �� ��ü ����
		dtmChatClientModel = new DefaultTableModel(strChatClientHeader, 0);
		// �� ��ü�� ����Ͽ� JTable ��ü�� ����
		this.tbChatClient = new JTable(dtmChatClientModel);
		tbChatClient.setRowHeight(50);
		tbChatClient.setFont(f_30);
		tbChatClient.getTableHeader().setFont(f_30);
		tbChatClient.getTableHeader().setSize(30, 30);
		// ���̺��� ������ ȭ���� ������ ����� ��츦 ó���ϱ� ���� ��ũ�� �� ��ü ����
		JScrollPane sp3 = new JScrollPane(this.tbChatClient);

		this.add(sp3);

		this.add(rp);

	}
}
