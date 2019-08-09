package server;

public class BroadCaster {
	
	public static void broadCast(String msg) {
		
		for( int i = 0 ; i < ClientSaver.getClientSize() ; i++ )
			ClientSaver.getClient(i).send(msg);
	}
	
	public static synchronized void broadCast(String host, String msg) {
		for( int i = 0 ; i < ClientSaver.getClientSize() ; i++ ) {
			
			Client client = ClientSaver.getClient(i);
			
			if( !client.getHost().equals(host) )
				client.send(msg);
			
		}
		
		System.out.printf("%s : %s\n", host, msg);
		
	}

}
