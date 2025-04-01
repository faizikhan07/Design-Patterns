package org.example;

/**
 * Customer Management Application
 * Consider a scenario where you're building a customer management application.
 * You have two classes: 'Customer' and 'Order'.
 *
 * The 'Order' class needs information from the 'Customer' class to process orders.
 */

class Order {
    private Customer customer;

    public Order() {
        customer = new Customer();
    }

    public void processOrder() {
        // Process order using customer details
    }
}

class Customer {
    private String name;
    private String email;
}


public class Test {
}
