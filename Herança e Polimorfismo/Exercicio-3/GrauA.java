
/**Classe relativa ao exercício 3 do estudo dirigido da disciplina Laboratório I
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 * @see Exercicio3/Grau.java
 */

package Exercicio3;

public class GrauA extends Grau
{
    /**Campos
     * Os campos são variáveis de instância.
     * -notaTrabalho: Double -> a nota do trabalho.
     * -notaProva: Double -> a nota da prova
     */
    private Double notaTrabalho, notaProva;

    /**Construtores
     * Teremos dois construtores, respectivamente:
     * +GrauA(String dataComeco, String dataFim, Double notaTrabalho, Double notaProva) -> inicializa todos os campos
     * +GrauA() -> inicializa os campos da classe como 0.
     */
    public GrauA (String dataComeco, String dataFim, Double notaTrabalho, Double notaProva)
    {
        super(dataComeco, dataFim);
        this.notaTrabalho = notaTrabalho;
        this.notaProva = notaProva;
    };//Fim do construtor

    public GrauA()
    {
        this.notaTrabalho = 0.0;
        this.notaProva = 0.0;
    }; //Fim do construtor

    /**MÉTODOS DE ACESSO
     * +getNotaTrabalho(): Double -> este método retorna o valor da nota do trabalho.
     * @return Double notaTrabalho;
     * 
     * +getNotaProva(): Double -> este método retorna o valor da nota da prova.
     * @return Double notaProva;
     */
    public Double getNotaTrabalho()
    {
        return this.notaTrabalho;
    };//Fim do método getNotaTrabalho()

    public Double getNotaProva()
    {
        return this.notaProva;
    };//Fim do método getNotaProva()

    /**MÉTODOS DE CONFIGURAÇÃO
     * +setNotaTrabalho(Double nota) -> altera o valor da nota de trabalho.
     * @param Double nota -> o novo valor da nota do trabalho 
     * 
     * +setNotaProva(Double nota) -> altera o valor da nota da notaProva
     * @param Double nota -> o novo valor da nota da prova.
     */
    public void setNotaTrabalho(Double nota)
    {
        this.notaTrabalho = nota;
    };//Fim do método setNotaTrabalho(Double nota)

    public void setNotaProva(Double nota)
    {
        this.notaProva = nota;
    };//Fim do método setNotaProva(Double nota)

    /**MÉTOOS
     * +toString(): String -> sobrescreve o método da superclasse 
     * @return Uma string com as informações da instância;
     * 
     * +calculaNotaFinalGrau(): Double -> retorna a nota do grau A (nota do trabalho, 30%; nota da prova, 70%);
     * @return notaFinal -> o valor da nota final. 
     */
    public String toString()
    {
        return String.format("\nNota do trabalho: %f\nNota da prova: %f", this.getNotaTrabalho(), this.getNotaProva());
    };//Fim do método toString()
    
    public Double calculaNotaFinalGrau()
    {
        Double notaFinal = (this.getNotaTrabalho() * 0.3) + (this.getNotaProva() * 0.7);
        return notaFinal;
    };//Fim do método calculaNotaFinal();

};//Fim da classe GrauA
