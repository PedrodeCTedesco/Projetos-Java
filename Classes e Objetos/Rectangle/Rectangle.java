/** Crie uma classe Rectangle com os atributos length e width, cada um dos quais assume o padrão de 1. Forneça 
os métodos que calculam o perímetro e a área do retângulo. A classe tem métodos set e get para o comprimento (length) e a largura 
(width). Os métodos set devem verificar se length e width são, cada um, números de ponto flutuante maiores que 0,0 e menores que 
20,0. Escreva um programa para testar a classe Rectangle.*/

public class Rectangle
{
	public static void main (String[] args)
	{
		//Instanciando 4 objetos
		RectangleObject rec1 = new RectangleObject(); //deve inicializar com os valores padrão
		RectangleObject rec2 = new RectangleObject(3.2, 12.7);
		//RectangleObject rec3 = new RectangleObject(3.4, 22.7); //deve lançar um erro
		//RectangleObject rec4 = new RectangleObject(-3.4, 5.21); //deve lançar um erro
		
		//Testando os métodos de consulta
		System.out.printf("Valores de length e width de rec1:%nLength rec1: %.2f%nWidth rec1: %.2f%n", rec1.getLength(), rec1.getWidth());
		System.out.printf("Valores de length e width de rec2:%nLength rec2: %.2f%nWidth rec2: %.2f%n", rec2.getLength(), rec2.getWidth());
		
		//Testando os métodos de modificação
		rec1.setLength(4);
		rec1.setWidth(7);
		
		rec2.setLength(17);
		rec2.setWidth(11);
		
		//System.out.printf("Alterando os valores de length e width de rec2 com valores inválidos:%n");
		//rec2.setLength(321);
		//rec2.setWidth(-123);
		
		//Testando métodos cliente
		System.out.printf("Área de rec1: %f%nPerímetro de rec1: %.2f%n", rec1.calculateArea(), rec1.calculatePerimeter());
		System.out.printf("Área de rec2: %f%nPerímetro de rec2: %.2f%n", rec2.calculateArea(), rec2.calculatePerimeter());
		
		//Exibindo os valores finais das instâncias
		System.out.printf("Rec1: %n%s", rec1);
		System.out.printf("Rec2: %n%s", rec2);
	};//fim do método main
};//fim da classe Rectangle

class RectangleObject
{
	/** CAMPOS. 
	 * Todos são variáveis de instância. Ainda que estejam inicializadas como 1, no construtor teremos a possibilidade
	 * de alterar estes valores. 
	 * */
	private double length; 
	private double width;
	
	/** CONSTRUTORES.
	 * Teremos dois construtores, um que inicializa todos os campos com os valores inicializados na classe, e outro
	 * que permite a inserção de novos valores. 
	 * */
	public RectangleObject ()
	{
		this(1.0, 1.0);
	};//fim do construtor
	
	public RectangleObject (double lenght, double width)
	{
		//Verificação dos valores passados
		if (length < 0.0 || length > 20.0)
		{
			throw new IllegalArgumentException("Valor de length e/ou width devem ser de ponto flutuante e maiores do que 0,0"
					+ "e menores do que 20,0.");
		}
		
		if (width < 0.0 || width > 20.0)
		{
			throw new IllegalArgumentException("Valor de length e/ou width devem ser de ponto flutuante e maiores do que 0,0"
					+ "e menores do que 20,0.");
		}
		
		this.length = length;
		this.width = width;
	};//fim do construtor
	
	/** MÉTODOS DE CONSULTA*/
	public double getLength()
	{
		return length;
	};//fim do método getLength();
	
	public double getWidth()
	{
		return width;
	};//fim do método getWidth();
	
	/** MÉTODOS MODIFICADORES */
	public void setLength(double length)
	{
		if (length < 0.0 || length > 20.0)
		{
			throw new IllegalArgumentException("Valor de length e/ou width devem ser de ponto flutuante e maiores do que 0,0"
					+ "e menores do que 20,0.");
		};//fim da sentença de seleção condicional simples
		
		this.length = length;
	};//fim do método setLength(int length);
	
	public void setWidth(double width)
	{
		if (width < 0.0 || width > 20.0)
		{
			throw new IllegalArgumentException("Valor de length e/ou width devem ser de ponto flutuante e maiores do que 0,0"
					+ "e menores do que 20,0.");
		};//fim da sentença de seleção condicional simples
		
		this.width = width;
	};//fim do método setLength(int width);
	
	/** MÉTODOS 
	 * Como são métodos para o cliente utilizar possuirão visibilidade public. Poderíamos redigir como: 2 * (length + width), porém
	 * com os métodos de consulta garantimos que qualquer alteração na lógica desses métodos não gerará modificações na lógica
	 * deste método. */
	public double calculatePerimeter()
	{
		double perimeter = 2 * (getLength() + getWidth());
		return perimeter;
	};//fim do método calculatePerimeter();
	
	public double calculateArea()
	{
		double area = getLength() * getWidth();
		return area;
	};//fim do método calculateArea();
	
	public String toString()
	{
		return String.format("Length: %.2f%nWidth: %.2f%n", getLength(), getWidth());
	};//fim do método toString();
};//fim da classe Rectangle