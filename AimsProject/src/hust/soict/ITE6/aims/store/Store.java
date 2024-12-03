package hust.soict.ITE6.aims.store;
import java.util.ArrayList;

import hust.soict.ITE6.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
	    if (!itemsInStore.contains(media)) {
	        itemsInStore.add(media);
	        System.out.println("Added: " + media.getTitle());
	    } else {
	        System.out.println(media.getTitle() + " is already in the store.");
	    }
	}
	
	public void removeMedia(Media media) {
	    if (itemsInStore.contains(media)) {
	        itemsInStore.remove(media);
	        System.out.println("Removed: " + media.getTitle());
	    } else {
	        System.out.println(media.getTitle() + " is not in the store.");
	    }
	}
	
	public void displayDVD() {
		if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty. No media available.");
        } else {
        	System.out.println("********************List of media in the store********************");
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i));
            }
            System.out.println("******************************************************************");
        }
	}
	
	public Media search(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				return media;
			}
		}
		return null;
	}
}