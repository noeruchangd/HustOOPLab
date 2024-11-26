package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	
	public CompactDisc(int length, String director, String artist, List<Track> tracks) {
		super(length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track added!");
		}
		else System.out.println("Track already on disc!");
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed!");
		}
		else System.out.println("Track not on disc!");
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


	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}

}
