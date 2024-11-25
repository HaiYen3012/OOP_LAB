public class DigitalVideoDiscLHY {
	private String title;
	private String category;
	private int length;
	private String director;
	private float cost;

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

    public DigitalVideoDiscLHY(String title) {
        this.title = title;
    }

    public DigitalVideoDiscLHY(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDiscLHY(String director, String category, String title, float cost) {
    	this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
    }

    public DigitalVideoDiscLHY(String title, String category, String director, int length, float cost) {
    	this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
    }
}
