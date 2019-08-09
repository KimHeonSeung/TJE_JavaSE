//package Chat;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.swing.JOptionPane;
//
//public class ListOutput extends Thread {
//	private ArrayList<PrintWriter> cliSocketListW = new ArrayList<PrintWriter>();
//	private String a;
//
//	public ListOutput() {
//		for (int i = 0; i < CS.getClientSize(); i++) {
//			try {
//				cliSocketListW.add(new PrintWriter(
//						new BufferedWriter(new OutputStreamWriter(CS.getSocket(i).getOutputStream())), true));
//			} catch (IOException e) {
//				// noticeArea.append("IOException e 발생. ListOutput 객체의 생성자 부분\\n");
//				JOptionPane.showMessageDialog(null, "IOException e 발생. ListOutput 객체의 생성자 부분", "경고", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//		}
//	}
//
//	public void run() {
//		for (int i = 0; i < cliSocketListW.size(); i++) {
//			cliSocketListW.get(i).println(CS.getClient(i).getID());
//		}
//	}
//}