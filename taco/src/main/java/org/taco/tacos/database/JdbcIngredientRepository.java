package org.taco.tacos.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.taco.tacos.Ingredients;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository
{
    //Campos
    private JdbcTemplate jdbcTemplate;

    //Construtor
    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    };//fim do construtor

    //Métodos sobrescritos
    @Override
    public Iterable<Ingredients> findAll()
    {
        return jdbcTemplate
                .query("select id, name, type from Ingredients",
                        this::mapRowToIngredients);
    };//fim de Iterable<Ingredients> findAll();

    @Override
    public Optional<Ingredients> findById(String id)
    {
        List<Ingredients> results = jdbcTemplate
                .query("select id, name, type from Ingredients where id=?",
                        this::mapRowToIngredients,
                        id);

        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    };//fim de Optional<Ingredients>findById(String id)

    @Override
    public Ingredients save(Ingredients ingredient)
    {
        jdbcTemplate.update(
                "insert into Ingredients (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());

        return ingredient;
    };//fim de save(...)

    //Métodos de implementação
    private Ingredients mapRowToIngredients(ResultSet row, int rowNum) throws SQLException
    {
        return new Ingredients(
                row.getString("id"),
                row.getString("name"),
                Ingredients.Type.valueOf(row.getString("type")));
    };//fim de Ingredients mapRowToIngredients(...)
};//fim de JdbcIngredientRepository
