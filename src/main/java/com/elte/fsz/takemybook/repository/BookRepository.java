package com.elte.fsz.takemybook.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    //methods to be implemented
	public List<Book> findByTitle(String title);
	public List<Book> findByauthor(String author);
	public List<Book> findBygenre(Genre genre);
	public List<Book> findAllByLanguage(Language language);
	public List<Book> findBycondition(Condition condition);
	public List<Book> findByTitleAndAuthorAndGenreAndLanguageAndCondition(String title, String author, Genre genre, Language language, Condition condition);
}