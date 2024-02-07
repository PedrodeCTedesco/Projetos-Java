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
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//AssertJ
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//Project
import org.junit5book.bookstoread.Book;
import org.junit5book.bookstoread.BookShelf;
import org.junit5book.bookstoread.Progress;
//API Java
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

@DisplayName("<= A bookshelf progress =>")
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
    void init(Map<String, Book> books)
    {
        //creates the BookShelf object
        shelf = new BookShelf();

        //before we used Book objects. Now, with DI we can inject the data for the tests
        this.effectiveJava = books.get("Effective Java");
        this.codeComplete = books.get("Code Complete");
        this.mythicalManMonth = books.get("The Mythical Man-Month");
        this.cleanCode = books.get("Clean Code");
        this.refactoring = books.get("Refactoring: Improving the Design of Existing Code");

        shelf.add(effectiveJava, codeComplete, mythicalManMonth, cleanCode, refactoring);
    };//end of init()

    @Nested
    @DisplayName("what happens when there is only one category on (completed, to-read or in progress")
    class OneCategoryOnly
    {
        @Test
        @DisplayName("is 0% completed, 0% in progress and 100% to-read when no book is read yet")
        void progress100PercentUnread()
        {
            Progress progress = shelf.progress();
            assertThat(progress.completed()).isEqualTo(0);
            assertThat(progress.toRead()).isEqualTo(100);
            assertThat(progress.inProgress()).isEqualTo(0);
        };//end of progress100PercentUnread();

        @Test
        @DisplayName("is 0% completed and 0% to-read when 100% in progress")
        void progress100InProgress()
        {
            effectiveJava.startedReadingOn(LocalDate.of(2004, Month.JUNE, 1));
            codeComplete.startedReadingOn(LocalDate.of(2002, Month.SEPTEMBER, 18));
            cleanCode.startedReadingOn(LocalDate.of(2003, Month.OCTOBER, 22));
            mythicalManMonth.startedReadingOn(LocalDate.of(2007, Month.DECEMBER, 19));
            refactoring.startedReadingOn(LocalDate.of(2021, Month.MAY, 12));

            Progress progress = shelf.progress();

            assertThat(progress.completed()).isEqualTo(0);
            assertThat(progress.toRead()).isEqualTo(0);
            assertThat(progress.inProgress()).isEqualTo(100);
        };//end of progress100InProgress()

        @Test
        @DisplayName("is 0% in progress and 0% to read and 100% completed")
        void allTheBooksInBookShelfAreCompleted()
        {
            effectiveJava.startedReadingOn(LocalDate.of(2000, Month.JANUARY, 1));
            effectiveJava.finishedReadingOn(LocalDate.of(2000, Month.JANUARY, 30));

            codeComplete.startedReadingOn(LocalDate.of(2001, Month.FEBRUARY, 3));
            codeComplete.finishedReadingOn(LocalDate.of(2001, Month.FEBRUARY, 28));

            cleanCode.startedReadingOn(LocalDate.of(2022, Month.JUNE, 2));
            cleanCode.finishedReadingOn(LocalDate.of(2022, Month.JUNE, 29));

            mythicalManMonth.startedReadingOn(LocalDate.of(2021, Month.NOVEMBER, 18));
            mythicalManMonth.finishedReadingOn(LocalDate.of(2021, Month.NOVEMBER, 19));

            refactoring.startedReadingOn(LocalDate.of(2020, Month.MARCH, 18));
            refactoring.finishedReadingOn(LocalDate.of(2020, Month.DECEMBER, 1));

            Progress progress = shelf.progress();

            assertThat(progress.completed()).isEqualTo(100);
            assertThat(progress.toRead()).isEqualTo(0);
            assertThat(progress.inProgress()).isEqualTo(0);
        };//end of allTheBooksInBookShelfAreCompleted();

    };//end of OneCategoryOnly

    @Nested
    @DisplayName("when books are completed, in progress and to-read simultaneously")
    class BooksCompletedInProgressToReadAtTheSameTime
    {
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
            assertThat(progress.inProgress()).isEqualTo(0);
        };//progressWithCompletedAndToReadPercentages();


        @Test
        @DisplayName("is 40% completed, 20% in progress and 40% to-read when 2 books read," +
                " 1 book in progress and 2 not read yet")
        void progressWith2BooksCompleted1InProgressAnd2NotReadYet()
        {
            //Completed books
            effectiveJava.startedReadingOn(LocalDate.of(2024, Month.JANUARY,1));
            effectiveJava.finishedReadingOn(LocalDate.of(2024, Month.JANUARY, 30));

            codeComplete.startedReadingOn(LocalDate.of(2024, Month.FEBRUARY, 1));
            codeComplete.finishedReadingOn(LocalDate.of(2024, Month.MARCH, 4));

            //In progress
            cleanCode.startedReadingOn(LocalDate.of(2024, Month.JULY, 8));

            Progress progress = shelf.progress();

            assertThat(progress.completed()).isEqualTo(40);
            assertThat(progress.toRead()).isEqualTo(40);
            assertThat(progress.inProgress()).isEqualTo(20);

        };//end of progressWith2BooksCompleted1InProgressAnd2NotReadYet()

        @Test
        @DisplayName("should be 20% of books in progress and 80% os books to read when 1 book is in progress")
        void progressWith1BookInProgress()
        {
            cleanCode.startedReadingOn(LocalDate.of(2000, Month.JANUARY, 1));

            Progress progress = shelf.progress();

            assertThat(progress.inProgress()).isEqualTo(20);
            assertThat(progress.toRead()).isEqualTo(80);
        };//end of progressWith1BookInProgress()

    };//end of BooksCompletedInProgressToReadAtTheSameTime class

    @Nested
    @DisplayName("this class checks the initial values of startedReadingOn, finishedReadingOn and readingInProgress")
    class initialValues
    {
        @Test
        @DisplayName("confirm that initial value of startedReadingOn, finishedReadingOn and readingInProgress is null")
        void theInitialValueOfStartedReadingOnFinishedReadingOnReadingInProgressIsNull()
        {
            assertThat(effectiveJava).hasAllNullFieldsOrPropertiesExcept("title",
                    "author", "publishedOn");
        }

        @Test
        @DisplayName("confirm that only finishedReadingOn is null when startedReadingOn() is called")
        void theInitialValueOfFinishedReadingOnIsTheOnlyNullValue()
        {
            mythicalManMonth.startedReadingOn(LocalDate.of(2000, Month.MAY, 13));

            assertThat(mythicalManMonth).hasFieldOrPropertyWithValue("title", mythicalManMonth.getTitle());
            assertThat(mythicalManMonth).hasFieldOrPropertyWithValue("author", mythicalManMonth.getAuthor());
            assertThat(mythicalManMonth).hasFieldOrPropertyWithValue("publishedOn", mythicalManMonth.getPublishedOn());
            assertThat(mythicalManMonth).hasFieldOrPropertyWithValue("startedReadingOn",
                    mythicalManMonth.getStartedReadingOn());
            assertThat(mythicalManMonth).hasFieldOrPropertyWithValue("readingInProgress",
                    mythicalManMonth.getReadingInProgress());
            assertThat(mythicalManMonth).hasFieldOrPropertyWithValue("finishedReadingOn",null);
        }
    };//end of initalValues();

};//end of BookShelfProgressSpec
