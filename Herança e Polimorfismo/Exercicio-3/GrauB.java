package Exercicio3;
/**Classe que pertence ao exercício 3 do estudo dirigido
 * da disciplina de Laboratório 1.
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 * @see ./Exercicio3/Grau.java
 */

public class GrauB extends Grau
{
    /**Campos
     * Todos os campos são variáveis de instância:
     * -notaAtividade: Double -> nota da atividade;
     * -notaSeminario: Double -> nota do seminário;
     * -notaParticipacao: Double -> nota de participação;
     */
    private Double notaAtividade, notaSeminario, notaParticipacao;

    /**Construtores
     * Os dois construtores respectivamente:
     * +GrauB(String dataComeco, String dataFim, Double notaAtividade, Double notaSeminario, Double notaParticipacao) ->inicializa todos os campos;
     * @param String dataComeco -> campo da superclasse;
     * @param String dataFim -> campo da superclasse;
     * @param Double notaAtividade -> campo da instância;
     * @param Double notaSeminario -> campo da instância;
     * @param Double notaParticipacao -> campo da instância;
     * 
     * +GrauB() -> inicializa os campos da classe como 0.0.
     */
    public GrauB (String dataComeco, String dataFim, Double notaAtividade, Double notaSeminario, Double notaParticipacao)
    {
        super(dataComeco, dataFim);
        this.notaAtividade = notaAtividade;
        this.notaSeminario = notaSeminario;
        this.notaParticipacao = notaParticipacao;
    };//Fim do construtor

    public GrauB ()
    {
        this.notaAtividade = 0.0;
        this.notaSeminario = 0.0;
        this.notaParticipacao = 0.0;
    };//Fim do construtor

    /**MÉTODOS DE ACESSO
     * +getNotaAtividade(): Double -> retorna o valor do campo notaAtividade
     * @return Double notaAtividade;
     * 
     * +getNotaSeminario(): Double -> retorna o valor do campo notaSeminario;
     * @return Double notaSeminario;
     * 
     * +getNotaParticipacao(): Double -> retorna o valor do campo notaParticipacao;
     * @return Double notaParticipacao;
     */
    public Double getNotaAtividade()
    {
        return this.notaAtividade;
    };//Fim do método getNotaAtividade()

    public Double getNotaSeminario()
    {
        return this.notaSeminario;
    };//Fim do método getNotaSeminario()

    public Double getNotaParticipacao()
    {
        return this.notaParticipacao;
    };//Fim do método getNotaParticipacao();

    /**MÉTODOS DE CONFIGURAÇÃO
     * +setNotaAtividade(Double nota) -> altera o valor do campo da instância
     * @param Double nota -> o novo valor do campo 'notaAtividade';
     * 
     * +setNotaSeminario(Double nota) -> altera o valor do campo da instância
     * @param Double nota -> o novo valor do campo 'notaSeminario';
     * 
     * +setNotaParticipacao(Double nota) -> altera o valor do campo da instância
     * @param Double nota -> o novo valor do campo 'notaParticipacao';
     */
    public void setNotaAtividade(Double nota)
    {
        this.notaAtividade = nota;
    };//Fim do método setNotaAtividade(Double nota)

    public void setNotaSeminario(Double nota)
    {
        this.notaSeminario = nota;
    };//Fim do método setNotaSeminario(Double nota)

    public void setNotaParticipacao(Double nota)
    {
        this.notaParticipacao = nota;
    };//Fim do método setNotaParticipacao (Double nota)

    /**MÉTODOS
     * +toString(): String -> sobrescreve o método da superclasse
     * @return String -> uma string formatada com as informações da instância;
     * 
     * +calculaNotaFinalGrau(): Double -> retorna o valor da nota final do grau B;
     * @return Double notaFinal -> nota de atividade, 30% / nota de seminário, 60% / nota de participação, 10%;
     */
    public String toString()
    {
        return String.format("\nNota da atividade: %f\nNota do seminário: %f\nNota de participação: %f", this.getNotaAtividade(), this.getNotaSeminario(), this.getNotaParticipacao());
    };//Fim do método toString()

    public Double calculaNotaFinalGrau()
    {
        Double notaFinal = (this.getNotaAtividade() * 0.3) + (this.getNotaSeminario() * 0.6) + (this.getNotaParticipacao() * 0.1);
        return notaFinal;
    };//Fim do método calculaNotaFinalGrau()
};//Fim da classe
