public class CartLHY {
    
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDiscLHY itemsOrdered[] = new DigitalVideoDiscLHY[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDiscLHY(DigitalVideoDiscLHY disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("DigitalVideoDisc has been added");
        } else {
            System.out.println("Your cart is full, cannot add a new item!");
        }
    }
    
    public void addDigitalVideoDiscLHY(DigitalVideoDiscLHY [] dvdList) {
       	if (dvdList.length > MAX_NUMBERS_ORDERED) {
       		System.out.println("Your cart is full, cannot add a new item!");
       	} else {
       		for (int i = 0; i < dvdList.length; i++) {
       			itemsOrdered[qtyOrdered] = dvdList[i];
       			System.out.println("DigitalVideoDisc: " + dvdList[i].getTitleLHY() + " has been added!");
       			qtyOrdered ++ ;
       		}
       	}
    }
      
    public void addDigitalVideoDiscLHY(DigitalVideoDiscLHY dvd1,DigitalVideoDiscLHY dvd2) {
           DigitalVideoDiscLHY [] dvdList = {dvd1, dvd2};
           addDigitalVideoDiscLHY(dvdList);
    }


    public void removeDigitalVideoDiscLHY(DigitalVideoDiscLHY disc) {
        boolean found = false; // To check if the disc was found
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitleLHY().equals(disc.getTitleLHY())) {
                found = true; // Set found to true
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1]; // Shift items left
                }
                itemsOrdered[qtyOrdered - 1] = null; // Clear the last item
                qtyOrdered--; // Decrement the quantity ordered
                System.out.println("DigitalVideoDisc has been removed");
                break; // Exit the loop after removing the item
            }
        }
        if (!found) {
            System.out.println("DigitalVideoDisc not found in the cart!");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getPriceLHY(); // Calculate total price
        }
        return total;
    }
    
    public void print() {
       	System.out.println("**************************CART***********************");
       	System.out.println("Ordered Items:");
       	for (int i = 0; i < qtyOrdered; i++) {
       		System.out.println(itemsOrdered[i]);
       	}
       	System.out.println("Total cost: " + totalCost());
       	System.out.println("*****************************************************");
    }
    
    public void searchByID(int id) {
       	boolean isFound = false;
       	for (int i = 0; i < qtyOrdered; i++) {
       		if (itemsOrdered[i].getId() == id) {
       			System.out.println("Found: " + itemsOrdered[i]);
       			isFound = true;
       		}
       	}
       	if (isFound == false) {
       		System.out.println("No DVDs were found with the given ID.");
       	}
    }
      
    public void searchByTitle(String keyword) {
       	boolean isMatchFound = false;
       	for (int i=0; i < qtyOrdered; i++) {
       		if (itemsOrdered[i].isMatch(keyword)) {
       			System.out.println("Found: " + itemsOrdered[i]);
       			isMatchFound = true;
       		}
       	}
       	if (isMatchFound == false) {
       		System.out.println("No DVDs found with the title containing \"" + keyword + "\".");
       	}
    }

}
