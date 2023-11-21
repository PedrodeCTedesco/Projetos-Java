package lab1_javaExercicios_5;

public class Produto {
    //Atributos

    private String nome;
    private Double preco;
    private Data dataDeValidade;

    //Construtor

    public Produto (String nome, Double preco, Data dataDeValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataDeValidade = dataDeValidade;
    };

    //Métodos de acesso

    public String getNome () {
        return this.nome;
    };

    public Double getPreco () {
        return this.preco;
    };

    public Data getDataDeValidade () {
        return this.dataDeValidade;
    };

    //Métodos de configuração

    public void setNome (String nome) {
        this.nome = nome;
    };

    public void setPreco (Double preco) {
        this.preco = preco;
    };

    public void setData (Data dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    };

    public Boolean verificaProduto(Data dataDeComparacao, Data dataDeValidade) {

        if (dataDeValidade.getAno() < dataDeComparacao.getAno() || dataDeValidade.getAno() <= dataDeComparacao.getAno() 
        && dataDeValidade.getMes() < dataDeComparacao.getMes() || dataDeValidade.getAno() <= dataDeComparacao.getAno() &&
        dataDeValidade.getMes() <= dataDeComparacao.getMes() && dataDeValidade.getDia() < dataDeComparacao.getDia()) {
            return true;
        } else {
            return false;
        }
    };

    //Sobreposição de métodos

    public String toString() {
        return "Informações do objeto: \n" + "Nome do produto: " + this.nome + "\n Valor do produto: " + this.preco + "\n Data de validade: " + this.dataDeValidade;
    };

}
