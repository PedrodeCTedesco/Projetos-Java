/**A classe faz parte do exercício sobre Herança e Polimorfismo da
 * disciplina de Laboratório I. É uma subclasse de Cadeira.
 * @author Pedro de Castro Tedesco
 * @version 1.0
 * @since 19/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio1;

public class CadeiraComRodinhas extends Cadeira
{
    private Data lastMaintenanceDate;
    private Cor color;

    public CadeiraComRodinhas (Cor color, Data lastMaintenanceDate)
    {
        super();
        this.color = color;
        this.lastMaintenanceDate = lastMaintenanceDate;
    };//Fim do construtor

    //query methods
    public Data getLastMaintenanceDate()
    {
        return lastMaintenanceDate;
    };//end of getLastMaintenanceDate();

    public Cor getChairColor()
    {
        return color;
    }

    //configuration methods
    public void setLastMaintenanceDate (Data lastMaintenanceDate)
    {
        this.lastMaintenanceDate = lastMaintenanceDate;
    };//end of setLastMaintenanceDate();

    public void setChairColor(Cor color)
    {
        this.color = color;
    };//end of setChairColor()

    @Override
    public String toString()
    {
        return String.format("%nData da última manutenção: " + getLastMaintenanceDate());
    };//end of toString() methods
}
