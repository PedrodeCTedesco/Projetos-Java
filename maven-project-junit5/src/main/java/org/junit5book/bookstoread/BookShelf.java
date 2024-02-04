/** This is the base class for learning how to use JUnit5 for unit testing in Java.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package org.junit5book.bookstoread;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf
{
    //Fields
    private final List<Book> books = new ArrayList<>();

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

};//end of BookShelf class
