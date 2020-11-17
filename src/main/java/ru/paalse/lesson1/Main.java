package ru.paalse.lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cart1 = context.getBean("cartService", CartService.class);
        cart1.addProductToCart(1l);
        cart1.addProductToCart(2l);
        System.out.println("Cart1: \n" + cart1);

        CartService cart2 = context.getBean("cartService", CartService.class);
        cart2.addProductToCart(3l);
        cart2.addProductToCart(4l);
        System.out.println("Cart2: \n" + cart2);
    }
}
