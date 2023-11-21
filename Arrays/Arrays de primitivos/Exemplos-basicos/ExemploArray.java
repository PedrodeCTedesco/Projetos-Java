/**Essa classe é utilizada como exemplo de como utilizar arrays unidimensionais
 * e integra o conteúdo do estudo dirigido da disciplina de Laboratório I
 * @author Pedro de Castro Tedesco
 * @since 24/10/2023
 * */

public class ExemploArray 
{
	public static void main (String[] args)
	{
		/**Utilizamos array para poder armazenar mais de 1 valor em um mesmo endereço de memória.
		 * Lembre que quando criamos uma variável ela funciona como um local de armazenamento
		 * na memória do computador e, por isso, seu nome técnico é "descritor".
		 * Um descritor é o conjunto de atributos de uma variável e possui: 
		 * (a) um identificador (o nome da variável); 
		 * (b) um endereço de memória;
		 * (c) um valor;
		 * (d) um tipo;
		 * (e) um escopo.
		 * */
		
		/**Abaixo nós criamos um descritor cujo valor é 67.*/
		Integer x = 67;
		/**Na sequência, sobrescrevemos o seu valor alterando-o para 21.*/
		x = 21;
		
		/**Logo, se tivéssemos que criar 1 descritor para cada variável isso deixaria
		 * o desenvolvimento de software inviável. Por isso, quando desejamos armazenar
		 * mais de 1 valor em um mesmo descritor nós utilizamos o tipo de dado Array.
		 * 
		 * A forma de identificarmos um array ocorre de acordo com a sintaxe:
		 * Exemplo: 
		 * Double[] d; (criando uma instância da classe Double);
		 * double[] d; (criando um array com valores primitivos do tipo double);
		 * --Utilizamos os colchetes para indicar que estamos lidando com um array. Nesse
		 * momento, o computador entende que existe um array cujo identificador é "d" sem dimensão.
		 * 
		 * Para instanciarmos o array e indicarmos qual o seu tamanho máximo, i.e., a quantidade
		 * de posições que ele ocupará na memória temos que utilizar o operador "new" e
		 * definir o tamanho. */
		
		double [] d = new double[100]; 
		
		/**Acima nós instanciamos um array que armazena valores primitivos double
		 * e que possui 100 posições. Em array, nós temos a primeira posição no índice 0
		 * e o último índice 99. 
		 * 
		 * Para adicionar valores no array temos que citar a variável e indicar a posição
		 * na qual desejamos inserir um valor.*/
		
		d[3] = 12.23;
		d[78] = 99.00;
		
		/**Podemos utilizar uma sentença de iteração for para acessar todas as posições do array
		 * 
		 * Abaixo nós estamos criando as condições de iteração (a variável de iteração e as condições
		 * de incremento e de cessação do for) e em seu corpo posicionamos o array com o valor 'i'
		 * recebendo o seu próprio valor de acordo com a iteração. Portanto, na primeira iteração
		 * 'i' tem o valor 0 e a posição d[0] armazenará o valor 0. Na segunda iteração a variável
		 * 'i' terá valor 1 e a posição d[1] armazenará o valor 1.*/
		
		for (Integer i = 0; i < 100; i++)
		{
			d[i] = i;
			System.out.println(d[i]);
		};//Fim do laço for
		
		/**Temos uma propriedade para array chamada 'length'. Ela retorna o tamanho do array.
		 * Portanto, d.lenght retornará 100.*/
		
		System.out.println("Tamanho do array: " + d.length);
		
		/**Essa variável é útil pois poderemos utilizá-la como condição de cessação do laço de iteração
		 * sem sabermos necessariamente qual o tamanho do array.
		 * Realizando a troca do laço for anterior teremos: 
		 * 
		 * for (Integer i = 0; i < d.length; i++
		 * {...}; 
		 * 
		 * */
		
		
	};//Fim do método main
};//Fim da classe ExemploArray
