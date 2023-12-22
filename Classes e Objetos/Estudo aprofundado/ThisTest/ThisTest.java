/**Classe para demonstração dos seguintes conceitos:
 * 
 * (a) A palavra reservada 'this' é utilizada de forma explícita e implícita;
 * 
 * (b) Temos 2 classes declaradas no mesmo arquivo. Note que apenas 1 delas possui o modificador de acesso 'public' para evitar
 * a ocorrência de um erro de compilação. Ainda assim, quando o arquivo for compilado o compilador produzirá os arquivos 
 * bytecode (.class) para cada classe presente no arquivo principal. Isso significa que se tivermos 2 classes em 1 arquivo teremos
 * um arquivo .class para cada uma delas, e apenas uma das classes terá o modificador de acesso 'public'.
 * 
 * (c) Quando temos múltiplas classes declaradas em um mesmo arquivo, todos os arquivos .class estarão no mesmo diretório. Ainda,
 * as classes cujo modificador de acesso 'public' estiver ausente somente serão acessadas por outras classes presentes no mesmo pacote.
 * 
 * */

public class ThisTest
{
	public static void main (String[]args)
	{
		SimpleTime time = new SimpleTime(15, 30, 19);
		System.out.println(time.buildString());
	};//fim da classe main
};//fim da classe ThisTest

//A classe SimpleTime exemplifica os usos da referência this

class SimpleTime
{
	private int hour; //entre 0 - 23
	private int minute; //entre 0 - 59
	private int second; //entre 0 - 59
	
	//Note que quando o construtor possui na sua lista de parâmetros identificadores iguais aos identificadores dos campos
	//a utilização da referência 'this' é obrigatória para que o construtor consiga distinguir os identificadores dos
	//campos da classe e os identificadores dos parâmetros
	public SimpleTime (int hour, int minute, int second)
	{
		this.hour = hour; //configura a hora do objeto 'this'
		this.minute = minute; //configura o minuto do objeto 'this'
		this.second = second; //configura o segundo do objeto 'this'
	};//fim do construtor
	
	//Utilizando a referência 'this' de forma explícita e implícita em um método
	public String buildString()
	{
		return String.format("%24s: %s%n%24s: %s", "this.toUniversalString()", this.toUniversalString(), "toUniversalString()", toUniversalString());
	};//fim do método buildString();
	
	private String toUniversalString()
	{
		//Aqui a referência 'this' não é obrigatória, pois o método não possui variáveis locais cujos identificadores
		//sejam os mesmos dos identificadores do campo da classe.
		return String.format("%02d:%02d:%02d", hour, this.minute, this.second);
	};//fim do método toUniversalString();
};//fim da classe SimpleTest