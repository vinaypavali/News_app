package com.info.news;

public class NewsItem {

    private String title;
    private String author;

    public NewsItem(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }

}
