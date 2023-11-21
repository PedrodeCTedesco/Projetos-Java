/**Essa classe é uma subclasse de Figura
 * @author Pedro de Castro Tedesco
 * @see "Exercicio2/Figura.java"
 * @since 22/10/2023
 */

package Exercicio2;

public class Circulo extends Figura 
{
    /**Campos
     * O campo é uma variável de instância
     * -raio:Double -> o raio de um círculo
     */
    private Double raio;

     /**Crie 3 construtores */
     /**Este construtor inicializa todos os campos 
      * @param Double raio;
      * @param Double x;
      * @param Double y;
     */
    public Circulo (Double x, Double y, Double raio)
    {
        super(x, y);
        this.raio = raio;
    };//Fim do construtor

    /**Este construtor inicializa o círculo apenas com o raio
     * @param Double raio;
     */
    public Circulo (Double raio) {
        this.raio = raio;
    };//Fim do construtor

    /**Este construtor inicializa o círculo sem definir o valor dos campos */
    public Circulo () {};//Fim do construtor

    /**--MÉTODOS DE ACESSO-- */

    /**Este método retorna o valor do raio do círculo
     * @return Double raio;
     */
    public Double getRaio()
    {
        return this.raio;
    };//Fim do método

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**Este método altera o valor do raio do círculo
     * @param Double raio;
     */
    public void setRaio(Double raio)
    {
        this.raio = raio;
    };//Fim do método

    /**---MÉTODOS--- */

    /**Este método calcula o valor da área do raio. */
    public Double calculaArea()
    {
        Double area = Math.PI * (this.getRaio() * this.getRaio());
        return area;
    };//Fim do método

    /**---MÉTODOS SOBRESCRITOS--- */

    /**Este método sobrescreve o método toString() da superclasse Object */
    public String toString()
    {
        return String.format("\nO raio do círculo é: " + this.getRaio());
    };//Fim do método

};//Fim da classe 
