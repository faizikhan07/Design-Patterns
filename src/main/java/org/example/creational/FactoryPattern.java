package org.example.creational;

/**
 * Question 1: What is Factory Design Pattern ?
 * 1. First of all, it comes under creational design pattern.
 * 2. This pattern encapsulate object creation logic in a seperate method.
 *
 * Question 1: What problem does this factory pattern solves ?
 *
 * Let say we are making a delivery service application. we deliver the goods or products using Car, Van and Cycle.
 * For this, we have created UML Diagram.
 *
 *                                                  +-------------------+
 *                                                  |   <<interface>>   |
 *                                                  |   + deliver()     |
 *                                                  +-------------------+
 *                                                            |
 *             +----------------------------------------------+----------------------------------------------+
 *             |                                              |                                              |
 *    +----------------+                            +-------------------+                          +-------------------+
 *    |  BikeDelivery  |                            |   CycleDelivery   |                          |   VanDelivery     |
 *    |  + deliver()   |                            |   + deliver()     |                          |   + deliver()     |
 *    +----------------+                            +-------------------+                          +-------------------+
 *             |                                              |                                             |
 *             +----------------------------------------------+---------------------------------------------+
 *                                                            |
 *                                                  +-------------------+
 *                                                  |  DeliveryService  |
 *                                                  |  + main()         |
 *                                                  +-------------------+
 */

interface Delivery {
    void deliver();
}

// Concrete Class
class BikeDelivery implements Delivery {
    @Override
    public void deliver() {
        System.out.println("Delivering by bike");
    }
}

class CycleDelivery implements Delivery {
    @Override
    public void deliver() {
        System.out.println("Delivering by Cycle");
    }
}

class VanDelivery implements Delivery {
    @Override
    public void deliver() {
        System.out.println("Delivering by Van");
    }
}

public class FactoryPattern {

    public static void main(String[] args) {
        /*
        // Without Factory Pattern
        Delivery bikeDelivery = new BikeDelivery();
        Delivery cycleDelivery = new CycleDelivery();
        Delivery vanDelivery = new VanDelivery();
        */

        // Factory Pattern
        Delivery bikeDelivery = DeliveryFactory.getDelivery("Bike");
        Delivery cycleDelivery = DeliveryFactory.getDelivery("Cycle");
        Delivery vanDelivery = DeliveryFactory.getDelivery("Van");

        bikeDelivery.deliver();
        cycleDelivery.deliver();
        vanDelivery.deliver();
    }
}

/**
 *
 * PROBLEM WITH ABOVE CODE
 *
 * This above is one complete program in Java. But the system design tells us that this application program is not properly designed
 * according to system design SOLID principles. This above program application is not following these below principles:
 *
 * 1. Single Responsibility Principle (SRP): SRP says that every class should have only single responsibility. Means the purpose of the class should
 * be single only. or Every class should have one reason to change.
 *
 * But as you can see that 'FactoryPattern' is doing two things:
 * 1. Creating different types of delivery/ or creating an object.
 * 2. It also delivers/ calling of methods.
 *
 * That's why it is violating SRP(Single Responsibility Principle)
 *
 * 2. Open-Closed Principle (OCP): OCP says a class should be open for extension but closed for modification.
 *
 * So, if we change the 'deliver' method, we have to change the Factory Pattern class as well. So it is also violating OCP.
 *
 * 3. Tight Coupling : The above class is also tightly coupled.
 *
 * SOLUTION TO THE ABOVE PROBLEM
 *
 * FACTORY DESIGN PATTERN
 *
 * So, in Factory design pattern, we just add another class which contains factory method, which gives us the created product already, we just
 * need to call it.
 *
 * The UML Diagram with Factory Method Pattern is:
 *
 *                                                      +-----------------------+
 *                                                      |       Delivery        |
 *                                                      |    << interface >>    |
 *                                                      |     + deliver()       |
 *                                                      +-----------------------+
 *                                                                  |
 *                +-------------------------------------------------+---------------------------------------------------+
 *                |                                                 |                                                   |
 *      +----------------+                                +------------------+                                  +-----------------+
 *      |  BikeDelivery  |                                |  CycleDelivery   |                                  |  VanDelivery    |
 *      |  + deliver()   |                                |   + deliver()    |                                  |   + deliver()   |
 *      +----------------+                                +------------------+                                  +-----------------+
 *                |                                                 |                                                   |
 *                +-------------------------------------------------+---------------------------------------------------+
 *                                                                  |
 *                                                        +-------------------+
 *                                                        |  DeliveryFactory  |
 *                                                        |  + getDelivery()  |
 *                                                        +-------------------+
 *                                                                  |
 *                                                        +-------------------+
 *                                                        | DeliveryService/  |
 *                                                        | Main/ FactoryPa-  |
 *                                                        | ttern             |
 *                                                        +-------------------+
 *
 */

class DeliveryFactory {

    static Delivery getDelivery(String deliveryType) {
        switch (deliveryType.toLowerCase()) {
            case "bike":
                return new BikeDelivery();
            case "cycle":
                return new CycleDelivery();
            case "van":
                return new VanDelivery();
            default:
                throw new IllegalArgumentException("Unknown delivery type");
        }
    }
}















