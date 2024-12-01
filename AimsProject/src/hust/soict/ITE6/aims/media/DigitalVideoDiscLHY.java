package hust.soict.ITE6.aims.media;

public class DigitalVideoDiscLHY extends Disc implements Playable {
    public boolean isMatch(String keyword) {
		return this.getTitle().toLowerCase().contains(keyword.toLowerCase());
	}

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
		return this.getId() + ". DVD: " + this.getTitle() +
				" - Category: " + this.getCategory() +
				" - Director: " + this.getDirector() +
				" - DVD length: " + this.getLength() +
				" - Cost: " + this.getCost() + "$";
	}
    
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

}
