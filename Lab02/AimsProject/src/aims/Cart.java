package aims;

public class Cart {
	private int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
    public Cart() {
        qtyOrdered = 0;
    }
	
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
    	if (qtyOrdered + size(dvdList) < MAX_NUMBERS_ORDERED) {
    		for (int i = 0, i < size(dvdList), i++) {
    			itemsOrdered[qtyOrdered] = dvdList[i];
    			qtyOrdered++;
    		}
    	}
    	else System.out.println("Not enough space in cart!")
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
}
