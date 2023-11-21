package lab1_javaExercicios;

public class Livro {
    //Atributos

    private String tituloLivro, autorLivro;
    private Integer pubLivro, qtdPagLivro;
    private Double valorLivro;

    //Construtor

    public Livro (String tituloLivro, String autorLivro, Integer pubLivro, Integer qtdPagLivro, Double valorLivro) {
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.pubLivro = pubLivro;
        this.qtdPagLivro = qtdPagLivro;
        this.valorLivro = valorLivro;
    };

    //Getters

    public String getTitulo () {
        return this.tituloLivro;
    }

    public String getAutor () {
        return this.autorLivro;
    };

    public Integer getPub () {
        return this.pubLivro;
    };

    public Integer getQtdPag () {
        return this.qtdPagLivro;
    };

    public Double getValor () {
        return this.valorLivro;
    };

    //Setters

    public void setTitulo (String tituloLivro) {
        this.tituloLivro = tituloLivro;
    };

    public void setAutor (String autorLivro) {
        this.autorLivro = autorLivro;
    };

    public void setPubLivro (Integer pubLivro) {
        this.pubLivro = pubLivro;
    };

    public void setQtdPag (Integer qtdPagLivro) {
        this.qtdPagLivro = qtdPagLivro;
    };

    public void setValor (Double valorLivro) {
        this.valorLivro = valorLivro;
    };

    //Métodos da classe

    public Double valorPrecoPorPagina (Integer qtdPagLivro, Double valorLivro) {
        Double vppLivro = qtdPagLivro / valorLivro;
        return vppLivro;
    };


    public void informacoesLivro () {
        System.out.println("Título: " + this.tituloLivro);
        System.out.println("Autor: " + this.autorLivro);
        System.out.println("Quantidade de páginas: " + this.qtdPagLivro);
        System.out.println("Ano de publicação: " + this.pubLivro);
        System.out.println("Valor: " + this.valorLivro);
    };
};
