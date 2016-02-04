import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class MusicServiceImpl extends UnicastRemoteObject implements MusicService{

	private static final long serialVersionUID = -6739553602341402439L;
	private List<Music> musicList;
	
	
	public MusicServiceImpl() throws RemoteException {
		super();
		
		musicList = new ArrayList<Music>();
		musicList.add(new Music("Musica 1", "Autor 1", "Album 1"));
		musicList.add(new Music("Musica 2", "Autor 2", "Album 2"));
		musicList.add(new Music("Musica 3", "Autor 3", "Album 3"));
	}
	
	@Override
	public Music findByTitle(String title) throws RemoteException {
		for(Music music : musicList){
			if(music.getTitle().equals(title)){
				return music;
			}
		}
		return null;
	}

	@Override
	public boolean insertMusic(Music music) throws RemoteException {
		if(music!=null){
			musicList.add(music);
			return true;
		}
		return false;
	}

}
