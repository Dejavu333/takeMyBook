package com.elte.fsz.takemybook.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;

public interface TradeRepository extends CrudRepository<Trade, Long> {
        //methods to be implemented

 		public Trade findByreceivedBook(Book book);
        public Trade findBygivenBook(Book book);
        public Trade findByGivenBookAndIsCompleted(Book book,boolean isCompleted);
        public List<Trade> findBygiver(Bookworm bookworm);
}


