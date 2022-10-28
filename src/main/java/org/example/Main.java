package org.example;

import java.util.List;
import org.example.dao.DessertDao;
import org.example.dao.DrinkDao;
import org.example.dao.MainDishDao;
import org.example.dao.impl.DessertDaoImpl;
import org.example.dao.impl.DrinkDaoImpl;
import org.example.dao.impl.MainDishDaoImpl;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.MainDish;
import org.example.service.MenuService;
import org.example.strategy.ParserStrategy;
import org.example.strategy.ParserStrategyImpl;
import org.example.strategy.parser.ParserGoods;
import org.example.util.FileReaderCsv;
import org.example.util.impl.CsvFileReader;

public class Main {
    private static final String DRINKS_FILE_NAME = "src/main/resources/drinks.csv";
    private static final String MAIN_DISHES_FILE_NAME = "src/main/resources/mainDish.csv";
    private static final String DESSERTS_FILE_NAME = "src/main/resources/desserts.csv";
    private static final ParserStrategy parserStrategy = new ParserStrategyImpl();
    private static final FileReaderCsv fileReaderCsv = new CsvFileReader();

    public static void main(String[] args) {
        OrderingSystem orderingSystem = getOrderingSystem();
        orderingSystem.run();
    }

    private static OrderingSystem getOrderingSystem() {
        MenuService menuService = initMenuService();
        MenuPresenter menuPresenter = new MenuPresenter(menuService);
        return new OrderingSystem(menuPresenter);
    }

    private static MenuService initMenuService() {
        DrinkDao drinkDao = new DrinkDaoImpl(getListOf(Drink.class, DRINKS_FILE_NAME));
        MainDishDao mainDishDao =
                new MainDishDaoImpl(getListOf(MainDish.class, MAIN_DISHES_FILE_NAME));
        DessertDao dessertDao = new DessertDaoImpl(getListOf(Dessert.class, DESSERTS_FILE_NAME));
        return new MenuService(dessertDao, mainDishDao, drinkDao);
    }

    private static <T> List<T> getListOf(Class<T> clazz, String fileName) {
        ParserGoods parser = parserStrategy.getParser(clazz);
        return parser.parse(fileReaderCsv.readCsvFile(fileName));
    }
}
