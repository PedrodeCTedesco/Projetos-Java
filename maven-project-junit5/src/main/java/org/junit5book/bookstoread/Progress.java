/** This is the class that hold the progress status of the books in bookshelf regarding to
 * it's reading status (complete, to-read or in progress)
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 05/02/2024
 * */

package org.junit5book.bookstoread;

public class Progress
{
    //Fields
    private final int completed;
    private final int toRead;
    private final int inProgress;

    //Constructor
    public Progress(int completed, int toRead, int inProgress)
    {
        this.completed = completed;
        this.toRead = toRead;
        this.inProgress = inProgress;
    };//end of three args constructor

    //Client methods
    public int completed()
    {
        return this.completed;
    };//end of completed();

    public int toRead()
    {
        return this.toRead;
    };//end of toRead();

    public int inProgress()
    {
        return this.inProgress;
    };//end of inProgress();

};//end of Progress class
