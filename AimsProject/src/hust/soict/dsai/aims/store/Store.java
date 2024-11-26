package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private int stockQuantity = 0;
	private static final int MAX_STOCK = 100;
	private DigitalVideoDisc itemsinStore[] = 
			new DigitalVideoDisc[MAX_STOCK];

	public Store() {
		stockQuantity = 0;
	}
	public void addDVD(DigitalVideoDisc dvd) {
		if (stockQuantity < MAX_STOCK) {
			itemsinStore[stockQuantity] = dvd;
			stockQuantity++;
			System.out.println("Disc " + dvd.getTitle() + " added to stock!");
		}
		else System.out.println("No more space in inventory!");
	}
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < stockQuantity; i++) {
			if (itemsinStore[i].getTitle().equals(dvd.getTitle()));
			for (int j = i; j < stockQuantity - 1; j++) {
				itemsinStore[j] = itemsinStore[j + 1];
			}
			itemsinStore[stockQuantity - 1] = null;
			stockQuantity--;
			System.out.println("Disc " + dvd.getTitle() + " removed from stock!");
			return;
		}
		System.out.println("Disc " + dvd.getTitle() + "not found!");
	}
}
