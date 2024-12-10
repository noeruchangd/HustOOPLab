package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public String toString() {
		String response = ("DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $");
		return response;
	}
	
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
    public DigitalVideoDisc(String title) {
        super(title);
    }    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
//    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//    	nbDigitalVideoDiscs++;
//    	this.id = nbDigitalVideoDiscs;
//        this.title = title;
//        this.category = category;
//        this.director = director;
//        this.length = length;
//        this.cost = cost;
//    } // all params
//    
//    public DigitalVideoDisc(String title) {
//    	nbDigitalVideoDiscs++;
//    	this.id = nbDigitalVideoDiscs;
//        this.title = title;
//        this.category = "N/A"; 
//        this.director = "N/A"; 
//        this.length = 0;  
//        this.cost = 0.0f;  
//    } // only title
//
//    public DigitalVideoDisc(String category, String title, float cost) {
//    	nbDigitalVideoDiscs++;
//    	this.id = nbDigitalVideoDiscs;
//        this.title = title;
//        this.category = category;
//        this.director = "N/A"; 
//        this.length = 0;    
//        this.cost = cost;
//    } // only cat, title and cost
//
//    public DigitalVideoDisc(String director, String category, String title, float cost) {
//    	nbDigitalVideoDiscs++;
//    	this.id = nbDigitalVideoDiscs;
//        this.title = title;
//        this.category = category;
//        this.director = director;
//        this.length = 0;   
//        this.cost = cost;
//    } // all but length
	
}
