/**Classe de exemplo de conceitos aprofundados de classes e objetos em Java.
 * @author pedro de castro tedesco
 * @link "Java: Como programar" (Deitel e Deitel, 10ª ed)
 * @since 21/12/2023*/

/* A classe Time1 mantém a data e hora no formato 24 horas */


package org.conductor.classesEobjetos.estudoAprofundado.time;

public class Time1
{
    /**CAMPOS. Todos são variáveis de instância.
     * -hour:int --> retorna a hora entre 0 e 23.
     * -minute: int --> retorna os minutos no formato 0 - 59.
     * -second: int --> retorna os segundos no formato 0 - 59.
     * */
    private int hour;
    private int minute;
    private int second;

    public void setTime1(int hour, int minute, int second)
    {
        //Validação da hora, minuto e segundo
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60)
        {
            throw new IllegalArgumentException("Hour, minute and/or second was out of range.");
        };//fim da sentença de seleção condicional simples

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    };//fim do método setTime1(int hour, int minute, int second);

    public String toUniversalString()
    {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    };//fim do método toUniversalString();

    @Override
    public String toString()
    {
        return String.format("%d:%02d:%02d %s", ((hour == 0 || hour == 12) ? 12 : hour % 12), minute, second, (hour < 12 ? "AM" : "PM"));
    };// fim do método toString();
}
