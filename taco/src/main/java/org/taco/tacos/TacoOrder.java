/** This class specifies how the users can order the taco and include their delivery preferences.   */

package org.taco.tacos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder
{
    //Fields
    @NotBlank(message = "Delivery name is required") //JSR 303
    private String deliveryName;

    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    private String deliveryCity;

    @NotBlank(message = "Tell us your street")
    private String deliveryState;

    @NotBlank(message = "You forgot the zip code!")
    private String deliveryZip;

    //@CreditCardNumber(message = "Not a valid credit card number") //Hibernate validator. Uncomment to activate
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{2}$",
            message = "Must be formatted MM/YY") //JSR 303
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    private Long id;
    private Date createdAt = new Date();

    //Client methods
    public void addTaco(Taco taco)
    {
        this.tacos.add(taco);
    };//fim de addTaco(Taco taco);
};//end of TacoOrder
