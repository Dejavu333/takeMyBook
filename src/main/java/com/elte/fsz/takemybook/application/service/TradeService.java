package com.elte.fsz.takemybook.application.service;

import java.util.List;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;

public interface TradeService
{
	public Trade findByreceivedBook(Book book);
	public Trade findByGivenBook(Book book);
	public Trade findByGivenBookAndActiceTrade(Book book);
	public List<Trade> findByGiver(Bookworm bookworm);
	public void complete(Trade trade);
	public void saveTrade(Trade trade);
	public List<Book> findAllActiveTrade(long id);

	public void tradeBooks(Bookworm giver, Bookworm receiver, Book givenBook, Book receivedBook);


}
