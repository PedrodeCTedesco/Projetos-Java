/**A classe faz parte do exercício sobre Herança e Polimorfismo da 
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */
package Exercicio1;
 public class Aluno
 {
    /**Campos
     * Os campos presentes são variáveis de instância
     * -nome: String -> representa o nome do aluno;
     * -idade: Integer -> representa a idade do aluno
     */
    private String nome;
    private Integer idade;

    /**Construtor
     * Este construtor inicializa todos os campos da classe
     * @param nome -> uma String que representa o nome do aluno;
     * @param idade -> um Integer que representa a idade do aluno;
     */
    public Aluno (String nome, Integer idade)
    {
        this.nome = nome;
        this.idade = idade;
    };//Fim do construtor

    /**---MÉTODOS DE ACESSO--- */

    /**O método getNome() retorna o valor da variável de instância "nome"; 
     * @return nome -> a String que representa o valor da variável.
    */
    public String getNome()
    {
        return this.nome;
    };//Fim do método getNome().

    /**O método getIdade() retorna o valor da variável de instância "idade" 
     * @return idade -> o Integer que representa o valor da variável.
    */
    public Integer getIdade()
    {
        return this.idade;
    };//Fim do método getIdade();

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**O método setNome(String nome) altera o estado da variável de instância "nome"
     * @param nome -> uma String que altera o estado da variável.
     */
    public void setNome(String nome)
    {
        this.nome=  nome;
    };//Fim do método setNome();

    /**O método setIdade(Integer idade) altera o estado da variável de instância "idade".
     * @param idade -> um Integer que altera o estado da variável.
     */
    public void setIdade (Integer idade)
    {
        this.idade = idade;
    };//Fim do método setIdade()

    /**---MÉTODOS--- */

    /**O método toString() sobrescreve o método toString() da superclasse Object e retorna
     * informações sobre a instância.
     */
    public String toString() 
    {
        return String.format("\nNome: %s\nIdade:%d", this.getNome(), this.getIdade());
    };//Fim do método toString();
 };//Fim da classe