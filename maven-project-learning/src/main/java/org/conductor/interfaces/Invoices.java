/** This class implements Payable
 * @author pedro de castro tedesco
 * @see Java: how to program (Deitel and Deitel, 10ªed, chapter 10)
 * @since 09/02/2024
 * */

package org.conductor.interfaces;

public class Invoices implements Payable
{
    //Fields
    private final String partNumber;
    private final String partDescription;
    private int quantity;
    private double pricePerItem;

    //Constructor
    public Invoices(String partNumber, String partDescription, int quantity, double pricePerItem)
    {
        //check the value of quantity and pricePerItem
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity must be >= 0");

        if (pricePerItem < 0.0)
            throw new IllegalArgumentException("Price per item must be >= 0.0");

        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    };//end of constructor;

    //Query methods
    public String getPartNumber()
    {
        return partNumber;
    };//end of getPartNumber();

    public String getPartDescription()
    {
        return partDescription;
    };//end of getPartDescription();

    public int getQuantity()
    {
        return quantity;
    };//end of getQuantity();

    public double getPricePerItem()
    {
        return pricePerItem;
    };//end of getPricePerItem();

    //Configuration methods
    public void setQuantity(int quantity)
    {
        //check the value of quantity and pricePerItem
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity must be >= 0");
        this.quantity = quantity;
    };//end of setQuantity(int quantity);

    public void setPricePerItem(double pricePerItem)
    {
        if (pricePerItem < 0.0)
            throw new IllegalArgumentException("Price per item must be >= 0.0");
        this.pricePerItem = pricePerItem;
    };//end of setPricePerItem(double pricePerItem();

    //Client methods
    @Override
    public String toString()
    {
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem());
    };//end of toString();

    @Override
    public double paymentAmount()
    {
        //Return total cost
        return getQuantity() * getPricePerItem();
    };//end of getPaymentAmount();

};//end of Invoices implements Payable
