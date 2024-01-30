package bookstoread;

// Classe para aprendizagem de utilização de JUnit 5. A utilização de convenções de nomeação
//  utilizada pelos autores é a BDD, logo as classes para teste terminam com Spec.
//  @link "Java Unit Testing with JUnit 5" (Shekhar Gulati, Rahul Sharma, 2017)
//  @since 29/01/2024
//

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BookShelfSpec
{
    @Test
    public void shelfEmptyWhenNoBookAdded() throws Exception
    {
        BookShelf shelf = new BookShelf();

        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "BookShelf shoul be empty");
    };//fim do método shelfEmptyWhenNoBookAdded()

};//fim da classe BookShelfSpec


