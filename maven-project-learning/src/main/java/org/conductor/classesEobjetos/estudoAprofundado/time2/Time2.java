/**Essa classe é utilizada como demonstração do funcionamento de construtores sobrecarregados
 * @author pedro de castro tedesco
 * @link "Java: Como programar" (Deitel e Deitel, cap. 8)
 * @since 22/12/2023
 * */

package org.conductor.classesEobjetos.estudoAprofundado.time2;

public class Time2
{
    /**CAMPOS. Todos são variáveis de instância
     * -hour: int --> hora entre 0 e 23.
     * -minute: int --> minutos entre 0 e 59.
     * -second: int --> segundos entre 0 e 59.
     * */
    private int hour;
    private int minute;
    private int second;

    /**CONSTRUTORES.
     * Temos 5 construtores que permitem a inicialização de uma instância de formas diferentes a depender das escolhas
     * do cliente da classe.
     * +Time2(): object --> não recebe parâmetros e inicializa todas as variáveis com os valores padrão
     * +Time2(int hour): object --> recebe apenas o parâmetro de hora e os demais são inicializados com os valores padrão
     * +Time2(int hour, int minute): object --> recebe dois parâmetros e deixa os segundos inicializados com o valor padrão.
     * +Time2(int hour, int minute, int second): object --> recebe todos os parâmetros e inicializa o objeto
     * +Time2(Time2 time): object --> recebe um objeto Time2 como parâmetro para inicializar os horários.
     * */
    public Time2()
    {
        this(0, 0 , 0); //Invoca o construtor com 3 parâmetros.
    };//fim do construtor

    public Time2 (int hour)
    {
        this(hour, 0, 0);
    };//fim do construtor

    public Time2(int hour, int minute)
    {
        this(hour, minute, 0);
    };//fim do construtor

    public Time2(int hour, int minute, int second)
    {
        //Verifica cada um dos parâmetros para avaliar se os valores passados são válidos
        if (hour < 0 || hour >= 24)
        {
            throw new IllegalArgumentException("Hour must be 0-23");
        };//fim da sentença de seleção condicional simples

        if (minute < 0 || minute >= 60)
        {
            throw new IllegalArgumentException("Minute must be 0-59");
        };//fim da sentença de seleção condicional simples

        if (second < 0 || second >= 60)
        {
            throw new IllegalArgumentException("Second must be 0-59");
        };//fim da sentença de seleção condicional simples

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    };//fim do construtor

    public Time2(Time2 time)
    {
        this(time.getHour(), time.getMinute(), time.getSecond());
    };//fim do construtor

    /**MÉTODOS DE ACESSO
     * +getHour(): int --> retorna o valor da hora.
     * @return int
     *
     * +getMinute(): int --> retorna o valor do minuto
     * @return int
     *
     * +getSecond(): int --> retorna o valor do segundo
     * @return int
     * */
    public int getHour()
    {
        //Aqui o uso de this explícito é opcional
        return this.hour;
    };//fim do método getHour()

    public int getMinute()
    {
        //Aqui o uso de this é implícito
        return minute;
    };//fim do método getMinute()

    public int getSecond()
    {
        return second;
    };//fim do método getSecond()

    public void setHour(int hour)
    {
        if(hour < 0 || hour >= 24)
        {
            throw new IllegalArgumentException("Hour must be 0-23");
        };//fim da sentença de seleção condicional simples

        //Como o identificador do parâmetro é idêntico ao nome do campo da classe temos que utilizar this de forma explícita
        this.hour = hour;
    };//fim do método setHour(int hour);

    public void setMinute(int minute)
    {
        if (minute < 0 || minute >= 60)
        {
            throw new IllegalArgumentException("Minute must be 0-59");
        };//fim da sentença de seleção condicional simples

        //Como o identificador do parâmetro é idêntico ao nome do campo da classe temos que utilizar this de forma explícita
        this.minute = minute;
    };//fim do método setMinute(int minute);

    public void setScond(int second)
    {
        if(second < 0 || second >= 60)
        {
            throw new IllegalArgumentException("Second must be 0-59");
        };//fim da sentença de seleção condicional simples

        //Como o identificador do parâmetro é idêntico ao nome do campo da classe temos que utilizar this de forma explícita
        this.second = second;
    };//fim do método setSecond(int second)

    /**MÉTODOS
     * +toUniversalString(): String --> retorna uma String no formato universal de data/hora
     * @return String
     *
     * +toString(): String --> retorna uma String no formato padrão de data (H:MM:SS AM/PM)
     * @return String
     * */
    public String toUniversalString()
    {
        //Na invocação dos métodos poderíamos utilizar this.getHour() (explícito).
        //Porém como no corpo do método não há variáveis locais com identificador idêntico aos do campo a chamada this é implícita.
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    };//fim do método toUniversalString()

    public String toString()
    {
        //Aqui temos a utilização da referência this explícita e implícita apenas para demonstrar essa possibilidade
        return String.format("%d:%02d:%02d %s", (getHour() == 0 || getHour() == 12 ? 12 : getHour() % 12), getMinute(), this.getSecond(), (this.getHour() < 12 ? "AM" : "PM"));
    };//fim do método toString();
}
