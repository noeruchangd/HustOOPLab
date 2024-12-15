package hust.soict.dsai.aims.store;

import java.util.*;
import hust.soict.dsai.aims.media.*;

public class Store {
	private static final int MAX_STOCK = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public Store() {
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	public void addMedia(Media media) {
		if (!itemsInStore.contains(media) && itemsInStore.size() < MAX_STOCK) {
			itemsInStore.add(media);
			System.out.println("Added " + media.getTitle());
		}
		else if (!(itemsInStore.size() < MAX_STOCK)) System.out.println("Inventory is full!");
		else System.out.println("Already in inventory!");
	}
	
	public void removeMedia (Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Removed " + media.getTitle());
		}
		else System.out.println("Not in stock!");
	}
    public void printStore() {
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("********************STORE INVENTORY********************");
            for (Media media : itemsInStore) {
                System.out.println(media);
            }
            System.out.println("********************************************************");
        }
    }
    public Media searchStore(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
}
