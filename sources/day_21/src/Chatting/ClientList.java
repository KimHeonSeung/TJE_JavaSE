package Chatting;

import java.util.*;

// �÷��� Ŭ������ ��ü�� ����Ͽ� 
// ���� ������ ���� ���� Ŭ���̾�Ʈ���� �����ϴ� Ŭ����
public class ClientList {
	private static ArrayList<ClientSocket> CLIENTS = new ArrayList<ClientSocket>();
	
	public static int getClientSize() {
		return CLIENTS.size();
	}
	
	public static ClientSocket getClient(int index) {
		return CLIENTS.get(index);
	}
	
	public static void addClient(ClientSocket client) {
		CLIENTS.add(client);
		
	}
	
	
	public static void delClient(ClientSocket client) {
		CLIENTS.remove(client);
		
	}
	
	public static boolean checkClient(ClientSocket client) {
		return CLIENTS.contains(client);
	}
}










