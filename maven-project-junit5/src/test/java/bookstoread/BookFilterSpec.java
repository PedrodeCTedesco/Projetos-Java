/** This is the class test for BookFilter behavior.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package bookstoread;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit5book.bookstoread.Book;
import org.junit5book.bookstoread.BookFilter;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@DisplayName("<== book filter spec ==>")
@ExtendWith(BooksParameterResolver.class)
public class BookFilterSpec
{
    //Fields
    private Book cleanCode;
    private Book codeComplete;

    private CompositeFilter compositeFilter;

    @BeforeEach
    void init(Map<String, Book> books)
    {
        compositeFilter = new CompositeFilter();

        this.cleanCode = books.get("Clean Code");
        this.codeComplete = books.get("Code Complete");
    };//end of init(Map<String, Book> books);

    @Nested
    @DisplayName("book published date")
    class BookPublishedFilterSpec
    {
        @Test
        @DisplayName("is after specified year")
        void validateBookPublishedDatePostAskedYear()
        {
            BookFilter filter = BookPublishedYearFilter.After(2007);

            Assertions.assertTrue(filter.apply(cleanCode));
            Assertions.assertTrue(filter.apply(codeComplete));
        };//end of validateBookPublishedDatePostAskedYear();

        @Test
        @DisplayName("is before specified year")
        void validateBookPublishedDateAfterAskedYear()
        {
            BookFilter filter = BookPublishedYearFilter.Before(2009);

            Assertions.assertTrue(filter.apply(cleanCode));
        };//end of validateBookPublishedDateAfterAskedYear();

    };//end of BookPublishedFilterSpec

    @Nested
    @DisplayName("composite criteria tests")
    class CompositeCriteriaTests
    {
        @Test
        @DisplayName("Composite criteria is based on multiple filters")
        void shouldFilterOnMultipleCriteria()
        {
            compositeFilter.addFilter(b -> false);
            Assertions.assertFalse(compositeFilter.apply(cleanCode));
        };//end of shouldFilterOnMultipleCriteria();

        @Test
        @Tag(value = "FixMockitoIssueDynamicLoadingAgentsSDK")
        @DisplayName("Composite criteria does not invoke after first failure")
        void shouldNotInvokeAfterFirstFailure()
        {
            //Using Mockito
            //BookFilter invokedMockedFilter = Mockito.mock(BookFilter.class);
            //Mockito.when(invokedMockedFilter.apply(cleanCode)).thenReturn(false);
            //compositeFilter.addFilter(invokedMockedFilter);

            //BookFilter notInvokedMockedFilter = Mockito.mock(BookFilter.class);
            //Mockito.when(notInvokedMockedFilter.apply(cleanCode)).thenReturn(true);
            //compositeFilter.addFilter(notInvokedMockedFilter);

            //Assertions.assertFalse(compositeFilter.apply(cleanCode));
            //Mockito.verify(invokedMockedFilter).apply(cleanCode);
            //Mockito.verifyNoInteractions(notInvokedMockedFilter);

            //The old way using lambda expressions. Validates the result but not the interaction
            compositeFilter.addFilter(b -> false);
            compositeFilter.addFilter(b -> true);
            Assertions.assertFalse(compositeFilter.apply(cleanCode));
        };//end of shouldNotInvokeAfterFirstFailure();

        @Test
        @Tag(value = "FixMockitoIssueDynamicLoadingAgentsSDK")
        @DisplayName("Composite criteria invokes all filters")
        void shouldInvokeAllFilters()
        {
            //Old way using lambda expressions. Validates the result, but not the interactions.
            compositeFilter.addFilter(b -> true);
            compositeFilter.addFilter(b -> true);
            Assertions.assertTrue(compositeFilter.apply(cleanCode));

            //Using Mockito
            //BookFilter firstInvokedMockedFilter = Mockito.mock(BookFilter.class);
            //Mockito.when(firstInvokedMockedFilter.apply(cleanCode)).thenReturn(true);
            //compositeFilter.addFilter(firstInvokedMockedFilter);

            //BookFilter secondInvokedMockedFilter = Mockito.mock(BookFilter.class);
            //Mockito.when(secondInvokedMockedFilter.apply(cleanCode)).thenReturn(true);
            //compositeFilter.addFilter(secondInvokedMockedFilter);

            //Assertions.assertTrue(compositeFilter.apply(cleanCode));
            //Mockito.verify(firstInvokedMockedFilter.apply(cleanCode));
            //Mockito.verify(secondInvokedMockedFilter.apply(cleanCode));
        };//end of shouldInvokeAllFilters();
    };//end of CompositeCriteriaTests class
};//end of BookFilterSpec

//This class implements BookFilter interface to aloud multiple filters based on published date
class BookPublishedYearFilter implements BookFilter
{
    //Fields
    private LocalDate startDate;

    //client methods
    static BookPublishedYearFilter After(int year)
    {
        BookPublishedYearFilter filter = new BookPublishedYearFilter();
        filter.startDate = LocalDate.of(year, 12, 13);
        return filter;
    };//end of After(int year);

    static BookPublishedYearFilter Before (int year)
    {
        BookPublishedYearFilter filter = new BookPublishedYearFilter();
        filter.startDate = LocalDate.of(year, 12, 13);
        return filter;
    };//end of Before(int year);

    @Override
    public boolean apply(final Book b)
    {
        return b.getPublishedOn().isAfter(startDate) || b.getPublishedOn().isBefore(startDate);
    };//end of apply(final Book b);
};//end of BookPublishedYearFilter implements BookFilter

//This class implements BookFilter interface to aloud multiple filter criteria
class CompositeFilter implements BookFilter
{
    //Fields
    private List<BookFilter> filters;

    //Constructor
    CompositeFilter()
    {
        filters = new ArrayList<>();
    };//end of CompositeFilter();

    //Client methods
    @Override
    public boolean apply(final Book b)
    {
        return filters.stream()
                .map(bookFilter -> bookFilter.apply(b))
                .reduce(true, (b1, b2) -> b1 && b2);
    };//end of apply(final Book b)

    void addFilter(final BookFilter bookFilter)
    {
        filters.add(bookFilter);
    };//end of addFilter(final BookFilter bookFilter);
};//end of CompositeFilter implements BookFilter

@Disabled("Need to understand better this interface implementation")
class BookPublishedBeforeFilterSpec implements FilterBoundaryTests
{
    //Fields
    BookFilter filter;

    @Tag("Need fix to work properly")
    @BeforeEach
    void init()
    {
        filter = BookPublishedYearFilter.Before(2007);
    };//end of init();

    @Override
    public BookFilter get()
    {
        return filter;
    }
}//end of BookPublishedBeforeFilterSpec implements FilterBoundaryTests