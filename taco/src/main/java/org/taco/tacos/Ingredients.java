/** The ingredients class of the tacos.
 * */

package org.taco.tacos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Ingredients")
public class Ingredients
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final String id;
    private final String name;
    private final Type type;


    public enum Type
    {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
    }

};//end of Ingredients
