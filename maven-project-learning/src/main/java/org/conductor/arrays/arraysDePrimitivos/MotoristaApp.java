package org.conductor.arrays.arraysDePrimitivos;

public class MotoristaApp
{
    private String nome;
    private double[] avaliacoes;

    public MotoristaApp (String nome, Integer quantMaxAvaliacoes)
    {
        this.nome = nome;
        this.avaliacoes = new double[quantMaxAvaliacoes];

        for (int i = 0; i < avaliacoes.length; i++)
        {
            avaliacoes[i] = -1;
        };//Fim do laço for
    };//Fim do construtor

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
        /**O primeiro if unário serve para avaliarmos se é possível inserir uma nova nota
         * de avaliação no array, i.e., se o array não está cheio e se a nota não for negativa
         * pois nesse caso seria avaliada como uma nota inválida.
         * */
        if (novaAvaliacao < 0)
        {
            return false;
        }
        else
        {
            /**Identificando as posições disponíveis do array. Quando uma posição sem uma nota válida, i.e.,
             * cujo valor for -1 for encontrada então a nova avaliação passada identificada como parâmetro
             * e passada como parâmetro formal (argumento) será o novo valor da posição do array. Por isso,
             * temos a introdução do goto 'break' ao final do if*/
            for (Integer i = 0; i < avaliacoes.length; i++)
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
        /**Avaliando se a nota é válida ou não para impressão*/
        for (int i = 0; i < avaliacoes.length; i++)
        {
            if (avaliacoes[i] != -1)
            {
                System.out.print(avaliacoes[i] + " | ");
            };//fim do if
        };//Fim do for
    };//Fim do método imprimeAvaliacao();
}
