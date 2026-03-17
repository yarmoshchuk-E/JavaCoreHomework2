package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] basket;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public Product[] getBasket() {
        return basket;
    }

    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addToBasket(Product product) {

        int size = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                size++;
            }
            if (basket[i] == null) {
                basket[i] = product;
                break;
            }
            if (size == basket.length) {
                System.out.println("Невозможно добавить продукт.");
            }
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

    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null.
    public void cleanerBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }
        }
    }
}