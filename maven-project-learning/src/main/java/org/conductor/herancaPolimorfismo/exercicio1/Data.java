/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio1;

public class Data
{
    private int dia;
    private int mes;
    private int ano;

    public Data (int dia, int mes, int ano)
    {
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

    public int getDia()
    {
        return this.dia;
    };//Fim do método getDia()

    public int getMes ()
    {
        return this.mes;
    };//Fim do método getMes()

    public int getAno ()
    {
        return this.ano;
    };//Fim do método getAno()

    public void setDia (Integer dia)
    {
        this.dia = dia;
    };

    public void setMes (Integer mes)
    {
        this.mes = mes;
    };

    public void setAno (Integer ano)
    {
        this.ano = ano;
    };

    @Override
    public String toString ()
    {
        return String.format("%nDia: " + this.dia + "%nMês: " + this.mes + "%nAno: " + this.ano);
    };//Fim do método toString()
}
