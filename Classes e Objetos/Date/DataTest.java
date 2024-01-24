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

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ValueRange;

public class DataTest
{
	public static void main(String[]args)
	{
	
		System.out.printf("%nTesting constructor number 1%n");
		Data d1 = new Data("June", 2, 1992);
		System.out.printf("%s%n",d1);
		System.out.println();
	
		System.out.printf("%nTesting constructor number 2%n");
		Data d2 = new Data(7, 9, 1996);
		System.out.printf("%s", d2);
		System.out.println();
		
		System.out.printf("%nTesting constructor number 3%n");
		Data d3 = new Data(365, 2012);
		System.out.printf("%s", d3);
		System.out.println();
	};//fim do métdo main
};//fim da classe DataTest

class Data
{
	private int day;
	private int month;
	private int year;
	private String nameOfTheMonth;
	
	public Data(int day, int month, int year)
	{
		//Verificação do dia
		if (!ValueRange.of(1,  31).isValidIntValue(day))
			throw new IllegalArgumentException("Day must be between 1 - 31");
		
		//Verificação do mês
		if (!ValueRange.of(0,  12).isValidIntValue(month))
			throw new IllegalArgumentException("Month must be between 1 - 12");
		
		//Verificação de ano bissexto
		LocalDate checkLeapYear = LocalDate.of(year, month, day);
		if(checkLeapYear.isLeapYear())
		{
			if (!ValueRange.of(1,  29).isValidIntValue(day))
				throw new IllegalArgumentException("Day must be between 1 - 29");
		};//fim da sentença de seleção condicional simples
		
		this.day = day;
		this.month = month;
		this.year = year;
		//this.nameOfTheMonth = "";
	};//fim do construtor
	
	public Data(String nameOfTheMonth, int day, int year)
	{
		//Verificação do dia
		if (!ValueRange.of(1,  31).isValidIntValue(day))
			throw new IllegalArgumentException("Day must be between 1 - 31");
				
		//Verificação de ano bissexto
		LocalDate checkLeapYear = LocalDate.of(year, 1, day);
		if(checkLeapYear.isLeapYear())
		{
			if (!ValueRange.of(1,  29).isValidIntValue(day))
				throw new IllegalArgumentException("Day must be between 1 - 29");
		};//fim da sentença de seleção condicional simples

		this.nameOfTheMonth = getNameOfTheMonth(nameOfTheMonth);
		this.day = day;
		//this.month = 0;
		this.year = year;
	}
	
	public Data(int day, int year)
	{
		//Esse método recebe o número de dias do ano (é o contrário do getTotalAmountOfDays())
		//Verificação do dia
		if (!ValueRange.of(1,  366).isValidIntValue(day))
			throw new IllegalArgumentException("Day must be between 1 - 365");
		
		//Gerando uma data a partir dos argumentos
		LocalDate currentDate = LocalDate.ofYearDay(year, day);
			
		this.day = currentDate.getDayOfMonth();
		this.month = currentDate.getMonthValue();
		this.year = currentDate.getYear();
	};//fim do construtor
	
	public int getDay()
	{
		return day;
	};//fim do método getDay();
	
	public int getTotalAmountOfDays()
	{
		LocalDate testDate = LocalDate.of(getYear(), ( getMonth() == 0 ? getMonth(nameOfTheMonth) : getMonth() ), getDay());
		return testDate.getDayOfYear();
	};//fim do métoo getDay()
	
	public int getMonth()
	{	
		return month;
	};//fim do método getMonth()
	
	public String getMonth(int month)
	{
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String nameOfTheMonth = "Name of the month must be a valid one.";
		
		for(int i = 0; i <= months.length; i+=1)
		{
			if(i == month - 1)
			{
				nameOfTheMonth = months[i];
				return nameOfTheMonth;
			};//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for com contador
		return nameOfTheMonth;
	}
	
	public int getMonth(String nameOfTheMonth)
	{
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int monthNumber = 0;
		
		for(int i = 0; i <= months.length; i+=1)
		{
			if(nameOfTheMonth == months[i])
			{
				monthNumber = i + 1;
				return monthNumber;
			};//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for com contador
		return monthNumber;
	}
	
	public String getNameOfMonth()
	{
		return nameOfTheMonth;
	}
	
	private String getNameOfTheMonth(String monthName)
	{
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String nameOfTheMonth = "Name of the month must be a valid one.";
		
		for(int i = 0; i <= months.length; i+=1)
		{
			if(monthName.equalsIgnoreCase(months[i]))
			{
				nameOfTheMonth = months[i];
				return nameOfTheMonth;
			};//fim da sentença de seleção condicional simples
		};//fim da sentença de iteração for com contador
		return nameOfTheMonth;
	};//fim do método getNameOfTheMonth();
	
	public int getYear()
	{
		return year;
	};//fim do método getYear()

	public String toString()
	{
		return String.format("USA data format (MM/DD/YYY): %s/%d/%d%nEnglish data format: %s, %d %d%nScientific data format: %d %d", 
							(getMonth() == 0 ? getMonth(nameOfTheMonth) : getMonth()), getDay(), getYear(),
							(getMonth() == 0 ? nameOfTheMonth : getMonth(month)), getDay(), getYear(),
							 getTotalAmountOfDays(), getYear());
		
	};//fim do método toUSAFormat();
};//fim da classe Data

