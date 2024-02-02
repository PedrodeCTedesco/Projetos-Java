package org.conductor.herancaPolimorfismo.exercicio2;

public class Rectangle extends Figure
{
    private double base;
    private double height;

    //constructors
    public Rectangle (double x, double y, double base, double height)
    {
        super(x, y);
        this.base = base;
        this.height = height;
    };

    public Rectangle (double base, double height)
    {
        this.base = base;
        this.height = height;
    };

    public Rectangle (){};

    //query methods
    public double getBase()
    {
        return base;
    };

    public double getHeight()
    {
        return height;
    };

    //configuration methods
    public void setBase (double base)
    {
        this.base = base;
    };

    public void setHeight (double height)
    {
        this.height = height;
    };

    //client methods
    public double rectangleArea()
    {
        return getBase() * getHeight();
    };

    @Override
    public String toString()
    {
        return String.format("%nBase do retângulo: " + getBase() + "%nAltura do retângulo: " + getHeight());
    };//Fim do método

};//end of Rectangle class
