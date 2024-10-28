package LAB_02.AimsProject;

public class DigitalVideoDiscLHY {
    private String title;
    private String category;
    private int length;
    private String author;
    private float price;

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
        return this.author;
    }

    public float getPriceLHY() {
        return this.price;
    }

    public DigitalVideoDiscLHY(String title) {
        this.title = title;
    }

    public DigitalVideoDiscLHY(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public DigitalVideoDiscLHY(String author, String category, String title, float price) {
        this(title, category, price);
        this.author = author;
    }

    public DigitalVideoDiscLHY(String title, String category, String author, int length, float price) {
        this(author, category, title, price);
        this.length = length;
    }
}
