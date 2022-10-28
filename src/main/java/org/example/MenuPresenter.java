package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;
import org.example.model.Goods;
import org.example.service.MenuService;

public class MenuPresenter {
    private static final int CODE_EXIT = 0;
    private final MenuService menuService;
    private Map<Integer, List<? extends Goods>> menus;
    private Map<Integer, String[]> selectionText;

    public MenuPresenter(MenuService menuService) {
        this.menuService = menuService;
    }

    public Optional<Goods> getSelectedGoods() {
        uploadMenus();
        return workWithMenu();
    }

    private void uploadMenus() {
        menus = new HashMap<>();
        menus.put(1, menuService.getAllMainDishes());
        menus.put(2, menuService.getAllDeserts());
        menus.put(3, menuService.getAllDrinks());

        selectionText = new HashMap<>();
        selectionText.put(1, new String[]{"1. Main dishes", "dishes"});
        selectionText.put(2, new String[]{"2. Desserts", "dishes"});
        selectionText.put(3, new String[]{"3. Drinks", "drinks"});
    }

    private Optional<Goods> workWithMenu() {
        System.out.println("Menu");
        displayMenuTypesWithNumberDishes();
        System.out.println(CODE_EXIT + ". To the previous page.");
        System.out.println("Select the option for detail view: ");
        while (true) {
            int option = getUserChoice(menus.size());
            if (menus.containsKey(option)) {
                return selectGoods(menus.get(option));
            } else if (option == CODE_EXIT) {
                return Optional.empty();
            } else {
                System.out.println("You should input the number from 1 to " + menus.size());
            }
        }
    }

    private Optional<Goods> selectGoods(List<? extends Goods> goodsList) {
        for (int i = 1; i < goodsList.size() + 1; i++) {
            System.out.println(i + " -> " + goodsList.get(i - 1));
        }
        System.out.println("What do you choose: ");
        int index = getUserChoice(goodsList.size()) - 1;
        return (index < 0 || index >= goodsList.size()) ? Optional.empty()
                : Optional.of(goodsList.get(index));
    }

    private int getUserChoice(int size) {
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("You should input the number from 1 to " + size + " or 0.");
            return 0;
        }
    }

    private void displayMenuTypesWithNumberDishes() {
        IntStream.range(1, menus.size() + 1).forEach(
                i -> {
                    String[] template = selectionText.get(i);
                    String message = template[0] + " - "
                            + menus.get(i).size() + " "
                            + template[1];
                    System.out.println(message);
                }
        );
    }
}
