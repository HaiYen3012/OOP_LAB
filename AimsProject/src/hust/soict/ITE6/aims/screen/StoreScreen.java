package hust.soict.ITE6.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import hust.soict.ITE6.aims.store.Store;
import hust.soict.ITE6.aims.cart.CartLHY;
import hust.soict.ITE6.aims.media.*;

public class StoreScreen extends JFrame {
    private static final long serialVersionUID = 1L;
	private Store store;
    private CartLHY cart;
    private JPanel centerPanel; // Declare centerPanel as a class field

    // Constructor
    public StoreScreen(Store store, CartLHY cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        
        // Initialize centerPanel when creating the store screen
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    // Method to create the NORTH component
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Method to create the Menu Bar
    JMenuBar createMenuBar() {
    	JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        
        // Add Book menu item
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(this, store);
        });
        smUpdateStore.add(addBookItem);

        // Add CD menu item
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(this, store);
        });
        smUpdateStore.add(addCDItem);

        // Add DVD menu item
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(this, store);
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        
        // Add View Cart menu item with action
        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> {
            new CartScreen(this.cart); // Open CartScreen with the current cart
            dispose();
        });
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Method to create the Header
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.addActionListener(e -> {
            new CartScreen(this.cart); // Open CartScreen with the current cart
        });
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    
    public void refreshStoreScreen() {
        // Remove existing center panel
        Container cp = getContentPane();
        cp.remove(centerPanel);

        // Recreate center panel with updated store items
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

        // Revalidate and repaint the frame
        revalidate();
        repaint();
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 4, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        // Example: Initialize Store and StoreScreen
    	Store store1 = new Store();
    	CartLHY cart = new CartLHY(); // Create a cart
    	DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Matrix", "Action", 15.50f, "Wachowskis", 136);     
        DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Inception", "Sci-Fi", 19.99f, "Christopher Nolan", 148); 
        DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("The Dark Knight", "Action", 17.99f);
        store1.addMedia(dvd1);
        store1.addMedia(dvd2);
        store1.addMedia(dvd3);

    
        Book book = new Book("Sherlock Holmes: The Complete Novels", "Mystery", 25.00f);
        Book book1 = new Book("Becoming", "Biography", 30.00f);
        Book book2 = new Book("The Great Gatsby", "Classic", 15.00f);
        store1.addMedia(book);
        store1.addMedia(book1);
        store1.addMedia(book2);


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

        store1.addMedia(cd1);
        store1.addMedia(cd2);
        store1.addMedia(cd3);

        new StoreScreen(store1, cart);      
        
    }
}
