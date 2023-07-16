package com.elte.fsz.takemybook.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.elte.fsz.takemybook.application.service.BookwormService;
import com.elte.fsz.takemybook.application.service.TradeRequestService;
import com.elte.fsz.takemybook.application.service.TradeService;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.domain.TradeRequest;

@Controller
public class TradeController {
    @Autowired
    private TradeService tradeService;
    @Autowired
    private TradeRequestService tradeRequestService;
    @Autowired
    private BookwormService bookwormService;
    @PostMapping("acceptrequest")
    public String makeTrade(Model model, long acceptreq) {
        TradeRequest tradereq = tradeRequestService.findById(acceptreq);
        Trade trade = tradereq.getTrade();


        trade.setReceiver(tradereq.getBookworm());
        trade.setReceivedBook(tradereq.getBook());

        tradeService.complete(trade);
        tradeRequestService.deleteAllRequestByTrade(trade);

        tradeService.tradeBooks(trade.getGiver(), trade.getReceiver(), trade.getGivenBook(), trade.getReceivedBook());
        bookwormService.checkScoreForRank(trade.getGiver());
        bookwormService.checkScoreForRank(trade.getReceiver());

        return "requests";
    }
}
