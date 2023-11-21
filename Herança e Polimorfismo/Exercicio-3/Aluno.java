
/**Classe que pertence a atividade de estudo dirigido sobre Herança e Polimorfismo
 * da disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 * @see ./Exercicio3/Grau.java
 */
package Exercicio3;

public class Aluno 
{
    /**Campos
     * Os campos da classe são variáveis de instância
     * -nome: String -> nome do aluno;
     * -ga: GrauA -> referência da classe GrauA;
     * -gb: GrauB -> referência da classe GrauB;
     */
    private String nome;
    private GrauA ga;
    private GrauB gb;

    /**Constutores
     * Teremos apenas 1 construtor explícito
     * +Aluno(String nome, GrauA ga, GrauB gb);
     * @param String nome;
     * @param GrauA ga;
     * @param GrauB gb;
     */
    public Aluno (String nome, GrauA ga, GrauB gb)
    {
        this.nome = nome;
        this.ga = ga;
        this.gb = gb;
    };//Fim do construtor

    /**MÉTODOS DE ACESSO
     * +getNome(): String -> retorna o valor da instância 'nome'
     * @return String nome;
     * 
     * +getGa(): GrauA -> retorna o valor da instância 'ga';
     * @return GrauA ga;
     * 
     * +getGb(): GrauB -> retorna o valor da instância 'gb'
     * @return GrauB gb;
     */
    public String getNome()
    {
        return this.nome;
    };//Fim do método getNome()

    public GrauA getGa()
    {
        return this.ga;
    };//Fim do método getGa()

    public GrauB getGb()
    {
        return this.gb;
    };//Fim do método getGb()

    /**MÉTODOS DE CONFIGURAÇÃO
     * +setNome(String nome) -> altera o estado do campo 'nome'
     * @param String nome -> o novo valor do campo;
     * 
     * +setGa(GrauA ga) -> altera o estado do campo 'ga'
     * @param GrauA ga -> o novo valor do campo;
     * 
     * +setGb(GrauB gb) -> altera o estado do campo 'gb'
     * @param GrauB gb -> o novo valor do campo;
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    };//Fim do método setNome()

    public void setGa(GrauA ga)
    {
        this.ga = ga;
    };//Fim do método setGa(GrauA ga)

    public void setGb(GrauB gb)
    {
        this.gb = gb;
    };//Fim do método setGb(GrauB gb)

    /**MÉTODOS
     * +toString(): String -> sobrescreve o método da superclasse 
     * @return String -> uma string formatada com as informações da instância;
     * 
     * +calculaNotaFinal(): Double -> retorna a nota final do aluno
     * @return Double notaFInal -> nota de Grau A, 33% / nota de Grau B, 67%;
     */

    public Double calculaNotaFinal()
    {
        Double notaFinal = (this.getGa().calculaNotaFinalGrau() * 0.33) + (this.getGb().calculaNotaFinalGrau() * 0.67);
        return notaFinal;
    };//Fim do método calculaNotaFinal()

    public String toString()
    {
    	Double notaA = this.getGa().calculaNotaFinalGrau();
    	Double notaB = this.getGb().calculaNotaFinalGrau();
        return String.format("\nNome do aluno: %s\nNota da prova de grau A: %.2f\nNota da prova de grau B: %.2f", this.getNome(), notaA, notaB);
    };//Fim da classe toString();
};//Fim da classe Aluno
