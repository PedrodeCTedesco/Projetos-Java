/** This is an interface to use on different lind of classes. Key points to remember: we use
 * an interface when classes that belong to different inheritance lines have the same behavior or fields.
 * That is why an interface defines common behavior for things, people and systems. Another thing: an
 * interface as abstract methods that are implicitly private static and final; the fields are
 * implicitly static and final.
 *
 * @author pedro de castro tedesco
 * @see Java: how to program (Deitel and Deitel, 10ªed, chapter 10)
 * @since 09/02/2024
 * */

package org.conductor.interfaces;

public interface Payable
{
    double paymentAmount();
};//end of Payable interface
