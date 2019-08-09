package tje.chat.model;

import java.text.SimpleDateFormat;
import java.util.*;

// ������ ����ڿ��� �޼����� ������ ���.
// �� �� ip�� ���� ����� ip, �г��ӵ� ���� ����� nickname�̴�.
public class ChatMessage {
	private String myID;
	private String ip;
	private String ID;
	private ArrayList<String> history;
	
	public ChatMessage(String myID, String ip, String ID) {
		super();
		this.myID = myID;
		this.ip = ip;
		this.ID = ID;
		this.history = new ArrayList<String>();
		this.addHistory(String.format("%s �԰� ä���� �����մϴ�.\n", this.ID));
	}
	
	public String addHistory(String msg) {
//		Date now = Calendar.getInstance().getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss  : ");
//		String output = String.format("(%s) %s%s\n", myNickName, sdf.format(now), msg);
//		this.history.add(output);
//		return output;
		
		// ���� ��¥�� ��� ��µǰ� �Ʒ��� ��¥�� ��µ��� �ʰ� ����
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss  -> ");
		String output = String.format("(%s) %s%s\n", myID, sdf.format(now), msg);
		this.history.add(output);
		return output;
	}
	
	public ArrayList<String> getHistory() {
		return this.history;
	}
	

}
