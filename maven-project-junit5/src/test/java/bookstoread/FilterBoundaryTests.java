/** This will be an interface to testing traits for BookFilter.
 * @author pedro de castro tedesco
 * @see "Java Unit Testing with Junit" (Gulati & Sharma, 2017)
 * @since 04/02/2024
 * */

package bookstoread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit5book.bookstoread.BookFilter;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public interface FilterBoundaryTests
{
    BookFilter get();

    @Test
    @DisplayName("should not fail for null book")
    default void nullTest()
    {
        assertThat(get().apply(null)).isFalse();
    }
};//end of FilterBoundaryTests interface
