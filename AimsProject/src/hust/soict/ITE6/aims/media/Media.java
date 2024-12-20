package hust.soict.ITE6.aims.media;

import java.util.Comparator;
import java.time.Duration;

import hust.soict.ITE6.aims.exception.PlayerException;

public abstract class Media implements Comparable<Media> {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
    private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public Media(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
	
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }
    
    public boolean isMatch(String keyword) {
		return this.getTitle().toLowerCase().contains(keyword.toLowerCase());
	}
    
    public void play() {
        System.out.println("Playing media");
    }
    
    public String playGUI() throws PlayerException {
        return "Playing media";
    }
    
    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj == this) {
    		return true;
    	}
    	if (obj == null || !(obj instanceof Media)) {
            return false;
        }
    	Media otherMedia = (Media) obj;
        return this.getTitle() != null && this.getTitle().equals(otherMedia.getTitle());

    }
    
    public String toString() {
    	return "Media: " + this.getTitle() + 
    		   " - Category: " + this.getCategory() + 
    		   " - Cost: " + this.getCost() + "$";
    }
    
    public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
        	return Float.compare(other.getCost(), this.getCost());
        }
    }

}
