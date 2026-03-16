package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] elements;

    public SearchEngine() {
        this.elements = new Searchable[10];
    }

    public Searchable[] getElements() {
        return elements;
    }

    public Searchable[] searchMatches(String query) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (int i = 0; i < elements.length; i++) {

            query = query.toLowerCase();
            query = query.replace(" ", "");

            if (elements[i] == null) {
                continue;
            }
            if (elements[i].getSearchTerm().contains(query)) {
                result[count] = elements[i];
                System.out.println(result[count]);
                count++;
                continue;
            }
                        if (count == result.length - 1) {
                break;
            }
        }
        if (count == 0) {
            System.out.println("не найдено объектов, соответствующих запросу");
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public void addElements(Searchable searchable) {
        int size = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                size++;
            }
            if (elements[i] == null) {
                elements[i] = searchable;
                break;
            }
            if (size == elements.length) {
                System.out.println("Невозможно добавить объект");
            }
        }
    }
}





