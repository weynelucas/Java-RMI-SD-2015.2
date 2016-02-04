import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;




public class MusicServiceReplicaImpl implements MusicServiceReplica{
	private static final String SERVER_TAG = "Servidor secundário";
	
	private List<Music> musicListReplica;
	
	public MusicServiceReplicaImpl() throws RemoteException {
		super();
		musicListReplica = new ArrayList<>();
	}

	@Override
	public Music findByTitle(String title) throws RemoteException {
		for(Music music : musicListReplica){
			if(music.getTitle().equals(title)){
				return music;
			}
		}
		return null;
	}

	@Override
	public boolean insertMusic(Music music) throws RemoteException {
		if(music != null){
			music.setServer(SERVER_TAG);
			musicListReplica.add(music);
			return true;
		}
		return false;
	}

	
}
