package tje.chat.server.panel;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.*;


public class CenterPanel extends JPanel {

	private JTextArea taLog = new JTextArea();
	// üũ�� �� ������ üũ�ڽ� ����
	private JCheckBox cbLog = new JCheckBox("�α׸޼��� ���", true);

	// ta�� �������� ����.
	
	private Font f_40 = new Font("�÷���", Font.PLAIN, 40);
	private Font f_25 = new Font("�÷���", Font.PLAIN, 25);
	public CenterPanel() {
		this.setLayout(new BorderLayout());
		this.taLog.setFont(f_40);
		this.cbLog.setFont(f_25);
		this.taLog.setEditable(false);
		JScrollPane sp = new JScrollPane(taLog);
		this.add(sp, BorderLayout.CENTER);
		this.add(cbLog, BorderLayout.SOUTH);

	}

	// �ܺο��� �����ϱ� ���� ���͸� ����
	public JTextArea getTaLog() {
		return taLog;
	}

	public JCheckBox getCbLog() {
		return cbLog;
	}
	
}
