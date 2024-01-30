
public class Cachorro extends Pet
{
	public Cachorro (String nome, int idade)
	{
		super(nome, idade);
	}
	@Test
	public void latir()
	{
		System.out.println("Au au");
	}
}