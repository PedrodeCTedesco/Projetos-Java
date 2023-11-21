/**Classe que será superclasse do exercício dirigido n.2 da disciplina de laboratório I.
 * @autor Pedro de Castro Tedesco
 * @since 22/10/2023
 */

package Exercicio2;

public class Figura 
{
    /**Campos.
     * Todos os campos são variáveis de instância
     * -x:Double -> coordenada abscissa da figura na tela.
     * -y:Double -> coordenada ordenada da figura na tela.
     */
    private Double x, y;

    /**Construtores
     * Este construtor inicializa todos os campos da classe
     * @param Double x;
     * @param Double y;
     */
    public Figura (Double x, Double y)
    {
        this.x = x;
        this.y = y;
    };//Fim do construtor

    /**Este construtor inicializa a figura sem inicializar os campos. */
    public Figura () {}

    /**---MÉTODOS DE ACESSO--- */

    /**Este método retorna o valor da coordenada absicissa
     * @return Double x;
     */
    public Double getX()
    {
        return this.x;
    };//Fim do método

    /**Este método retorna o valor da coordenada ordenada
     * @return Double y;
     */
    public Double getY()
    {
        return this.y;
    };

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**Este método altera o estado do campo da coordenada abscissa
     * @param Double x;
     */
    public void setX (Double x)
    {
        this.x = x;
    };//Fim do método;

    /**Este método altera o estado do campo da coordenada ordenada 
     * @param Double y;
    */
    public void setY (Double y)
    {
        this.y = y;
    };//Fim do método

    /**MÉTODOS */

    /**Este método sobrescreve o método toString() da superclasse */
    public String toString()
    {
        return String.format("\nO valor da coordenada abscissa é: " + this.getX() + "\nO valor da coordenada ordenada é: " + this.getY());
    };//Fim do método

};//Fim da classe Figura
