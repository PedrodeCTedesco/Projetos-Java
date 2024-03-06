/** This class specifies how the users can order the taco and include their delivery preferences.   */

package org.taco.tacos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder
{
    //Fields
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();

    //Client methods
    public void addTaco(Taco taco)
    {
        this.tacos.add(taco);
    }
};//end of TacoOrder
