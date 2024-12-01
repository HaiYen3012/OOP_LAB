package hust.soict.ITE6.aims.media;

public class DigitalVideoDiscLHY extends Media {
	private int length;
	private String director;

    public int getLengthLHY() {
        return this.length;
    }

    public String getDirectorLHY() {
        return this.director;
    }

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
    	super(title, category, cost);
    	this.director = director;
    }

    public DigitalVideoDiscLHY(String title, String category, String director, int length, float cost) {
    	super(title, category, cost);
    	this.director = director;
    	this.length = length;
    }
    
    public String toString() {
		return this.getId() + ". DVD: " + this.getTitle() +
				" - Category: " + this.getCategory() +
				" - Director: " + this.director +
				" - DVD length: " + this.length +
				" - Cost: " + this.getCost() + "$";
	}

}
