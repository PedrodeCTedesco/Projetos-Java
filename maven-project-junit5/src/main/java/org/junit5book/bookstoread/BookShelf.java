/** This is the base class for learning how to use JUnit5 for unit testing in Java.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package org.junit5book.bookstoread;

import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class BookShelf
{
    //Fields
    private final List<Book> books = new ArrayList<>();
    private int booksRead;

    //Client methods
    public List<Book> books()
    {
        return Collections.unmodifiableList(books);
    };//end of books();

    public void add (Book... bookToAdd)
    {
        Arrays.stream(bookToAdd).forEach(books::add);
    };//add(String bookToAdd);

    public List<Book> arrange()
    {
        return arrange(Comparator.naturalOrder());
    };//end of arrange();

    public List<Book> arrange(Comparator<Book> criteria)
    {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    };//end of arrange(Comparator<Book> criteria);

    public Map<Year, List<Book>> groupByPublicationYear()
    {
        return groupBy(book -> Year.of(book.getPublishedOn().getYear()));
    };// end of groupByPublicationYear();

    public <K> Map <K, List<Book>> groupBy(Function<Book, K> fx)
    {
        return books
                .stream()
                .collect(groupingBy(fx));
    };//end of groupBy(Function<Book, K> fx);

    public Progress progress()
    {
        int booksRead = Long.valueOf(books.stream().filter(Book::isRead).count()).
                intValue();

        int booksToRead = books.size() - booksRead;
        int percentageCompleted = booksRead * 100 / books.size();
        int percentageToRead = booksToRead * 100 / books.size();
        return new Progress(percentageCompleted, percentageToRead, 0);
    };//end of progress();
};//end of BookShelf class
