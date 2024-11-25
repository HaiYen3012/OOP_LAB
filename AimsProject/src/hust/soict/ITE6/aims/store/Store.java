package hust.soict.ITE6.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.ITE6.aims.disc.DigitalVideoDiscLHY;

public class Store {
	private List<DigitalVideoDiscLHY> itemsInStore = new ArrayList<DigitalVideoDiscLHY>();
	
	public void addDVD(DigitalVideoDiscLHY dvd)
	{
		int index = itemsInStore.indexOf(dvd);
		if (index != -1) {
            System.out.println(dvd.getTitleLHY() + " is already available in the store.");
        } else {
            itemsInStore.add(dvd);
            System.out.println(dvd.getTitleLHY() + " has been successfully added to the store.");
        }
	}
	
	public void removeDVD(DigitalVideoDiscLHY dvd)
	{
		boolean removed = itemsInStore.remove(dvd);
		if(removed)
		{
			System.out.println(dvd.getTitleLHY() + " has been successfully removed from the store.");
		} else {
			System.out.println(dvd.getTitleLHY() + " was not found in the store.");
		}
	}
	
	public void displayDVD() {
		if (itemsInStore.isEmpty()) {
            System.out.println("No DVDs available in the store.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i));
            }
        }
	}
}