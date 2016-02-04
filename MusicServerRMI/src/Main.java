import java.rmi.Naming;

public class Main{
	

	private static final String BIND_NAME = "MusicServiceRMI";

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
