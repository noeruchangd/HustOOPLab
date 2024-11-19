package aims;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f); 
		anOrder.addDigitalVideoDisc(dvd3);

		DigitalVideoDisc dvdList[] = new DigitalVideoDisc[3];
		dvdList[0] = dvd1;
		dvdList[1] = dvd2;
		dvdList[2] = dvd3;
		
		anOrder.addDigitalVideoDisc(dvdList);
		anOrder.addDigitalVideoDisc(dvd1, dvd2);
		
		
		
		System.out.println("Total cost is : ");
		System.out.println(anOrder.totalCost());
	}
}
