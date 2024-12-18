package hust.soict.ITE6.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import hust.soict.ITE6.aims.store.Store;
import hust.soict.ITE6.aims.media.*;

public class StoreScreen extends JFrame{
	private static Store store = new Store();
	
	public static void initSetup() {
		DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Matrix", "Action", 15.50f, "Wachowskis", 136);     
        DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Inception", "Sci-Fi", 19.99f, "Christopher Nolan", 148); 
        DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("The Dark Knight", "Action", 17.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

    
        Book book = new Book("Sherlock Holmes: The Complete Novels", "Mystery", 25.00f);
        Book book1 = new Book("Becoming", "Biography", 30.00f);
        Book book2 = new Book("The Great Gatsby", "Classic", 15.00f);
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);


        CompactDisc cd1 = new CompactDisc("Back In Black", "Rock", 12.99f, "AC/DC");
        Track track1CD1 = new Track("Hells Bells", 6 * 50 + 12);
        Track track2CD1 = new Track("Shoot to Thrill", 6*50 + 30);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);

        CompactDisc cd2 = new CompactDisc("Lover", "Pop", 14.99f, "Taylor Swift");
        Track track1CD2 = new Track("I Forgot That You Existed", 8 * 30);
        Track track2CD2 = new Track("Death by a Thousand Cuts", 8 * 30 - 10);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);

        CompactDisc cd3 = new CompactDisc("Future Nostalgia", "Pop", 16.99f, "Dua Lipa");
        Track track1CD3 = new Track("Don't Start Now", 5 * 20 - 17);
        Track track2CD3 = new Track("Physical", 8 * 40 + 2);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
	}
	
	public StoreScreen(Store store) {
		StoreScreen.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		initSetup();
		new StoreScreen(store);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i<9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
}
