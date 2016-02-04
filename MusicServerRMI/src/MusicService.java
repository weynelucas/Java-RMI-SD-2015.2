import java.rmi.Remote;
import java.rmi.RemoteException;


public interface MusicService extends Remote{
	Music findByTitle(String name) throws RemoteException;
	boolean insertMusic(Music music) throws RemoteException;
}
