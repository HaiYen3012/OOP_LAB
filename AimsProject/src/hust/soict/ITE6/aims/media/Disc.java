package hust.soict.ITE6.aims.media;

public class Disc extends Media {
	private String director;
	private int length;

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public Disc(String title) {
	    super(title);
    }
	
	public Disc(String title, String category) {
		super(title, category);
	}
	
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    }
    
    public Disc(String title, String category, float cost, String director, int length) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            } else {
                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
                if (lengthComparison != 0) {
                    return lengthComparison;
                } else {
                    return Float.compare(this.getCost(), otherDVD.getCost());
                }
            }
        } else {
            return super.compareTo(other);
        }
    }

}
