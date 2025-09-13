package LibraryManagement;
import java.util.Scanner;               
public class librarymanagement {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);     
		
		int maxCapacity = 10;                        
		classBook books[] = new classBook[maxCapacity];
		int totalBooks = 0;                      
		
		boolean exit = false;                      
		
		System.out.println("Library Management System");
		System.out.println("=========================");
		
		while (exit == false) {                           
			System.out.println("\nSelect an option");
			System.out.println("1. Add a book");
			System.out.println("2. Display books");
			System.out.println("3. Issue a book");
			System.out.println("4. Return a book");
			System.out.println("5. Check availability of a book");
			System.out.println("6. Exit");
			
			int selection = scanner.nextInt();        
			scanner.nextLine();
			
			switch (selection) {
				case 1:
					if (totalBooks == maxCapacity) {                  
						System.out.println("\nMaximum capacity of the library reached. Cannot add any more books");
						break;
					}
					                                               
					System.out.println("Enter the author: ");
					String author = scanner.nextLine();
					System.out.println("Enter the title:");
					String title = scanner.nextLine();
					System.out.println("Enter the ISBN (Integer only): ");
					int ISBN = scanner.nextInt();
					
					classBook addedBook = new classBook(title, author, ISBN);     
					books[totalBooks] = addedBook;
					totalBooks++;

					break;

				case 2:
					if (books.length >0) {
						for (int i=0; i<totalBooks; i++) {               
							books[i].displayBook();
						}
					}else {
						System.out.println("\n No books to Display");
					}
					break;

				case 3:
					System.out.println("\nEnter the ISBN of the book: ");           
					int searchISBN = scanner.nextInt();
					boolean bookFound = false;
					int arrayElement = 0;
					
					for(int i=0; i<totalBooks; i++) {
						if (books[i].bookISBN == searchISBN) {
							arrayElement = i;
							bookFound = true;
							break;
						}
					}
					
					if (bookFound) {                
						if (books[arrayElement].isAvailable()) {
							boolean bookIssued = books[arrayElement].issueBook();
							if (bookIssued) {
								System.out.println("\nBook is issued");	       
							} else {
								System.out.println("\nBook could NOT be issued");
							}
							
						} else {
							System.out.println("\nBook is already issued to someone else"); 
						} 
					} else {
						System.out.println("\nBook not found in the library");
					}
					
					break;

				case 4:
					System.out.println("\nEnter the ISBN of the book: ");          
					int searchISBN1 = scanner.nextInt();
					boolean bookFound1 = false;
					int arrayElement1 = 0;
					
					for(int i=0; i<totalBooks; i++) {
						if (books[i].bookISBN == searchISBN1) {
							arrayElement1 = i;
							bookFound1 = true;
							break;
						}
					}
					
					if (bookFound1) {                   
						if (!books[arrayElement1].isAvailable()) {
							boolean bookReturned = books[arrayElement1].returnBook();
							if (bookReturned) {
								System.out.println("\nBook is returned");	
							} else {
								System.out.println("\nBook could NOT be returned");
							}
							
						} else {
							System.out.println("\nBook is already returned to the library");
						}
					} else {
						System.out.println("\nBook not found in the library");
					}
					
					break;

				case 5:
					System.out.println("\nEnter the ISBN of the book: ");
					int searchISBN2 = scanner.nextInt();
					boolean bookFound2 = false;
					int arrayElement2 = 0;
					
					for(int i=0; i<totalBooks; i++) {
						if (books[i].bookISBN == searchISBN2) {
							arrayElement2 = i;
							bookFound2 = true;
							break;
						}
					}
					
					if (bookFound2) {
						if (books[arrayElement2].isAvailable()) {
							System.out.println("\nBook is available");
						} else {
							System.out.println("\nBook is NOT available");
						}
					} else {
						System.out.println("\nBook not found in the library");
					}
					
					break;

				case 6:
					exit = true;
					System.out.println("\nExiting the application. Thank you.");
					break;

				default:
					System.out.println("\nInvalid selction. Please try again");  
					break;
			}
		}

		scanner.close();

	}

}

