package com.elte.fsz.takemybook.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.domain.TradeRequest;

public interface TradeRequestRepository extends CrudRepository<TradeRequest, Long> {
    //methods to be implemented
    public TradeRequest findByBook(Book book);
    public List<TradeRequest> findByBookworm(Bookworm bookworm);
    public List<TradeRequest> findByTrade(Trade trade);

}


