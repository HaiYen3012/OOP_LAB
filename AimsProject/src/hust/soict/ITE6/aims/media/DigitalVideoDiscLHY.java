package hust.soict.ITE6.aims.media;

import hust.soict.ITE6.aims.exception.PlayerException;

public class DigitalVideoDiscLHY extends Disc implements Playable {
    public DigitalVideoDiscLHY(String title) {
       	super(title);
    }

    public DigitalVideoDiscLHY(String title, String category, float cost) {
    	super(title, category, cost);
    }

    public DigitalVideoDiscLHY(String director, String category, String title, float cost) {
    	super(title, category, cost, director);
    }

    public DigitalVideoDiscLHY(String title, String category, float cost, String director, int length) {
    	super(title, category, cost, director, length);
    }
    
    public String toString() {
		return this.getId() + " - DVD: " + this.getTitle() +
				" - Category: " + this.getCategory() +
				" - Director: " + this.getDirector() +
				" - DVD length: " + this.getLength() +
				" - Cost: " + this.getCost() + "$";
	}
    
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
                return "Playing DVD: " + this.getTitle() + "\n" + 
                    "DVD length: " + formatDuration(this.getLength());
            } else {
                throw new PlayerException("ERROR: DVD length is non-positive!");
            }
    }

}
