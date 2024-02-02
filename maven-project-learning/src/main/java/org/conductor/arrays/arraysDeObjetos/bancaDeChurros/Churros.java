package org.conductor.arrays.arraysDeObjetos.bancaDeChurros;

public class Churros
{
    private String sabor;
    private double preco;

    public Churros (String sabor, double preco)
    {
        this.sabor = sabor;
        this.preco = preco;
    };//fim do construtor

    public Churros (String sabor)
    {
        this.sabor = sabor;
        this.preco = 0.0;
    };//fim do construtor

    public Churros (double preco)
    {
        this.preco = preco;
        this.sabor = "";
    };//fim do construtor

    public String getSabor()
    {
        return this.sabor;
    };//fim do método getSabor();

    public double getPreco()
    {
        return this.preco;
    };//fim do método getPreco();

    public void setSabor(String sabor)
    {
        this.sabor = sabor;
    };//fim do método setSabor(String sabor)

    public void setPreco(double preco)
    {
        this.preco = preco;
    };//fim do método setPreco(double preco);

    /**MÉTODOS
     * +toString(): String --> sobrescreve o método da superclasse
     * @return String
     * */
    public String toString()
    {
        return String.format("Sabor do churros: %s\nPreço do churros: %.2f", this.getSabor(), this.getPreco());
    };//fim do método toString();
}
