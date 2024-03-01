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

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("design")
@SessionAttributes("tacoOrder")
@Slf4j
public class DesignTacoController
{
    @ModelAttribute(value= "tacoIngredients")
    public void addIngredientsToModel(Model model)
    {
        Map<String, Ingredients> map = new HashMap<>();

        Ingredients flourTortilla = new Ingredients("FLTO", "Flour Tortilla", Ingredients.Type.WRAP);
        Ingredients cornTortilla = new Ingredients("COTO", "Corn Tortilla", Ingredients.Type.WRAP);
        Ingredients groundBeff = new Ingredients("GRBF", "Ground Beff", Ingredients.Type.PROTEIN);
        Ingredients carnitas = new Ingredients("CARN", "Carnitas", Ingredients.Type.PROTEIN);
        Ingredients dicedTomatoes = new Ingredients("TMTO", "Diced Tomatoes", Ingredients.Type.VEGGIES);
        Ingredients lettuce = new Ingredients("LETC", "Lettuce", Ingredients.Type.VEGGIES);
        Ingredients cheddar = new Ingredients("CHED", "Cheddar", Ingredients.Type.CHEESE);
        Ingredients monterreyJack = new Ingredients("JACK", "Monterrey Jack", Ingredients.Type.CHEESE);
        Ingredients salsa = new Ingredients("SLSA", "Salsa", Ingredients.Type.SAUCE);
        Ingredients sourCream = new Ingredients("SRCR", "Sour Cream", Ingredients.Type.SAUCE);

        map.put("flour tortilla", flourTortilla);
        map.put("corn tortilla", cornTortilla);
        map.put("ground beff", groundBeff);
        map.put("carnitas", carnitas);
        map.put("diced tomatoes", dicedTomatoes);
        map.put("lettuce", lettuce);
        map.put("cheddar", cheddar);
        map.put("monterrey jack", monterreyJack);
        map.put("salsa", salsa);
        map.put("sour cream", sourCream);

        model.addAttribute("tacoIngredients", map);
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
    };//end of showDesignForm();
};//end of DesignTacoController
