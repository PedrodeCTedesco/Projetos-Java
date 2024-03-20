/** This is a converter class. This is required to convert the string values of the form
 * into Ingredients objects to populate the Taco object after the form is submitted.
 * @author pedro de castro tedesco
 * @since 04/03/2024
 * @see "Spring and Spring Boot in Action (Craig Walls)
 * */

package org.taco.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.taco.tacos.Ingredients;
import org.taco.tacos.database.IngredientRepository;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class IngredientByNameConverter implements Converter<String, Ingredients>
{
    //Fields
    private final Map<String, Ingredients> ingredientsMap = new HashMap<>();
    private IngredientRepository ingredientRepository;

    //Constructor
    @Autowired
    public IngredientByNameConverter(IngredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;
        /**
        //Adds the ingredients using the name of the ingredient as a key
        ingredientsMap.put("Flour Tortilla", new Ingredients("FLTO", "Flour Tortilla", Ingredients.Type.WRAP));
        ingredientsMap.put("Corn Tortilla", new Ingredients("COTO", "Corn Tortilla", Ingredients.Type.WRAP));
        ingredientsMap.put("Ground Beff", new Ingredients("GRBF", "Ground Beff", Ingredients.Type.PROTEIN));
        ingredientsMap.put("Carnitas", new Ingredients("CARN", "Carnitas", Ingredients.Type.PROTEIN));
        ingredientsMap.put("Diced Tomatoes",
                new Ingredients("TMTO", "Diced Tomatoes", Ingredients.Type.VEGGIES));
        ingredientsMap.put("Lettuce", new Ingredients("LETC", "Lettuce", Ingredients.Type.VEGGIES));
        ingredientsMap.put("Cheddar", new Ingredients("CHED", "Cheddar", Ingredients.Type.CHEESE));
        ingredientsMap.put("Monterrey Jack",
                new Ingredients("JACK", "Monterrey Jack", Ingredients.Type.CHEESE));
        ingredientsMap.put("Salsa", new Ingredients("SLSA", "Salsa", Ingredients.Type.SAUCE));
        ingredientsMap.put("Sour Cream", new Ingredients("SRCR", "Sour Cream", Ingredients.Type.SAUCE));
         */
    };//end of constructor

    @Override
    public Ingredients convert (@NonNull String id)
    {

        return ingredientRepository.findById(id).orElse(null);
        //return ingredientsMap.get(n);
    };//end of convert(...)
};//end of IngredientByNameConverter implements Converter<String, Ingredients>
