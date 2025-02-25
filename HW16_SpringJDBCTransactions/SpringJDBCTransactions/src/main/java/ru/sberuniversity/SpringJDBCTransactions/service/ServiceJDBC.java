package ru.sberuniversity.SpringJDBCTransactions.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.sberuniversity.SpringJDBCTransactions.component.DishImpl;

import java.util.Scanner;

@Component
public class ServiceJDBC implements CommandLineRunner {

    private final DishImpl dishImpl;

    public ServiceJDBC(DishImpl dishImpl) {
        this.dishImpl = dishImpl;
    }

    @Override
    public void run(String... args) {
        System.out.println("Добро пожаловать в книгу рецептов!");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    Выберите действие (укажите цифру):
                    1. Добавить рецепт
                    2. Просмотреть список рецептов
                    3. Найти блюдо
                    4. Удалить рецепт
                    0. Выйти
                    """);
            var menu = scanner.nextLine();
            switch (menu) {
                case "1":
                    System.out.println("Введите название блюда");
                    var dishName = scanner.nextLine();
                    System.out.println("Введите название ингредиента и его количества через запятую" +
                            "(пример: молоко 300 мл, масло растительное - 50 мл, соль - 0,5 ч. ложки)");
                    var ingredientsName = scanner.nextLine();
                    dishImpl.addDish(dishName);
                    dishImpl.addIngredients(ingredientsName);
                    dishImpl.addRecipe(dishName, ingredientsName);
                    break;
                case "2":
                    dishImpl.getAllDish();
                    System.out.println("Укажите номер блюда, чтобы посмотреть его рецепт");
                    var dishNumber = scanner.nextInt();
                    dishImpl.getRecipe(dishNumber);
                    break;
                case "3":
                    System.out.println("Введите название блюда или его часть");
                    var dishNameSearch = scanner.nextLine();
                    if (dishImpl.findByNameDish(dishNameSearch)) {
                        System.out.println("Укажите номер блюда, чтобы посмотреть его рецепт");
                        var dishNumberSearch = scanner.nextInt();
                        dishImpl.getRecipe(dishNumberSearch);
                    }
                    break;
                case "4":
                    System.out.println("Укажите номер блюда, чтобы удалить его");
                    dishImpl.getAllDish();
                    var dishRemoveNumber = scanner.nextInt();
                    dishImpl.removeDish(dishRemoveNumber);
                    break;
                case "0":
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверное значение. Попробуйте снова.");
            }
        }
    }
}
