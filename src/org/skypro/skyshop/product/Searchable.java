package org.skypro.skyshop.product;

public interface Searchable {

    String getName();

    String getSearchTerm();

    String getTypeOfContent();

    default String getStringRepresentation() {
        return getSearchTerm() + getTypeOfContent();
    }

}
