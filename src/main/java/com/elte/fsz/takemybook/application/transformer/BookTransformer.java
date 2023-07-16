package com.elte.fsz.takemybook.application.transformer;
import org.springframework.stereotype.Component;

import com.elte.fsz.takemybook.application.webdomain.BookForm;
import com.elte.fsz.takemybook.domain.Book;

@Component
public class BookTransformer {
    public void transform(Book book, BookForm editBookForm) {
        editBookForm.setId(book.getId());
        editBookForm.setAuthor(book.getAuthor());
        editBookForm.setTitle(book.getTitle());
        editBookForm.setCondition(book.getCondition());
        editBookForm.setActiveTrade(book.isActiveTrade());
        editBookForm.setDescription(book.getDescription());
        editBookForm.setLanguage(book.getLanguage());
        editBookForm.setGenre(book.getGenre());
    }

    public void transform(BookForm editBookForm, Book book) {
        book.setAuthor(editBookForm.getAuthor());
        book.setTitle(editBookForm.getTitle());
        book.setCondition(editBookForm.getCondition());
        book.setActiveTrade(editBookForm.isActiveTrade());
        book.setDescription(editBookForm.getDescription());
        book.setLanguage(editBookForm.getLanguage());
        book.setGenre(editBookForm.getGenre());
    }
}
