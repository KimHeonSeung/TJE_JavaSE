//package Chatting;
//
//import java.io.*;
//import java.util.*;
//
//public class NoticeReceiverThread extends Thread{
//	private String title;
//	private BufferedReader in;
//	public ArrayList<String> msgArray;
//	
//	public NoticeReceiverThread(String title, BufferedReader in) {
//		this.in = in;
//		this.title = title;
//	}
//	public void run() {
//		String msg;
//		while(true) {
//			try {
//				while( (msg = in.readLine()) != null ) {
//					msgArray.add(msg);
//				}
//
//			} catch (IOException e) {
//				break;
//			}
//		}
//		try {
//			this.in.close();
//		} catch (IOException e) {
//			System.out.println("입력 스트림 종료과정에서 예외가 발생했습니다.");
//		}
//	}
//	
//	public ArrayList getList() {
//		return msgArray;
//	}
//}
	

