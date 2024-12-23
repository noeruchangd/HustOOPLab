package hust.soict.dsai.aims.media;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
		}
		else throw new PlayerException("CD Length is non positive");
		}
	public String toString() {
		String response = ("CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getLength() + " : " + this.getCost() + " $");
		return response;
	}
	
	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track added!");
		}
		else System.out.println("Track already on disc!");
	}

	public void removeTrack(Track track) throws FileNotFoundException {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed!");
		}
		else throw new FileNotFoundException("Track not on disc!");
	}
	
	public int getLength() {
		int sum = 0;
		for (int i = 0; i < tracks.size(); i++) {
			sum += tracks.get(i).getLength();
		}
		return sum;
	}
	public String getArtist() {
		return artist;
	}


    // Constructor 
    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

}
