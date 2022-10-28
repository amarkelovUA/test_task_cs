package org.example;

import java.util.Optional;
import org.example.model.Goods;
import org.example.model.Order;
import org.example.strategy.AddingGoodsStrategy;
import org.example.strategy.AddingGoodsStrategyImpl;

public class OrderingSystem {
    private final MenuPresenter menuPresenter;
    private final AddingGoodsStrategy addingGoodsStrategy = new AddingGoodsStrategyImpl();

    public OrderingSystem(MenuPresenter menuPresenter) {
        this.menuPresenter = menuPresenter;
    }

    public void run() {
        boolean isOrderInProgress = true;
        Order order = new Order();
        while (isOrderInProgress) {
            Optional<Goods> selectedGoods = menuPresenter.getSelectedGoods();
            selectedGoods.ifPresent(goods -> addGoodsToOrder(order, goods));
            isOrderInProgress = checkOrderAndMakeAdviceToIt(order);
        }
        System.out.println("Your order is: ");
        order.makeOrder();
        order.finishOrder();
        System.out.println(order);
    }

    private void addGoodsToOrder(Order order, Goods goods) {
        addingGoodsStrategy.addingGoodsHolder(goods).addGoods(order, goods);
    }

    private boolean checkOrderAndMakeAdviceToIt(Order order) {
        if (order.getLunch() == null) {
            System.out.println("You should choose a main dish and a dessert to lunch.");
            return true;
        }
        if (order.getLunch().getMainDish() == null) {
            System.out.println("You should choose a main dish to lunch.");
            return true;
        }
        if (order.getLunch().getDessert() == null) {
            System.out.println("You should choose a dessert to lunch.");
            return true;
        }
        if (order.getDrink() == null) {
            System.out.println("You can order a drink.");
            return true;
        }
        return false;
    }
}
