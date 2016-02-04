import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Main {
	private static final String SERVER_BIND_NAME = "MusicServiceReplicaRMI";
	private static final int BACKUP_SERVER_PORT = 2000;
	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(BACKUP_SERVER_PORT);

			MusicServiceReplicaImpl obj = new MusicServiceReplicaImpl();
            MusicServiceReplica stub = (MusicServiceReplica) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry(BACKUP_SERVER_PORT);
            registry.bind(SERVER_BIND_NAME, stub);
			
            System.out.println("Servidor secundário (backup) inicializado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
