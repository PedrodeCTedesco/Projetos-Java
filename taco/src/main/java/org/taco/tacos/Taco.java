/** This class is used to show how the ingredients are bound togheter.*/

package org.taco.tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco")
public class Taco
{
    //Campos
    @Column(name = "name")
    @NotNull //JSR 303
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Column(name = "ingredients_list")
    @ManyToMany
    @NotNull
    @Size(min = 1, message = "You must select at least one ingredient")
    private List<Ingredients> ingredientList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt = new Date();

};//end of Taco
