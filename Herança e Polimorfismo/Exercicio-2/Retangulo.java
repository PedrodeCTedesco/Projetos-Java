/**Subclasse da super classe Figura
 * @author Pedro de Castro Tedesco
 * @see "./Exercicio2/Figura.java"
 * @since 22/10/2023
 */

package Exercicio2;

public class Retangulo extends Figura
{
    /**Campos
     * Os campos da classe são variáveis de instância
     * -base:Double -> o valor da base do retângulo
     * -altura:Double -> o valor da altura do retângulo
     */
    private Double base, altura;

    /**Construtores
     * Teremos 3 construtores;
     * +Construtor(Double x, Double y, Double base, Double altura);
     * +Construtor(Double base, Double altura);
     * +Construtor();
     */
    public Retangulo (Double x, Double y, Double base, Double altura)
    {
        super(x, y);
        this.base = base;
        this.altura = altura;
    };//Fim do construtor

    public Retangulo (Double base, Double altura)
    {
        this.base = base;
        this.altura = altura;
    };//Fim do construtor

    public Retangulo () 
    {};//Fim do construtor

    /**--MÉTODOS DE ACESSO-- */

    /**Este método retorna o valor da base de uma instância da classe
     * @return Double base;
     */
    public Double getBase()
    {
        return this.base;
    };//Fim do método

    /**Este método retorna o valor da altura de uma instância da classe
     * @return Double altura;
     */
    public Double getAltura()
    {
        return this.altura;
    };//Fim do método

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**Este método altera o estado do campo base de uma instância da classe
     * @param Double base;
     */
    public void setBase (Double base)
    {
        this.base = base;
    };//Fim do método

    /**Este método altera o estado do campo altura de uma instância da classe
     * @param Double altura;
     */
    public void setAltura (Double altura)
    {
        this.altura = altura;
    };

    /**---MÉTODOS--- */

    /**Este método calcula e retorna o valor da área de uma instância da classe */
    public Double calculaArea()
    {
        Double area = this.getBase() * this.getAltura();
        return area;
    };//Fim do método

    /**Este método sobrescreve o método da superclasse Figura e retorna as informações da instância 
     * @return String;
    */
    public String toString()
    {
        return String.format("\nBase do retângulo: " + this.getBase() + "\nAltura do retângulo: " + this.getAltura());
    };//Fim do método
};//Fim da classe
