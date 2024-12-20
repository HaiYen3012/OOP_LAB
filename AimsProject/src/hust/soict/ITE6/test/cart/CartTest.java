package hust.soict.ITE6.test.cart;
import hust.soict.ITE6.aims.cart.CartLHY;
import javax.naming.LimitExceededException;
import hust.soict.ITE6.aims.media.DigitalVideoDiscLHY;

public class CartTest {
   public static void main(String[] args) throws LimitExceededException {
   
       CartLHY cart = new CartLHY();
      
       DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Lion King",
       		"Animation", 19.95f, "Roger Allers", 87);
       cart.addMedia(dvd1);
       DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Star War",
       		"Science Fiction", 24.95f, "George Lucas", 87);
       cart.addMedia(dvd2);
       DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("Aladin",
       		"Animation", 18.99f);
       cart.addMedia(dvd3);
       DigitalVideoDiscLHY dvd4 = new DigitalVideoDiscLHY("Aladin",
          		"Animation", 18.99f);
       cart.addMedia(dvd4);
       cart.print();
       cart.searchByID(1);
       cart.searchByTitle("Star");
       cart.searchByTitle("Baby");
   }
}