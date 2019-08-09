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
//				// noticeArea.append("IOException e 발생. ListOutput 객체의 생성자 부분\\n");
//				JOptionPane.showMessageDialog(null, "IOException e 발생. ListOutput 객체의 생성자 부분", "경고", JOptionPane.WARNING_MESSAGE);
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
//				JOptionPane.showMessageDialog(null, "IOException e 발생. ListInput 객체의 run() 부분", "경고", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
//		}
//	}
//	
//	public String getList(int i) {
//		try {
//			return cliSocketList.get(i).readLine();
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, "IOException e 발생. ListInput 객체의 getList 메소드 부분", "경고", JOptionPane.WARNING_MESSAGE);
//			return "목록을 가져오는데 실패함.";
//		}
//	}
//}