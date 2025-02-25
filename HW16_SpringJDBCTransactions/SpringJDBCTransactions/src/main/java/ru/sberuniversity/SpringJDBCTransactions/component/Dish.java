package ru.sberuniversity.SpringJDBCTransactions.component;

public interface Dish {
    void addDish(String dishName);

    void getAllDish();

    void addIngredients(String ingredientsName);

    void addRecipe(String dishName, String ingredientsName);

    void getRecipe(int dishNumber);

    boolean findByNameDish(String dishNameSearch);

    void removeDish(int dishNumber);
}
