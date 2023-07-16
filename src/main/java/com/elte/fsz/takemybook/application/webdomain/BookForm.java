package com.elte.fsz.takemybook.application.webdomain;

import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;

public class BookForm {
    private long id;
    @NotEmpty(message = "Author may not be empty.")
    private String author;
    @NotEmpty(message = "Title may not be empty.")
    private String title;
    @NotEmpty(message = "At least one genre must be choosen.")
    private Collection<Genre> genre;
    @Size(max = 800, message = "Description may not be longer than 800 characters.")
    private String description;

    private boolean activeTrade;
    @NotNull(message = "Language may not be empty.")
    private Language language;
    @NotNull(message = "Psyhical condition must be choosen.")
    private Condition condition;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Collection<Genre> genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isActiveTrade() {
        return activeTrade;
    }

    public void setActiveTrade(boolean activeTrade) {
        this.activeTrade = activeTrade;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }


}
