package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
   private final int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        this.productPrice = productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
