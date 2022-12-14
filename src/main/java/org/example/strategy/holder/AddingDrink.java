package org.example.strategy.holder;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import org.example.model.Drink;
import org.example.model.Order;
import org.example.model.Supplement;

public class AddingDrink implements AddingGoods<Drink> {
    @Override
    public void addGoods(Order order, Drink drink) {
        if (drink.getSupplement().isEmpty()) {
            offerSupplement(drink);
        }
        order.setDrink(drink);
    }

    private void offerSupplement(Drink drink) {
        System.out.println("You can choose to complement your drink ("
                + drink.getName() + ") for free:");
        Arrays.stream(Supplement.values())
                .forEach(s -> System.out.println((s.ordinal() + 1) + " -> " + s.getDescription()));
        System.out.println("0 -> nothing");
        long size = Arrays.stream(Supplement.values()).count();
        int index = getUserChoice((int) size) - 1;
        Optional<Supplement> optionalSupplement = Arrays.stream(Supplement.values())
                .filter(s -> s.ordinal() == index).findFirst();
        drink.setSupplement(optionalSupplement);
    }

    private int getUserChoice(int size) {
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("You should input the number from 1 to " + size + " or 0.");
            return 0;
        }
    }
}
