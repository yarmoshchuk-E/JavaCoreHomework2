package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] basket;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public Product[] getBasket() {
        return basket;
    }


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
                System.out.println("невозможно добавить продукт");
            }
        }
    }


    public int getTotalBasket() {
        int sum = 0;
        for (Product product : basket) {
            if (product == null)
                continue;
           sum += product.getProductPrice();
        }
        //System.out.println("всего в корзине: "+ sum);
        return sum;
    }

    public void printBasket() {
        for (Product element : basket) {
            if (element != null) {
                System.out.println(element);
            }
            if (getTotalBasket() == 0) {
                System.out.println("корзина пуста");
            }
        }
        int total = getTotalBasket();
        System.out.println("Итого: " + total);

    }

    public boolean checkingTheContent(String productName) {
        for (Product element : basket) {
            if (element == null) {
                continue;
            }
            if (productName.equals(element.getProductName())) {
                System.out.println("товар есть в корзине");
                return true;
            }
        }
        System.out.println("товара нет в корзине");
        return false;
    }

    public void cleanerBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }
        }
    }

}