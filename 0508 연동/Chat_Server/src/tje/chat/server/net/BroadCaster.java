package tje.chat.server.net;

import tje.chat.common.Packet;

// Ư�� Ŭ���Ʈ�� �޼����� ��� Ŭ���̾�Ʈ����
// �����ϴ� Ŭ����
// �Ǵ� ������ ���� �޼����� ��� Ŭ���̾�Ʈ����
// ������ ���� ����
public class BroadCaster {

	// ������ �������� ���޿� �޼ҵ�
	// Ŭ���̾�ƮSaver�� ��� Ŭ���̾�Ʈ �� ��ŭ �޾ƿ� packet�� send�Ѵ�.
	public static void broadCast(Packet packet) {
		for (int i = 0; i < ClientSaver.getClientSize(); i++)
			ClientSaver.getClient(i).send(packet);
	}
	
	// Ŭ���̾�Ʈ�鳢�� �ְ�޴� ��ȭ ���޿� �޼ҵ� �����ε�
	public static void broadCast(Packet packet, String targetIp) {
		if( ClientSaver.exists(targetIp) ) {
			ClientSaver.getClient(targetIp).send(packet);
		}
	}
}

