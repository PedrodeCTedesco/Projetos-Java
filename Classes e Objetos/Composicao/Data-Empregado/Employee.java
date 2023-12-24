/**Classe para demonstração de composições. 
 * @author pedro de castro tedesco
 * @since 24/12/2023
 * @link "Java: Como programar" (Deitel e Deitel), cap. 8*/

public class Employee
{
	/**CAMPOS. Todos são variáveis de instância. Note que dois dos campos são referências a instâncias da classe Date
	 * -firstName: String --> o primeiro nome do empregado.
	 * -lastName: String --> o sobrenome do empregado.
	 * -hireDate: Date --> a data de contratação do empregado.
	 * -birthDate: Date --> a data de nascimento do empregado.
	 * */
	private String firstName;
	private String lastName;
	private Date hireDate;
	private Date birthDate;
	
	/**CONSTRUTORES.
	 * +Employee(String firstName, String lastName, Date birthDate, Date hireDate): Employee --> construtor que inicializa todos os campos da classe
	 * @param String firstName;
	 * @param String lastName;
	 * @param Date birthDate;
	 * @param Date hireDate;
	 * */
	public Employee (String firstName, String lastName, Date hireDate, Date birthDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
	};//fim do construtor
	
	/**MÉTODOS
	 * +toString(): String --> retorna uma String com as informações da instância.
	 * @return String
	 * */
	public String toString()
	{
		//Repare que como estamos formatando as saídas como Strings, o método toString() da classe Date é 
		//implicitamente invocado quando os objetos da classe são invocados.
		return String.format("%s, %s, Hired: %s Birthday: %s", lastName, firstName, hireDate, birthDate);
	};//fim do método toString();
};//fim da classe Employee