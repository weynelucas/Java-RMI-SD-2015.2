import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main{
	

	private static final String BIND_NAME = "MusicServiceRMI";
	private static final int PRIMARY_SERVER_PORT = 4000;

	public static void main(String[] args) {
		
		try {
			LocateRegistry.createRegistry(PRIMARY_SERVER_PORT);
			
			MusicServiceImpl obj = new MusicServiceImpl();
			MusicService stub = (MusicService) UnicastRemoteObject.exportObject(obj,0);
			
			Registry registry = LocateRegistry.getRegistry(PRIMARY_SERVER_PORT);
			registry.bind(BIND_NAME, stub);
			
			System.out.println("Servidor primário inicializado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
