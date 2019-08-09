package tje.chat.common;

import java.io.Serializable;

// �����»��, �޴� ����� ������ ��ŶŬ������ �����ؾ� ���ϴ�
public class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// �򰥸� ������ ��� ����
	public static final int TYPE_NOTICE = 1;
	public static final int TYPE_NEW_CLIENT = 2;
	public static final int TYPE_DISCONECT_CLIENT = 3;
	public static final int TYPE_CLIENT_MSG = 4;
	public static final int TYPE_SIGN_INFO = 5;
	
	// ������ Ÿ��
	// 1. �����޽��� 
	// 2. ������ ���Ӱ� ������ Ŭ���̾�Ʈ�� ����
	// 3. ������ ������ ����� Ŭ���̾�Ʈ�� ����
	// 4. Ŭ���̾�Ʈ ���� �޼���
	// 5. ȸ������ ����
	private int packetType;
	private Object packetData;
	private String targetIp;
	private String sourceIp;
	private String sourceID;
	
	public Packet(int packetType, Object packetData) {
		this.packetType = packetType;
		this.packetData = packetData;
	}
	
	// ip�������� �������ִ� ������ �����ε�
	public Packet(int packetType, Object packetData, String targetIp, String sourceIp, String sourceID) {
		this(packetType, packetData);
		this.targetIp = targetIp;
		this.sourceIp = sourceIp;
		this.sourceID = sourceID;
	}
	
	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getSourceID() {
		return sourceID;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}

	public String getTargetIp() {
		return targetIp;
	}

	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}

	public int getPacketType() {
		return packetType;
	}

	public void setPacketType(int packetType) {
		this.packetType = packetType;
	}

	public Object getPacketData() {
		return packetData;
	}

	public void setPacketData(Object packetData) {
		this.packetData = packetData;
	}
	
	

}
