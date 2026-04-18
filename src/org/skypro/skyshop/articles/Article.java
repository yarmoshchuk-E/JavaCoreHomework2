package org.skypro.skyshop.articles;

import org.skypro.skyshop.product.Searchable;

public class Article implements Searchable {
    private final String articleTitle;
    private final String textOfTheArticle;

    public Article(String articleTitle, String textOfTheArticle) {
        this.articleTitle = articleTitle;
        this.textOfTheArticle = textOfTheArticle;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getTextOfTheArticle() {
        return textOfTheArticle;
    }

    @Override
    public String toString() {
        return "\n"+ getArticleTitle() + "- " + getTextOfTheArticle();
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }
}
