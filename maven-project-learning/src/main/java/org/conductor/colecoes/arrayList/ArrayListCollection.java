/**Classe para testar os métodos comuns da coleção ArrayList*/

package org.conductor.colecoes.arrayList;

import java.util.ArrayList;
public class ArrayListCollection
{
    public static void main (String[]args)
    {
        //Inicialização de uma coleção ArrayList que armazena instâncias de Strings com capacidade inicial de 10 posições
        ArrayList<String> list = new ArrayList<String>(10);

        display(list, "Valores das posições após inicializar uma instância de ArrayList<String>: ");

        //O método add() adiciona um novo elemento ao final da coleção
        list.add("red");
        list.add("green");
        list.add("blue");
        list.add("orange");
        list.add("purple");
        list.add("gray");
        list.add("lightgreen");
        list.add("white");
        list.add("darkblue");
        list.add("black");

        display(list, "Valores das posições após inicializar uma instância de ArrayList<String> e utilizar o método add(): ");
        int elementos = list.size();
        System.out.printf("A quantidade de elementos atualmente no ArrayList é %d%n", elementos);
        System.out.println();

        //O primeiro parâmetro de add() permite identificar qual a posição de índice que desejo inserir um novo elemento.
        //O segundo parâmetro representa o novo elemento adicionado.

        System.out.printf("Utilizando add(4, \"yellow\") para inserir na posição 4 o valor yellow%n");
        list.add(4, "yellow");

        display(list, "Após a execução do método os valores da coleção são: ");
        System.out.printf("Note que não houve substituição do valor da posição 4 pelo novo elemento. Antes, o novo elemento foi adicionado" +
                " causando um aumento no tamanho inicial do ArrayList<String>.");
        System.out.println();

        //Utilizando o método size() que retorna o número de elementos armazenados no ArrayList
        elementos = list.size();
        System.out.printf("A quantidade de elementos atualmente no ArrayList é %d%n", elementos);
        display(list, "Os elementos no ArrayList<String> list são: ");
        System.out.println();

        //Removendo elementos do ArrayList<String>
        System.out.printf("Utilizando o método remove(). Esse método é sobrecarregado e ou remove a primeira ocorrência passada por parâemtro " +
                "ou remove o elemento na posição de índice especificada.%n");

        list.remove("gray");
        display(list, "Removendo a primeira ocorrência de \"gray\". Valores restantes: ");
        elementos = list.size();
        System.out.printf("A quantidade de elementos atualmente no ArrayList é %d%n", elementos);

        System.out.printf("Removendo o elemento na posição 7.%n");
        list.remove(7);

        display(list, "Após a remoção do elemento na posição 7 temos como valores restantes: ");
        elementos = list.size();
        System.out.printf("A quantidade de elementos atualmente no ArrayList é %d%n", elementos);
        System.out.println();

        //Verificando se há um elemento no ArrayList utilizando contains().
        System.out.printf("Verificando se o valor \"lightgreen\" ainda está no ArrayList. Para isso, "
                + "utilizaremos o método contains(). Ele retorna um valor booleano no true significa que o elemento " +
                "está presente e false indica que não está. Realizaremos o mesmo procedimento com o elemento \"white\".%n");

        System.out.printf("O elemento \"lightgreen\" está está presente? %b%n", list.contains("lightgreen") ? true : false);
        System.out.printf("O elemento \"white\" está está presente? %b%n", list.contains("white") ? true : false);
        System.out.println();

        //Utilizando o método get() para recuperar um elemento do ArrayList
        System.out.printf("Com o método get() podemos recuperar o valor de um elemento em uma posição do ArrayList passada como " +
                "argumento do método. Por exemplo, com list.get(3) teremos na posição 3 o elemento: %s", list.get(3));

    };//fim da classe main

    //Métodos estáticos da classe
    public static void display(ArrayList<String> items, String header)
    {
        System.out.printf(header);

        //Exibe cada elemento da coleção
        for (String item : items)
        {
            System.out.printf(" %s", item);
        };//fim da sentença de iteração for aprimorado
        System.out.println();
    };//fim do método display(ArrayList<String> items, String header);
}
