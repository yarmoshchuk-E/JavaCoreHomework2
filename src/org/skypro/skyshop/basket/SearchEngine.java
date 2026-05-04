package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Searchable;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> elements;

    public SearchEngine() {
        this.elements = new HashSet<>();
    }



    public void addElements(Searchable searchable) {
        elements.add(searchable);

    }



    public Set<Searchable> searchMatches(String query) {

                 Set<Searchable> result = elements.stream()
                .filter(e -> e!=null && e.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect (Collectors.toCollection(() -> new TreeSet<>  (new SearchableComparator())));

        System.out.println(result);
        return result;

    }


//        for (Searchable searchable : elements) {
//            if (searchable.getSearchTerm().contains(query)) {
//                result.add(searchable);
//            }
//        }
//        if (result.isEmpty()) {
//            System.out.println("не найдено объектов, соответствующих запросу");
//        }
//        System.out.println(result);
//        return result;
//    }


    public Searchable findBestResult (String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxCount = 0;
        for (Searchable searchable: elements) {
            if (searchable != null) {
                String searchFor = searchable.getSearchTerm().toLowerCase();
                String searchIn = search.toLowerCase();
                int count = countSearchContains(searchIn, searchFor);
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = searchable;
                }
            }
        }
        if (bestResult==null) {
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