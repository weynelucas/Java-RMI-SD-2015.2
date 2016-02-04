import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Main{
	

	private static final String BIND_NAME = "MusicServiceRMI";
	private static final int PORT = 4553;

	public static void main(String[] args) {
		
		try {
			
			MusicServiceImpl stub = new MusicServiceImpl();
			Naming.rebind(BIND_NAME, stub);
			System.out.println("Serviço inicializado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
