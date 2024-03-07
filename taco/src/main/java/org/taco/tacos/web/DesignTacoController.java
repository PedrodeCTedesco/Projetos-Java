package org.taco.tacos.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.taco.tacos.Ingredients;
import org.taco.tacos.Taco;
import org.taco.tacos.TacoOrder;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("design")
@SessionAttributes({"tacoOrder", "tacoIngredients"})
@Slf4j
public class DesignTacoController
{
    //fields
    private final IngredientByNameConverter conversor;

    //constructor
    @Autowired
    public DesignTacoController(IngredientByNameConverter conversor)
    {
        this.conversor = conversor;
    };//fim do construtor

    //Model attributes
    @ModelAttribute(name = "tacoIngredients")
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

    //GET Handler
    @GetMapping
    public String showDesignForm()
    {
        return "design";
    };//end of showDesignForm();

    //POST Handler
    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder,
                              HttpServletRequest request,
                              @ModelAttribute("tacoIngredients") Map<String, Ingredients> map)
    {
        //Filtrar os elementos de 'map' comparando com os valores recebidos de request
        //Map com os parâmetros de solicitação. Abaixo tenho os checkbox marcados ('on')
        //no formato Map {on = 'Flour Tortilla', on = 'Sour Cream' etc)
        Map<String, String[]> param = request.getParameterMap();

        //List de ingredientes
        List<Ingredients> ingredients = new ArrayList<>();

        //Para acessar apenas os valores presentes no array de "String" param
        for(Map.Entry<String, String[]> entry : param.entrySet())
        {
            String[] values = entry.getValue();
            for(String value : values)
            {
                Ingredients ingredientSelected = conversor.convert(value);
                ingredients.add(ingredientSelected);
            };//fim da sentença de iteração for aprimorado interna
        };//fim da sentença de iteração for aprimorado

        //Como pegamos em "param" todos os dados do formulário (inclusos dados que não são requeridos para
        //conversão) agora nós filtramos novamente utilizando os dados adicionados ao modelo sob nome
        //"tacoIngredients".
        List<Ingredients> finalList = map
                                        .values()
                                        .stream()
                                        .filter(ingredients::contains)
                                        .collect(Collectors.toList());

        //Configura os ingredientes no objeto Taco
        taco.setIngredientList(finalList);

        //Adiciona o objeto Taco ao objeto TacoOrder. Note que todos os campos de Taco estão inicializados
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    };//end of processTaco(...)
};//end of DesignTacoController
