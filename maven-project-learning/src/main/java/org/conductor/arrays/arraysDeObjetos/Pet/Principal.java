package org.conductor.arrays.arraysDeObjetos.Pet;

public class Principal
{
    public static void main	(String[] args)
    {
        PetShop pet = new PetShop(5);

        System.out.print("***** INSERÇÃO DE PET ******\n");

        for (int i =0; i < 7; i += 1)
        {
            double sorteio = Math.random();
            boolean inseriu = false;

            if (sorteio < 0.33)
            {
                inseriu = pet.inserePet(new Cachorro("Lulu " + i, i));
            } else if (sorteio < 0.66)
            {
                inseriu = pet.inserePet(new Gato("Vênus " + i, i));
            } else
            {
                inseriu = pet.inserePet(new Papagaio("Loro José " + i, i));
            }

            if (inseriu)
            {
                System.out.print("Pet inserido com sucesso");
            } else
            {
                System.out.print("Pet não foi inserido");
            }

        }

        System.out.print("***** IMPRIMINDO PET ******\n");
        pet.imprimePets();

        System.out.print("***** REMOÇÃO DE PET ******\n");

        Pet removido = pet.removePet("Vênus 3");
        if (removido == null)
        {
            System.out.println("Pet não encontrado");
        } else
        {
            System.out.println("Pet removido: " + removido);
        }

        System.out.print("***** FAZENDO CACHORRO LATIR ******\n");

        pet.fazCachorrosLatirem();
    }
}
