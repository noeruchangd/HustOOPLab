package hust.soict.dsai.aims.media;

public class Track implements Playable {
	
	private String title;
	private int length;
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	public boolean equals(Track o) {
		if (this.getLength() == o.getLength() && this.getTitle() == o.getTitle()) {
			return true;
		}
		else return false;
	}
	

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

}
