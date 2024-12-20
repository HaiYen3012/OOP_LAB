package hust.soict.ITE6.aims.cart;
import java.util.*;

import hust.soict.ITE6.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;

public class CartLHY {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
    public ObservableList<Media> getItemsOrdered(){
    	return itemsOrdered;
    }
    
    public String addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		} else if (itemsOrdered.contains(media)){
			return media.getTitle() + " is already in the cart!";
		} else {
			itemsOrdered.add(media);
			return (media.getTitle() + "has been added!" );
		}
	}
    
//    public void addMedia(Media[] mediaList) {
//        if (mediaList == null || mediaList.length == 0) {
//            System.out.println("The media list is empty.");
//            return;
//        }
//        for (Media media : mediaList) {
//            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
//                System.out.println("The cart is full! Cannot add more items.");
//                break;
//            }
//            itemsOrdered.add(media);
//            System.out.println("The media " + media.getTitle() + " has been added.");
//        }
//    }
//    
//    public void addMedia(Media firstMedia, Media... otherMedia) {
//        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
//            itemsOrdered.add(firstMedia);
//            System.out.println("Added: " + firstMedia.getTitle());
//        } else {
//            System.out.println("The cart is full! Cannot add more items.");
//            return;
//        }
//
//        for (Media media : otherMedia) {
//            if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
//                System.out.println("The cart is full! Cannot add more items.");
//                break;
//            }
//            itemsOrdered.add(media);
//            System.out.println("Added: " + media.getTitle());
//        }
//    }
//    
//    public void addMedia(Media media1, Media media2) {
//    	if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
//    		itemsOrdered.add(media1);
//			System.out.println("The media " + media1.getTitle() + " has been added.");
//		}
//		else System.out.println("The cart is almost full.");
//		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
//			itemsOrdered.add(media2);
//		}
//		else System.out.println("The cart is almost full.");
//    }
    
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
    
    public Media searchToRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
    
    public int qtyOrdered = 0;

    public void empty() {
        if (itemsOrdered.size() == 0) {
            System.out.println("The cart is currently empty, nothing to remove!");
        } else {
            qtyOrdered = 0;
            itemsOrdered.clear();
            System.out.println("Order has been created.");
            System.out.println("Your current cart is now empty!");
            System.out.println();
        }
    }

    public void sortMediaByTitle() {
        FXCollections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Media list after sorting by title and cost:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void sortMediaByCost() {
        FXCollections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Media list after sorting by cost and title:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }
    
    public String placeOrder() {
    	if(itemsOrdered.isEmpty()) {
    		return "Oops! It looks like your cart is empty.";
    	} else {
    		qtyOrdered = 0;
    		itemsOrdered.clear();
    		return "Success! Your order has been placed.\\nYour cart is now empty.";
    	}
    }
    
}
