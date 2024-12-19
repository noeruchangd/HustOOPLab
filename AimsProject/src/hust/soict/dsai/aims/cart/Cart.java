package hust.soict.dsai.aims.cart;
import java.util.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public Cart() {
    }
    
	public String addMedia(Media media) {
		if (!itemsOrdered.contains(media) && itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			return ("Added " + media.getTitle());
		}
		else if (!(itemsOrdered.size() < MAX_NUMBERS_ORDERED)) return ("Cart is full!");
		else return ("Already in cart!");
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
    public Media searchTitleReturn(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
    
    public ObservableList<Media> getItemsOrdered() {
    	ObservableList<Media> observableList = FXCollections.observableList(itemsOrdered);
    	return observableList;
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
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void empty() {
        if (itemsOrdered.size() == 0) {
            System.out.println("Cart already empty!");
        } else {
            itemsOrdered.clear();
            System.out.println("Cart emptied!");
            System.out.println();
        }
    }
    
    public String placeOrder() {
        if (itemsOrdered.size() == 0) {
            return "Your cart is empty!";
        } else {
            itemsOrdered.clear();
            return "Order created!\n" + "Now your cart will be empty!";
        }
    }

}
