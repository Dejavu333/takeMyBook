package com.elte.fsz.takemybook.application.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;
import com.elte.fsz.takemybook.domain.Trade;

public interface BookService {
	public List<Book> getAllObsoleteBook();
	public List<Book> findBooksByBookworm(Bookworm bookworm);
	public List<Trade> getBookHistory(Book book);
	public List<Book> getBooksInArea(Bookworm bookworm, double distance);
	public Iterable<Book> getAllBooks();
	public void deleteById(long id);
    public Book saveBook(Book book);
    public Book findByid(long id);
    public List<Book> sb(String title, String author, Optional<Genre> genre, Optional<Language> language, Optional<Condition> condition, boolean anyCondition, HttpSession session);
}
