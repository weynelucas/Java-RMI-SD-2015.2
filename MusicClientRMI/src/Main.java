

public class Main {
	
	public static void main(String[] args) {
		initClientThreads();
	}

	public static void initClientThreads() {
		
		new ClientThread(1, new ClientBusinessProcedure() {
			@Override
			public void execute(Integer clientId, MusicService musicService) {
				try {
					Music music = musicService.findByTitle("Someday");
					System.out.println("Resposta ao cliente " + clientId + ": " + music);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
/*		new ClientThread(2, new ClientBusinessProcedure() {
			@Override
			public void execute(Integer clientId, MusicService musicService) {
				try {
					Music music = new Music("Someday", "The Strokes", "Is This It");
					System.out.println("Resposta ao cliente " + clientId + ": " + musicService.insertMusic(music));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();*/
	}

}
