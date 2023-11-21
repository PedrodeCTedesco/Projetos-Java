package lab1_javaExercicios_4;

public class Calculadora {
    //Atributos

    private Integer memoria = 0;
    private String cor;

    //Construtor

    public Calculadora (String cor, Integer memoria) {
        this.memoria = memoria;
        this.cor = cor;
    };

    //Métodos de acesso

    public String getCor () {
        return this.cor;
    };
    
    public Integer getMemoria () {
        return this.memoria;
    };

    //Métodos de configuração

    public void setCor (String cor) {
        this.cor = cor;
    };

    public void setMemoria (Integer memoria) {
        this.memoria = memoria;
    };

    //Métodos

    public Double soma (Double num1, Double num2) {
        Double resultado = num1 + num2;
        return resultado;
    };

    public Double subtrai (Double num1, Double num2) {
        Double resultado = num1 - num2;
        return resultado;
    };

    public Double multiplica (Double num1, Double num2) {
        Double resultado = num1 * num2;
        return resultado;
    };

    public Double divide (Double num1, Double num2) {
        Double resultado = num1 / num2;
        return resultado;
    };

    public Integer elevaAoQuadrado (Integer num) {
        Integer resultado = num * num;
        return resultado;
    };

    public Integer elevaAoCubo (Integer num) {
        Integer resultado = num * num * num;
        return resultado;
    };

    public void imprimeInfo() {
        System.out.println("Quantidade disponível em memória: " + this.memoria);
        System.out.println("Cor da calculadora: " + this.cor);
    };

};