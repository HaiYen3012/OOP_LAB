package hust.soict.ITE6.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof Track)) {
			return false;
		}
		Track other = (Track) obj;
	    return this.getTitle().equals(other.getTitle()) && this.getLength() == other.getLength();
 	}

}
