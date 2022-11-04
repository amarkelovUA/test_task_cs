package org.example;

import java.util.List;
import java.util.Map;
import org.example.dao.DessertDao;
import org.example.dao.DrinkDao;
import org.example.dao.MainDishDao;
import org.example.dao.impl.DessertDaoImpl;
import org.example.dao.impl.DrinkDaoImpl;
import org.example.dao.impl.MainDishDaoImpl;
import org.example.model.Dessert;
import org.example.model.Drink;
import org.example.model.Goods;
import org.example.model.MainDish;
import org.example.service.FileReaderCsv;
import org.example.service.MenuService;
import org.example.service.OrderService;
import org.example.service.impl.CsvFileReader;
import org.example.service.impl.MenuServiceImpl;
import org.example.service.impl.OrderServiceImpl;
import org.example.strategy.AddingGoodsStrategy;
import org.example.strategy.AddingGoodsStrategyImpl;
import org.example.strategy.ParserStrategy;
import org.example.strategy.ParserStrategyImpl;
import org.example.strategy.holder.AddingDesserts;
import org.example.strategy.holder.AddingDrink;
import org.example.strategy.holder.AddingGoods;
import org.example.strategy.holder.AddingMainDish;
import org.example.strategy.parser.DessertParserImpl;
import org.example.strategy.parser.DrinkParserImpl;
import org.example.strategy.parser.MainDishParserImpl;
import org.example.strategy.parser.ParserGoods;

public class Main {
    private static final String DRINKS_FILE_NAME = "src/main/resources/drinks.csv";
    private static final String MAIN_DISHES_FILE_NAME = "src/main/resources/mainDish.csv";
    private static final String DESSERTS_FILE_NAME = "src/main/resources/desserts.csv";
    private static final FileReaderCsv fileReaderCsv = new CsvFileReader();

    public static void main(String[] args) {
        OrderingSystem orderingSystem = getOrderingSystem();
        orderingSystem.run();
    }

    private static OrderingSystem getOrderingSystem() {
        MenuService menuService = initMenuService();
        MenuPresenter menuPresenter = new MenuPresenter(menuService);
        OrderService orderService = new OrderServiceImpl();
        AddingGoodsStrategy addingGoodsStrategy = getAddingGoodsStrategy();
        return new OrderingSystem(addingGoodsStrategy, menuPresenter, orderService);
    }

    private static MenuService initMenuService() {
        DrinkDao drinkDao = new DrinkDaoImpl(getListOf(Drink.class, DRINKS_FILE_NAME));
        MainDishDao mainDishDao =
                new MainDishDaoImpl(getListOf(MainDish.class, MAIN_DISHES_FILE_NAME));
        DessertDao dessertDao = new DessertDaoImpl(getListOf(Dessert.class, DESSERTS_FILE_NAME));
        return new MenuServiceImpl(dessertDao, mainDishDao, drinkDao);
    }

    private static <T> List<T> getListOf(Class<T> clazz, String fileName) {
        ParserGoods parser = getParserStrategy().getParser(clazz);
        return parser.parse(fileReaderCsv.readCsvFile(fileName));
    }

    private static AddingGoodsStrategy getAddingGoodsStrategy() {
        Map<Class<? extends Goods>, AddingGoods> holders = Map.of(
                Drink.class, new AddingDrink(),
                Dessert.class, new AddingDesserts(),
                MainDish.class, new AddingMainDish());
        return new AddingGoodsStrategyImpl(holders);
    }

    private static ParserStrategy getParserStrategy() {
        Map<Class<? extends Goods>, ParserGoods<? extends Goods>> parserMap = Map.of(
                Drink.class, new DrinkParserImpl(),
                MainDish.class, new MainDishParserImpl(),
                Dessert.class, new DessertParserImpl()
        );
        return new ParserStrategyImpl(parserMap);
    }
}
