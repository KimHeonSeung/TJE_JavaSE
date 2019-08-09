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
	

	
	
	public CenterPanel() {
		this.setLayout(new BorderLayout());
		
		
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
