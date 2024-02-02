package org.conductor.arrays.arraysDeObjetos.bancaDeChurros;

public class BancaDeChurros
{
    private final Churros[] churros;
    public BancaDeChurros ()
    {
        churros = new Churros [10];
    };//fim do construtor

    public BancaDeChurros (int quantMax)
    {
        this.churros = new Churros[quantMax];
    };//fim do construtor

    public int estoqueChurros (String sabor)
    {
        int count = 0;

        for (int i = 0; i < this.churros.length; i += 1)
        {
            try
            {
                if (this.churros[i] != null && this.churros[i].getSabor().equalsIgnoreCase(sabor))
                {
                    count += 1;
                };//fim da sentença de seleção simples
            } catch (Exception NullPointerException)
            {
                System.out.printf("Sabor %s indisponível no momento.\n", sabor);
            };//fim do tratamento de exceções
        };//fim da sentença de iteração
        return count;
    };//fim do método estoqueChurros (String sabor);

    public boolean insereChurro (Churros churro)
    {
        //Verificando qual a primeiro posição livre do array. Será uma posição cujo valor é null
        for (int i = 0; i < this.churros.length; i += 1)
        {
            if (this.churros[i] == null)
            {
                this.churros[i] = churro;
                return true;
            };//fim da sentença de seleção simples
        };//fim da sentença de iteração
        return false;
    };//fim do método insereChurro(Churros churro);

    public double valorTotal()
    {
        /**Variáveis de apoio*/
        double soma = 0;

        //Sentença de iteração para somar o preço de todos os churros do array
        for (int i = 0; i < this.churros.length; i += 1)
        {
            soma += this.churros[i].getPreco();
        };//fim da sentença de iteração
        return soma;
    };//fim do método valorTotal();

    public boolean vendeChurros(String sabor)
    {

        System.out.printf("Você deseja comprar um churros sabor %s\n", sabor);

        //Retira o churros vendido do array de objetos
        for (int i = 0; i < this.churros.length; i += 1)
        {
            try
            {
                if (this.churros[i] != null && this.churros[i].getSabor().equalsIgnoreCase(sabor))
                {
                    System.out.printf("Vendido churros sabor %s. Valor da compra %.2f\n", this.churros[i].getSabor(), this.churros[i].getPreco());
                    this.churros[i] = null;
                    return true;
                };//fim da sentença de seleção simples

            } catch (Exception NullPointerException)
            {
                System.out.print("Este churros já foi vendido!\n");
            };//fim do tratamento de exceções
        };//fim da sentença de iteração
        return false;
    };//fim do método vendeChurros(String sabor);


    public void imprimeChurros()
    {
        //Impressão de todos os churros da banca
        for (int i = 0; i < this.churros.length; i += 1)
        {
            try
            {
                System.out.println(this.churros[i]);

            } catch (Exception NullPointerException)
            {
                System.out.printf("O churros na posição %d já foi vendido!", i);
            };//fim do tratamento de exceções
        };//fim da sentença de iteração
    };//fim do método imprimeChurros();


    public boolean lePedidos (String nome, String sabor, int quantidade)
    {
        /**Variáveis de apoio*/
        int quantosChurrosHa = this.estoqueChurros(sabor);

        //Etapa 1: quantos churros do sabor desejado estão disponíveis
        this.estoqueChurros(sabor);

        if (quantosChurrosHa == 0)
        {
            return false;
        };//fim da sentença de seleção simples

        //Etapa 2: Havendo churros, quantos estão disponíveis e quem quer comprá-los
        System.out.printf("%s deseja comprar %d churros de %s\n", nome, quantidade, sabor);

        //Verificando a venda do churros
        while (quantidade > 0)
        {
            this.vendeChurros(sabor);
            quantidade -= 1;
        };//fim da sentença de iteração
        return true;
    };//fim do método lePedidos(String nome, String sabor, int quantidade);

    public int quantosChurrosTem ()
    {
        //Variáveis de apoio
        int countChurrosOk = 0;
        int countChurrosNotOk = 0;

        //Iterando pelo array de objetos para verificar quantas posiçõe nulas e não nulas existem
        for (int i = 0; i < this.churros.length; i += 1)
        {
            if (this.churros[i] == null)
            {
                countChurrosNotOk += 1;
            } else
            {
                countChurrosOk += 1;
            }
        };//fim da sentença de iteração
        return countChurrosOk;
    };//fim do método quantosChurrosTem();
}
