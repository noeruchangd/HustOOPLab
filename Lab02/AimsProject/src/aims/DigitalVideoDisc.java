package aims;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public int getId() {
		return id;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
	this.title = title;
	}
	

	public String toString() {
		String response = ("DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + " $");
		return response;
	}
	
	public boolean isMatch(String title) {
		return (title == this.title);
	}
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	nbDigitalVideoDiscs++;
    	this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    } // all params
    
    public DigitalVideoDisc(String title) {
    	nbDigitalVideoDiscs++;
    	this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = ""; 
        this.director = ""; 
        this.length = 0;  
        this.cost = 0.0f;  
    } // only title

    public DigitalVideoDisc(String category, String title, float cost) {
    	nbDigitalVideoDiscs++;
    	this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = ""; 
        this.length = 0;    
        this.cost = cost;
    } // only cat, title and cost

    public DigitalVideoDisc(String director, String category, String title, float cost) {
    	nbDigitalVideoDiscs++;
    	this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = 0;   
        this.cost = cost;
    } // all but length
	
}
