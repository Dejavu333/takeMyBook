package com.elte.fsz.takemybook.application.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.repository.BookRepository;
import com.elte.fsz.takemybook.repository.TradeRepository;

@Service
public class DefaultBookService implements BookService{
	@Autowired
    private BookRepository bookRepository;

	@Autowired
    private TradeRepository tradeRepository;

	@Autowired
	private AuthenticationService authenticationService;

	@Override
	public List<Book> getAllObsoleteBook() {
		List<Book> obsoletes = new ArrayList<>();
		for (Book book : bookRepository.findAll())
		{
			if (book.getObsolete() != null) {
				obsoletes.add(book);
			}
		}

		return obsoletes;
	}

	@Override
	public List<Book> findBooksByBookworm(Bookworm bookworm) {
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepository.findAll())
		{
			if (book.getBookworm().getId() == bookworm.getId()) {
				books.add(book);
			}
		}
		return books;
	}

	@Override
	public List<Trade> getBookHistory(Book book) {
		// search for given and received book as well
		List<Trade> trades = new ArrayList<>();
		for (Trade trade: tradeRepository.findAll()){
			if (trade.getGivenBook().equals(book) || trade.getReceivedBook().equals(book)) {
				trades.add(trade);
			}
		}
		return trades;
	}

	@Override
	public List<Book> getBooksInArea(Bookworm bookworm, double distance) {
		/*List<Bookworm> bookwormsInArea = new ArrayList<>();
		for (User user: userRepository.findAll()) {
			if (user instanceof Bookworm && ) {

			}
		}*/
		return null;
	}

	@Override
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void deleteById(long id) {
		bookRepository.deleteById(id);
		return;
	}
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> sb(String title, String author, Optional<Genre> genre,
						 Optional<Language> language, Optional<Condition> condition, boolean anyCondition,
						 HttpSession session)
	{

		List<Book> tmp2 =  new ArrayList<>();
		for (Book book : bookRepository.findAll())
		 {
			 if(((Bookworm)authenticationService.getUserFromSession(session)).getId() != book.getBookworm().getId() && book.isActiveTrade())
				tmp2.add(book);
		 }
		tmp2 = title != "" ? tmp2.stream().filter(c -> c.getTitle().equals(title)).collect(Collectors.toList()) : tmp2;
		tmp2 = author != "" ? tmp2.stream().filter(c -> c.getAuthor().equals(author)).collect(Collectors.toList()) : tmp2;
		tmp2 = genre.isPresent() ? tmp2.stream().filter(c -> c.getGenre().contains(genre.get())).collect(Collectors.toList()) : tmp2;
		tmp2 = language.isPresent() ? tmp2.stream().filter(c -> c.getLanguage().equals(language.get())).collect(Collectors.toList()) : tmp2;
		tmp2 = condition.isPresent() && !anyCondition  ? tmp2.stream().filter(c -> c.getCondition().equals(condition.get())).collect(Collectors.toList()) : tmp2;
		return tmp2;
	}

	@Override
	public Book findByid(long id) {
		return bookRepository.findById(id).get();
	}
}
