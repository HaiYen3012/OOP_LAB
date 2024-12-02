package hust.soict.ITE6.aims.cart;
import java.util.*;

import hust.soict.ITE6.aims.media.Media;

public class CartLHY {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
        } else {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }
    
    public void addMedia(Media[] mediaList) {
        if (mediaList == null || mediaList.length == 0) {
            System.out.println("The media list is empty.");
            return;
        }
        for (Media media : mediaList) {
            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full! Cannot add more items.");
                break;
            }
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added.");
        }
    }
    
    public void addMedia(Media firstMedia, Media... otherMedia) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(firstMedia);
            System.out.println("Added: " + firstMedia.getTitle());
        } else {
            System.out.println("The cart is full! Cannot add more items.");
            return;
        }

        for (Media media : otherMedia) {
            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full! Cannot add more items.");
                break;
            }
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }
    
    public void addMedia(Media media1, Media media2) {
        addMedia(media1, media2);
    }
    
    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
        	System.out.println("The cart is empty! Nothing to remove.");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println("Removed: " + media.getTitle());
            } else {
                System.out.println("Media not found in the cart!");
            }
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }
    
    public void print() {
       	System.out.println("**************************CART***********************");
       	System.out.println("Ordered Items:");
       	int i =0;
        for (Media media : itemsOrdered) {
            i +=1;
            System.out.println(i + ". " + media);
        }
       	System.out.println("Total cost: " + totalCost());
       	System.out.println("*****************************************************");
    }
    
    public void searchByID(int id) {
       	boolean isFound = false;
       	for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found " + media);
       			isFound = true;
       		}
       	}
       	if (isFound == false) {
       		System.out.println("No DVDs were found with the given ID.");
       	}
    }
      
    public void searchByTitle(String keyword) {
       	boolean isMatchFound = false;
       	for (Media media : itemsOrdered) {
            if (media.isMatch(keyword)) {
                System.out.println("Found " + media);
       			isMatchFound = true;
       		}
       	}
       	if (isMatchFound == false) {
       		System.out.println("No DVDs found with the title containing \"" + keyword + "\".");
       	}
    }

}
