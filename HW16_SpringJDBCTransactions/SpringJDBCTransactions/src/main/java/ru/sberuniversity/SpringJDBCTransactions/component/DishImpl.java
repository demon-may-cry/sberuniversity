package ru.sberuniversity.SpringJDBCTransactions.component;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sberuniversity.SpringJDBCTransactions.config.DataSource;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class DishImpl implements Dish {
    private final JdbcTemplate jdbcTemplate;
    Logger logger = LogManager.getLogger(DishImpl.class);

    @Autowired
    public DishImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addDish(String dishName) {
        if (jdbcTemplate.queryForRowSet("SELECT name FROM dish WHERE name = ?", dishName).next()) {
            logger.warn("Dish '{}' already exists", dishName);
            return;
        }
        jdbcTemplate.update("INSERT INTO dish (name) VALUES (?)", dishName);
        logger.info("Dish '{}' added successfully", dishName);
    }

    @Override
    public void getAllDish() {
        Map<Integer, String> mapDish = new HashMap<>();
        jdbcTemplate.query("SELECT id, name FROM dish", (resultSet) -> {
            mapDish.put(resultSet.getInt("id"), resultSet.getString("name"));
        });
        mapDish.forEach((K, V) -> System.out.println(K + ". " + V));
        logger.info("List of dishes: {}", mapDish);
    }

    @Override
    public void addIngredients(String ingredientsName) {
        Map<String, String> ingredients = mapIngredients(ingredientsName);
        for (String s : ingredients.keySet()) {
            if (jdbcTemplate.queryForRowSet("SELECT name FROM ingredients WHERE name =?", s).next()) {
                logger.warn("Ingredient '{}' already exists", s);
                continue;
            }
            jdbcTemplate.update("INSERT INTO ingredients (name) VALUES (?)", s);
            logger.info("Ingredient '{}' added successfully", s);
        }
    }

    @Override
    public void addRecipe(String dishName, String ingredientsName) {
        Map<String, String> ingredients = mapIngredients(ingredientsName);
        if (!jdbcTemplate.queryForRowSet("SELECT name FROM dish WHERE name =?", dishName).next()) {
            logger.warn("Dish '{}' does not exist", dishName);
            return;
        }
        for (Map.Entry<String, String> entry : ingredients.entrySet()) {
            if (!jdbcTemplate.queryForRowSet("SELECT name FROM ingredients WHERE name =?", entry.getKey()).next()) {
                logger.warn("Ingredient '{}' does not exist", entry.getKey());
                continue;
            }
            jdbcTemplate.update("INSERT INTO recipes (id_dish, id_ingredients, count_ingredients) VALUES (" +
                    "(SELECT id FROM dish WHERE name = ?), " +
                    "(SELECT id FROM ingredients WHERE name = ?), ?)", dishName, entry.getKey(), entry.getValue());
            logger.info("Recipe '{}' added successfully", dishName);
        }
    }

    @Override
    public void getRecipe(int dishNumber) {
        if (!jdbcTemplate.queryForRowSet("SELECT id FROM dish WHERE id =?", dishNumber).next()) {
            logger.warn("Dish '{}' does not exist", dishNumber);
            return;
        }
        String sqlGetRecipe = "SELECT ingredients.name, count_ingredients " +
                "FROM recipes " +
                "JOIN dish ON recipes.id_dish = dish.id " +
                "JOIN ingredients ON recipes.id_ingredients = ingredients.id " +
                "WHERE dish.id = " + dishNumber;
        String dishName = jdbcTemplate.queryForObject("SELECT name FROM dish WHERE id =?", String.class, dishNumber);
        Map<String, String> mapRecipe = new HashMap<>();
        jdbcTemplate.query(sqlGetRecipe, (resultSet, rowNum) ->
                mapRecipe.put(resultSet.getString("name"), resultSet.getString("count_ingredients")));
        System.out.println("Рецепт блюда: " + dishName);
        mapRecipe.forEach((K, V) -> System.out.println(K + ": " + V));
        logger.info("List of recipe: {}", mapRecipe);
    }

    @Override
    public boolean findByNameDish(String dishNameSearch) {
        String sqlFindByName = "SELECT id, name FROM dish WHERE name LIKE '%" + dishNameSearch + "%'";
        Map<Integer, String> map = new HashMap<>();
        jdbcTemplate.query(sqlFindByName, (resultSet) -> {
            map.put(resultSet.getInt("id"), resultSet.getString("name"));
        });
        if (!map.isEmpty()) {
            map.forEach((K, V) -> System.out.println(K + ". " + V));
            logger.info("List of dishes by name: {}", map);
            return true;
        } else {
            logger.info("Dish '{}' not found", dishNameSearch);
            System.out.println("Блюдо '" + dishNameSearch + "' не найдено");
        }
        return false;
    }

    @Override
    public void removeDish(int dishNumber) {
        if (!jdbcTemplate.queryForRowSet("SELECT id FROM dish WHERE id =?", dishNumber).next()) {
            logger.warn("Dish '{}' does not exist", dishNumber);
            return;
        }
        jdbcTemplate.update("DELETE FROM dish WHERE id =?", dishNumber);
        System.out.println("Рецепт удалён");
        logger.info("Dish '{}' removed successfully", dishNumber);
    }

    private Map<String, String> mapIngredients(String ingredients) {
        Map<String, String> mapIngredients = new HashMap<>();
        String regex = "(?<name>[а-яА-я ]+\\s)(\\s|\\W*)(?<count>\\d+(,\\d+)?\\s[а-яА-Я.\\s]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ingredients);
        while (matcher.find()) {
            mapIngredients.put(matcher.group("name").trim(), matcher.group("count").trim());
        }
        return mapIngredients;
    }
}

