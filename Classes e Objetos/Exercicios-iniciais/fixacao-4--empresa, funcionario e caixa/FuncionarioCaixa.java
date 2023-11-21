package lab1_javaExercicios_4;

public class FuncionarioCaixa {
    //Atributos

    private String nome, endereco, sexo;
    private Calculadora calculadoraFuncionario;

    //Construtores

    public FuncionarioCaixa () {
        this.nome = "Funcionário não identificado(a)";
        this.endereco = "Endereço desconhecido";
        this.sexo = "Sexo não indicado";
    }

    public FuncionarioCaixa (String nome, String endereco, String sexo, Calculadora calculadoraFuncionario) {
        this.nome = nome;
        this.endereco = endereco;
        this.sexo = sexo;
        this.calculadoraFuncionario = calculadoraFuncionario;
    };

    //Métodos de acesso
    public String getNome () {
        return this.nome;
    };

    public String getEndereco () {
        return this.endereco;
    };

    public String getSexo () {
        return this.sexo;
    };

    public Calculadora getCalculadora () {
        return this.calculadoraFuncionario;
    };

    //Métodos de configuração

    public void setNome (String nome) {
        this.nome = nome;
    };

    public void setEndereco (String endereco) {
        this.endereco = endereco;
    };

    public void setSexo (String sexo) {
        this.sexo = sexo;
    };

    public void setCalculadora (Calculadora calculadoraFuncionario) {
        this.calculadoraFuncionario = calculadoraFuncionario;
    };

    //Métodos 

    public Double somaFuncionario (Double num1, Double num2) {
        return calculadoraFuncionario.soma(num1, num2);
    };

    public Double subtraiFuncionario (Double num1, Double num2) {
        return calculadoraFuncionario.subtrai(num1, num2);
    };

    public Double multiplicaFuncionario (Double num1, Double num2) {
        return calculadoraFuncionario.multiplica(num1, num2);
    };

    public Double divideFuncionario (Double num1, Double num2) {
        return calculadoraFuncionario.divide(num1, num2);
    };

    public Integer elevaAoQuadradoFuncionario (Integer num) {
        return calculadoraFuncionario.elevaAoQuadrado(num);
    };

    public Integer elevaAoCuboFuncionario (Integer num) {
        return calculadoraFuncionario.elevaAoCubo(num);
    };

    public void imprimeInfoFuncionario() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Sexo: " + this.sexo);
        calculadoraFuncionario.imprimeInfo();
    };
};