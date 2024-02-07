package org.conductor.heranca.exercicio2;

public class Circle extends Figure
{
    private double radius;

    public Circle (double x, double y, double radius)
    {
        super(x, y);
        this.radius = radius;
    };

    public Circle (double radius) {
        this.radius = radius;
    };

    public Circle(){};

    //query methods
    public double getRadius()
    {
        return radius;
    };

    //configuration methods
    public void setRadius(double radius)
    {
        this.radius = radius;
    };

    //client methods
    public double circleArea()
    {
        return Math.PI * (getRadius() * getRadius());
    };

    @Override
    public String toString()
    {
        return String.format("%nThe circle with radius equal %.2f has an area of %.2f: " + getRadius(), circleArea());
    };

}
