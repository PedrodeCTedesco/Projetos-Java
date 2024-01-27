/** Nesta classe temos um exemplo de classe de teste mais robusta, escalável e de fácil manutenção. Note os seguintes pontos:
 * 
 * (1) Movemos a seção de teste de CalculatorTest.java para um método chamado addTest(). Dessa forma, fica mais fácil sabermos
 * o que esse método faz; além disso, podemos adicionar mais métodos conforme necessário para a testagem sem deixar o método main
 * difícil de ler e manter. 
 * 
 * (2) Modificamos o método main para que ele gere uma pilha de rastreamento de erros. Caso algum erro exista, no final do método
 * nós teremos como retorno um sumário dos erros (quantidade de erros e onde ocorreram). Note, também, a utilização de estruturas de
 * tratamento de exceções (try...catch) com as devidas exceções mapeadas.
 * 
 * Apesar dos avanços, essa forma de manutenção de testes ainda não é automatizada e possui algumas falhas, a saber:
 * 
 * (a) Idealmente, para que cada teste seja independente eles deveriam rodar em instâncias da classe Calculator diferentes, além de 
 * rodar em class loaders diferentes.
 * 
 * (b) Apesar de podermos inserir mais métodos de teste como addTest(), teríamos que adicionar mais blocos de tratamento de exceções. 
 * Isso, dependendo do tamanho do programa, pode gerar problemas de manutenção.
 * */

public class BetterCalculatorTest
{
	//Campo para armazenar a quantidade de erros
	private int numberOfErros = 0;
	
	//Método para testar o método add()
	private void addTest()
	{
		//(1) inserimos aqui o corpo de CalculatorTest.java. Modificamos a mensagem de erro que sairia na janela de comando para uma exceção
		Calculator calculator = new Calculator();
		//Testando o método
		double result = calculator.add(10, 50);
				
		if (result != 60)
			throw new IllegalStateException("Bad result: " + result);
	};//fim do método addTest()
	
	//(2) Modificação do corpo do main para que sirva como rastreio de erros
	
	public static void main (String[] args)
	{
		//Instância da classe de teste para que possamos utilizar os campos e métodos dela
		BetterCalculatorTest test = new BetterCalculatorTest();
		
		//Tratamento de exceções
		try 
		{
			//Veriica se o método funciona
			test.addTest();
			
		} catch (Throwable e)
		{
			test.numberOfErros+=1;
			e.printStackTrace();
		};//fim do tratamento de exceções
		
		//Sentença de seleção condicional simples para notificação dos erros, se existirem
		if (test.numberOfErros > 0)
			throw new IllegalStateException("There were " + test.numberOfErros + " error(s)");
		
	};//fim do método main
	
};//fim da classe BetterCalculatorTest
 