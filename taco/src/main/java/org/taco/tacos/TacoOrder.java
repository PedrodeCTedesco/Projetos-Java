/** This class specifies how the users can order the taco and include their delivery preferences.   */

package org.taco.tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class TacoOrder
{
    //Campos
    @NotBlank(message = "Delivery name is required")
    @NaturalId
    @Column(table = "Taco_Order")
    private String deliveryName;

    @Column(table = "Taco_Order")
    @NotBlank(message = "Delivery street is required")
    private String deliveryStreet;

    @Column(table = "Taco_Order")
    @NotBlank(message = "City is required")
    private String deliveryCity;

    @Column(table = "Taco_Order")
    @NotBlank(message = "Tell us your street")
    private String deliveryState;

    @Column(table="Taco_Order")
    @NotBlank(message = "You forgot the zip code!")
    private String deliveryZip;

    @Column(name = "cartaoDeCredito_Numero", table="Taco_Order")
    //@CreditCardNumber(message = "Not a valid credit card number") //Hibernate validator. Uncomment to activate
    private String ccNumber;

    @Column(name = "cartaoDeCredito_Expiração", table="Taco_Order")
    @Pattern(regexp = "^(0[1-9]|1[0-2])/[0-9]{2}$", message = "Must be formatted MM/YY") //JSR 303
    private String ccExpiration;

    @Column(name = "cartãoDeCrédito_CVV", table="Taco_Order")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_taco",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "taco_id")
    )
    private List<Taco> tacos = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "ID", table="Taco_Order")
    private Long id;

    @Version
    @Column(name = "created_at", table="Taco_Order")
    private Date createdAt = new Date();

    //Client methods
    public void addTaco(Taco taco)
    {
        this.tacos.add(taco);
    };//fim de addTaco(Taco taco);

    //Métodos sobrescritos
    @Override
    public boolean equals(Object anotherObj)
    {
        return anotherObj instanceof TacoOrder
                && ((TacoOrder)anotherObj).getDeliveryName().equals(deliveryName);
    };//fim de equals(...)

    @Override
    public int hashCode()
    {
        return deliveryName.hashCode();
    };//fim de hashCode().
};//end of TacoOrder
