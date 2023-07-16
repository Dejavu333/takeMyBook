package com.elte.fsz.takemybook.application.service;

import java.util.List;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.domain.TradeRequest;
import com.elte.fsz.takemybook.domain.TradeRequestStatus;

public interface TradeRequestService
{
	public TradeRequest findByBook(Book book);
    public List<TradeRequest> findByBookworm(Bookworm bookworm);
	public void changeTradeRequestStatus(TradeRequest tradeRequest,TradeRequestStatus tradeRequestStatus);
	public List<TradeRequest> findByTrade(Trade trade);
	public Iterable<TradeRequest> getAllTradeRequest();
	public void deleteById(long id);
	public void saveTradeRequest(TradeRequest tradeRequest);
	public TradeRequest findById(long id);
	public void deleteAllRequestByTrade(Trade trade);
}
