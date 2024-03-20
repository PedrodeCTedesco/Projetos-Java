/** Essa classe é uma classe que funciona como uma tabela no banco de dados e realiza
 * a ligação entre a tabela Taco e a tabela Ingredients
 * */

package org.taco.tacos.database;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.taco.tacos.Ingredients;
import org.taco.tacos.Taco;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Ingredients_Ref")
public class IngredientsRef
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredients")
    private Ingredients ingredients;

    @ManyToOne
    @JoinColumn(name = "taco")
    private Taco taco;

    @Column(name = "taco_key", nullable = false)
    private Long tacoKey;
};//fim de IngredientsRef
