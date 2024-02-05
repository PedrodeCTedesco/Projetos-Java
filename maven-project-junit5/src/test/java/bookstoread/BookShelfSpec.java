/** This is the class for test of BookShelf. The goal is to show how Junit 5 can be used
 * to realize BDD. That is why we are using "Spec" at the end of the class.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package bookstoread;

//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

//AssertJ
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//Project imports
import org.junit5book.bookstoread.Book;
import org.junit5book.bookstoread.BookShelf;

//API Java
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@DisplayName("<= BookShelfSpec =>")
@ExtendWith(BooksParameterResolver.class)
public class BookShelfSpec
{
    //Fields
    private BookShelf shelf;
    private Book effectiveJava;
    private Book codeComplete;
    private Book mythicalManMonth;
    private Book cleanCode;

    @BeforeEach
    void init(Map<String, Book> books)
    {
        //creates the BookShelf object
        shelf = new BookShelf();

        //before we used Book objects. Now, with DI we can inject the data for the tests
        this.effectiveJava = books.get("Effective Java");
        this.codeComplete = books.get("Code Complete");
        this.mythicalManMonth = books.get("The Mythical Man-Month");
        this.cleanCode = books.get("Clean Code");
    };//end of init()

    //Let's use @Nested to group the tests in a logical manner
    @Nested
    @DisplayName("is empty")
    class IsEmpty
    {
        @Test
        @DisplayName("is empty when no book is added to it")
        void shelfEmptyWhenNoBookAdded()
        {
            List<Book> books = shelf.books();
            assertTrue(books.isEmpty(), ()-> "BookShelf should be empty");
        };//end of shelfEmptyWhenNoBookAdded();

        @Test
        @DisplayName("when called with zero books bookshelf should be empty")
        void emptyBookShelfWhenAddIsCalledWithoutBooks()
        {
            shelf.add();
            List<Book> books = shelf.books();
            assertTrue(books.isEmpty(), ()->"BookShelf should be empty");
        };//emptyBookShelfWhenAddIsCalledWithoutBooks();
    };//end of IsEmpty inner static class

    @Nested
    @DisplayName("after adding books")
    class BooksAreAdded
    {
        @Test
        @DisplayName("bookshelf should contain two books when two book added")
        void bookshelfContainsTwoBooksWhenTwoBooksAdded()
        {
            shelf.add(effectiveJava, codeComplete);
            List<Book> books = shelf.books();
            assertEquals(2, books.size(), ()->"BookShelf should have two books");
        }


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
    };//end of BooksAreAdded inner static class

    @Nested
    @DisplayName("books arranged by user provided criteria")
    class UserProvidedCriteria
    {
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

        @Test
        @DisplayName("books inside bookshelf are grouped by publication year")
        void groupBooksInsideBookShelfByPublicationYear()
        {
            shelf.add(effectiveJava, codeComplete, mythicalManMonth, cleanCode);

            Map<Year, List<Book>> booksByPublicationYear = shelf.groupByPublicationYear();

            assertThat(booksByPublicationYear)
                    .containsKey(Year.of(2008))
                    .containsValues(Arrays.asList(effectiveJava, cleanCode));

            assertThat(booksByPublicationYear)
                    .containsKeys(Year.of(2004))
                    .containsValues(singletonList(codeComplete));

            assertThat(booksByPublicationYear)
                    .containsKeys(Year.of(1975))
                    .containsValues(singletonList(mythicalManMonth));

        };//end of groupBooksInsideBookShelfByPublicationYear();

        @Test
        @DisplayName("books inside bookshelf are grouped according to user provided criteria (group by author name)")
        void groupBooksByUserProvidedCriteria()
        {
            shelf.add(effectiveJava, codeComplete, mythicalManMonth, cleanCode);

            Map<String, List<Book>> booksByAuthor = shelf.groupBy(Book::getAuthor);

            assertThat(booksByAuthor)
                    .containsKey("Joshua Bloch")
                    .containsValues(singletonList(effectiveJava));

            assertThat(booksByAuthor)
                    .containsKey("Steve McConnel")
                    .containsValues(singletonList(codeComplete));

            assertThat(booksByAuthor)
                    .containsKey("Frederick Phillips Brooks")
                    .containsValues(singletonList(mythicalManMonth));

            assertThat(booksByAuthor)
                    .containsKey("Robert Cecil Martin")
                    .containsValues(singletonList(cleanCode));
        };//end of groupBooksByUserProvidedCriteria();

        @Test
        @DisplayName("bookshelf should be arranged by book title")
        void bookshelfArrangedByBookTitle()
        {
            shelf.add(effectiveJava, codeComplete, mythicalManMonth);
            List<Book> books = shelf.arrange();
            assertEquals(asList(codeComplete, effectiveJava, mythicalManMonth), books,
                    ()-> "Books in bookshelf should be arranged lexicographically by book title");
        };//bookshelfArrangedByBookTitle();

    };//end of UserProvidedCriteria inner static class

};//end of BookShelfSpec class

class BooksParameterResolver implements ParameterResolver
{
    @Override
    public boolean supportsParameter(final ParameterContext parameterContext,
                                     final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Parameter parameter = parameterContext.getParameter();
        return Objects.equals(parameter.getParameterizedType().getTypeName(),
                "java.util.Map<java.lang.String, org.junit5book.bookstoread.Book>");
    };//end of supportsParameter(...);

    @Override
    public Object resolveParameter(final ParameterContext parameterContext,
                                   final ExtensionContext extensionContext) throws ParameterResolutionException
    {
        Map<String, Book> books = new HashMap<>();

        books.put("Effective Java", new Book("Effective Java", "Joshua Bloch",
                LocalDate.of(2008, Month.MAY, 8)));

        books.put("Code Complete", new Book("Code Complete", "Steve McConnel",
                LocalDate.of(2004, Month.JUNE, 9)));

        books.put("The Mythical Man-Month", new Book("The Mythical Man-Month", "Frederick Phillips Brooks",
                LocalDate.of(1975, Month.JANUARY, 1)));

        books.put("Clean Code", new Book("Clean Code", "Robert Cecil Martin",
                LocalDate.of(2008, Month.AUGUST, 1)));

        books.put("Refactoring: Improving the Design of Existing Code",
                new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler",
                        LocalDate.of(2002, Month.MARCH, 9)));

        return books;
    };//end of resolveParameter(...);
};//end of BooksParameterResolver inner static class