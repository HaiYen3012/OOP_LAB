package hust.soict.ITE6.test.store;
import hust.soict.ITE6.aims.media.DigitalVideoDiscLHY;
import hust.soict.ITE6.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Lion King",
				"Animation", 19.95f, "Roger Allers", 87);
		store.addDVD(dvd1);
		
		DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Star Wars",
				"Science Fiction", 24.95f, "George Lucas", 87);
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