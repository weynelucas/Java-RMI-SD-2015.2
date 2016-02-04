import java.io.Serializable;


public class Music implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6157919716830502860L;

	private String title;
	private String author;
	private String album;
	
	//Forma de saber de qual servidor o cliente está recebendo o objeto
	//Servidor seta o atributo antes de responder ao cliente
	private String server;
	
	public Music(String title, String author, String album) {
		this.title = title;
		this.author = author;
		this.album = album;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getServer() {
		return server;
	}
	
	public void setServer(String server) {
		this.server = server;
	}
	
	@Override
	public String toString() {
		return "[" + server + ", " + title + ", " + author + ", " + album + "]";
	}
}
