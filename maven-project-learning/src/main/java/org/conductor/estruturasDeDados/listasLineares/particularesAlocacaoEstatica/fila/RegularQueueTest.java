/**Classe para demonstrar a aplicação de uma estrutura de dados de fila. Note  * que nesse exemplo, a fila apresenta
 * um problema: caso um elemento seja adicionado e removido muitas vezes, a fila acabará "parecendo" cheia quando na verdade estiver vazia.
 * Isso acontece porque as variáveis de início e fim (first, last) são sempre incrementadas.
 * */

package org.conductor.estruturasDeDados.listasLineares.particularesAlocacaoEstatica.fila;

public class RegularQueueTest
{
    public static void main(String[]args)
    {

        RegularQueue fila = new RegularQueue(5);

        fila.enqueue(Integer.valueOf(1));
        fila.dequeue();

        fila.enqueue(Integer.valueOf(1));
        fila.dequeue();

        fila.enqueue(Integer.valueOf(1));
        fila.dequeue();

        fila.enqueue(Integer.valueOf(1));
        fila.dequeue();

        fila.enqueue(Integer.valueOf(1));
        fila.dequeue();

        System.out.printf("Testando método isEmpty(): %b%n", fila.isEmpty());
        System.out.printf("Testando método isFull(): %b%n", fila.isFull());
    };//fim do método main
}
