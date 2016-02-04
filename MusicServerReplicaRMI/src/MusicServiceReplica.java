import java.rmi.Remote;
import java.rmi.RemoteException;


public interface MusicServiceReplica extends Remote{
	Music findByTitle(String title) throws RemoteException;
	boolean insertMusic(Music music) throws RemoteException;
}
