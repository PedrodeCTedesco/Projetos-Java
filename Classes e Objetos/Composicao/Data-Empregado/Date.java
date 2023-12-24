/**Classe para demonstração de composições. 
 * @author pedro de castro tedesco
 * @since 22/12/2023
 * @link "Java: Como programar" (Deitel e Deitel), cap. 8*/
 
public class Date
{
	/**CAMPOS. Todos são variáveis de instância
	 * -month: int --> Entre 1 e 12.
	 * -day: int --> entre 1 e 31 conforme o mês.
	 * -year: int --> qualquer ano. 
	 * -daysPerMonth: int[] --> array de inteiros com a quantidade total de dias em cada mês.
	 * */
	private int month;
	private int day;
	private int year;
	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**CONSTRUTORES.
	 * +Date(int month, int day, int year): object --> o construtor valida os valores de dia e mês. Por brevidade, vamos supor que
	 * o valor de year já está correto, mas para fins industriais teríamos que validar o ano também. 
	 * @param int day.
	 * @param int month.
	 * @param int year.*/
	
	public Date(int month, int day, int year)
	{
		//Verifica se o mês está dentro do intervalo correto
		if(month <= 0 || month > 12)
		{
			throw new IllegalArgumentException("moth (" + month + ") must be 1-12");
		};//fim da sentença de seleção condicional simples
		
		//Verifica se o dia está correto de acordo com o mês
		if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
		{
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		};//fim da sentença de seleção condicional simples
		
		//Verifica se o ano é bissexto e, se for, que o mês seja 2 e o dia 29
		if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		{
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		};//fim da sentença de seleção condicional simples
		
		this.month = month;
		this.day = day;
		this.year = year;
		
		//Realiza uma saída da data utilizando a referência 'this'.
		//Note que a referência 'this' é uma referência implícita a instância criada.
		//Quando isso acontece ele invoca implicitamente o método toString() da instância.
		System.out.printf("Date object constructor for data: %s%n", this);
	};//fim do construtor
	
	/**Métodos */
	public String toString()
	{
		return String.format("%d/%d/%d", day, month, year);
	};//fim do método toString();
};//fim da classe Date