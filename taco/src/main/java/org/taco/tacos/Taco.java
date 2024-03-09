/** This class is used to show how the ingredients are bound togheter.*/

package org.taco.tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco
{
    //Fields
    @NotNull //JSR 303
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must select at least one ingredient")
    private List<Ingredients> ingredientList;

};//end of Taco
