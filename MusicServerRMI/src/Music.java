import java.io.Serializable;


public class Music implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6157919716830502860L;

	private String title;
	private String author;
	private String album;
	
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
	
	@Override
	public String toString() {
		return "[" + title + ", " + author + ", " + album + "]";
	}
}
