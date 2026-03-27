package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

    private final String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("не указано имя продукта!");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "<" + getProductName() + ": " + getProductPrice() + ">";
    }
}