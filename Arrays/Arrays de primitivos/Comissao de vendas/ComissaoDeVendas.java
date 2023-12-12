/**Problema: Utilize um array unidimensional para resolver o seguinte problema: uma empresa paga seu pessoal de vendas por 
comissão. O pessoal de vendas recebe R$ 200 por semana mais 9% de suas vendas brutas durante essa semana. Por exemplo, um vendedor 
que vende R$ 5.000 brutos em uma semana recebe R$ 200 mais 9% de R$ 5.000 ou um total de R$ 650. Escreva um aplicativo (utilizando 
um array de contadores) que determina quanto o pessoal de vendas ganhou em cada um dos seguintes intervalos (suponha que o salário 
de cada vendedor foi truncado para uma quantia inteira):
a) $200–299
b) $300–399
c) $400–499
d) $500–599
e) $600–699
f) $700–799
g) $800–899
h) $900–999
i) R$ 1.000 e acima
Resuma os resultados em formato tabular.*/

public class ComissaoDeVendas
{
	public static void main (String[]args)
	{
		//Gerando o array em formato tabular
		System.out.printf("%5s%25s%8s%12s%18s%n", "Intervalo", "Salário base", "Bônus", "Comissão", "Salário mensal");
		
		for(int i = 0; i < INTERVALOS.length; i += 1)
		{
			System.out.printf("%s%12.1f%12.1f%10.1f%15.1f%n", INTERVALOS[i], SALARIO_BASE, BONUS, valorComissao(VENDAS_BRUTAS[i]), salarioMensal(VENDAS_BRUTAS[i]));
		};//fim da sentença de iteração
		
	};//fim do método main
	
	
	/**INTEFACE PÚBLICA */
	
	/**Campos
	 * BONUS: double --> representa o bônus cujo valor fixo é de R$ 200,00
	 * */
	
	static final double BONUS = 200;
	static final double SALARIO_BASE = 5000;
	static final String[] INTERVALOS = {"R$ 200,00 - 299,00", "R$ 300,00 - 399,00", "R$ 400,00 - 499,00", "R$ 500,00 - 599,00", "R$ 600,00 - 699,00", "R$ 700,00 - 799,00", "R$ 800,00 - 899,00", "R$ 900,00 - 999,00", "R$ 1.000,00 - mais"}; 
	static final double[] VENDAS_BRUTAS = {270, 390, 460, 560, 699, 730, 811, 987, 1340};
	
	/**Métodos
	 * +valorComissao(double vendasBrutas): Double --> o método calcula o valor da comissão com base no valor de vendas brutas do vendedor.
	 * @param double vendasBrutas --> o valor das vendas brutas.
	 * @return double valorComissao --> o valor da comissão
	 * 
	 * +salarioMensal(double vendasBrutas): double --> calcula o valor do salário do vendedor.
	 * @param double vendasBrutas --> o valor das vendas brutas do mês.
	 * @return double salario --> o valor do salário final, i.e., a partir do bônus e do valor da comissão.
	 * */
	public static double valorComissao(double vendasBrutas)
	{
		/**Variável de apoio 
		 * PERCENTUAL: double {valor constante}*/
		final double PERCENTUAL = 0.09;
		double valorComissao = 0.0;
		
		valorComissao = vendasBrutas * PERCENTUAL;
		
		return valorComissao;
	};//fim do método valorComissao(double vendasBrutas);
	
	public static double salarioMensal(double vendasBrutas)
	{
		double salario = SALARIO_BASE + BONUS + valorComissao(vendasBrutas);
		return salario;
	};//fim do método salario();
	
};//fim da classe ComissaoDeVendas