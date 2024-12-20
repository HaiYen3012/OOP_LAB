package hust.soict.ITE6.aims;
import hust.soict.ITE6.aims.cart.CartLHY;
import javax.naming.LimitExceededException;
import hust.soict.ITE6.aims.media.*;
import hust.soict.ITE6.aims.store.Store;

import java.util.*;

public class AimsLHY {
	private static Store store = new Store();
    private static CartLHY cart = new CartLHY();
    
    public static void initSetup() {
    	store.addMedia(new DigitalVideoDiscLHY("Frozen", "Fantasy", 21.95f, "Chris Buck", 102));
        store.addMedia(new DigitalVideoDiscLHY("Interstellar", "Science Fiction", 29.99f, "Christopher Nolan", 169));
        store.addMedia(new DigitalVideoDiscLHY("Mulan", "Adventure", 20.50f));
        
        store.addMedia(new Book("The Hound of the Baskervilles", "Mystery", 22.00f));
        store.addMedia(new Book("Educated: A Memoir", "Biography", 210.00f));
        store.addMedia(new Book("Astrophysics for People in a Hurry", "Science", 125.00f));

        CompactDisc cd1 = new CompactDisc("Adele - 25", "Music", 1400.75f, "Adele");
        cd1.addTrack(new Track("Hello", 295));
        cd1.addTrack(new Track("When We Were Young", 270));
        cd1.addTrack(new Track("Water Under the Bridge", 245));
        store.addMedia(cd1);

        CompactDisc cd2 = new CompactDisc("Infections of a Different Kind", "Music", 1800.50f, "Aurora");
        cd2.addTrack(new Track("Queendom", 233+28));
        cd2.addTrack(new Track("Forgotten Love", 187+30));
        cd2.addTrack(new Track("Churchyard", 26*5+12));
        store.addMedia(cd2);
        
        CompactDisc cd3 = new CompactDisc("Changes", "Music", 1200.50f, "Justin Bieber");
        cd3.addTrack(new Track("Intentions", 5*40+24));
        cd3.addTrack(new Track("Yummy", 4*60+22));
        store.addMedia(cd3);
        
        clearConsole();
    }
    
	public static void main(String[] args) {
		initSetup();
		boolean exit = false;
		
		while (!exit) {
			showMenu();		
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			scanner.nextLine();		
			
			switch (option) {
			    case 0 -> {
			    	exit = true;
                    System.out.println("Exiting AIMS. Goodbye!");
                }
				case 1 -> {
					clearConsole();
					storeMenu(scanner);
				}
				case 2 -> {
					clearConsole();
					updateStoreMenu(scanner);
				}
				case 3 -> {
					clearConsole();
                    cartMenu(scanner);
				}
                default -> {
                	clearConsole();
                	System.out.println("Invalid choice. Please try again.");
                }
			}
		}
	}
	
	public static void clearConsole() {
		for (int i=0; i<50; i++) {
			System.out.println();
		}
	}
    
    public static void showMenu() {
    	System.out.println("""
                AIMS:
                --------------------------------
                1. View store
                2. Update store
                3. See current cart
                0. Exit
                --------------------------------
                Please choose a number: 0-1-2-3
                """);
    }
    
    public static void storeMenu(Scanner scanner) {
    	boolean back = false;
    	while(back == false) {
    		store.displayDVD();
    		
    		System.out.println("""
                    Options:
                    --------------------------------
                    1. See a media's details
                    2. Add a media to cart
                    3. Play a media
                    4. See current cart
                    0. Back
                    --------------------------------
                    Please choose a number: 0-1-2-3-4
                    """);
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 0 -> {
                    clearConsole();
                    back = true;
                }
                case 1 -> {
                    boolean foundDetails = false;
                    while (foundDetails == false) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            clearConsole();
                            System.out.println("Details: ");
                            System.out.println(media);
                            mediaDetailsMenu(scanner, media);
                            foundDetails = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                }
                case 2 -> {
                    boolean foundToAdd = false;
                    while (foundToAdd == false) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                        	try {
                                cart.addMedia(media);
                            } catch (LimitExceededException e) {
                                e.printStackTrace();
                            }
                            foundToAdd = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                }
                case 3 -> {
                    boolean foundToPlay = false;
                    while (foundToPlay == false) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) {
                                media.play();
                            } else {
                                System.out.println("This type of media is not supported!");
                            }
                            foundToPlay = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                }
                case 4 -> {
                    clearConsole(); 
                    cartMenu(scanner);
                }    
                default -> {
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                }
             }
    	}
    }
    
    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        boolean back = false;
        while (back == false) {
        	System.out.println("""
                    Options:
                    --------------------------------
                    1. Add to cart
                    2. Play
                    0. Back
                    --------------------------------
                    Please choose a number: 0-1-2
                    """);
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 0 -> {
                    clearConsole(); 
                    back = true;
                }
                case 1 -> {
                	try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    if (media instanceof Disc || media instanceof CompactDisc) {
                        media.play();
                    } else {
                        System.out.println("This type of media is not supported!");
                    }
                }
                default -> {
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                }
            }
        }
    }
    
    public static void cartMenu(Scanner scanner) {
        boolean back = false;
        while (back == false) {
            cart.print();
            System.out.println("""
                    Options:
                    --------------------------------
                    1. Filter medias in cart
                    2. Sort medias in cart
                    3. Remove media from cart
                    4. Play a media
                    5. Place order
                    0. Back
                    --------------------------------
                    Please choose a number: 0-1-2-3-4-5
                    """);

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0 -> {
                    clearConsole(); 
                    back = true;
                }
                case 1 -> {
                    System.out.println("Filter medias in cart by (1) id or (2) title:");
                    int filterOption = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    while (found == false) {
                        if (filterOption == 1) {
                            System.out.println("Enter the id to filter (type 0 to stop):");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            if (id == 0) {
                                clearConsole();
                                break;
                            }
                            cart.searchByID(id);
                            found = true;
                        } else if (filterOption == 2) {
                            System.out.println("Enter the title to filter (type 0 to stop):");
                            String title = scanner.nextLine();
                            if (title.equals("0")) {
                                clearConsole();
                                break;
                            }
                            cart.searchByTitle(title);
                            found = true;
                        } else if (filterOption == 0) {
                            clearConsole();
                            break;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Sort medias in cart by (1) title or (2) cost:");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();
                    if (sortOption == 1) {
                        cart.sortMediaByTitle();
                    } else if (sortOption == 2) {
                        cart.sortMediaByCost();
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
                case 3 -> {
                    boolean foundToRemove = false;
                    while (foundToRemove==false) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = cart.searchToRemove(title);
                        if (media != null) {
                            clearConsole();
                            cart.removeMedia(media);
                            foundToRemove = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    } 
                }
                case 4 -> {
                    boolean foundToPlay = false;
                    while (foundToPlay == false) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) {
                                media.play();
                            } else {
                                System.out.println("This type of media is not supported!");
                            }
                            foundToPlay = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                }
                case 5 -> {
                    clearConsole();
                    cart.empty();
                }
                default -> {
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                }
            }
        }
    }
    
    public static void updateStoreMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
        	System.out.println("""
                    Options:
                    --------------------------------
                    1. Add a media
                    2. Remove a media
                    0. Back
                    --------------------------------
                    Please choose a number: 0-1-2
                    """);
        	
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0 -> {
                    clearConsole();
                    back = true;
                }
                case 1 -> {
                    System.out.println("Enter the category of the media (1) Book, (2) CD, (3) DVD or (0) exit:");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (categoryChoice == 1) {
                        System.out.println("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.println("Enter book category: ");
                        String bookCategory = scanner.nextLine();
                        System.out.println("Enter book cost: ");
                        Float bookCost = scanner.nextFloat();
                        scanner.nextLine();

                        Book newBook = new Book(bookTitle, bookCategory, bookCost);
                        store.addMedia(newBook);
                    } else if (categoryChoice == 2) {
                        System.out.println("Enter CD title: ");
                        String cdTitle = scanner.nextLine();
                        System.out.println("Enter CD category: ");
                        String cdCategory = scanner.nextLine();
                        System.out.println("Enter CD artist: ");
                        String cdArtist = scanner.nextLine();
                        System.out.println("Enter CD cost: ");
                        Float cdCost = scanner.nextFloat();
                        scanner.nextLine();

                        CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdCost, cdArtist);

                        
                        System.out.println("Do you want to add tracks to your CD? (1) Yes (0) No:");
                        int addTrack = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (addTrack == 1) {
                            System.out.println("How many tracks in your CD?");
                            int numTrack = scanner.nextInt();
                            scanner.nextLine();
                            for (int i = 0; i < numTrack; i++) {
                                System.out.println("Your " + (i+1) + " track: ");
                                System.out.println("Enter track title: ");
                                String trackTitle = scanner.nextLine();
                                System.out.println("Enter track length: ");
                                int trackLength = scanner.nextInt();
                                scanner.nextLine();

                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                            store.addMedia(newCD);
                        } else if (addTrack == 0) {
                            store.addMedia(newCD);
                        }
                    } else if (categoryChoice == 3) {
                        System.out.println("Enter DVD title: ");
                        String dvdTitle = scanner.nextLine();
                        System.out.println("Enter DVD category: ");
                        String dvdCategory = scanner.nextLine();
                        System.out.println("Enter book cost: ");
                        Float dvdCost = scanner.nextFloat();
                        scanner.nextLine();
                        
                        DigitalVideoDiscLHY newDVD = new DigitalVideoDiscLHY(dvdTitle, dvdCategory, dvdCost);
                        store.addMedia(newDVD);                
                    } else if (categoryChoice == 0) {
                        clearConsole();
                        break;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
                case 2 -> {
                    boolean foundToRemove = false;
                    while (!foundToRemove) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String titleForRemove = scanner.nextLine();
                        if (titleForRemove.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(titleForRemove);
                        if (media != null) {
                            System.out.println("Are you sure you want to remove this media? (yes/no): ");
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("yes")) {
                                clearConsole();
                                store.removeMedia(media);
                                System.out.println("***MEDIA REMOVED***");
                                foundToRemove = true;
                            } else {
                                System.out.println("***MEDIA NOT REMOVED***");
                            }
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                }
                default -> {
                    clearConsole();
                    System.out.println("Invalid option, please choose again.");
                }
            }
        }
    }
}