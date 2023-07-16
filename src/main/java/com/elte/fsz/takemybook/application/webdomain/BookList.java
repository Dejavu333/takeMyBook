package com.elte.fsz.takemybook.application.webdomain;

import java.util.List;

import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Genre;

public class BookList {

    private final long id;
    private final String title;
    private final String author;
    private final Condition condition;

    private final boolean isActiveTrade;
    private final List<Genre> genre;
    private final String description;

    public BookList(long id, String title, String author, Condition condition, boolean isActiveTrade, List<Genre> genre, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.isActiveTrade = isActiveTrade;
        this.genre = genre;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Condition getCondition() {
        return condition;
    }

    public boolean isActiveTrade() {
        return isActiveTrade;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

}
