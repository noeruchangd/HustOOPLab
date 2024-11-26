package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Added new author: " + authorName);
		}
		else System.out.println("Author already exists in list!");
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Removed author: " + authorName);
		}
		else System.out.println("Author is not already in author list!");
	}

	public List<String> getAuthors() {
		return authors;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

}
