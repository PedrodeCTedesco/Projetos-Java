

public class Pet
{
	private String nome;
	private int idade;
	
	public Pet (String nome, int idade)
	{
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public int getIdade()
	{
		return this.idade;
	}
	
	public String toString()
	{
		return "Nome: " + this.nome + "| idade: " + this.idade;
	}
}