package org.conductor.estruturasDeDados.listasLineares.particularesAlocacaoEstatica.fila;

public class CircularQueueTest
{
    public static void main(String[]args)
    {
        CircularQueue fila = new CircularQueue(5);

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

        fila.enqueue(Integer.valueOf(1));
        fila.enqueue(Double.valueOf(2.3));
        fila.enqueue(String.valueOf("Ronaldo"));
        fila.enqueue(Boolean.valueOf(false));
        fila.enqueue(String.valueOf("Dida"));
        fila.enqueue(Integer.valueOf(3421));
        fila.enqueue(Integer.valueOf(53721));
        fila.enqueue(Double.valueOf(1.0000));

        System.out.printf("Testando método isEmpty(): %b%n", fila.isEmpty());
        System.out.printf("Testando método isFull(): %b%n", fila.isFull());

        Object elemento = fila.dequeue();

        System.out.print("Elemento removido: " + elemento);
    };//fim do método main
}
