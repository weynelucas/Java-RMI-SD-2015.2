import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClientThread extends Thread{
	private static final String SERVER_BIND_NAME = "MusicServiceRMI";
	private static final int SERVER_PORT = 4000; 
	
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
			Registry registry = LocateRegistry.getRegistry(SERVER_PORT);
			stub = (MusicService) registry.lookup(SERVER_BIND_NAME);
			clientBusinessProcedure.execute(clientId, stub);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
