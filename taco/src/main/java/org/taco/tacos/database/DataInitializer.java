package org.taco.tacos.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.taco.tacos.Ingredients;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class DataInitializer
{
    //Campos
    @Autowired
    private SessionFactory sessionFactory;

    //Métodos
    public void initializeData()
    {
        Session session = null;
        Transaction transaction = null;

        //rotina de tratamento de exceções
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            //inserção de dados da tabela Ingredients
            Collection<Ingredients> ingredientsList = new ArrayList<>();
            ingredientsList.add(new Ingredients("FLTO", "Flour Tortilla", Ingredients.Type.WRAP));
            ingredientsList.add(new Ingredients("COTO", "Corn Tortilla", Ingredients.Type.WRAP));
            ingredientsList.add(new Ingredients("GRBF", "Ground Beff", Ingredients.Type.PROTEIN));
            ingredientsList.add(new Ingredients("CARN", "Carnitas", Ingredients.Type.PROTEIN));
            ingredientsList.add(new Ingredients("TMTO", "Diced Tomatoes", Ingredients.Type.VEGGIES));
            ingredientsList.add(new Ingredients("LETC", "Lettuce", Ingredients.Type.VEGGIES));
            ingredientsList.add(new Ingredients("CHED", "Cheddar", Ingredients.Type.CHEESE));
            ingredientsList.add(new Ingredients("JACK", "Monterrey Jack", Ingredients.Type.CHEESE));
            ingredientsList.add(new Ingredients("SLSA", "Salsa", Ingredients.Type.SAUCE));
            ingredientsList.add(new Ingredients("SRCR", "Sour Cream", Ingredients.Type.SAUCE));

            session.persist(ingredientsList);
            transaction.commit();
        } catch(Exception exception)
        {
            if(transaction != null)
                transaction.rollback();
            exception.printStackTrace();
        } finally
        {
            if(session != null)
                session.close();
        }
    };//fim de initializeData
};//fim de DataInitializer
