package Chatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileListener implements ActionListener {

	private JFileChooser chooser;

	// ���� ���� ��ư�� ������ ���� ������ ����
	FileListener() {
		chooser = new JFileChooser();
	}

	public void actionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
		chooser.setFileFilter(filter);

		int ret = chooser.showOpenDialog(null);

		if (ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// �������� ���õ� ������ in�� �о����
		File selFile = chooser.getSelectedFile(); // .getPath();

		try {
			BufferedReader in = new BufferedReader(new FileReader(selFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// �о�� in�� input�� �����Ͽ� ArrayList�� selectedFile�� ���� ���� ����
		// day_17 Server_05 ����
		String input;

	}
}
