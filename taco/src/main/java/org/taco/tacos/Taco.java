/** This class is used to show how the ingredients are bound togheter.*/

package org.taco.tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco")
public class Taco
{
    //Campos
    @Column(length=100, table="Taco")
    @NotNull
    @NaturalId
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @OneToMany(mappedBy = "taco")
    @Size(min = 1, message = "You must select at least one ingredient")
    private List<Ingredients> ingredientList;

    @Id
    @GeneratedValue
    @Column(name="ID", table="Taco")
    private Long id;

    @Version
    @Column(name="created_at", table="Taco")
    private Date createdAt = new Date();

    //Métodos sobrescritos
    @Override
    public boolean equals(Object anotherObj)
    {
        return anotherObj instanceof Taco
                && ((Taco)anotherObj).getName().equals(name);
    };//fim de equals(....)

    @Override
    public int hashCode()
    {
        return name.hashCode();
    };//fim de hashCode();

};//end of Taco
