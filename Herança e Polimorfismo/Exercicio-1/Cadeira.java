/**A classe faz parte do exercício sobre Herança e Polimorfismo da 
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package Exercicio1;

public class Cadeira 
{
    /**Campos 
     * Todos os campos são variáveis de instância.
     * -cor:Cor -> um campo cujo tipo é uma Cor que representa a cor da cadeira do aluno.
     * -aluno:Aluno -> um campo cujo tipo é um Aluno que representa qual o aluno que está ocupando a cadeira.
    */
    private Cor cor;
    private Aluno aluno;

    /**Construtores
     * Este construtor inicializa uma cadeira sem ocupantes.
     * @param Cor cor -> a cor da cadeira.
     */
    public Cadeira (Cor cor)
    {
        this.cor = cor;
        this.aluno = null;
    };//Fim do construtor

    /**---MÉTODOS DE ACESSO--- */

    /**o método getCor() retorna uma instância do tipo Cor que representa a cor da cadeira do Aluno
     * @return Cor cor -> o valor da em RGB que representa a cor da cadeira do aluno
     */
    public Cor getCor()
    {
        return this.cor;
    };//Fim do método getCor()

    /**O método getAluno() retorna uma instância do tipo Aluno que representa o aluno que está ocupando a cadeira
     * @return Aluno aluno -> o aluno que ocupa a cadeira
     */
    public Aluno getAluno()
    {
        return this.aluno;
    };//Fim do método getAluno()

    /**---MÉTODOS DE CONFIGURAÇÃO--- */

    /**O método setCor(Cor cor) altera o estado do campo Cor da variável de instância
     * @param Cor cor -> a nova cor da cadeira
     */
    public void setCor(Cor cor)
    {
        this.cor = cor;
    };//Fim do método setCor (Cor cor)

    /**O método setAluno (Aluno aluno) altera o estado do campo Aluno da variável de instância
     * @param Aluno aluno -> o aluno que ocupa a cadeira
     */
    public void setAluno (Aluno aluno)
    {
        this.aluno = aluno;
    };//Fim do método setAluno(Aluno aluno)

    /**---MÉTODOS--- */

    /**O método toString() sobrescreve o método da superclasse Object e retorna
     * as informações da instância
     */
    public String toString()
    {
        return String.format("\nCor da cadeira: " + this.getCor() + "\nAluno que a ocupa: " + this.getAluno());
    };//Fim do método toString()

};//Fim da classe Cadeira
