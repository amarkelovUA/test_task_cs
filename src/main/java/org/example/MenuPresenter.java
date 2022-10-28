package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
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

    public void run() {
        uploadMenus();
        workWithMenu();
    }

    private void uploadMenus() {
        menus = new HashMap<>();
        menus.put(1, menuService.getAllMainDishes());
        menus.put(2, menuService.getAllDeserts());
        menus.put(3, menuService.getAllDrinks());

        selectionText = new TreeMap<>();
        selectionText.put(1, new String[]{"1. Main dishes", "dishes"});
        selectionText.put(2, new String[]{"2. Desserts", "dishes"});
        selectionText.put(3, new String[]{"3. Drinks", "drinks"});
    }

    private void workWithMenu() {
        System.out.println("Menu");
        displayMenuTypesWithNumberDishes();
        System.out.println(CODE_EXIT + ". To the previous page.");
        System.out.println("Select the option for detail view: ");
        while (true) {
            int option = getUserChoice();
            if (menus.containsKey(option)) {
                System.out.println(menus.get(option));
            } else if (option == CODE_EXIT) {
                return;
            } else {
                System.out.println("You should input the number from 1 to " + menus.size());
            }
        }
    }

    private int getUserChoice() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("You should input the number from 1 to " + menus.size());
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
