package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.SearchEngine;
import org.skypro.skyshop.product.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        //создаю новую корзину.
        ProductBasket basket1 = new ProductBasket(new HashMap<String, List<Product>>());

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
        basket1.addToBasket(product6);


        //Печать содержимого корзины с несколькими товарами.
        basket1.printBasket();

        //Получение стоимости корзины с несколькими товарами.
        System.out.println();
        System.out.println(basket1.getTotalBasket());

        //Поиск товара, который есть в корзине.
        basket1.checkingTheContent("МОЛОКО");

        //Поиск товара, которого нет в корзине.
        basket1.checkingTheContent("лаваш");

        //Очистка корзины.
        basket1.cleanerBasket();

        //Печать содержимого пустой корзины.
        System.out.println();
        System.out.println(basket1.getBasket());

        //Получение стоимости пустой корзины.
        System.out.println();
        System.out.println(basket1.getTotalBasket());

        //Поиск товара по имени в пустой корзине.
        System.out.println();
        basket1.checkingTheContent("мясо");
        basket1.printBasket();
        //System.out.println(basket1.getBasket());


        System.out.println("\n Демонстрация и тестирование изменений по д/з - ООП: полиморфизм, интерфейсы \n");

        //создаю объект SearchEngine
        SearchEngine elements = new SearchEngine(new LinkedList<Searchable>());

        //добавляю товары из продуктовой корзины
        elements.addElements(product2);
        elements.addElements(product2);
        elements.addElements(product2);
        elements.addElements(product2);
        elements.addElements(product2);

        System.out.println(elements.getElements());

        //создаю несколько объектов типа Article и добавляю их в массив SearchEngine
        Article article1 = new Article("хлеб", "хлеб темный Дарницкий");
        Article article2 = new Article("чай", "чай чорный Цейлонский");
        Article article3 = new Article("сыр", "сыр Голландский полутвёрдый");

        elements.addElements(article1);
        elements.addElements(article1);
        elements.addElements(article1);
        elements.addElements(article2);
        elements.addElements(article3);
        elements.addElements(article3);

        System.out.println(elements.getElements());

        //проверяю функциональность поиска
        System.out.println();
        elements.searchMatches("хлеб");
        System.out.println();
        elements.searchMatches("СЫР");
        System.out.println();
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
        //elements.findBestResult("колбаса");

        System.out.println("\n Демонстрация и тестирование изменений по д/з - Java Collections Framework: List \n");

        //добавляем продукты в корзину
        basket1.addToBasket(product1);
        basket1.addToBasket(product2);
        basket1.addToBasket(product3);
        basket1.addToBasket(product4);
        basket1.addToBasket(product4);
        basket1.addToBasket(product5);
        basket1.addToBasket(product6);


        //удаляем существующий продукт из корзины и выводим удаленные продукты на экран
        List<Product> deleted = basket1.deletingFromBasketByName("сыр");

        if (deleted.isEmpty()) {
            System.out.println("список пуст");
        } else {
            System.out.println("список удаленных продуктов: " + deleted);
        }

        //выводим содержимое корзины с помощью метода printBasket()
        basket1.printBasket();

        //очищаем список удаленных продуктов
        deleted.clear();

        //удаляем несуществующий продукт.
        basket1.deletingFromBasketByName("колбаса");

        // Проверяем, что список удаленных продуктов пуст и выводим сообщение “Список пуст”.

        if (deleted.isEmpty()) {
            System.out.println("список пуст");
        } else {
            System.out.println("список удаленных продуктов: " + deleted);
        }

        //выводим содержимое корзины с помощью метода printBasket()
        // basket1.printBasket();

        //метод поиска возвращает все подходящие результаты (а не 5 результатов, как раньше)
        elements.searchMatches("хлеб");

        System.out.println("\n Демонстрация и тестирование изменений по д/з - Java Collections Framework: Map \n");

//      создаю новый лист элементов поискового движка
        SearchEngine elements2 = new SearchEngine(new LinkedList<Searchable>());

        elements2.addElements(product1);
        elements2.addElements(product2);
        elements2.addElements(product3);
        elements2.addElements(product4);
        elements2.addElements(product5);
        elements2.addElements(product6);

//      для демонстрации корректного вывода поиска (сортировка результатов в алфавитном порядке) создаю несколько продуктов,
//      которые содержат в себе строку запроса (query) в значении, но отличаются по ключу.

        Article article4 = new Article("мякиш", "хлеб мягенький");
        Article article5 = new Article("сухарик", "хлеб тверденький");

        elements2.addElements(article1);
        elements2.addElements(article2);
        elements2.addElements(article3);
        elements2.addElements(article4);
        elements2.addElements(article5);

        elements2.searchMatches("хлеб");

        elements2.searchMatches("колбаса");

    }
}