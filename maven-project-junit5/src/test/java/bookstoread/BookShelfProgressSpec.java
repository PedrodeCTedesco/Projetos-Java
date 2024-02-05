/** This is a new class test that we've created to implement the progress feature.
 * The goal is that the user can keep track of the % books that are complete (the book was read),
 * in progress (the user as start reading) or to-do (not read yet).
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 05/02/2024
 * */

package bookstoread;

//JUnit 5
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//AssertJ
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//Project
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.engine.config.EnumConfigurationParameterConverter;
import org.junit5book.bookstoread.Book;
import org.junit5book.bookstoread.BookShelf;
import org.junit5book.bookstoread.Progress;
//API Java
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@DisplayName("<= A bookshelf progress")
@ExtendWith(BooksParameterResolver.class)
public class BookShelfProgressSpec
{
    //Fields
    private BookShelf shelf;
    private Book effectiveJava;
    private Book codeComplete;
    private Book mythicalManMonth;
    private Book cleanCode;
    private Book refactoring;

    @BeforeEach
    void init() throws Exception
    {
        //creates the BookShelf object
        shelf = new BookShelf();

        //before we used Book objects. Now, with DI we can inject the data for the tests
        effectiveJava = new Book("Effective Java", "Joshua Bloch",
                LocalDate.of(2008, Month.MAY, 8));
        codeComplete = new Book("Code Complete", "Steve McConnel",
                LocalDate.of(2004, Month.JUNE, 9));
        mythicalManMonth = new Book("The Mythical Man-Month", "Frederick Phillips Brooks",
                LocalDate.of(1975, Month.JANUARY, 1));
        cleanCode = new Book("Clean Code", "Robert Cecil Martin",
                LocalDate.of(2008, Month.AUGUST, 1));
        refactoring = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler",
                LocalDate.of(2002, Month.MARCH, 9));

        shelf.add(effectiveJava, codeComplete, mythicalManMonth, cleanCode, refactoring);
    };//end of init()

    @Test
    @DisplayName("is 0% completed and 100% to-read when no book is read yet")
    void progress100PercentUnread()
    {
        Progress progress = shelf.progress();
        assertThat(progress.completed()).isEqualTo(0);
        assertThat(progress.toRead()).isEqualTo(100);
    };//end of progress100PercentUnread();

    @Test
    @DisplayName("is 40% completed and 60% to-read when two books are finished and 3 books not read yet")
    void progressWithCompletedAndToReadPercentages()
    {
        effectiveJava.startedReadingOn(LocalDate.of(2016, Month.JULY, 1));
        effectiveJava.finishedReadingOn(LocalDate.of(2016, Month.JULY, 30));

        cleanCode.startedReadingOn(LocalDate.of(2016, Month.AUGUST,1));
        cleanCode.finishedReadingOn(LocalDate.of(2016, Month.AUGUST, 24));

        Progress progress = shelf.progress();

        assertThat(progress.completed()).isEqualTo(40);
        assertThat(progress.toRead()).isEqualTo(60);
    };//progressWithCompletedAndToReadPercentages();
};//end of BookShelfProgressSpec
