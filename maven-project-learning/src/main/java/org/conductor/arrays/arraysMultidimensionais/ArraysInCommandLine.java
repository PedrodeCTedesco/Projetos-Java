package org.conductor.arrays.arraysMultidimensionais;

public class ArraysInCommandLine
{
    public static void main (String[] args)
    {
        //check the numbers of args from the command line
        if (args.length != 3)
        {
            System.out.printf("Error: please re-enter the entire command, including%n" +
                    "an array size, initial value and increment%n");
        } else
        {
            //the size of the array will be given by the first arg from command line
            int arrayLength = Integer.parseInt(args[0]);
            int[] arr = new int[arrayLength];

            //gets the initial value and increments (the value of the increment came from the args from command line
            int initialValue = Integer.parseInt(args[1]);
            int increment = Integer.parseInt(args[2]);

            //get the value for each array element
            for (int counter = 0; counter < arr.length; counter += 1)
            {
                arr[counter] = initialValue + increment * counter;
            };//end of the iteration sentence (for)

            System.out.printf("%s%8s%n", "Index", "Valor");

            //prints array index and value
            for (int counter = 0; counter < arr.length; counter += 1)
            {
                System.out.printf("%5d%8d%n", counter, arr[counter]);
            };//end of iteration sentence (for)
        }
    };//end of main method
};//end of the class
