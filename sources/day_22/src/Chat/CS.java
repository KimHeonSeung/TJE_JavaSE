package Chat;

import java.util.ArrayList;

import Chat.Client_UI.Client;
import Chat.Server_UI.ClientSocketStr;
import java.net.*;

public class CS {
	private static ArrayList<ClientSocketStr> ClientSockets = new ArrayList<ClientSocketStr>();
	
	public static int getClientSize() {
		return ClientSockets.size();
	}
	
	public static ClientSocketStr getClient(int index) {
		return ClientSockets.get(index);
	}
	
	public static void addClient(ClientSocketStr client) {
		ClientSockets.add(client);
	}
	
	public static void delClient(ClientSocketStr client) {
		ClientSockets.remove(client);
	}
	
	public static boolean checkClient(ClientSocketStr client) {
		return ClientSockets.contains(client);
	}
	
	public static void clearClient() {
		for(int i = 0 ; i < ClientSockets.size() ; i++) {
			ClientSockets.get(i).close();
		}
	}
	
	public static Socket getSocket(int index) {
		return ClientSockets.get(index).getSocket();
	}
}
