package org.taco.tacos.database;

import org.taco.tacos.Ingredients;

import java.util.Optional;

public interface IngredientRepository
{
    //Métodos abstratos
    Iterable<Ingredients> findAll();

    Optional<Ingredients> findById(String id);

    Ingredients save(Ingredients ingredient);
};//fim de IngredientRepository
