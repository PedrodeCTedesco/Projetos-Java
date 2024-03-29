/** This class is used to demonstrate how to build a good application step by step
 * initiating with tests.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package org.junit5book.bookstoread;

import java.time.LocalDate;

public class Book implements Comparable<Book>
{
    //Fields
    private final String title;
    private final String author;
    private final LocalDate publishedOn;
    private LocalDate startedReadingOn;
    private LocalDate finishedReadingOn;
    private LocalDate readingInProgress;

    //Constructor
    public Book(String title, String author, LocalDate publishedOn)
    {
        this.title = title;
        this.author = author;
        this.publishedOn = publishedOn;
        this.startedReadingOn = null;
        this.finishedReadingOn = null;
        this.readingInProgress = null;
    };//end of three args constructor

    //Query methods
    public String getTitle()
    {
        return title;
    };//end of getTitle();

    public String getAuthor()
    {
        return author;
    };//end of getAuthor();

    public LocalDate getPublishedOn()
    {
        return publishedOn;
    };//end of getPublishedOn();

    public LocalDate getStartedReadingOn()
    {
        return startedReadingOn;
    }

    public LocalDate getFinishedReadingOn()
    {
        return  finishedReadingOn;
    }

    public LocalDate getReadingInProgress()
    {
        return readingInProgress;
    }

    @Override
    public String toString()
    {
        return String.format("%s {%ntitle=%s,%nauthor=,%s,%nnpublishedOn=%s}",
                "Book", getTitle(), getAuthor(), getPublishedOn());
    };//end of toString();

    @Override
    public int compareTo(Book that)
    {
        return this.title.compareTo(that.title);
    }

    public void startedReadingOn(LocalDate startedOn)
    {
        this.startedReadingOn = startedOn;
        this.readingInProgress = startedOn;
    }

    public void finishedReadingOn(LocalDate finishedOn) {
        this.finishedReadingOn = finishedOn; }

    //public void startedDate(LocalDate startedAt)
    //{
       // this.readingInProgress = startedAt;
    //}

    public boolean isProgress()
    {
        return readingInProgress != null && finishedReadingOn == null;
    }

    public boolean isRead()
    {
        return startedReadingOn != null && finishedReadingOn != null;
    }

    //Query Methods


};//end of Book class
