package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private final List<Searchable> elements;

    public SearchEngine(List<Searchable> elements) {
        this.elements = elements;
    }

    public List<Searchable> getElements() {
        return elements;
    }

    public void addElements(Searchable searchable) {
        elements.add(searchable);
    }

    public Map<String, Searchable> searchMatches(String query) {
        Map<String, Searchable> result = new TreeMap<>();

        query = query.toLowerCase();
        query = query.replace(" ", "");

        Iterator<Searchable> el = elements.iterator();

        while (el.hasNext()) {
            Searchable item = el.next();
            if (item.getSearchTerm().contains(query)) {
                result.put(item.getSearchTerm(), item);
            }
        }
        if (result.isEmpty()) {
            System.out.println("не найдено объектов, соответствующих запросу");
        }
        System.out.println(result);
        return result;
    }


    public void findBestResult(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxCount = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (!search.isEmpty() && elements.get(i) != null) {
                String searchFor = elements.get(i).getSearchTerm().toLowerCase();
                String searchIn = search.toLowerCase();
                int count = countSearchContains(searchIn, searchFor);
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = elements.get(i);
                }
            }
        }
        if (maxCount <= 0) {
            throw new BestResultNotFound(search);
        }
        System.out.println(bestResult);
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