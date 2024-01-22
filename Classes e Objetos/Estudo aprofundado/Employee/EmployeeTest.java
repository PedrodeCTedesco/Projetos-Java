/** Classe de teste da classe Employee para demonstrar o funcionamento da classe Employee */

public class EmployeeTest
{
	public static void main (String[] args)
	{
		//Provando que a contagem de instâncias de Employee é zero, pois nenhum objeto foi instanciado
		System.out.printf("Employees before instantiation: %d%n", Employee.getCount());
		
		//Criando 4 empregados. A contagem deverá ser 4
		Employee e1 = new Employee("Eduarda", "Endler");
		Employee e2 = new Employee("Pedro", "Tedesco");
		Employee e3 = new Employee("Paulo", "Lopes");
		Employee e4 = new Employee("Vera", "Lopes");
		
		//Demonstrando os valores da contagem de empregados. Note que o valor é o mesmo para todos
		//Note que usamos duas formas de invocar o método estático: via instância, via classe
		System.out.printf("Employess after instantiation:%n");
		System.out.printf("Number of employess after e1: %d%n", e1.getCount());
		System.out.printf("Number of employess after e2: %d%n", e2.getCount());
		System.out.printf("Number of employess after e3: %d%n", Employee.getCount());
		System.out.printf("Number of employess after e4: %d%n", Employee.getCount());
		
		//Nomes dos empregados
		System.out.printf("Employee 1: %s %s%nEmployee 2: %s %s%nEmployee 3: %s %s%nEmployee 4: %s %s", 
				e1.getFirstName(), e1.getLastName(), e2.getFirstName(), e2.getLastName(), e3.getFirstName(),
				e3.getLastName(), e4.getFirstName(), e4.getLastName());
	};//fim do método main
};//fim da classe EmployeeTest