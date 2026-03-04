package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;



public class App {
        public static void main(String[] args) {

            ProductBasket basket1 = new ProductBasket();

            Product product1 = new Product("молоко", 100);
            Product product2 = new Product("хлеб", 40);
            Product product3 = new Product("мясо", 600);
            Product product4 = new Product("сыр", 250);
            Product product5 = new Product("конфеты", 450);
            Product product6 = new Product("чай", 150);
            Product product7 = new Product("печенье", 200);

            System.out.println(product1);
            System.out.println(product2);

            basket1.addToBasket(product1);
            basket1.addToBasket(product2);
            basket1.addToBasket(product3);
            basket1.addToBasket(product4);
            basket1.addToBasket(product5);
            basket1.addToBasket(product6);
            basket1.addToBasket(product7);

            basket1.checkingTheContent("хлеб");
            basket1.checkingTheContent("лаваш");
            basket1.getTotalBasket();

            basket1.printBasket();

            System.out.println(Arrays.toString(basket1.getBasket()));
            basket1.cleanerBasket();
            System.out.println(Arrays.toString(basket1.getBasket()));

            basket1.addToBasket(product3);
            basket1.addToBasket(product4);
            basket1.addToBasket(product5);

            basket1.checkingTheContent("сыр");
            basket1.checkingTheContent("лаваш");


            basket1.printBasket();


        }

    }

