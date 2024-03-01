/** This class is used to show how the ingredients are bound togheter.*/

package org.taco.tacos;

import lombok.Data;

import java.util.List;

@Data
public class Taco
{
    private String name;
    private List<Ingredients> ingredientList;

};//end of Taco
