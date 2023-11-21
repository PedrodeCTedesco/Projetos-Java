/**Classe que integra o exercício 3 do estudo dirigido em herança e polimorfismo
 * da disciplina de Laboratório I da Unisinos
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 */

package Exercicio3;

public class Grau 
{
    /**Campos.
     * Ambos os campos são variáveis de instância.
     * -dataComeco: String -> representa a data de começo de colação de grau.
     * -dataFim: String -> rerepsenta a data de término da colação de grau.
     */
    private String dataComeco, dataFim;

    /**Construtores
     * Este construtor inicializa todos os campos
     * +Grau(String dataComeco, String dataFim)
     */
    public Grau (String dataComecao, String dataFim)
    {
        this.dataComeco = dataComecao;
        this.dataFim = dataFim;
    };//Fim do construtor

    /**Este construtor não recebe parâmetros e inicializa os campos como null.
     * +Grau()
     */
    public Grau ()
    {
        this.dataComeco = null;
        this.dataFim = null;
    };//Fim do construtor

    /**MÉTODOS DE ACESSO */

    /**Este método retorna o valor do campo dataComeco.
     * +getDataComeco(): String
     * @return String dataComeco;
     */
    public String getDataComeco()
    {
        return this.dataComeco;
    };//Fim do método getDataComeco()

    /**Este método retorna o valor do capmo dataFim
     * +getDataFim(): String
     * @return String dataFim;
     */
    public String getDataFim()
    {
        return this.dataFim;
    };//Fim do método getDataFim()

    /**MÉTODOS DE CONFIGURAÇÃO */

    /**Este método altera o estado do campo dataComeco
     * +setDataComeco(String data);
     * @param String data -> O novo valor do campo.
     */
    public void setDataComeco (String data)
    {
        this.dataComeco = data;
    };//Fim do método setDataComeco(String data)

    /**Este método altera o estado do campo dataFim
     * +setDataFim(String data);
     * @param String data -> O novo valor do campo
     */
    public void setDataFim(String data)
    {
        this.dataFim = data;
    };//Fim do método setDataFim(String data)

    /**MÉTODOS */

    /**Este método sobrescreve o método toString() da superclasse e retorna as informações
     * da instância
     * +toString(): String
     */
    public String toString()
    {
        return String.format("\nData de começo: %s\nData de fim: %s", this.getDataComeco(), this.getDataFim());
    };//Fim do método toString()


};//Fim da classe
