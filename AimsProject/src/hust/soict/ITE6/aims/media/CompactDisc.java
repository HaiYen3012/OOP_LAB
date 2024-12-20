package hust.soict.ITE6.aims.media;
import java.util.*;

import java.util.ArrayList;
import hust.soict.ITE6.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
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
            System.out.println(track.getTitle() + " has been added!");
        }
    }
	
	public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println(track.getTitle() + " has been removed!");
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
	
	public String toString() {
		return this.getId() + " - CD: " + this.getTitle() + 
			   " - Category: " + this.getCategory() + 
			   " - Artist: " + this.getArtist() + 
			   " - Length: " + this.getLength() + " seconds" + 
			   " - Cost: " + this.getCost() + "$";
	}
	
	public String playGUI() throws PlayerException {
        if(this.getLength() > 0) {
            String output =  "Playing CD: " + this.getTitle() + "\n" + 
                            "CD length: " + formatDuration(this.getLength()) + "\n"+ "\n";
            for (Track track : tracks) {
                try {
                    output += track.playGUI() + "\n";
                } catch (PlayerException e) {
                    output += track.getTitle() + "\n" + e.getMessage();
                }
            }
            return output;
            } else {
                throw new PlayerException("ERROR: CD length is non-positive!");
            }
    }

}
