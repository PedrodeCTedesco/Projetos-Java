/** Classes criadas para demonstrar o acesso de pacote
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, 10ª ed, cap. 8)
 * */
 
public class PackageDataTest
{
	public static void main (String[]args)
	{
		PackageData packageData = new PackageData();
		
		//Gera saída da representação String de packageData
		//Lembre que citar a instância invoca implicitamente o método toString();
		System.out.printf("After the instantiation: %n%s%n", packageData);
		
		//Muda os dados de acesso de pacote no objeto packageData
		packageData.number = 87;
		packageData.string = "Adeus!";
		
		//Gera saída da representação da String de packageData
		System.out.printf("%nAfter changing values:%n%s%n", packageData);
	};//fim do método main
};//fim da classe PackageDataTest

	//Classe PackageData
	class PackageData 
	{
		//Declarando os campos sem modificadores de acesso. Logo, são variáveis de instância de acesso de pacote
		int number;
		String string;
		
		//Construtor
		public PackageData()
		{
			number = 0;
			string = "Olá!";
		};//fim do construtor
		
		//Método toString() sobrescrito
		public String toString()
		{
			return String.format("number: %d%n; string: %s%n", number, string);
		};//fim do método toString()
	};//fim da classe PackageData