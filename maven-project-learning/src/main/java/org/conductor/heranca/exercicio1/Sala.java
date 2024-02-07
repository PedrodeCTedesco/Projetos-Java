/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I.
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.heranca.exercicio1;

public class Sala
{
    /**Campos
     * Todos os campos são variáveis de instância
     * -nome:String -> o nome da sala;
     * -cadeira1:Cadeira -> uma cadeira da sala;
     * -cadeira2:Cadeira -> uma cadeira da sala;
     * -cadeira3:Cadeira -> uma cadeira da sala;
     * -cadeira4:Cadeira -> uma cadeira da sala;
     */
    private String nome;
    private Cadeira cadeira1, cadeira2, cadeira3, cadeira4;
    public Sala (String nome, Cadeira cadeira1, Cadeira cadeira2, Cadeira cadeira3, Cadeira cadeira4)
    {
        this.nome = nome;
        this.cadeira1 = cadeira1;
        this.cadeira2 = cadeira2;
        this.cadeira3 = cadeira3;
        this.cadeira4 = cadeira4;
    };//Fim do construtor

    public String getNome()
    {
        return this.nome;
    };//Fim do método getNome()

    /**O método getCadeira1() retorna o valor da variável de instância "cadeira1"
     * @return Cadeira cadeira1 -> a cadeira1;
     */
    public Cadeira getCadeira1()
    {
        return this.cadeira1;
    };//Fim do método getCadeira1();

    /**O método getCadeira2() retorna o valor da variável de instância "cadeira2"
     * @return Cadeira cadeira2 -> a cadeira2;
     */
    public Cadeira getCadeira2()
    {
        return this.cadeira2;
    };//Fim do método getCadeira2();

    /**O método getCadeira3() retorna o valor da variável de instância "cadeira3"
     * @return Cadeira cadeira3 -> a cadeira3;
     */
    public Cadeira getCadeira3()
    {
        return this.cadeira3;
    };//Fim do método getCadeira3();

    /**O método getCadeira4() retorna o valor da variável de instância "cadeira4"
     * @return Cadeira cadeira4 -> a cadeira4;
     */
    public Cadeira getCadeira4()
    {
        return this.cadeira4;
    };//Fim do método getCadeira4();

    public void setNome(String nome)
    {
        this.nome = nome;
    };//Fim do método setNome(String nome)

    public void setCadeira1(Cadeira cad1)
    {
        this.cadeira1 = cad1;
    };//Fim do método setCadeira1(Cadeira cad1)

    public void setCadeira2(Cadeira cad2)
    {
        this.cadeira2 = cad2;
    };//Fim do método setCadeira2(Cadeira cad2)

    public void setCadeira3(Cadeira cad3)
    {
        this.cadeira3 = cad3;
    };//Fim do método setCadeira3(Cadeira cad3)

    public void setCadeira4(Cadeira cad4)
    {
        this.cadeira4 = cad4;
    };//Fim do método setCadeira4(Cadeira cad4)

    public Integer cadeirasComMesaDisponiveis ()
    {
        /**Variáveis locais
         * -cadeiraMesa:Integer -> quantidade de cadeiras com mesa
         */
        Integer cadeiraMesa = 0;

        /**Sentenças de seleção que avaliam se a instância armazenada nas variáveis
         * de instância da classe Sala são do tipo da subclasse CadeiraComMesa
         */

        if (this.getCadeira1() instanceof CadeiraComMesa)
        {
            cadeiraMesa++;
        };

        if (this.getCadeira2() instanceof CadeiraComMesa)
        {
            cadeiraMesa++;
        };

        if (this.getCadeira3() instanceof CadeiraComMesa)
        {
            cadeiraMesa++;
        };

        if (this.getCadeira4() instanceof CadeiraComMesa)
        {
            cadeiraMesa++;
        };

        return cadeiraMesa;

    };//Fim do método cadeirasComMesaDisponiveis()

    /**O método cadeirasComRodinhaDisponives() retorna a quantidade de cadeiras com rodinhas disponíveis na sala, i.e.,
     * onde os alunos possam sentar
     * @return Integer mesasDisponiveis -> a quantidade de mesas disponíveis
     */
    public Integer cadeirasComRodinhasDisponiveis ()
    {
        /**Variáveis locais
         * -cadeiraMesa:Integer -> quantidade de cadeiras com mesa
         */
        Integer cadeiraRodinha = 0;

        /**Sentenças de seleção que avaliam se a instância armazenada nas variáveis
         * de instância da classe Sala são do tipo da subclasse CadeiraComRodinhas
         */

        if (this.getCadeira1() instanceof CadeiraComRodinhas)
        {
            cadeiraRodinha++;
        };

        if (this.getCadeira2() instanceof CadeiraComRodinhas)
        {
            cadeiraRodinha++;
        };

        if (this.getCadeira3() instanceof CadeiraComRodinhas)
        {
            cadeiraRodinha++;
        };

        if (this.getCadeira4() instanceof CadeiraComRodinhas)
        {
            cadeiraRodinha++;
        };

        return cadeiraRodinha;

    };//Fim do método cadeirasComRodinhaDisponives()

    public void entraAluno(Aluno aluno, String opcaoCadeira)
    {
        /**Variáveis */

        Integer contadorCadeiraMesa = this.cadeirasComMesaDisponiveis();
        /*         Integer contadorCadeiraRodinhas = this.cadeirasComRodinhasDisponiveis(); */


        /**Verificar se há cadeiras disponíveis */

        if (opcaoCadeira == "Mesa" || opcaoCadeira == "mesa")
        {
            System.out.println("O aluno " + aluno.getName() + " está sentado em uma cadeira de mesa.");
            contadorCadeiraMesa--;
            System.out.print("\nCadeiras com mesa restantes: " + contadorCadeiraMesa);

        } else {
            System.out.println("\nNão há cadeiras disponíveis.");
        }//Fim do if...else
    };//Fim do método entraAluno(Aluno aluno, String tipoDeCadeira)

    /**O métoo toString() sobrescreve o método da superclasse Object
     * e retorna as informações da instância
     */
    public String toString()
    {
        return String.format("\nNome da sala: " + this.getNome() + "\nPrimeira cadeira: " + this.getCadeira1() + "\nSegunda cadeira: " + this.getCadeira2() + "\nTerceira cadeira: " + this.getCadeira3() + "\nQuarta cadeira: " + this.getCadeira4());
    };//Fim do método toString()
}
