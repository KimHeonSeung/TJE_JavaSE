package tje.chat.server.net;

import java.util.*;
import tje.chat.common.*;

// ������ Ŭ���̾�Ʈ���� �����ϴ� Ŭ����

public class ClientSaver {
	// ���ϵ��� �����Ѵ� �迭
	private static ArrayList<ClientSocket> socket_list = new ArrayList<ClientSocket>();
	// �� ip ��ȣ�� �������� Ű�� ������� ����
	private static HashMap<String, ClientSocket> map = new HashMap<String, ClientSocket>();
	// Ŭ���̾�Ʈ ���� ��ü�� ��̸���Ʈ��
	private static ArrayList<ClientInfo> info_list = new ArrayList<ClientInfo>();

	// Ŭ���̾�Ʈ ������ ���ս�Ʈ������ �г����� �����ѵڿ� ������ü�� �ҷ��������� ���� ����
	// �̰� �ҷ��ͼ� out.writeObj�� ����Ѵ�.
	public static ArrayList<ClientInfo> getInfo_list() {
		return info_list;
	}

	public static boolean exists(ClientSocket cs) {
		return map.containsKey(cs.getIp());
	}

	public static boolean exists(String targetIp) {
		return map.containsKey(targetIp);
	}
	
	public static ClientSocket getClient(String targetIp) {
		return map.get(targetIp);
	}
	
	// ��� �ϳ��� �θ��ϱ� ��ũ�γ����� �ʿ����
	// �޾ƿ� ClientSocket ��ü�� �� �迭�� �߰��ѵ� 
	// ClientInfo ��ü�� ����� Packet���� ����(BroadCast)�ϰ�
	// info_list�� �߰�
	public static void insert(ClientSocket cs) {
		socket_list.add(cs);
		map.put(cs.getIp(), cs);

		// Ŭ���̾�Ʈ���� ��ü�� ���� ���� ������ ����
		Date now = Calendar.getInstance().getTime();
		ClientInfo info = new ClientInfo(cs.getIp(), cs.getInUser(), now);
		
		// ��ü�� ��Ŷ���� ����� Ŭ���̾�Ʈ�鿡�� broadcast �Ѵ�.
		Packet packet = new Packet(Packet.TYPE_NEW_CLIENT, info);
		// �ڱ� �ڽ��� �����ʿ������ ������ �̷��� �ȴ�.
		info_list.add(info);
		
		BroadCaster.broadCast(packet);
		
	}

	
	// ��� ���ÿ� ������ �θ��� ��ũ�γ���� �ʿ�
	public static synchronized void delete(ClientSocket cs) {
		socket_list.remove(cs);
		map.remove(cs.getIp());
		
		// ���� �ε����� ����
		// �����ǿ� �г����� �´� �ε����� �����´�.
		int index = info_list.indexOf(new ClientInfo(cs.getIp(), cs.getInUser(), null));
		
		// ��ü�� ��Ŷ���� ����� Ŭ���̾�Ʈ�鿡�� broadcast �Ѵ�.
		Packet packet = new Packet(Packet.TYPE_DISCONECT_CLIENT, info_list.get(index));
		BroadCaster.broadCast(packet);
		
		// remove ��ü���� �Ʒ� ���İ� ���� ���� equals�� ã�Ƴ��� �����.
		info_list.remove(index);
	}

	public static int getClientSize() {
		return socket_list.size();
	}

	public static ClientSocket getClient(int index) {
		return socket_list.get(index);
	}

	public static ClientSocket getClient(ClientInfo ci) {
		return map.get(ci.getIp());
	}
}
