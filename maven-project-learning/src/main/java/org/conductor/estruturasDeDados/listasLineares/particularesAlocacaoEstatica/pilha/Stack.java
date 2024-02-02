/**Classe para demonstrar a aplicação de uma pilha
 * @author pedro de castro tedesco
 * @link "Estruturas de dados e algoritmos" (Gustavo Lermen)
 * @since 29/12/2023*/

package org.conductor.estruturasDeDados.listasLineares.particularesAlocacaoEstatica.pilha;

public class Stack
{
    /**CAMPOS. Ambos são variáveis de instância.
     * -stack[]: Object --> uma pilha de elementos de qualquer tipo que herde a classe Object. Note que a estrutura
     * de dados para a implementação é um vetor (matriz unidimensional), pois a alocação é estática e os valores
     * armazenados estarão em posições contíguas de memória.
     * -top: int --> variável para acompanhar o valor do topo da pilha
     * */
    private Object stack[];
    private int top = -1;

    public Stack(int size)
    {
        stack = new Object[size];
    };//fim do construtor

    public int size()
    {
        return top + 1;
    };//fim do método size();

    public boolean isEmpty()
    {
        //Verifica se a pilha está vazia
        return top == -1;
    };//fim do método isEmpty();

    public boolean isFull()
    {
        return top == stack.length - 1;
    };//fim do método isFull();

    public void push(Object obj)
    {
        //Verifica se a pilha está ou não está cheia.
        if(!isFull())
        {
            //Se temos espaço na pilha nós incrementaremos o valor da variável que controla a posição de índice dos elementos da pilha.
            //Note que estamos utilizando um incremento pré-fixado, portanto, o valor atual da variável é o valor após o incremento.
            //Isso assegura que estamos lidando com o valor da posição atual/real da variável que rastreia a posição de índice da pilha.
            stack[++top] = obj;
        } else
        {
            throw new StackOverflowError();
        }//fim da sentença de seleção condicional composta
    };//fim do método push(Object obj);

    public Object pop()
    {
        //Verifica se há um elemento na pilha para poder ser removido
        if(!isEmpty())
        {
            //Salvo uma referência do objeto removido;
            Object objRemovido = stack[top];
            //Libero a posição tornando-a nula;
            stack[top] = null;
            //Decrementa a posição da variável de rastreio das posições da pilha
            top-=1;
            return objRemovido;
        } else
        {
            throw new RuntimeException();
        }//fim da sentença de seleção condicional composta
    };//fim do método pop();

    public Object top()
    {
        return stack[top];
    };//fim do método top();
}
