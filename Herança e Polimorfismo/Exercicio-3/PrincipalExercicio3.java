
import Exercicio3.Aluno;
import Exercicio3.GrauA;
import Exercicio3.GrauB;
import Exercicio3.Turma;
import Exercicio3.Grau;

public class PrincipalExercicio3 
{
    public static void main (String[] args)
    {
        /**Aluno 1 */
        GrauA ga1 = new GrauA("02/06/1992", "05/12/2000", 4.5, 7.8);
        GrauB gb1 = new GrauB("04/06/1999", "12/12/2000", 5.7, 9.0, 2.5);
        Aluno a1 = new Aluno ("Pedro", ga1, gb1);

        /**Aluno 2 */
        GrauA ga2 = new GrauA("04/06/1222", "05/09/2000", 7.7, 8.9);
        GrauB gb2 = new GrauB();
        Aluno a2 = new Aluno ("Eduarda", ga2, gb2);

        /**Aluno 3 */
        GrauA ga3 = new GrauA ("04/05/2010", "03/11/2023", 7.8, 9.2);
        GrauB gb3 = new GrauB ("02/12/2020", "12/11/2040", 8.8, 4.3, 5.1);
        Aluno a3 = new Aluno ("Lorenzo", ga3, gb3);

        Turma turma = new Turma ("3036", a1, a2, a3);

        /**Média de notas */
        System.out.printf("A média de notas da turma é: %.2f", turma.mediaNotasTurma());
        
        /**Sabendo que a média de aprovação é 6.0, imprima uma mensagem dizendo:
         * [nome do aluno] passou por média / ou 
         * [nome do aluno; ficou em grau C 
         */
        if (a1.calculaNotaFinal() >= 6.0)
        {
        	System.out.print(a1.getNome() + ": passou por média!");
        } else
        {
        	System.out.println(a1.getNome() + ": ficou em grau C.");
        }
        
        if (a2.calculaNotaFinal() >= 6.0)
        {
        	System.out.print(a2.getNome() + ": passou por média!");
        } else
        {
        	System.out.println(a2.getNome() + ": ficou em grau C.");
        }
        
        if (a3.calculaNotaFinal() >= 6.0)
        {
        	System.out.print(a3.getNome() + ": passou por média!");
        } else
        {
        	System.out.println(a3.getNome() + ": ficou em grau C.");
        }
    };//Fim do main
}
