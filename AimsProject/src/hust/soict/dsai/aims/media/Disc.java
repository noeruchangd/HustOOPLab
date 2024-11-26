package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	protected int length;
	protected String director;
	
	

	public Disc(int length, String director) {
		super();
		this.length = length;
		this.director = director;
	}



	public int getLength() {
		return length;
	}



	public String getDirector() {
		return director;
	}



	public Disc() {
		// TODO Auto-generated constructor stub
	}

}
