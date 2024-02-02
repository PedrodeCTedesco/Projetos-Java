package org.conductor.selecao;

public class Pessoa
{
    //Atributos

    private String nome, sexo, endereco;
    private Integer idade, qtdIrmaos;
    private Double altura;

    //Construtor

    public Pessoa (String nome, String sexo, String endereco, Integer idade, Integer qtdIrmaos, Double altura) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.qtdIrmaos = qtdIrmaos;
        this.altura = altura;
    };

    //Métodos de acesso

    public String getNome () {
        return this.nome;
    };

    public String getSexo () {
        return this.sexo;
    };

    public String getEndereco () {
        return this.endereco;
    };

    public Integer getIdade () {
        return this.idade;
    };

    public Integer getQtdIrmaos () {
        return this.qtdIrmaos;
    };

    public Double getAltura () {
        return this.altura;
    };

    //Métodos de configuração

    public void setNome (String nome) {
        this.nome = nome;
    };

    public void setSexo (String sexo) {
        this.sexo = sexo;
    };

    public void setEndereco (String endereco) {
        this.endereco = endereco;
    };

    public void setIdade (Integer idade) {
        this.idade = idade;
    };

    public void setQtdIrmaos (Integer qtdIrmaos) {
        this.qtdIrmaos = qtdIrmaos;
    };

    public void setAltura (Double altura) {
        this.altura = altura;
    };

    //Métodos de sobrescrição

    public String toString() {
        return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nEndereço: " + this.endereco + "\nIdade: " + this.idade + "\nQuantidade de irmãos: " + this.qtdIrmaos + "\nAltura: " + this.altura;

    };

    //Método

    public void imprimeInformacoes() {
        toString();
    };

    public Boolean isFilhoUnico (Pessoa p1) {
        if (p1.qtdIrmaos == 0) {
            return true;
        } else {
            return false;
        }
    }

}
