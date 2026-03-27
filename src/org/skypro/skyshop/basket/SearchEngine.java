package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] elements;

    public SearchEngine(int size) {
        this.elements = new Searchable[size];
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
                if (count == result.length) {
                    break;
                }
            }
        }
        if (count == 0) {
            System.out.println("не найдено объектов, соответствующих запросу");
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public void addElements(Searchable searchable) {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                count++;
            }
            if (elements[i] == null) {
                elements[i] = searchable;
                break;
            }
            if (count == elements.length) {
                System.out.println("Невозможно добавить объект: " + searchable.getSearchTerm());
            }
        }
    }

    public Searchable findBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxCount = 0;
        for (int i = 0; i < elements.length; i++) {
            if (!search.isEmpty() && elements[i] != null) {
                String searchFor = elements[i].getSearchTerm().toLowerCase();
                String searchIn = search.toLowerCase();
                int count = countSearchContains(searchIn, searchFor);
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = elements[i];
                }
            }
        }
        if (maxCount <= 0) {
            throw new BestResultNotFound(search);
        }
        System.out.println(bestResult);
        return bestResult;
    }

    public int countSearchContains(String searchIn, String searchFor) {

        String str = searchFor;
        String substring = searchIn;
        int count = 0;
        int index = 0;
        int subIndex = str.indexOf(substring, index);
        while (subIndex != -1) {
            count++;
            index = subIndex + substring.length();
            subIndex = str.indexOf(substring, index);
        }
        return count;
    }
}