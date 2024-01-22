/** Classe para demonstrar a utilização da classe BigDecimal para aplicações financeiras precisas 
 * @author pedro de castro tedesco
 * @link "Java: como programar" (Deitel e Deitel, 10ª ed, cap. 8)
 * */
 
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Interest
{
	public static void main (String[] args)
	{
		//Quantidade principal inicial antes do cálculo dos juros
		//Utilizamos o método estático valueOf() que recebe um argumento do tipo double e retorna o valor exato especificado
		BigDecimal principal = BigDecimal.valueOf(36.97);
		BigDecimal rate = BigDecimal.valueOf(0.1375); //taxa de juros
		
		//Exibição dos cabeçalhos
		System.out.printf("%s%20s%n", "Year", "Amount on deposit");
		
		//Calcula a quantidade de depósito para cada um dos dez anos
		for (int year = 1; year <= 4; year+=1)
		{
			//Calcula nova quantidade durante o ano especificado
			/** Primeiro, temos a invocação do método rate() com o argumento BigDecimal.ONE. Esse método é invocado para
			 * produzir como resultado 1 + 0.1375 resultando em 13.75 (para indicar uma taxa de 13,75%). A constante ONE de
			 * BigDecimal tem como valor 1, e outras constantes utilizadas são ZERO (retorna O) e TEN (retorna 10).
			 * 
			 * Na sequência, esse resultado (rate.add(BigDecimal.ONE)) é passado como argumento do método pow(year) que eleva 
			 * este resultado à potência cujo valor é year. 
			 * 
			 * Por fim, passamos esse resultado como argumento do método multiply() invocando-o diretamente na variável principal.
			 * Isto tem como resultado um BigDecimal que representa o valor no depósito no final de cada ano.
			 * */
			BigDecimal amount = principal.multiply(rate.add(BigDecimal.ONE).pow(year));
			
			//Exbie o ano e a quantidade de juros
			/** Os métodos estáticos da classe NumberFormat() são invocados da seguinte forma: primeiro, a expressão getCurrencyInstance()
			 * é invocada para obter um NumberFormat que é pré-configurado para formatar valores numéricos como Strings de moedas específicas
			 * da localidade. Essa formatação específica é uma parte importante da internacionalização. 
			 * 
			 * A seguir, a expressão invoca o método format() da classe NumberFormat no objeto retornado por getCurrencyInstance() para
			 * realizar a formatação do valor amount. O método format então retorna a representação String específica da localidade, arredondada
			 * para dois dígitos à direita do ponto decimal. 
			 * */
			System.out.printf("%4d%20s%n", year, NumberFormat.getCurrencyInstance().format(amount));
		};//fim da sentença de iteração for com contador
	};//fim do método main
};//fim da classe Interest