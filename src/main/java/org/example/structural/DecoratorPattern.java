package org.example.structural;

/**
 * Structural Pattern deals with object relationship.
 *
 * Problem Statement of Decorator Pattern
 *
 * Imagine that you're working on a notification library which lets other
 * program notify their users about important events.
 *
 * The initial version of the library was based on the 'Notifier' class that
 * had only a few fields, a constructor and a single 'send' method. The method
 * could accept a message argument from a client and send the message to a list
 * of emails that were passed to the notifier via its constructor. A third
 *
 */

interface Pizza {
    String getDescription();
    double getCost();
}

// Basic Pizza class
class BasicPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Basic Pizza with";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}

// Pizza Decorator abstract class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// Cheese Topping Class
class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}

// Olives Topping class
class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00;
    }
}

class Mushrooms extends PizzaDecorator {
    public Mushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new BasicPizza();
        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Mushrooms(pizza);

        System.out.println("Ordered Pizza: " + pizza.getDescription() + "\nCost: " + pizza.getCost());

        Pizza pizza1 = new BasicPizza();
        pizza1 = new Cheese(pizza1);
        pizza1 = new Mushrooms(pizza1);

        System.out.println(pizza1.getDescription() + "\nCost: " + pizza1.getCost());
    }
}
