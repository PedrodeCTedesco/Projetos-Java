package lab1_javaExercicios_3;

public class Computador {
    //Atributos

    private String marca;
    private Double velocidade;
    private Integer anoFabricacao;
    private Boolean novo;

    //Construtor

    public Computador (String marca, Double velocidade, Integer anoFabricacao, Boolean novo) {
        this.marca = marca;
        this.velocidade = velocidade;
        this.anoFabricacao = anoFabricacao;
        this.novo = novo;
    };

    //Métodos de acesso (getters)

    public String getMarca () {
        return this.marca;
    };

    public Double getVelocidade () {
        return this.velocidade;
    };

    public Integer getAnoFabricacao () {
        return this.anoFabricacao;
    };

    public Boolean getNovo () {
        return this.novo;
    };

    //Métodos de configuração (setters)

    public void setMarca (String marca) {
        this.marca = marca;
    };

    public void setVelocidade (Double velocidade) {
        this.velocidade = velocidade;
    };

    public void setAnoFabricacao (Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    };

    public void setNovo (Boolean novo) {
        this.novo = novo;
    };

    //Método

    public void exibeInfo () {
        System.out.println("Marca: " + this.marca);
        System.out.println("Ano de fabricação: " + this.anoFabricacao);
    }
};