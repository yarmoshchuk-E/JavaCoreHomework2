package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    int basePrice;
    int percentageDiscount;

    public DiscountedProduct(String productName, int basePrice, int percentageDiscount) {
        super(productName);
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public int getProductPrice() {
        return basePrice - (basePrice * percentageDiscount / 100);
    }

    @Override
    public String toString() {
        return "<" + getProductName() + ": " + getProductPrice() + ">" + "(" + "<" + percentageDiscount + ">" + "%)";
    }
}
