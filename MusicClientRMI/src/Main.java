

public class Main {
	
	public static void main(String[] args) {
		try {
			new ClientThread("Cliente 1", "Musica 1").start();
			new ClientThread("Cliente 2", "Musica 2").start();
			new ClientThread("Cliente 3", "Musica 3").start();
			
			/*MusicService stub = (MusicService) Naming.lookup(BIND_NAME);
			Music music = stub.findByTitle("Musica 1");
			System.out.println("[" + music.getTitle() + ", " + music.getAuthor() + ", " + music.getAlbum() + "]");*/
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
