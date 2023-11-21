/**A classe faz parte do exercício sobre Herança e Polimorfismo da 
 * disciplina de Laboratório I. É uma subclasse de Cadeira.
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package Exercicio1;

public class CadeiraComRodinhas extends Cadeira
{
    /**Campos
     * Os campos são variáveis de instância
     */
    private Data ultimaManutencao;

    /**Construtor
     * Este construtor inicializa todos os campos
     * @param Data ultimaManutencao -> a data da última manutenção da cadeira
     */
    public CadeiraComRodinhas (Cor cor, Data data)
    {
        super(cor);
        this.ultimaManutencao = data;
    };//Fim do construtor

    /**---MÉTODOS DE ACESSO--- */

    /**O método getUltimaManutencao() retorna uma instância do tipo Data que representa a data da última manutenção
     * da Cadeira
     * @return Data ultimaManutencao -> a data a última manutenção da cadeira
     */
    public Data getUltimaManutencao()
    {
        return this.ultimaManutencao;
    };//Fim do método getUltimaManutencao();

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**O método setUltimaManutencao(Data data) altera o estado da variável de instância "ultimaManutencao"
     * alterando o valor desta variável
     * @param Data data -> a data da última manutenção da cadeira com rodinhas
     */
    public void setUltimaManutencao (Data data)
    {
        this.ultimaManutencao = data;
    };//Fim do método setUltimaManutencao(Data data)

    /**---MÉTODOS--- */

    /**O método toString() sobrescreve o método toString() da superclasse Object 
     * e retorna as informações da instância
     */
    public String toString()
    {
        return String.format("\nData da última manutenção: " + this.getUltimaManutencao());
    };//Fim do método toString()

};//Fim da classe CadeiraComRodinhas
