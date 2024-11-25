package hust.soict.ITE6.aims.disc;
public class DigitalVideoDiscLHY {
	private String title;
	private String category;
	private int length;
	private String director;
	private float cost;
	
	private static int nbDigitalVideoDiscs = 0;
    private int id;

    public String getTitleLHY() {
        return this.title;
    }

    public String getCategoryLHY() {
        return this.category;
    }

    public int getLengthLHY() {
        return this.length;
    }

    public String getDirectorLHY() {
        return this.director;
    }

    public float getPriceLHY() {
        return this.cost;
    }
    
    public void setterTitleLHY(String title) {
		this.title = title;
	}
    
    public int getId() {
		return id;
    }
    
    public boolean isMatch(String keyword) {
		return this.title.toLowerCase().contains(keyword.toLowerCase());
	}

    public DigitalVideoDiscLHY(String title) {
       	super();
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDiscLHY(String title, String category, float cost) {
       	super();
       	this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDiscLHY(String director, String category, String title, float cost) {
       	super();
       	this.title = title;
        this.category = category;
    	this.director = director;
    	this.cost = cost;
    	this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDiscLHY(String title, String category, String director, int length, float cost) {
       	super();
    	this.title = title;
    	this.category = category;
    	this.director = director;
    	this.length = length;
    	this.cost = cost;
    	this.id = ++nbDigitalVideoDiscs;
    }
    
    public String toString() {
		return this.id + ". DVD: " + this.title +
				" - Category: " + this.category +
				" - Director: " + this.title +
				" - DVD length: " + this.length +
				" - Cost: " + this.cost + "$";
	}

}
