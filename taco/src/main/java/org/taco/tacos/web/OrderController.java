/** This is the controller for the view: orderForm.
 * This controller is needed to generate a view for the user after the form is submitted.
 * @author pedro de castro tedesco
 * @since 04/03/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls)
 * */

package org.taco.tacos.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.taco.tacos.TacoOrder;

@Controller
@RequestMapping("/orders")
@SessionAttributes({"tacoOrder", "tacoIngredients"})
@Slf4j
public class OrderController
{
    //Handle GET request
    @GetMapping("/current")
    public String orderForm()
    {
        return "orderForm";
    };//end of orderForm();

    //Handle POST request
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus)
    {
        log.warn("Error in TacoOrder" + errors.toString());
        //Check for invalid data
        if(errors.hasErrors())
            return "design";

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    };//end of processOrder(...)
};//end of OrderController()
