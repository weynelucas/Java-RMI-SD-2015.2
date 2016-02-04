import java.rmi.Naming;


public class ClientThread extends Thread{
	private static final String SERVER_BIND_NAME = "MusicServiceRMI";
	
	private String client;
	private String query;
	
	public ClientThread(String client, String query) {
			this.client = client;
			this.query = query;
	}
	
	@Override
	public void run() {
		MusicService stub;
		try {
			stub = (MusicService) Naming.lookup(SERVER_BIND_NAME);
			Music music = stub.findByTitle(query);
			
			System.out.println(client + " recebeu: " + music);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
}
