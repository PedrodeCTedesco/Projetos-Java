/** This is the class for test of BookShelf. The goal is to show how Junit 5 can be used
 * to realize BDD. That is why we are using "Spec" at the end of the class.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package bookstoread;

//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//AssertJ
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//Packages imported from project
import org.junit5book.bookstoread.Book;
import org.junit5book.bookstoread.BookShelf;

//Java API
import java.time.LocalDate;
import java.time.Month;
import static java.util.Arrays.asList;
import java.util.Comparator;
import java.util.List;

@DisplayName("<= BookShelfSpec =>")
public class BookShelfSpec
{
    //Fields
    private BookShelf shelf;
    private Book effectiveJava;
    private Book codeComplete;
    private Book mythicalManMonth;

    @BeforeEach
    void init() throws Exception
    {
        //creates the BookShelf object
        shelf = new BookShelf();

        //creates the Book objects
        effectiveJava = new Book("Effective Java", "Joshua Bloch",
                LocalDate.of(2008, Month.MAY, 8));

        codeComplete = new Book ("Code Complete", "Steve McConnel",
                LocalDate.of(2004, Month.JUNE, 9));

        mythicalManMonth = new Book("The Mythical Man-Month", "Frederick Phillips Brooks",
                LocalDate.of(1975, Month.JANUARY, 1));
    };//end of init()

    @Test
    @DisplayName("is empty when no book is added to it")
    void shelfEmptyWhenNoBookAdded()
    {
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), ()-> "BookShelf should be empty");
    };//end of shelfEmptyWhenNoBookAdded();

    @Test
    @DisplayName("bookshelf should contain two books when two book added")
    void bookshelfContainsTwoBooksWhenTwoBooksAdded()
    {
        shelf.add(effectiveJava, codeComplete);
        List<Book> books = shelf.books();
        assertEquals(2, books.size(), ()->"BookShelf should have two books");
    }

    @Test
    @DisplayName("when called with zero books bookshelf should be empty")
    void emptyBookShelfWhenAddIsCalledWithoutBooks()
    {
        shelf.add();
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), ()->"BookShelf should be empty");
    };//emptyBookShelfWhenAddIsCalledWithoutBooks();

    @Test
    @DisplayName("the client must not be able to modify the shelf after calling add()")
    void booksReturnedFromBookShelfIsImmutableForClient()
    {
        shelf.add(effectiveJava, codeComplete);
        List<Book> books = shelf.books();
        try
        {
            books.add(mythicalManMonth);
            fail(()->"Should not be able to add book to books");
        } catch (Exception e)
        {
            assertTrue(e instanceof UnsupportedOperationException, ()->"Should throw UnssuportedOperationException");
        };//end of exception treatment
    };//booksReturnedFromBookShelfIsImmutableForClient();

    @Disabled("Needs to implement Comparator")
    @Test
    @DisplayName("bookshelf should be arranged by book title")
    void bookshelfArrangedByBookTitle()
    {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);
        List<Book> books = shelf.arrange();
        assertEquals(asList(codeComplete, effectiveJava, mythicalManMonth), books,
                ()-> "Books in bookshelf should be arranged lexicographically by book title");
    };//bookshelfArrangedByBookTitle();

    @Test
    @DisplayName("books in bookshelf should be in insertion order after calling arrange()")
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange()
    {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);
        shelf.arrange();

        List<Book> books = shelf.books();
        assertEquals(asList(effectiveJava, codeComplete, mythicalManMonth),
                books, ()->"Books in bookshelf are in insertion order");
    };//booksInBookShelfAreInInsertionOrderAfterCallingArrange();

    @Test
    @DisplayName("books arranged by client's criteria")
    void bookshelfArrangedByUserProvidedCriteria() {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);

        Comparator<Book> reversed = Comparator.<Book>naturalOrder().reversed();

        List<Book> books = shelf.arrange(reversed);
        assertThat(books).isSortedAccordingTo(reversed);
    };//end of bookshelfArrangedByUserProvidedCriteria()
};//end of BookShelfSpec class
