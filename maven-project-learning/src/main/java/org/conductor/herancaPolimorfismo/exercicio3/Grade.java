/**Classe que integra o exercício 3 do estudo dirigido em herança e polimorfismo
 * da disciplina de Laboratório I da Unisinos
 * @author Pedro de Castro Tedesco
 * @since 23/10/2023
 */

package org.conductor.herancaPolimorfismo.exercicio3;

public class Grade
{
    private String entryDate;
    private String checkoutDate;

    //Constructors
    public Grade (String entryDate, String checkoutDate)
    {
        this.entryDate = entryDate;
        this.checkoutDate = checkoutDate;
    };

    public Grade ()
    {
        this(null, null);
    };

    //query methods
    public String getEntryDate()
    {
        return entryDate;
    };

    public String getCheckoutDate()
    {
        return checkoutDate;
    };

    //configuration methods
    public void setEntryDate (String entryDate) {
        this.entryDate = entryDate;
    };
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    };

    //client methods
    @Override
    public String toString()
    {
        return String.format("%nData de começo: %s%nData de fim: %s", getEntryDate(), getCheckoutDate());
    };
};//end of Grade class
