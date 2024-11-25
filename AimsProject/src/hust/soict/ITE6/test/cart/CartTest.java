package hust.soict.ITE6.test.cart;
import hust.soict.ITE6.aims.cart.CartLHY;
import hust.soict.ITE6.aims.disc.DigitalVideoDiscLHY;

public class CartTest {
   public static void main(String[] args) {
   
       CartLHY cart = new CartLHY();
      
       DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Lion King",
       		"Animation", "Roger Allers", 87, 19.95f);
       cart.addDigitalVideoDiscLHY(dvd1);
       DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Star War",
       		"Science Fiction", "George Lucas", 87, 24.95f);
       cart.addDigitalVideoDiscLHY(dvd2);
       DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("Aladin",
       		"Animation", 18.99f);
       cart.addDigitalVideoDiscLHY(dvd3);
       cart.print();
       cart.searchByID(1);
       cart.searchByTitle("Star");
       cart.searchByTitle("Baby");
   }
}