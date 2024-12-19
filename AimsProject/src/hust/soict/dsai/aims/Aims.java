package hust.soict.dsai.aims;

import java.util.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.*;
import hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.test.disc.StoreTest;
import hust.soict.dsai.test.store.TestPassingParameter;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    
	public static void main(String[] args) {
//		CartTest.main(args);
//		StoreTest.main(args);
//		TestPassingParameter.main(args);
		testInit();
		new StoreScreen(store, cart);
		boolean exit = false;
		while (!exit) {
			showMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
            case 0:
                exit = true;
                System.out.println("See you next time!");
                break;
            case 1:
                clearConsole();
                storeMenu(scanner);
                break;
            case 2:
                clearConsole();
                updateStoreMenu(scanner);
                break;
            case 3:
                clearConsole();
                cartMenu(scanner);
                break;
            default:
                clearConsole(); 
                System.out.println("Invalid option");
                break;
        }      
		}
		}
	
	public static void testInit() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);     
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "N/A", 0 , 18.99f);
     
       
        Book book1 = new Book("Book A", "Man A", 22.00f);
        Book book2 = new Book("Book B", "Man B", 25.00f);
        Book book3 = new Book("Book C", "Man C", 25.00f);



        CompactDisc cd1 = new CompactDisc("Disk A", "Breakcore","Man A", 54.12f);
        Track track1CD1 = new Track("Lol, Lmao", 123);
        Track track2CD1 = new Track("Chill Guy", 423);
        Track track3CD1 = new Track("Beyond The Speed of Love", 213);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);

        CompactDisc cd2 = new CompactDisc("To Those I Dread To See Every Morning", "Pop","Man B", 1234.343f);
        Track track1CD2 = new Track("Why Am I Doing This", 343);
        Track track2CD2 = new Track("My Baby Blue", 123);
        Track track3CD2 = new Track("Grievous Lady", 420);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);

        CompactDisc cd3 = new CompactDisc("if only", "Experimental","The Beyond", 231.23f);
        Track track1CD3 = new Track("model.Maximize(happiness);", 431);
        Track track2CD3 = new Track("exit();", 1234);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
    
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
  
        
        clearConsole();
    }
	
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void storeMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            store.printStore();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    boolean found = false;
                    while (!found) {
                        System.out.println("Enter title (type 0 to return): ");
                        String title = scanner.nextLine();
                        
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        
                        Media media = store.searchStore(title);
                        if (media != null) {
                            clearConsole();
                            System.out.println("Details of " + title + ": ");
                            System.out.println(media);
                            mediaDetails(scanner, media);
                            found = true;
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break;
                case 2:
                    boolean found1 = false;
                    while (!found1) {
                        System.out.println("Enter title (type 0 to return): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.searchStore(title);
                        if (media != null) {
                            cart.addMedia(media);
                            found1 = true;
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break;
                case 3:
                    boolean found2 = false;
                    while (!found2) {
                        System.out.println("Enter title (type 0 to return): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.searchStore(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) {
                                media.play();
                            } else {
                                System.out.println("Type not supported!");
                            }
                            found2 = true;
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break;
                case 4:
                    clearConsole(); 
                    cartMenu(scanner);
                    break;    
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, try again.");
                    break;
            }
        }
    }
    public static void mediaDetails(Scanner scanner, Media media) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole(); 
                    back = true;
                    break;
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Disc || media instanceof CompactDisc) {
                        media.play();
                    } else {
                        System.out.println("Type not supported!");
                    }
                    break;
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, try again.");
                    break;
            }
        }
    }
    public static void cartMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole(); 
                    back = true;
                    break;
                case 1:
                    System.out.println("Filter media in cart by (1) ID or (2) title:");
                    int filterOption = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    while (!found) {
                        if (filterOption == 1) {
                            System.out.println("Enter ID to filter (type 0 to return):");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            if (id == 0) {
                                clearConsole();
                                break;
                            }
                            cart.searchId(id);
                            found = true;
                        } else if (filterOption == 2) {
                            System.out.println("Title to filter (type 0 to return): ");
                            String title = scanner.nextLine();
                            if (title.equals("0")) {
                                clearConsole();
                                break;
                            }
                            cart.searchTitle(title);
                            found = true;
                        } else if (filterOption == 0) {
                            clearConsole();
                            break;
                        } else {
                            System.out.println("Invalid option, try again.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Sort cart by (1) title or (2) cost:");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();
                    if (sortOption == 1) {
                        cart.sortMediaByTitle();
                    } else if (sortOption == 2) {
                        cart.sortMediaByCost();
                    } else {
                        System.out.println("Invalid option, try again.");
                    }
                    break;
                case 3:
                    boolean found1 = false;
                    while (!found1) {
                        System.out.println("Enter title (enter 0 to return): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = cart.searchTitleReturn(title);
                        if (media != null) {
                            clearConsole();
                            cart.removeMedia(media);
                            found1 = true;
                        } else {
                            System.out.println("Not found!");
                        }
                    } 
                    break;
                case 4:
                    boolean found2 = false;
                    while (!found2) {
                        System.out.println("Enter title (enter 0 to return): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.searchStore(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) {
                                media.play();
                            } else {
                                System.out.println("Type not supported!");
                            }
                            found2 = true;
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break; 
                case 5:
                    clearConsole();
                    System.out.println("Order placed!");
                    cart.empty();
                    break;
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, try again.");
                    break;
            }
        }
    }
    public static void updateStoreMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    System.out.println("Media type? (1) Book, (2) CD, (3) DVD. (0) to exit:");
                    int cat = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (cat == 1) {
                        System.out.println("Book title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.println("Book category: ");
                        String bookCategory = scanner.nextLine();
                        System.out.println("Book price: ");
                        Float bookCost = scanner.nextFloat();
                        scanner.nextLine();

                        Book newBook = new Book(bookTitle, bookCategory, bookCost);
                        store.addMedia(newBook);
                    } else if (cat == 2) {
                        System.out.println("CD title: ");
                        String cdTitle = scanner.nextLine();
                        System.out.println("CD category: ");
                        String cdCategory = scanner.nextLine();
                        System.out.println("CD artist: ");
                        String cdArtist = scanner.nextLine();
                        System.out.println("CD price: ");
                        Float cdCost = scanner.nextFloat();
                        scanner.nextLine();

                        CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);

                        
                        System.out.println("Add tracks to CD? (1) Yes (0) No:");
                        int addTrack = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (addTrack == 1) {
                            System.out.println("Number of tracks: ");
                            int numTrack = scanner.nextInt();
                            scanner.nextLine();
                            for (int i = 0; i < numTrack; i++) {
                                System.out.println("Track " + (i+1) + ": ");
                                System.out.println("Track title: ");
                                String trackTitle = scanner.nextLine();
                                System.out.println("Track length: ");
                                int trackLength = scanner.nextInt();
                                scanner.nextLine();

                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                            store.addMedia(newCD);
                        } else if (addTrack == 0) {
                            store.addMedia(newCD);
                        }
                    } else if (cat == 3) {
                        System.out.println("Enter DVD title: ");
                        String dvdTitle = scanner.nextLine();
                        System.out.println("Enter DVD category: ");
                        String dvdCategory = scanner.nextLine();
                        System.out.println("Enter book price: ");
                        Float dvdCost = scanner.nextFloat();
                        scanner.nextLine();
                        
                        DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost);
                        store.addMedia(newDVD);                
                    } else if (cat == 0) {
                        clearConsole();
                        break;
                    } else {
                        System.out.println("Invalid option. Try again.");
                    }
                    break;
                case 2:
                    boolean found = false;
                    while (!found) {
                        System.out.println("Enter title (enter 0 to return): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.searchStore(title);
                        if (media != null) {
                            clearConsole();
                            store.removeMedia(media);
                            found = true;
                        } else {
                            System.out.println("Not found!");
                        }
                    }
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, try again.");
                    break;
            }
        }
    }
}

