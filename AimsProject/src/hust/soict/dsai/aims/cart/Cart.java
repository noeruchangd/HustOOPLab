package hust.soict.dsai.aims.cart;
import java.util.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public Cart() {
    }
    
	public void addMedia(Media media) {
		if (!itemsOrdered.contains(media) && itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Added " + media.getTitle());
		}
		else if (!(itemsOrdered.size() < MAX_NUMBERS_ORDERED)) System.out.println("Cart is full!");
		else System.out.println("Already in cart!");
	}
	
	public void removeMedia (Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed " + media.getTitle());
		}
		else System.out.println("Not in cart!");
	}


    public float totalCost() { // to rewrite
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum = sum + itemsOrdered.get(i).getCost();
		}
		return sum;
	}
    
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}
	
	public void searchId(int id) {
		List<Media> results = new ArrayList<Media>();
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				results.add(itemsOrdered.get(i));
			}
		}
		if (results.size() != 0) {
		System.out.println("Search results for discs with ID " + id + ":");
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).toString());
		}
		}
		else System.out.println("No results for discs matching ID " + id + ".");
	
	}
	public void searchTitle(String title) {
		List<Media> results = new ArrayList<Media>();
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle() == title) {
				results.add(itemsOrdered.get(i));
			}
		}
		if (results.size() != 0) {
		System.out.println("Search results for discs with title " + title + ":");
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i).toString());
		}
		}
		else System.out.println("No results for discs matching title " + title + ".");
}
}
