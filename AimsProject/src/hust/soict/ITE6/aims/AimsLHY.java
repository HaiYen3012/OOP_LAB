package hust.soict.ITE6.aims;
import hust.soict.ITE6.aims.cart.CartLHY;
import hust.soict.ITE6.aims.media.DigitalVideoDiscLHY;

public class AimsLHY {
    public static void main(String[] args) {
        // Create a new cart
        CartLHY anOrder = new CartLHY();
        
        // Create new DVD objects and add them to the cart
        DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Lion King", 
            "Animation", 19.95f, "Roger Allers", 87);
        anOrder.addDigitalVideoDiscLHY(dvd1);
        
        DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Star Wars", 
            "Science Fiction", 24.95f, "George Lucas", 87);
        anOrder.addDigitalVideoDiscLHY(dvd2);
        
        DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("Aladin", 
            "Animation", 18.99f);
        anOrder.addDigitalVideoDiscLHY(dvd3);
        
        // Add dvd4
        DigitalVideoDiscLHY dvd4 = new DigitalVideoDiscLHY("The Incredibles", 
            "Animation", 21.99f, "Brad Bird", 115);
        anOrder.addDigitalVideoDiscLHY(dvd4);

        // Print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        
        anOrder.removeDigitalVideoDiscLHY(dvd3);

        // Print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
