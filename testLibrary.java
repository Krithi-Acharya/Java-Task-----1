package LibraryManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testLibrary {
	
	private classBook book;
//	book = new classBook("Java Programming", "Krithi Acharya", 1234);

	@BeforeEach
	void setUp() throws Exception {
		book = new classBook("Java Programming", "Krithi Acharya", 1234);
	}

	@Test
	void testIsAvailable() {
		assertTrue(book.isAvailable(), "Book should available when created");
	}

	@Test
	void testIssueBook() {
		assertTrue(book.issueBook(), "Book should issued since it is available");
	}
	
	@Test
	void testReturnBook() {
		//now issue the book, before testing return book
		book.issueBook();
		assertTrue(book.returnBook(), "Book should returnable since it is issued");
	}
	
	@Test
	void testFalseReturn() {

		// since the book is not issued yet, this should result in false. Hence assertFalse is used
		assertFalse(book.returnBook(), "Book should NOT be returnable since it is never issued");
	}
	
	@Test
	void testFalseIssue() {
		//now issue the book, before trying to issue the book again
		book.issueBook();
		// since the book is issued, you should not be able to issue the book again. Hence assertFalse is used
		assertFalse(book.issueBook(), "Book should NOT be issueable since it is already issued");
	}
}
