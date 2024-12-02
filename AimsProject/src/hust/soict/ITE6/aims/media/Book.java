package hust.soict.ITE6.aims.media;

import java.util.*;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();

	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Author added successfully.");
		} else {
			System.out.println("This author is already in the list!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author removed successfully.");
		} else {
			System.out.println("No author with this name found in the list!");
		}
	}
	
	public String toString() {
		return "Book: " + this.getTitle() + 
			   " - Category: " + this.getCategory() + 
			   " - Cost: " + this.getCost() + "$";
	}

}
