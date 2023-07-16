package com.elte.fsz.takemybook.application.webdomain;

import java.util.List;

import com.elte.fsz.takemybook.domain.Genre;

public class AllBookList {

    private final long id;
    private final String title;
    private final String author;
    private final boolean isActiveTrade;
    private final List<Genre> genre;
    private final String loginName;

    public AllBookList(long id, String title, String author, boolean isActiveTrade, List<Genre> genre, String description, String loginName) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isActiveTrade = isActiveTrade;
        this.genre = genre;
        this.loginName = loginName;
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

    public boolean isActiveTrade() {
        return isActiveTrade;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public String getLoginName() {
        return loginName;
    }

}
