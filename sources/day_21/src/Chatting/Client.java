//package Chatting;
//
//import javax.swing.*;
//import java.io.*;
//import java.net.*;
//import java.util.ArrayList;
//
//public class Client extends Thread {
//	private String ip, nick, host;
//	private int port;
//	private Socket socket;
//	private BufferedReader socket_in;
//	private PrintWriter socket_out;
//	public NoticeReceiverThread nrt;
//
//	Client(String ip, int port, String nick) {
//		this.ip = ip;
//		this.port = port;
//		this.nick = nick;
//		this.host = this.socket.getInetAddress().getHostAddress();
//
//		try {
//			socket = new Socket(ip, port);
//		} catch (UnknownHostException e) {
//			JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
//			return;
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, "서버와 연결에 실패했습니다.", "경고", JOptionPane.WARNING_MESSAGE);
//			return;
//		}
//
//		try {
//			socket_out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
//
//			socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		nrt = new NoticeReceiverThread("서버", socket_in);
//		
//
//	}
//	
//	class NoticeReceiverThread extends Thread{
//		private String title;
//		private BufferedReader in;
//		public ArrayList<String> msgArray;
//		
//		public NoticeReceiverThread(String title, BufferedReader in) {
//			this.in = in;
//			this.title = title;
//		}
//		public void run() {
//			String msg;
//			while(true) {
//				try {
//					while( (msg = in.readLine()) != null ) {
//						msgArray.add(msg);
//					}
//
//				} catch (IOException e) {
//					break;
//				}
//			}
//			try {
//				this.in.close();
//			} catch (IOException e) {
//				System.out.println("입력 스트림 종료과정에서 예외가 발생했습니다.");
//			}
//		}
//		
//		public ArrayList getList() {
//			return msgArray;
//		}
//	}
//	
//}
