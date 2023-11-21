package lab1_javaExercicios_3;

public class Produto {
    //Atributos

    private String nome, descricao;
    private Double valor;
    private Integer qtdEstoque;
    private Computador novoComputador;

    //Construtor

    public Produto (String nome, String descricao, Double valor, Integer qtdEstoque, Computador novoComputador) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
        this.novoComputador = novoComputador;
    };

    //Métodos de acesso (getters)

    public String getNome () {
        return this.nome;
    };

    public String getDescricao () {
        return this.descricao;
    };

    public Double getValor () {
        return this.valor;
    };

    public Integer getQtdEstoque () {
        return this.qtdEstoque;
    };

    public Computador getComputador () {
        return this.novoComputador;
    }

    //Métodos de configuração (setters)

    public void setNome (String nome) {
        this.nome = nome;
    };

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    };

    public void setValor (Double valor) {
        this.valor = valor;
    };

    public void setQtdEstoque (Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    };

    public void setComputador (Computador novoComputador) {
        this.novoComputador = novoComputador;
    };

    //Métodos

    public void infoPc () {
        novoComputador.exibeInfo();
    };
};