package hust.soict.ITE6.test.store;
import hust.soict.ITE6.aims.media.DigitalVideoDiscLHY;
import hust.soict.ITE6.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		
		DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("Aladin", 
				"Animation", 18.99f);
		store.addDVD(dvd3);
		
		store.displayDVD();
		
		store.addDVD(dvd2);
		store.removeDVD(dvd2);
		
		store.displayDVD();
		
		store.addDVD(dvd2);
		
		store.displayDVD();
	}
}