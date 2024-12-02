package hust.soict.ITE6.test.media;
import java.util.*;
import hust.soict.ITE6.aims.media.*;

public class MediaTest {

	public static void main(String[] args) {
		List<Media> mediaList = new ArrayList<Media>();
		
		DigitalVideoDiscLHY dvd = new DigitalVideoDiscLHY("Interstellar", "Science Fiction", 25.50f, "Christopher Nolan", 169);
        Book book = new Book("Sherlock Holmes: The Hound of the Baskervilles", "Mystery", 15.75f);
        CompactDisc cd = new CompactDisc("Taylor Swift - Evermore", "Pop", 1200.45f, "Taylor Swift");
        
        Track track1 = new Track("Willow", 215);
        Track track2 = new Track("Champagne Problems", 243);
        Track track3 = new Track("Evermore (feat. Bon Iver)", 301);
        
        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);
        
        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);
        
        for (Media media : mediaList) {
        	System.out.println(media.toString());
        }
	}
}