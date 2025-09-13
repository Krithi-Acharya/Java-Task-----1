package LibraryManagement;

public class classBook implements interfaceBook {
		private String bookTitle;                     
		private String bookAuthor;
		public int bookISBN;
		private boolean isAvailable; 
		
		public classBook(String title, String author, int ISBN) {
			this.bookTitle = title;                     
			this.bookAuthor = author;
			this.bookISBN = ISBN;
			this.isAvailable = true;
		}
		
		public void displayBook() {       
			System.out.println();
			System.out.println("Book Title: " + this.bookTitle);
			System.out.println("Book Author: " + this.bookAuthor);
			System.out.println("Book ISBN: " + this.bookISBN);
			System.out.println("Book Available?: " + this.isAvailable);
			System.out.println();       
			
		}
		
		public boolean issueBook() {           
			if (this.isAvailable) {
				this.isAvailable = false;         
				return true;                 
			} else {
				return false;			
			}
		}
		
		public boolean returnBook() {          
			if (!this.isAvailable) {
				this.isAvailable = true;        
				return true;
			} else {
				return false;			
			}
		}
		
		public boolean isAvailable() {
			if (this.isAvailable) {           
				return true;
			} else {
				return false;
			}
		}

	}
