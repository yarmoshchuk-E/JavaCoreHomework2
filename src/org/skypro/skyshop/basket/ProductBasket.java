package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final List<Product> basket;

    public ProductBasket(List<Product> basket) {
        this.basket = basket;
    }

    public List<Product> getBasket() {
        return basket;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null.
    public void cleanerBasket() {
        Iterator<Product> del = basket.iterator();
        while (del.hasNext()) {
            del.next();
            del.remove();
        }
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getTotalBasket() {
        int sum = 0;
        for (Product product : basket) {
            if (product == null)
                continue;
            sum += product.getProductPrice();
        }
        return sum;
    }

    /*Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
      <имя продукта>: <стоимость>
      <имя продукта>: <стоимость>
      <имя продукта>: <стоимость>
     Итого: <общая стоимость корзины> */
    public void printBasket() {
        int countSpecial = 0;
        for (Product element : basket) {
            if (element != null) {
                System.out.println(element);
                if (element.isSpecial()) {
                    countSpecial++;
                }
            }
            if (getTotalBasket() == 0) {
                System.out.println("В корзине пусто.");
                break;
            }
        }
        int total = getTotalBasket();
        System.out.println("Итого: " + "< " + total + " >");
        System.out.println("Специальных товаров: " + "< " + countSpecial + " >");
    }

    /*Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает
        boolean в зависимости от того, есть продукт в корзине или его нет.*/
    public boolean checkingTheContent(String productName) {
        for (Product element : basket) {
            if (element == null || productName == null || element.getProductName() == null) {
                continue;
            }
            //приведение к нижнему регистру и замена пробелов
            productName = productName.toLowerCase();
            productName = productName.replace(" ", "");
            if (productName.equals(element.getProductName())) {
                System.out.println("товар есть в корзине");
                return true;
            }
        }
        System.out.println("товара нет в корзине");
        return false;
    }

    public void addToBasket(Product product) {
        basket.add(product);
    }

        //удаление продукта из корзины по имени с перемещением в отдельный список
    public List<Product> deletingFromBasketByName(String deletingName) {
        List<Product> deleted = new LinkedList<>();

        Iterator<Product> delName = basket.iterator();

        deletingName = deletingName.toLowerCase();
        deletingName = deletingName.replace(" ", "");

        while (delName.hasNext()) {
            Product item = delName.next();

            if (item.getSearchTerm().contains(deletingName)) {
                deleted.add(item);
                delName.remove();
            }
        }
        return deleted;
    }
}