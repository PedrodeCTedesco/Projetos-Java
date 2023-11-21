package Exercicio3;
/**Esta classe pertence ao estudo dirigido sobre Herança e Polimorfismo
 * da disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 * @see ./Exercicio3/Grau.java
 */

public class Turma 
{
    /**Campos
     * Todos os campos são variáveis de instância
     * -codigo: String -> código da turma;
     * -a1: Aluno -> um aluno da turma;
     * -a2: Aluno -> um aluno da turma;
     * -a3: Aluno -> um aluno da turma;
     */
    private String codigo;
    private Aluno a1, a2, a3;

    /**Construtores
     * +Turma(String codigo, Aluno a1, Aluno a2, Aluno a3)
     * @param String codigo;
     * @param Aluno a1;
     * @param Aluno a2;
     * @param Aluno a3;
     */
    public Turma (String codigo, Aluno a1, Aluno a2, Aluno a3)
    {
        this.codigo = codigo;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    };//Fim do construtor

    /**MÉTODOS DE ACESSO 
     * +getCodigo(): String -> retorna o código da turma
     * @return String codigo;
    */
    public String getCodigo()
    {
        return this.codigo;
    };//Fim do método getCodigo()


    /**MÉTODOS
     * +mediaNotasTurma(): Double -> retorna a média de nota (nota final) de todos os alunos da turma, ou retorna -1.0 se não existir alunos na turma
     * @return Double notaFinal -> média de nota da turma || -1.0 (caso não existam alunos na turma)
     * 
     * +alteraNotasGrauA(String nome, Double nota1, Double nota2) -> altera as notas de grau A do aluno
     * @param String aluno -> o nome do aluno;
     * @param Double nota1 -> o novo valor da nota de trabalho do grau A;
     * @param Double nota2 -> o novo valor da nota da prova do grau A;
     * 
     * +alteraNotasGrauB(String aluno, Double nota1, Double nota2, Double nota3) -> altera as notas de grau B do aluno
     * @param String aluno -> o nome do aluno;
     * @param Double nota1 -> o novo valor da nota de atividade;
     * @param Double nota2 -> o novo valor da nota de seminário;
     * @param Double nota3 -> o novo valor da nota de participação;
     * 
     * +toString(): String -> sobrescreve o método da superclasse
     * @return String -> uma string com informações da instância.
     */
    public Double mediaNotasTurma()
    {
        if (this.a1.getNome().equals(a1.getNome()) && this.a2.getNome().equals(a2.getNome()) && this.a3.getNome().equals(a3.getNome()) == false)
        {
            return -1.0;
        } else
        {
            Double notaFinal = (this.a1.calculaNotaFinal() + this.a2.calculaNotaFinal() + this.a3.calculaNotaFinal()) / 3;
            return notaFinal;
        }//Fim do if...else
    };//Fim do método mediaNotasTurma();

    public void alteraNotasGrauA(String aluno, Double nota1, Double nota2)
    {
        if (aluno == a1.getNome()) 
        {
            a1.getGa().setNotaTrabalho(nota1);
            a1.getGa().setNotaProva(nota2);
        } else if (aluno == a2.getNome())
        {
            a2.getGa().setNotaTrabalho(nota1);
            a2.getGa().setNotaProva(nota2);
        } else if (aluno == a3.getNome())
        {
            a3.getGa().setNotaTrabalho(nota1);
            a3.getGa().setNotaProva(nota2);
        } else 
        {
            System.out.print("Não há alunos com esse nome na turma. Os alunos são: " + a1.getNome() + "\n" + a2.getNome() + "\n" + a3.getNome());
        }
    };//Fim do método alteraNotasGrauA(String aluno, Double nota1, Double nota2)

    public void alteraNotasGrauB (String aluno, Double nota1, Double nota2, Double nota3)
    {
        if (aluno == a1.getNome())
        {
            a1.getGb().setNotaAtividade(nota1);
            a1.getGb().setNotaSeminario(nota2);
            a1.getGb().setNotaParticipacao(nota3);
        } else if (aluno == a2.getNome())
        {
            a2.getGb().setNotaAtividade(nota1);
            a2.getGb().setNotaSeminario(nota2);
            a2.getGb().setNotaParticipacao(nota3);
        } else if (aluno == a3.getNome())
        {
            a3.getGb().setNotaAtividade(nota1);
            a3.getGb().setNotaSeminario(nota2);
            a3.getGb().setNotaParticipacao(nota3);
        } else 
        {
            System.out.print("Não há alunos com esse nome na turma. Os alunos são: " + a1.getNome() + "\n" + a2.getNome() + "\n" + a3.getNome());
        }
    };//Fim do método alteraNotasGrauB(String aluno, Double nota1, Double nota2, Double nota3)

    public String toString()
    {
        return String.format("Informações da turma:\nCódigo da turma: %s\nAlunos: %s\n%s\n%s", this.getCodigo(), this.a1.getNome(), this.a2.getNome(), this.a3.getNome());
    }

};//Fim da classe Turma
