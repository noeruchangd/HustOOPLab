package hust.soict.dsai.aims.media;

import java.util.*;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		int titleComp = m1.getTitle().compareTo(m2.getTitle());

		if (m1.getCost() > m2.getCost()) return 1;
		else if (m1.getCost() < m2.getCost()) return -1;
		
		else {
			if (titleComp < 0) return -1;
			else if (titleComp > 0) return 1;
			else return 0;
		}
	}
}
