package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {

    private final HashMap<String, List<Product>> basket;

    public ProductBasket(HashMap<String, List<Product>> basket) {
        this.basket = new HashMap<>();
    }

    public Map<String, List<Product>> getBasket() {
        return basket;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает список
    public void cleanerBasket() {
        getBasket().clear();
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getTotalBasket() {
        int sum = 0;
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product pr : product.getValue()) {
                if (pr != null) {
                    sum += pr.getProductPrice();
                }
            }
        }
        return sum;
    }

//       Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
//      <имя продукта>: <стоимость>
//      <имя продукта>: <стоимость>
//      <имя продукта>: <стоимость>
//       Итого: <общая стоимость корзины>
    public void printBasket() {
        int countSpecial = 0;
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product element : product.getValue()) {
                if (element != null) {
                    System.out.println(element);
                    if (element.isSpecial())
                        countSpecial++;
                }

                if (getTotalBasket() == 0) {
                    System.out.println("В корзине пусто.");
                    break;
                }
            }
        }
            int total = getTotalBasket();
            System.out.println("Итого: " + "< " + total + " >");
            System.out.println("Специальных товаров: " + "< " + countSpecial + " >");

    }

//    Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает
//    boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean checkingTheContent(String productName) {

        //приведение к нижнему регистру и замена пробелов
        productName = productName.toLowerCase();
        productName = productName.replace(" ", "");

        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product element : product.getValue()) {
                if (element != null && element.getProductName().equals(productName)) {
                    System.out.println("товар есть в корзине");
                    return true;
                }
            }
        }
        System.out.println("товара нет в корзине");
        return false;
    }

    //добавление продукта в корзину
    public void addToBasket(Product product) {
        basket.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
        System.out.println("Добавлен продукт: " + product.getProductName());
    }

    //удаление продукта из корзины по имени с перемещением в отдельный список
    public List<Product> deletingFromBasketByName(String deletingName) {
        List<Product> deleted = new LinkedList<>();

        deletingName = deletingName.toLowerCase();
        deletingName = deletingName.replace(" ", "");

        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            for (Product item : product.getValue()) {
                if (Objects.equals(item.getProductName(), deletingName)) {
                    deleted.add(item);

                }
            }
        }
        basket.remove(deletingName);
        return deleted;

    }

}