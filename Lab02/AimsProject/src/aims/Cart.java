package aims;
import java.util.*;

public class Cart {
	private int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
    public Cart() {
        qtyOrdered = 0;
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    	if ((qtyOrdered + dvdList.length) < MAX_NUMBERS_ORDERED)
			{
    		for (int i = 0; i < dvdList.length; i++) {
    			itemsOrdered[qtyOrdered] = dvdList[i];
    			qtyOrdered++;
    			System.out.println("Disc " + dvdList[i].getTitle() + " added successfully!");
    		}
    	}
    	else System.out.println("Not enough space in cart!");
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	if ((qtyOrdered + 2) < MAX_NUMBERS_ORDERED)
			{
				itemsOrdered[qtyOrdered] = dvd1;
    			System.out.println("Disc " + dvd1.getTitle() + " added successfully!");
    			qtyOrdered++;
    			itemsOrdered[qtyOrdered] = dvd2;
    			System.out.println("Disc " + dvd1.getTitle() + " added successfully!");
    		}
    	else System.out.println("Not enough space in cart!");
    	}
    
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("Disc " + disc.getTitle() + " added successfully!");
		}
		else System.out.println("Cart is full!");
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().equals(disc.getTitle()));
			for (int j = i; j < qtyOrdered - 1; j++) {
				itemsOrdered[j] = itemsOrdered[j + 1];
			}
			itemsOrdered[qtyOrdered - 1] = null;
			qtyOrdered--;
			System.out.println("Disc " + disc.getTitle() + " removed successfully!");
			return;
		}
		System.out.println("Disc " + disc.getTitle() + "not found!");
	}
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum = sum + itemsOrdered[i].getCost();
		}
		return sum;
	}
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}
	
	public void searchId(int id) {
		List<DigitalVideoDisc> results = new ArrayList<DigitalVideoDisc>();
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				results.add(itemsOrdered[i]);
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
		List<DigitalVideoDisc> results = new ArrayList<DigitalVideoDisc>();
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				results.add(itemsOrdered[i]);
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
