package org.taco.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.taco.tacos.Ingredients;
import org.taco.tacos.Taco;
import org.taco.tacos.TacoOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@Slf4j
public class DesignTacoController
{
    @ModelAttribute
    public void addIngredientsToModel(Model model)
    {
        List<Ingredients> ingredients = Arrays.asList(
                new Ingredients("FLTO", "Flour Tortilla", Ingredients.Type.WRAP),
                new Ingredients("COTO", "Corn Tortilla", Ingredients.Type.WRAP),
                new Ingredients("GRBF", "Ground Beff", Ingredients.Type.PROTEIN),
                new Ingredients("CARN", "Carnitas", Ingredients.Type.PROTEIN),
                new Ingredients("TMTO", "Diced Tomatoes", Ingredients.Type.VEGGIES),
                new Ingredients("LETC", "Lettuce", Ingredients.Type.VEGGIES),
                new Ingredients("CHED", "Cheddar", Ingredients.Type.CHEESE),
                new Ingredients("JACK", "Monterrey Jack", Ingredients.Type.CHEESE),
                new Ingredients("SLSA", "Salsa", Ingredients.Type.SAUCE),
                new Ingredients("SRCR", "Sour Cream", Ingredients.Type.SAUCE));

        Ingredients.Type[] types = Ingredients.Type.values();
        for (Ingredients.Type type : types)
        {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    };//addIngredientsToModel(Model model)

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order()
    {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco()
    {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm()
    {
        return "design";
    }

    private Iterable<Ingredients> filterByType(List<Ingredients> ingredients, Ingredients.Type type)
    {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
};//end of DesignTacoController
