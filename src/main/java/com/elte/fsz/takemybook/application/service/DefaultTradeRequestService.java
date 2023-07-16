package com.elte.fsz.takemybook.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.domain.TradeRequest;
import com.elte.fsz.takemybook.domain.TradeRequestStatus;
import com.elte.fsz.takemybook.repository.TradeRequestRepository;

@Service
public class DefaultTradeRequestService implements TradeRequestService
{
	//* properties
	@Autowired
    private TradeRequestRepository tradeRequestRepository;

	//* methods
	@Override
	public void changeTradeRequestStatus(TradeRequest tradeRequest, TradeRequestStatus p_tradeRequestStatus)
	{
		tradeRequestRepository.findById(tradeRequest.getId()).ifPresent(tr -> {
			tr.setTradeRequestStatus(p_tradeRequestStatus);
			tradeRequestRepository.save(tr);
		});
	}

	@Override
	public TradeRequest findByBook(Book p_book)
	{
		return tradeRequestRepository.findByBook(p_book);
	}

	@Override
	public List<TradeRequest> findByBookworm(Bookworm p_bookworm)
	{
		return tradeRequestRepository.findByBookworm(p_bookworm);
	}

	@Override
	public List<TradeRequest> findByTrade(Trade trade) {
		return tradeRequestRepository.findByTrade(trade);
	}

	@Override
	public Iterable<TradeRequest> getAllTradeRequest() {
		return tradeRequestRepository.findAll();
	}

	@Override
	public void deleteById(long id) {
		tradeRequestRepository.deleteById(id);
		return;
	}

	@Override
	public void saveTradeRequest(TradeRequest tradeRequest) {
		tradeRequestRepository.save(tradeRequest);
	}

	@Override
	public TradeRequest findById(long id) {
		return tradeRequestRepository.findById(id).get();
	}

	@Override
	public void deleteAllRequestByTrade(Trade trade) {
		trade.getRequests().forEach(request -> tradeRequestRepository.delete(request));
	}
}
