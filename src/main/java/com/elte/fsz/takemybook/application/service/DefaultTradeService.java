package com.elte.fsz.takemybook.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.repository.BookRepository;
import com.elte.fsz.takemybook.repository.BookwormRepository;
import com.elte.fsz.takemybook.repository.TradeRepository;

@Service
public class DefaultTradeService implements TradeService
{
	//*properties
	@Autowired
    private TradeRepository tradeRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookwormRepository bookwormRepository;

	@Override
	public void complete(Trade trade)
	{
		trade.setIsCompleted(true);
		tradeRepository.save(trade);
	}

	@Override
	public Trade findByGivenBook(Book book)
	{
		return tradeRepository.findBygivenBook(book);
	}

	@Override
	public List<Trade> findByGiver(Bookworm bookworm)
	{
		return tradeRepository.findBygiver(bookworm);
	}

	@Override
	public Trade findByreceivedBook(Book book) {
		return tradeRepository.findByreceivedBook(book);
	}

	@Override
	public Trade findByGivenBookAndActiceTrade(Book book) {
		return tradeRepository.findByGivenBookAndIsCompleted(book, false);
	}

	@Override
	public void saveTrade(Trade trade) {
		tradeRepository.save(trade);
	}

	@Override
	public List<Book> findAllActiveTrade(long id) {
		List<Book> books = new ArrayList<>();

		for (Trade trade :
				tradeRepository.findAll()) {
			if (!trade.getIsCompleted() && trade.getGiver().getId() != id) {
				books.add(bookRepository.findById(trade.getGivenBook().getId()).get());
			}
		}
		return books;
	}

	@Override
	public void tradeBooks(Bookworm giver, Bookworm receiver, Book givenBook, Book receivedBook) {
		List<Book> giverCurrentBooks = giver.getCurrentBooks();
		giverCurrentBooks.add(receivedBook);
		giver.setCurrentBooks(giverCurrentBooks);
		receivedBook.setBookworm(giver);
		giver.setSwitchedBooks(giver.getSwitchedBooks() + 1);
		giver.setScore(giver.getScore() - 1);

		List<Book> receiverCurrentBooks = receiver.getCurrentBooks();
		receiverCurrentBooks.add(givenBook);
		receiver.setCurrentBooks(receiverCurrentBooks);
		givenBook.setBookworm(receiver);
		receiver.setSwitchedBooks(giver.getSwitchedBooks() + 1);
		receiver.setScore(giver.getScore() - 1);

		bookRepository.save(givenBook);
		bookRepository.save(receivedBook);

		giverCurrentBooks.remove(givenBook);
		receiverCurrentBooks.remove(receivedBook);

		bookRepository.save(givenBook);
		bookRepository.save(receivedBook);
		bookwormRepository.save(giver);
		bookwormRepository.save(receiver);
	}
}
