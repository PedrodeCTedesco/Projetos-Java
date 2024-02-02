package org.conductor.arrays.arraysDeObjetos.Biblioteca;

public class Antigo extends Livro
{
    private int edicao;

    public Antigo (String titulo, String autor, double preco, int ano, int edicao)
    {
        super(titulo, autor, preco, ano);
        this.edicao = edicao;
    };//fim do construtor

    public Antigo (int edicao)
    {
        this.edicao = edicao;
    }

    /**MÉTODOS DE ACESSO
     * +getEdicao(): int --> retorna o número de edição do livro
     * @return int;
     * */
    public int getEdicao()
    {
        System.out.printf("A edição de %s é %d\n", super.getTitulo(), this.edicao);
        return this.edicao;
    };//fim do método getEdicao();

    public void setEdicao (int edicao)
    {
        this.edicao = edicao;
    };//fim do método setEdicao(int edicao);

    /**MÉTODOS
     * +toString(): String --> sobrescreve o método da superclasse
     * @return String;
     * */
    public String toString()
    {
        return String.format("Informações adicionais sobre o livro:\nA edição inicial de %s é de %d\n", super.getTitulo(), this.getEdicao());
    };//fim do método toString();
}
