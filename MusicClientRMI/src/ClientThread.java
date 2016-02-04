import java.rmi.Naming;


public class ClientThread extends Thread{
	private static final String SERVER_BIND_NAME = "MusicServiceRMI";
	
	private Integer clientId;
	private ClientBusinessProcedure clientBusinessProcedure;
	
	public ClientThread(Integer clientId, ClientBusinessProcedure clientBusinessProcedure) {
			this.clientId = clientId;
			this.clientBusinessProcedure = clientBusinessProcedure;
	}
	
	@Override
	public void run() {
		MusicService stub;
		try {
			stub = (MusicService) Naming.lookup(SERVER_BIND_NAME);
			clientBusinessProcedure.execute(clientId, stub);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
