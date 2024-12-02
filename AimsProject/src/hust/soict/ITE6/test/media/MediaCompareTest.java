package hust.soict.ITE6.test.media;
import java.util.*;
import hust.soict.ITE6.aims.media.*;

public class MediaCompareTest {

    public static void main(String[] args) {
    	List<Media> mediae = new ArrayList<Media>();

        DigitalVideoDiscLHY dvd1 = new DigitalVideoDiscLHY("Inception", "Sci-Fi", 29.99f, "Christopher Nolan", 148);
        DigitalVideoDiscLHY dvd2 = new DigitalVideoDiscLHY("Avatar", "Adventure", 24.50f, "James Cameron", 162);
        DigitalVideoDiscLHY dvd3 = new DigitalVideoDiscLHY("Finding Nemo", "Animation", 15.75f, "Andrew Stanton", 100);

        Book book1 = new Book("Sherlock Holmes: A Study in Scarlet", "Mystery", 10.99f);
        Book book2 = new Book("Becoming", "Biography", 25.50f);
        Book book3 = new Book("The Theory of Everything", "Science", 18.00f);
        Book book4 = new Book("Dracula", "Horror", 8.99f);

        CompactDisc cd = new CompactDisc("Taylor Swift - 1989", "Pop", 200.00f, "Taylor Swift");
        Track track1 = new Track("Blank Space", 231);
        Track track2 = new Track("Style", 245);
        Track track3 = new Track("Shake It Off", 219);

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(dvd3);
        mediae.add(book1);
        mediae.add(book2);
        mediae.add(book3);
        mediae.add(book4);
        mediae.add(cd);

        System.out.println("\n******* SORT USING OVERRIDE compareTo() METHOD *******");
        Collections.sort(mediae);
        printMediaList(mediae);

        System.out.println("\n********** SORT BY TITLE USING COMPARATOR **********");
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        printMediaList(mediae);

        System.out.println("\n********** SORT BY COST USING COMPARATOR **********");
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        printMediaList(mediae);
    }

    private static void printMediaList(List<Media> mediaList) {
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
        System.out.println("***************************************************");
    }
}

