package hust.soict.ITE6.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
		super(title, category, cost, director, length);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, float cost, String director) {
		super(title, category, cost, director);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category) {
		super(title, category);
	}

	public CompactDisc(String title) {
		super(title);
	}
	
	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track is already in the list!");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully.");
        }
    }
	
	public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track not found in the list!");
        }
    }
	
	public int getLength() {
	    int totalLength = 0;
	    for (int i = 0; i < tracks.size(); i++) {
	        totalLength += tracks.get(i).getLength();
	    }
	    return totalLength;
	}
	
	public void play() {
	    System.out.println("Playing CD: " + this.getTitle());
	    System.out.println("Artist: " + this.getArtist());
	    System.out.println("CD length: " + this.getLength());
	    for (Track track : tracks) {
	        track.play();
	    }
	}

}
