//package Chat;
//
//import java.io.*;
//import java.util.ArrayList;
//
//import javax.swing.JOptionPane;
//
//public class ListInput extends Thread {
//	private ArrayList<BufferedReader> cliSocketList = new ArrayList<BufferedReader>();
//	private String a;
//
//	public ListInput() {
//		for (int i = 0; i < CS.getClientSize(); i++) {
//			try {
//				cliSocketList.add(new BufferedReader(new InputStreamReader(CS.getSocket(i).getInputStream())));
//			} catch (IOException e) {
//				// noticeArea.append("IOException e �߻�. ListOutput ��ü�� ������ �κ�\\n");
//				JOptionPane.showMessageDialog(null, "IOException e �߻�. ListOutput ��ü�� ������ �κ�", "���", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//		}
//	}
//
//	public void run() {
//		for (int i = 0; i < cliSocketList.size(); i++) {
//			try {
//				cliSocketList.get(i).readLine();
//			} catch (IOException e) {
//				JOptionPane.showMessageDialog(null, "IOException e �߻�. ListInput ��ü�� run() �κ�", "���", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//		}
//	}
//	
//	public String getList(int i) {
//		try {
//			return cliSocketList.get(i).readLine();
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, "IOException e �߻�. ListInput ��ü�� getList �޼ҵ� �κ�", "���", JOptionPane.WARNING_MESSAGE);
//			return "����� �������µ� ������.";
//		}
//	}
//}