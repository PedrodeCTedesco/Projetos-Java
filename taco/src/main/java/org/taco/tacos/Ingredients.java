/** The ingredients class of the tacos.
 * */

package org.taco.tacos;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
@Entity
@Table(name = "Ingredients")
public class Ingredients
{
    @Id @GeneratedValue
    @Column(name="ID", table="Ingredients")
    private final String id;

    @NaturalId
    @Column(length=20, table="Ingredients")
    private final String name;

    @Enumerated(EnumType.STRING)
    @Column(table="Ingredients")
    private final Type type;

    @ManyToOne
    @JoinColumn(name = "taco_id")
    private Taco taco;

    //Métodos sobrescritos
    @Override
    public boolean equals(Object anotherObj)
    {
        return anotherObj instanceof Ingredients && ((Ingredients)anotherObj).getName().equals(name);
    };//fim de equals(...)

    @Override
    public int hashCode()
    {
        return name.hashCode();
    };//fim de hashCode();

    //Tipo enum
    public enum Type
    {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
    };//fim de Type



};//end of Ingredients
