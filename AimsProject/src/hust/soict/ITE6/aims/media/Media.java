package hust.soict.ITE6.aims.media;

public abstract class Media {
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
    
    public boolean equals(Object obj) {
    	if (obj == this) {
    		return true;
    	}
    	if (!(obj instanceof Media)) {
    		return false;
    	}
    	Media other = (Media) obj;
        return this.getTitle().equals(other.getTitle());
    }

}
