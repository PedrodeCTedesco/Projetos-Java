/** Crie uma classe Date com as seguintes capacidades:
a) Gerar saída da data em múltiplos formatos, como
 MM/DD/YYYY 
 June 14, 
 
 *Utilizar construtores sobrecarregados para criar objetos Date inicializados com datas dos formatos na parte (a). No primeiro caso, o 
construtor deve receber três valores inteiros. No segundo caso, deve receber uma String e dois valores inteiros. No terceiro caso, deve 
receber dois valores inteiros, o primeiro representando o número de dias no ano. [Dica: para converter a representação de String do 
mês em um valor numérico, compare as Strings utilizando o método equals. Por exemplo, se s1 e s2 forem strings, a chamada 
de método s1.equals(s2) retornará true se as strings forem idênticas, caso contrário retornará false.
 */

public class DataTest
{
	public static void main(String[]args)
	{
		System.out.printf("Testing constructor number 1%n");
		Data d1 = new Data(2, 6, 1992);
		
		
	};//fim do métdo main
};//fim da classe DataTest

class Data
{
	private int day_integer;
	private int month_integer;
	private int year_integer;
	private int number_of_days;
	private String month_string;
	
	public Data(int day, int month, int year)
	{
		day_integer = day;
		month_integer = month;
		year_integer = year;
	};//fim do construtor
	
	public Data(String month, int day, int year)
	{
		this(day, year);
		month_string = month;
	};//fim do construtor
	
	public Data(int day, int year)
	{
		number_of_days = day;
		year_integer = year;
	};//fim do construtor
	
	public int getDay()
	{
		return day_integer;
	};//fim do métoo getDay()

	public int getMonth()
	{
		return month_integer;
	};//fim do método getMonth()
	
	public int getYear()
	{
		return year_integer;
	};//fim do método getYear()
	
	public String toUniversalString()
	{
		return String.format("%2d/%2d/%2d", getDay(), getMonth(), getYear());
	};//fim do método toString();
	
	public String toString 
	{
		return String.format("%s");
	}
};//fim da classe Data

