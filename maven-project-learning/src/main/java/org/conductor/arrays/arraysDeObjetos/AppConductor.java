package org.conductor.arrays.arraysDeObjetos;

public class AppConductor
{
    /**Campos
     * Todos os campos são variáveis de instância.
     * -nome:String -> o nome do motorista;
     * -avaliacoes: double -> o valor das avaliações. O tipo é array que armazena valores primitivos do tipo double;
     * */
    private String nome;
    private double[] avaliacoes;

    /**Construtores
     * +MotoristaApp(String nome, Integer quantMaxAvaliacoes)-> o construtor inicializa uma instância
     * da classe definindo o tamanho do array.
     * @param nome -> o nome do motorista;
     * @param quantMaxAvaliacoes -> a quantidade máxima de avaliações que um motorista
     * pode receber. Esse valor será utilizado para instanciar o array definindo a quantidade de
     * posições que a variável 'avaliacoes' poderá conter.
     * */
    public AppConductor (String nome, Integer quantMaxAvaliacoes)
    {
        this.nome = nome;
        this.avaliacoes = new double[quantMaxAvaliacoes];
        /**A sentença de iteração garantirá que quando o array for inicializado
         * todas as posições estejam com o valor -1 indicando que nenhuma nota
         * válida foi inserida*/
        for (int i = 0; i < avaliacoes.length; i++)
        {
            avaliacoes[i] = -1;
        };//Fim do laço for
    };//Fim do construtor

    /**Métodos de acesso
     * +getNome():String -> retorna o valor do campo 'nome';
     * @return String nome;
     *
     * +getAvaliacoes(): double[] avaliacoes -> retorna um array de valores primitivos do tipo double contendo
     * os valores das avaliações do motorista.
     * @return double[] avaliacoes;
     * */
    public String getNome()
    {
        return this.nome = nome;
    };//Fim do método getNome();

    public double[] getAvaliacoes()
    {
        return this.avaliacoes;
    };//Fim do método getAvaliacoes();

    public void setNome(String nome)
    {
        this.nome = nome;
    };//Fim do método setNome(String nome);

    public void setAvaliacoes (double[] avaliacoes)
    {
        this.avaliacoes = avaliacoes;
    };//Fim do método setAvaliacoes(double[]avaliacoes);

    public boolean insereAvaliacao(double novaAvaliacao)
    {
        if (novaAvaliacao < 0)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < avaliacoes.length; i++)
            {
                if (avaliacoes[i] == -1)
                {
                    avaliacoes[i] = novaAvaliacao;
                    return true;
                };//Fim do if
            };//Fim da sentença de iteração for
        }
        return false;
    };//Fim do método insereAvaliacao(double novaAvaliacao);

    public void imprimeAvaliacao()
    {
        for (int i = 0; i < avaliacoes.length; i++)
        {
            if (avaliacoes[i] != -1)
            {
                System.out.print(avaliacoes[i] + " | ");
            };//fim do if
        };//Fim do for
    };//Fim do método imprimeAvaliacao();
};//end of AppConductor class
