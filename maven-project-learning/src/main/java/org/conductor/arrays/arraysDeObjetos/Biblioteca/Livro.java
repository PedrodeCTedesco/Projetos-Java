package org.conductor.arrays.arraysDeObjetos.Biblioteca;

public class Livro
{
    /**CAMPOS. Todos são variáveis de instância
     * -titulo: String --> o título do livro
     * -autor: String --> o autor do livro
     * -preco: double --> o valor em reais do livro
     * -ano: String --> o ano de criação do livro
     * */
    private String titulo;
    private String autor;
    private double preco;
    private int ano;

    /**CONSTRUTORES
     * Este construtor inicializa todos os campos
     * +Livro(String titulo, String autor, double preco, String ano): Livro
     * @param String titulo;
     * @param String autor;
     * @param double preco;
     * @param int ano;
     * @return uma instância de Livro
     *
     * Este construtor inicializa todos os campos com os valores padrão do compilador
     * +Livro(): Livro
     *
     * */
    public Livro (String titulo, String autor, double preco, int ano)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.ano = ano;
    };//fim do construtor

    public Livro ()
    {}

    /**MÉTODOS DE ACESSO
     * +getTitulo(): String --> retorna o título do livro
     * @return String
     *
     * +getAutor(): String --> retorna o autor do livro
     * @return String
     *
     * +getPreco(): double --> retorna o preço do livro
     * @return double
     *
     * +getAno(): int --> retorna o ano de criação do livro
     * @return int
     * */
    public String getTitulo()
    {
        return this.titulo;
    };//fim do método getTitulo();

    public String getAutor()
    {
        return this.autor;
    };//fim do método getAutor();

    public double getPreco()
    {
        return this.preco;
    };//fim do método getPreco();

    public int getAno()
    {
        return this.ano;
    };//fim do método getAno();

    /**MÉTODOS DE CONFIGURAÇÃO
     * +setTitulo(String titulo): void --> altera o título do livro
     * @param String
     *
     * +setAutor(String autor): void --> altera o nome do autor do livro
     * @param String
     *
     * +setPreco(double preco): void --> altera o preço em reais do livro
     * @param double
     *
     * +setAno(int ano): void --> altera o ano de criação do livro
     * @param int
     * */
    public void setTitulo (String titulo)
    {
        this.titulo = titulo;
    };//fim do método setTitulo(String titulo);

    public void setAutor (String autor)
    {
        this.autor = autor;
    };//fim do método setAutor(String autor);

    public void setPreco (double preco)
    {
        this.preco = preco;
    };//fim do método setPreco(double preco);

    public void setAno (int ano)
    {
        this.ano = ano;
    };//fim do método setAno(String ano);

    /**MÉTODOS
     * +toString(): String --> sobrescreve o método da superclasse
     * @return String
     * */
    public String toString()
    {
        return String.format("\nTítulo: %s\nAutor: %d\nAno: %s\nPreço: %.2f\n", this.getTitulo(), this.getAutor(), this.getAno(), this.getPreco());
    };//fim do método toString();
}
