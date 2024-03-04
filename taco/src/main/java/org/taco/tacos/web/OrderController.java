/** This is the controller for the view: orderForm.
 * This controller is needed to generate a view for the user after the form is submitted.
 * @author pedro de castro tedesco
 * @since 04/03/2024
 * @see "Spring and Spring Boot in Action" (Craig Walls)
 * */

package org.taco.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@Slf4j
public class OrderController
{
    @GetMapping("/current")
    public String orderForm()
    {
        return "orderForm";
    };//end of orderForm();
};//end of OrderController()
