package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.SearchEngine;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        //создаю новую корзину.
        ProductBasket basket1 = new ProductBasket();

        //создаю продукты.
        Product product1 = new SimpleProduct("молоко", 100);
        Product product2 = new SimpleProduct("хлеб", 40);
        Product product3 = new FixPriceProduct("зефир");
        Product product4 = new DiscountedProduct("сыр", 400, 20);
        Product product5 = new SimpleProduct("конфеты", 450);
        Product product6 = new SimpleProduct("чай", 150);

        //Добавление продукта в корзину.
        basket1.addToBasket(product1);
        basket1.addToBasket(product2);
        basket1.addToBasket(product3);
        basket1.addToBasket(product4);
        basket1.addToBasket(product5);

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

        System.out.println("\n Демонстрация и тестирование изменений по д/з - ООП: полиморфизм, интерфейсы \n");

        //создаю объект SearchEngine
        SearchEngine elements = new SearchEngine(10);

        //добавляю товары из продуктовой корзины
        elements.addElements(product2);
        elements.addElements(product2);
        elements.addElements(product2);
        elements.addElements(product2);
        elements.addElements(product2);

        System.out.println(Arrays.toString(elements.getElements()));

        //создаю несколько объектов типа Article и добавляю их в массив SearchEngine
        Article article1 = new Article("Хлеб", "хлеб темный Дарницкий");
        Article article2 = new Article("Чай", "чай чорный Цейлонский");
        Article article3 = new Article("Сыр", "сыр Голландский полутвёрдый");

        elements.addElements(article1);
        elements.addElements(article1);
        elements.addElements(article1);
        elements.addElements(article2);
        elements.addElements(article3);
        elements.addElements(article3);

        System.out.println(Arrays.toString(elements.getElements()));

        //проверяю функциональность поиска
        elements.searchMatches("хлеб");
        elements.searchMatches("ЧАЙ");
        elements.searchMatches("зефир");


        System.out.println("\n Демонстрация и тестирование изменений по д/з - Исключения в Java \n");

        //создаю продукты с неверно заполненными полями и обрабатываю их в try-catch

        try {
            Product product7 = new SimpleProduct("хлеб", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("ошибка создания продукта :" + e.getMessage());
        }
        try {
            Product product8 = new FixPriceProduct(null);
        } catch (IllegalArgumentException e) {
            System.out.println("ошибка создания продукта :" + e.getMessage());
        }
        try {
            Product product9 = new DiscountedProduct("сыр", 400, 115);
        } catch (IllegalArgumentException e) {
            System.out.println("ошибка создания продукта :" + e.getMessage());
        }

        // проверяю работу поискового метода
        elements.findBestResult("хлеб");
        elements.findBestResult("колбаса");

    }
}