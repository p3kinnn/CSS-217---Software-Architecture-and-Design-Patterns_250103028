package com.ecommerce;

public class Main {
    public static void main(String[] args) {
        CheckoutFacade checkoutFacade = new CheckoutFacade();

        boolean success = checkoutFacade.placeOrder("Laptop-X1", "user_404", "Almaty", 1200.00);

        if (success) {
            System.out.println("Order completed successfully!");
        } else {
            System.out.println("Order failed.");
        }
    }

}
