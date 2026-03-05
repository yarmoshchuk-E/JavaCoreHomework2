package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        //создаю новую корзину.
        ProductBasket basket1 = new ProductBasket();

        //создаю продукты.
        Product product1 = new Product("молоко", 100);
        Product product2 = new Product("хлеб", 40);
        Product product3 = new Product("мясо", 600);
        Product product4 = new Product("сыр", 250);
        Product product5 = new Product("конфеты", 450);
        Product product6 = new Product("чай", 150);

        //Добавление продукта в корзину.
        basket1.addToBasket(product1);
        basket1.addToBasket(product2);
        basket1.addToBasket(product3);
        basket1.addToBasket(product4);
        basket1.addToBasket(product5);

        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket1.addToBasket(product6);

        //Печать содержимого корзины с несколькими товарами.
        basket1.printBasket();

        //Получение стоимости корзины с несколькими товарами.
        basket1.getTotalBasket();

        //Поиск товара, который есть в корзине.
        basket1.checkingTheContent("МОЛОКО");

        //Поиск товара, которого нет в корзине.
        basket1.checkingTheContent("лаваш");

        //Очистка корзины.
        basket1.cleanerBasket();

        //Печать содержимого пустой корзины.
        basket1.printBasket();

        //Получение стоимости пустой корзины.
        System.out.println(basket1.getTotalBasket());

        //Поиск товара по имени в пустой корзине.
        basket1.checkingTheContent("мясо");

        System.out.println(Arrays.toString(basket1.getBasket()));
    }
}