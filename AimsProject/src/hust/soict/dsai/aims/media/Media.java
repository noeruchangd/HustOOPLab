package hust.soict.dsai.aims.media;

import java.util.*;

import hust.soict.dsai.aims.exception.PlayerException;

public abstract class Media {
	private static int nbMedia = 0;
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public boolean equals(Media o) {
		if (this.getTitle() == o.getTitle()) {
			return true;
		}
		else return false;
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}

    public void play() throws PlayerException {
        System.out.println("Playing " + this.getTitle());
    }
    public String playGUI() {
        return "Playing " + this.getTitle();
    }

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}



	public void setCost(float cost) {
		this.cost = cost;
	}

    public String toString() {
        return "Media: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }


    public Media(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }

}
