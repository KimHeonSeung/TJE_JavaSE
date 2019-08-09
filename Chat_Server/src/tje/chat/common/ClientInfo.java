package tje.chat.common;

import java.io.Serializable;
import java.util.Date;

public class ClientInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String ip;
	private String nickName;
	private Date connectedTime;

	public ClientInfo(String ip, String nickName, Date connectedTime) {
		super();
		this.ip = ip;
		this.nickName = nickName;
		this.connectedTime = connectedTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getConnectedTime() {
		return connectedTime;
	}

	public void setConnectedTime(Date connectedTime) {
		this.connectedTime = connectedTime;
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof ClientInfo) )
			return false;
					
		ClientInfo target = (ClientInfo)obj;
		boolean flag1 = this.ip.equals(target.ip);
		boolean flag2 = this.nickName.equals(target.nickName);
					
		return flag1 && flag2;
	}
}












