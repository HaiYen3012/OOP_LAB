package LAB_02.AimsProject;

public class AimsLHY {
    public static void main(String[] args) {
        // Create a new cart
        CartLHY anOrder = new CartLHY();
        
        // Create new DVD objects and add them to the cart
        DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDiscLHY(dvd1);
        
        DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDiscLHY(dvd2);
        
        DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("Aladin", 
            "Animation", 18.99f);
        anOrder.addDigitalVideoDiscLHY(dvd3);
        
        // Add dvd4
        DigitalVideoDiscLHY dvd4 = new DigitalVideoDiscLHY("The Incredibles", 
            "Animation", "Brad Bird", 115, 21.99f);
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
