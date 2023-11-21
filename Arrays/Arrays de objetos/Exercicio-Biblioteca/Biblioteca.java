import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

/**Classe de exercício de fixação de array de objetos
 * @link
 * @since 14/11/2023
 * */

public class Biblioteca
{
	/**CAMPOS. Todos são variáveis de instância
	 * -livros: Livro[] --> um array de objetos Livro.
	 * */
	private Livro[] livros;
	
	/**CONSTRUTORES
	 * Este construtor inicializa o array de livros apenas com seu tamanho
	 * +Biblioteca(int quantidadeLivros): Biblioteca
	 * @param int quantidadeLivros.
	 * */
	public Biblioteca (int quantidadeLivros)
	{
		livros = new Livro[quantidadeLivros];
	};//fim do construtor
	
	/**MÉTODOS DE ACESSO
	 * +getLivros(): Livro[] --> retorna o array de objetos Livro
	 * @return Livro[];
	 * */
	public Livro[] getLivro()
	{
		return this.livros;
	};//fim do método getLivro();
	
	/**MÉTODOS DE CONFIGURAÇÃO
	 * +setLivro(Livro[] livros): void --> altera os livros da biblioteca
	 * @param Livro[];
	 * */
	public void setLivro (Livro[] livros)
	{
		this.livros = livros;
	};//fim do método setLivro(Livro[] livros)
	
	/**MÉTODOS
	 * +toString(): String --> sobrescreve o método da superclasse
	 * @return String
	 * 
	 * +insereLivro (Livro novoLivro): boolean --> insere um novo livro na primeira posição livre do array. 
	 * @param Livro;
	 * @return boolean --> 'true' (foi possível inserir) || 'false' (não foi possível inserir);
	 * 
	 * +procuraLivroPorTitulo(String livro): Livro --> procura no array por um livro com o título passado por parâmetro oficial e o retorna.
	 * @param String livro;
	 * @return Livro || null (caso não exista o livro)
	 * 
	 * +livroDuplicado (String Livro): int --> retorna a quantidade de livros com títulos duplicados.
	 * @param String
	 * @return int
	 * 
	 * +verificaDesconto (String titulo): double -> retorna o valor do desconto do livro solicitado.
	 * @param String
	 * @return valorDesconto || -1 (caso o livro não exista)
	 * 
	 * +imprimeEdicoes(): void --> imprime as informações de todos os livros que possuem uma edição
	 * 
	 * +imprimeLivroPorAno(): void --> imprime os livros do array de livros por ordem decrescente do ano de publicação.
	 * 
	 * +calculaMediaPreco(): double --> retorna a média dos valores dos livros no array de objetos
	 * @return double;
	 * 
	 * +livroComMaiorTitulo(): int --> retorna o livro com maior título do array de objetos
	 * @return int
	 */ 
	public String toString()
	{
		return String.format("Os livros na biblioteca são: " + this.getLivro());
	};//fim do método toString();
	
	public boolean insereLivro (Livro novoLivro)
	{
		//Verificar se a primeira posição do array está livre
		//Incluir tratamento de exceção
		for (int i = 0; i < this.livros.length; i+= 1)
		{
			if (this.livros[i] == null)
			{
				this.livros[i] = novoLivro;
				System.out.println("Livro inserido com sucesso.\n");
				return true;
			};//fim do if
		};//fim do for
		return false;
	};//fim do método insereLivro(Livro novoLivro);
	
	public Livro procuraLivroPorTitulo (String livro)
	{
		//Sentença de iteração para procurar pelas posições do array a existência do livro.
		//Inserir tratamento de exceções
		Livro livroEncontrado = null;
		
		for (int i = 0; i < this.livros.length; i += 1)
		{
			try 
			{
				if (this.livros[i] != null && this.livros[i].getTitulo().equalsIgnoreCase(livro))
				{
					System.out.printf("Livro encontrado! Está na posição: %d\n", i);
					livroEncontrado = this.livros[i];
					return livroEncontrado;
				};//fim do if
			} catch (Exception NullPointerException)
			{
				System.out.print("Erro na posição " + i + " valor da posição: " + this.livros[i]);
			};//fim do tratamento de exceção	
		};//fim do for
		
		return livroEncontrado;
	};//fim do método procuraLivroPorTitulo(String Livro);
	
	public int livroDuplicado(String livro)
	{
		int count = 0; //para identificar quantos livros com mesmo título existem no array.
		
		//Identificando quantos livros com mesmo título existem no array
		for (int i = 0; i < this.livros.length; i =+ 1)
		{
			try
			{
				if (this.livros[i] != null && this.livros[i].getTitulo().equalsIgnoreCase(livro))
				{
					count += 1;
				};//fim do if
			} catch (Exception NullPointerException)
			{
				System.out.print("Erro identificado na posição " + i + " valor da posição: " + this.livros[i]);
			};//fim do tratamento de exceção	
		};//fim do for
		
		
		//Verificando a quantidade de livros e retornando
		if (count == 0)
		{
			System.out.print("Não existem livros com esse título.");
			return count;
		} else
		{
			System.out.printf("Existem %d livros", count);
			return count;
		}
		
	};//fim do método livroDuplicado(String livro);
	
	public double verificaDesconto(String titulo)
	{
		//Variáveis necessárias
		Novo livroNovo = null;
		//Iterar pelo array de livros
		//Inserir tratamento de exceções
		for (int i = 0; i < this.livros.length; i += 1)
		{
			try 
			{
				if (this.livros[i] != null && this.livros[i].getTitulo().equalsIgnoreCase(titulo))
				{
					livroNovo = (Novo) this.livros[i];
					System.out.printf("O valor do desconto do livro é: " + livroNovo.getValorDesconto());
					return livroNovo.getValorDesconto();
				};//fim do if
			} catch (Exception NullPointerException)
			{
				System.out.print("Erro na posição " + i + " valor da posição: " + this.livros[i]);
			};//fim do tratamento de exceções
		};//fim do for
		return -1;
	};//fim do método verificaDesconto(String titulo);
	
	public void imprimeEdicoes()
	{	
		//Iterar o array de objetos Livro para identificar os livros antigos
		//Inserir tratamento de exceções
		for (int i = 0; i < this.livros.length; i += 1)
		{
			if (this.livros[i] != null && this.livros[i] instanceof Antigo)
			{
				((Antigo)this.livros[i]).getEdicao();
			};//fim do if
		};//fim do for
	};//fim do método imprimeEdicoes();
	
	public void imprimeLivroPorAno()
	{
		//Variáveis necessárias
		int z = 0;
		int[] livrosPorAnoCrescente = new int[this.livros.length];
		
		//Etapa 1: separando os valores dos anos dos livros em um array de inteiros.
		
		for (int i = 1; i < this.livros.length; i += 1)
		{
			livrosPorAnoCrescente[i] = this.livros[i].getAno();
		};//fim do for
		
		//Etapa 2: ordenando o array de inteiros em ordem crescente
		
		Arrays.sort(livrosPorAnoCrescente);
		
		//Etapa 3: imprimindo na ordem decrescente.
		
		for (int i = 1; i < livrosPorAnoCrescente.length; i += 1)
		{
			System.out.printf("Resultados: %d\n", livrosPorAnoCrescente[livrosPorAnoCrescente.length - i]);
		};//fim do for
		
	};//fim do método imprimeLivroPorAno();
	
	public double calculaMediaPreco()
	{
		//Variáveis necessárias
		double media = 0;
		double soma = 0;
		
		for (int i = 0; i < this.livros.length; i += 1)
		{
			soma += this.livros[i].getPreco(); 
		};//fim do for
		
		media = soma / this.livros.length;
		
		return media;
	};//fim do método calculaMediaPreco();
	
	public Livro livroComMaiorTitulo()
	{
		//Variável de comparação
		String maiorValor = "";
		Livro livroComMaiorTitulo = null;
		
		//Iterando no array em busca do título de maior vídeo
		for (int i = 0; i < this.livros.length; i += 1)
		{
			if (this.livros[i].getTitulo().length() > maiorValor.length())
			{
				maiorValor = this.livros[i].getTitulo();
				livroComMaiorTitulo = this.livros[i];
			};//fim do if
		};//fim do for
		return livroComMaiorTitulo;
	};//fim do método livroComMaiorTitulo();
};//fim da classe Biblioteca