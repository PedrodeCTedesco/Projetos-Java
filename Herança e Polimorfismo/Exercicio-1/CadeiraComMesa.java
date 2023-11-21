/**A classe faz parte do exercício sobre Herança e Polimorfismo da 
 * disciplina de Laboratório I. É uma subclasse de Cadeira
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package Exercicio1;

public class CadeiraComMesa extends Cadeira
{
    /**Campos
     * Os campos são variáveis de instância.
     * -largura:Double -> Representa a largura da mesa acoplada;
     * -profundidade:Double -> Representa a profundidade da mesa acoplada;
     */
    private Double largura, profundidade;

    /**Construtores
     * Este construtor inicializa todos os campos da classe
     * @param Cor cor -> [superclasse]
     * @param Aluno aluno -> [superclasse]
     * @param Double largura -> a largura da mesa acoplada;
     * @param Double profundidade -> a profundidade da mesa acoplada;
     */
    public CadeiraComMesa (Cor cor, Double largura, Double profundidade)
    {
        super(cor);
        this.largura = largura;
        this.profundidade = profundidade;
    };//Fim do construtor

    /**---MÉTODOS DE ACESSO--- */

    /**O método getLargura() retorna o valor da variável de instância "largura"
     * @return Double largura -> o valor da largura da mesa acoplada
     */
    public Double getLargura()
    {
        return this.largura;
    };//Fim do método getLargura();

    /**O método getProfundidade() retorna o valor da variável de instância "profundidade"
     * @return Double profundidade -> o valor da profundidade da mesa acoplada
     */
    public Double getProfundidade()
    {
        return this.profundidade;
    };//Fim do método getProfundidade()

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**O método setLargura(Double largura) altera o estado da variável de instância "largura"
     * @param Double largura -> o novo valor da variável "largura"
     */
    public void setLargura(Double largura)
    {
        this.largura = largura;
    };//Fim do método setLargura(Double largura)

    /**O método setProfundidade(Double profundidade) altera o estado da variável de instância "profundidade"
     * @param Double profundidade -> o novo valor da variável "profundidade"
     */
    public void setProfundidade (Double profundidade)
    {
        this.profundidade = profundidade;
    };//Fim do método setProfundidade(Double profundidade);

    /**---MÉTODOS--- */

    /**O método toString() sobrescreve o método da superclasse Object e retorna
     * as informações da instância
     */
    public String toString()
    {
        return String.format("\nLargura: " + this.getLargura() + "\nProfundidade: " + this.getProfundidade());
    };//Fim do método toString();

};//Fim da classe CadeiraComMesa
