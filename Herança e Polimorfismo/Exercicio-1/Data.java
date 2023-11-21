/**A classe faz parte do exercício sobre Herança e Polimorfismo da 
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package Exercicio1;

public class Data {
    /**Campos */
    private Integer dia, mes, ano;

    /**---CONSTRUTORES--- */
    
    /**O construtor inicializa todos os valores das variáveis de instância e valida os valores passados como parâmetros. */
    /**Critérios de validação: */
    /**(a) O ano é condizente com o mês (p.ex.: agosto tem 31 dias); */
    /**(b) O ano é bissexto, logo o dia 29 de fevereiro é possível. */
    /**No caso da data inserida ser inválida a data padrão será: 1/1/2000. */
    /**@param Integer dia -> o dia da data. */
    /**@param Integer mes -> o mês da data. */
    /**@param Integer ano -> o ano da data. */
    public Data (Integer dia, Integer mes, Integer ano)
    {
        /**Verificando a partir do valor do mês */
        switch (mes)
        {
            case 4, 6, 9, 11:
                if (1 <= dia && dia <= 30) 
                {
                    this.dia = dia;
                    this.mes = mes;
                    this.ano = ano;
                } else 
                {
                    this.dia = 1;
                    this.mes = 1;
                    this.ano = 2000;
                }
            break;
            case 1, 3, 5, 7, 8, 10, 12:
                if (1 <= dia && dia <= 31)
                {
                    this.dia = dia;
                    this.mes = mes;
                    this.ano = ano;
                } else 
                {
                    this.dia = 1;
                    this.mes = 1;
                    this.ano = 2000;
                }
            break;
            case 2:
                /**Verifica se o ano é bissexto */
                if (ano % 4 == 0 && ano % 100 != 0) 
                {
                    if (1 <= dia && dia <= 29) 
                    {
                        this.dia = dia;
                        this.mes = mes;
                        this.ano = ano;
                    }
                } else if (ano % 4 == 0 && ano % 100 == 0 && ano % 400 == 0)
                        {
                            if (1 <= dia && dia <= 29) 
                            {
                                this.dia = dia;
                                this.mes = mes;
                                this.ano = ano;
                            }
                        }
                    else {
                        if (1 <= dia && dia <= 28)
                        {
                            this.dia = dia;
                            this.mes = mes;
                            this.ano = ano;
                        } else 
                        {
                            this.dia = 1;
                            this.mes = 1;
                            this.ano = 2000;
                        }
                    }
            break;
            default:
                this.dia = 1;
                this.mes = 1;
                this.ano = 2000;

        }
    };//Fim do construtor

    /**---MÉTODOS DE ACESSO--- */

    /**O método getDia() retorna o dia da data */
    /**@return Integer dia -> o dia da data. */
    public Integer getDia()
    {
        return this.dia;
    };//Fim do método getDia()

    /**O método getMes() retorna o mês da data. */
    /**@return Integer mes -> o mês da data. */
    public Integer getMes ()
    {
        return this.mes;
    };//Fim do método getMes()

    /**O método getAno() retorna o ano da data. */
    /**@return Integer ano -> o ano da data. */
    public Integer getAno ()
    {
        return this.ano;
    };//Fim do método getAno()

    /**---MÉTODOS DE CONFIGURAÇÃO (MODIFICADORES) */

    /**O método setDia() altera o estado da variável de instância 'dia'. */
    /**@param Integer dia -> o valor da variável de instância. */
    public void setDia (Integer dia)
    {
        this.dia = dia;
    };

    /**O método setMes() altera o estado da variável de instância 'mês'. */
    /**@param Integer mes -> o valor da variável de instância. */
    public void setMes (Integer mes)
    {
        this.mes = mes;
    };

    /**O método setAno() altera o estado da variável de instância 'ano'. */
    /**@param Integer ano -> o valor da variável de instância. */
    public void setAno (Integer ano)
    {
        this.ano = ano;
    };

    /**---MÉTODOS--- */

    /**O método toString() retorna uma string com as informações da instância. */
    /**@return String -> uma string formatada com as informações da instância. */
    public String toString ()
    {
        return String.format("\nDia: " + this.dia + "\nMês: " + this.mes + "\nAno: " + this.ano);
    };//Fim do método toString()

}
