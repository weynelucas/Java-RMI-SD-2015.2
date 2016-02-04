
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;


public class MusicServiceImpl implements MusicService{
	private static final String SERVER_BIND_NAME = "MusicServiceReplicaRMI";
	private static final int BACKUP_SERVER_PORT = 2000;
	private static final String SERVER_TAG = "Servidor primário";
	
	private List<Music> musicList;
	
	//Variável para fazer o swich de requisição (remota ou local)
	private boolean isRemote;
	
	private MusicServiceReplica stub;
	
	
	
	public MusicServiceImpl() throws RemoteException {
		super();
		isRemote = false;
		try {
            Registry registry = LocateRegistry.getRegistry(BACKUP_SERVER_PORT);
            stub = (MusicServiceReplica) registry.lookup(SERVER_BIND_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		musicList = new ArrayList<Music>();
		insertMusic((new Music("Musica 1", "Autor 1", "Album 1")));
		insertMusic((new Music("Musica 2", "Autor 2", "Album 2")));
		insertMusic(new Music("Musica 3", "Autor 3", "Album 3"));
	}
	
	@Override
	public Music findByTitle(String title) throws RemoteException {
		Music music = null;
		
		if(isRemote){
			music = stub.findByTitle(title);
		} else {	
			music = localFindByTitle(title);
		}
		//Balanceamento de carga
		isRemote = !isRemote;
		
		return music;
	}

	@Override
	public boolean insertMusic(Music music) throws RemoteException {
		try {
			if(music!=null){
				//Inserindo música na lista remota (réplica)
				stub.insertMusic(music);
				
				//Inserindo música na lista local
				music.setServer(SERVER_TAG);
				musicList.add(music);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public Music localFindByTitle(String title){
		for(Music music : musicList){
			if(music.getTitle().equals(title)){
				return music;
			}
		}
		return null;
	}

}
