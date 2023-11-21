/**A classe faz parte do exercício sobre Herança e Polimorfismo da 
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package Exercicio1;

public class Cor 
{
    /**Campos
     * Todos os campos são variáveis de instância.
     * -R:Integer -> o valor do campo R que representa o componente Red de uma cor no formato RGB.
     * -G:Integer -> o valor do campo G que representa o componente Green de uma cor no formato RGB.
     * -B:Integer -> o valor do campo B que representa o componente Blue de uma cor no formato RGB.
     */
    private Integer R, G, B;

    /**Construtores
     * Este construtor inicializa todos os campos da classe
     * @param Integer R -> o valor do campo R;
     * @param Integer G -> o valor do campo G;
     * @param Integer B -> o valor do campo B;
     */
    public Cor (Integer R, Integer G, Integer B)
    {
        this.R = R;
        this.G = G;
        this.B = B;
    };//Fim do construtor.

    /**---MÉTODOS DE ACESSO--- */

    /**O método getR() retorna o valor do campo R da instância.
     * @return Integer R -> o valor do componente R de uma cor no formato RGB.
     */
    public Integer getR()
    {
        return this.R;
    };//Fim do método getR();

    /**O método getG() retorna o valor do campo G da instância.
     * @return Integer G -> o valor do componente G de uma cor no formato RGB.
     */
    public Integer getG()
    {
        return this.G;
    };//Fim do método getG();

    /**O método getB() retorna o valor do campo B da instância. 
     * @return Integer B -> o valor do componente B de uma cor no formato RGB.
    */
    public Integer getB()
    {
        return this.B;
    };//Fim do método getB();

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**O método setR(Integer R) altera o estado do campo R
     * @param Integer R -> o novo valor do componente R de uma cor no formato RGB.
     */
    public void setR(Integer R)
    {
        this.R = R;
    };//Fim do método setR(Integer R);

    /**O método setG(Integer G) altera o estado do campo G
     * @param Integer G -> o valor do componente G de uma cor no formato RGB.
     */
    public void setG(Integer G)
    {
        this.G = G;
    };//Fim do método setG (Integer G)

    /**O método setB(Integer B) altera o estado do campo B 
     * @param Integer B -> o valor do componente B de uma cor no formato RGB.
    */
    public void setB(Integer B)
    {
        this.B = B;
    };//Fim do método setB(Integer B)

    /**---MÉTODOS--- */

    /**O método toString() sobrescreve o método da superclasse Object e retorna uma String
     * com informações sobre a instância.
     */
    public String toString()
    {
        return String.format("\nR: %d\nG: %d\nB: %d", this.getR(), this.getG(), this.getB());
    };//Fim do método toString().

};//Fim da classe
