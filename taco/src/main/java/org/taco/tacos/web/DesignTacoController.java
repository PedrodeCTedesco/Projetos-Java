package org.taco.tacos.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.taco.tacos.Ingredients;
import org.taco.tacos.Taco;
import org.taco.tacos.TacoOrder;
import org.taco.tacos.database.IngredientRepository;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("design")
@SessionAttributes({"tacoOrder", "tacoIngredients"})
@Slf4j
public class DesignTacoController
{
    //Campos
    private final IngredientByNameConverter conversor;
    private final IngredientRepository ingredientRepository;

    //constructor
    @Autowired
    public DesignTacoController(IngredientByNameConverter conversor, IngredientRepository ingredientRepository)
    {
        this.conversor = conversor;
        this.ingredientRepository = ingredientRepository;
    };//fim do construtor

    //Model attributes
    @ModelAttribute(name = "tacoIngredients")
    public void addIngredientsToModel(Model model)
    {
        Iterable<Ingredients> ingredients = ingredientRepository.findAll();

        Map<String, Ingredients> map = new HashMap<>();

        for(Ingredients ingredientes : ingredients)
            map.put(ingredientes.getName().toLowerCase(), ingredientes);

       /**
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

        */

        model.addAttribute("tacoIngredients", map);
    };//addIngredientsToModel(Model model)

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order()
    {
        //log.info("TacoOrder created when /desgin is accesed: " + tacoOrder);
        return new TacoOrder();
    }
/** Se eu descomentar este método ele tentará inserir um objeto Taco nos dados do modelo quando a página
 * for acionada. Embora isso seja um comportamento adequado, no nosso caso isso acabará gerando um erro.
 * O motivo é que como usamos no método processTaco a anotação @Valid* a JSR 303 tenta validar o
 * objeto Taco criado no modelo antes da submissão dos dados do formulário. Como consequência,
 * acabamos com uma mensagem de erro, ou com 2 objetos Taco no modelo após a submissão (sempre haverá
 * um objeto Taco a mais além dos requisitados pelo usuário; o objeto extra é o defaultTaco).
 *
 *  *processTaco(@Valid Taco taco, @ModelAttribute TacoOrder tacoOrder...)
 *
    //@ModelAttribute(name = "taco")
    //public Taco taco(@ModelAttribute("tacoIngredients") Map<String, Ingredients> map)
    //{
      //  Taco defaultTaco = new Taco();
       // defaultTaco.setIngredientList(new ArrayList<>(map.values()));
       // defaultTaco.setName("Default taco as all ingredients");
       // return defaultTaco;
    //};//end of taco(...);
*/
    //GET Handler
    @GetMapping
    public String showDesignForm()
    {
        return "design";
    };//end of showDesignForm();

    //POST Handler
    @PostMapping
    public String processTaco(@ModelAttribute TacoOrder tacoOrder,
                              HttpServletRequest request, Errors errors,
                              @ModelAttribute("tacoIngredients") Map<String, Ingredients> map)
    {
        //Taco as a @Valid (an JSR 303 annotattion), so let's check for invalid data
        if (errors.hasErrors())
            return "design";

        //Cria um objeto Taco para atribuir os campos marcados do formulário
        Taco taco = new Taco();

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

        //Configura o nome do objeto Taco
        String tacoName = request.getParameter("name");
        taco.setName(tacoName);

        //Adiciona o objeto Taco ao objeto TacoOrder. Note que todos os campos de Taco estão inicializados
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    };//end of processTaco(...)
};//end of DesignTacoController
