package org.example.creational;

interface PaymentProcessor {
    void processPayment(double amount);
}

class Payment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println(amount);
    }
}

public class LooseCoupling {
    private PaymentProcessor paymentProcessor;

    public LooseCoupling(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout() {
        double totalamount = 100.0;
        LooseCoupling looseCoupling = new LooseCoupling(new Payment());
        // Call processPayment overriden method of Payment class
        this.paymentProcessor.processPayment(totalamount);
    }
}
