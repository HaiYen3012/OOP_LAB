package hust.soict.ITE6.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import hust.soict.ITE6.aims.media.*;
import hust.soict.ITE6.aims.cart.CartLHY;
import hust.soict.ITE6.aims.screen.controller.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.naming.LimitExceededException;

public class CartScreen extends JFrame{
    private static final long serialVersionUID = 1L;
	private CartLHY cart;
    public CartScreen(CartLHY cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/ITE6/aims/screen/view/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }            
        });
    }
    
    public static void main(String[] args) {
        CartLHY cart = new CartLHY();

        DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Matrix", "Action", 15.50f, "Wachowskis", 136);    
        DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Inception", "Sci-Fi", 19.99f, "Christopher Nolan", 148);
        DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("The Dark Knight", "Action", 17.99f);
    
        Book book = new Book("Sherlock Holmes: The Complete Novels", "Mystery", 25.00f);
        Book book1 = new Book("Becoming", "Biography", 30.00f);
        Book book2 = new Book("The Great Gatsby", "Classic", 15.00f);

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

        try {
            cart.addMedia(dvd1);
            cart.addMedia(dvd2);
            cart.addMedia(dvd3);
            cart.addMedia(book);
            cart.addMedia(book1);
            cart.addMedia(book2);
            cart.addMedia(cd1);
            cart.addMedia(cd2);
            cart.addMedia(cd3);
        } catch (LimitExceededException e) {
            System.out.println(e.getMessage());
        }
        
        CartScreen cartScreen = new CartScreen(cart);
        System.out.println("Hi");
        cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}