package com.elte.fsz.takemybook.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.elte.fsz.takemybook.application.service.AuthenticationService;
import com.elte.fsz.takemybook.application.service.BookService;
import com.elte.fsz.takemybook.application.service.BookwormService;
import com.elte.fsz.takemybook.application.service.TradeRequestService;
import com.elte.fsz.takemybook.application.service.TradeService;
import com.elte.fsz.takemybook.application.webdomain.BookList;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.domain.TradeRequest;
import com.elte.fsz.takemybook.domain.TradeRequestStatus;

@Controller
public class TradeRequestsController {
    @Autowired
    private TradeRequestService tradeRequestService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private AuthenticationService authenticationService;
	@Autowired
	private BookService bookService;
    @Autowired
    private BookwormService bookwormService;
    @Autowired
    private HttpSession session;

    @GetMapping("requests")
    public String showRequests(Model model) {
        Bookworm bookworm = bookwormService.findById(((Bookworm)authenticationService.getUserFromSession(session)).getId());

        // Incoming request for Bookworm's trades
        List<Trade> tradesInProgress = new ArrayList<>();
        for (Trade trade:
                tradeService.findByGiver(bookworm)) {
            if (trade.getRequests() != null && !trade.getIsCompleted()) {
                tradesInProgress.add(trade);
            }
        }

        List<TradeRequest> incomingRequests = new ArrayList<>();
        for (Trade trade :
                tradesInProgress) {
            for (TradeRequest request :
                    trade.getRequests()) {
                if (request.getTradeRequestStatus() == TradeRequestStatus.PENDING) {
                    incomingRequests.add(request);
                }
            }
        }

        model.addAttribute("incoming", incomingRequests);

        // Outgoing trade requests by Bookworm
        List<TradeRequest> outgoingRequests = tradeRequestService.findByBookworm(bookworm);
        model.addAttribute("outgoing", outgoingRequests);


        return "requests";
    }

    @RequestMapping(path = "/makerequest", method = RequestMethod.POST)
	@ResponseBody
    public ModelAndView makerequest(Model model,long reqbook) {
    List<BookList> bookLists = new ArrayList<>();
    List<Book> allBooks = bookService.findBooksByBookworm((Bookworm)authenticationService.getUserFromSession(session));
    for (Book book :
            allBooks) {
        if (book.getObsolete() == null) {
            bookLists.add(new BookList(book.getId(), book.getTitle(), book.getAuthor(), book.getCondition(), book.isActiveTrade(), book.getGenre().stream().toList(), book.getDescription()));
        }

    }
    Book tradeBook = bookService.findByid(reqbook);
    model.addAttribute("reqbook", reqbook);
    model.addAttribute("bookshelf", bookLists);
    model.addAttribute("tradeBook", tradeBook);
    return new ModelAndView("makerequest");
    }

    @RequestMapping(path = "/makerequestfinal", method = RequestMethod.POST)
	@ResponseBody
    public RedirectView makerequestfinal(Model model,long gibook,long reqbook, RedirectAttributes redirectAttributes) {
    	TradeRequest tmp= new TradeRequest();
    	tmp.setTrade(tradeService.findByGivenBookAndActiceTrade(bookService.findByid(reqbook)));
    	tmp.setTradeRequestStatus(TradeRequestStatus.PENDING);
    	tmp.setBook(bookService.findByid(gibook));
    	tmp.setBookworm((Bookworm)authenticationService.getUserFromSession(session));
    	tradeRequestService.saveTradeRequest(tmp);
        redirectAttributes.addFlashAttribute("message", "Request successfully sent. Keep up!");
    	return new RedirectView("requests");
    }

    @GetMapping("requestdetails/{id}")
    public String showRequestDetails(Model model, @PathVariable("id") long id) {
        TradeRequest tradeRequest = tradeRequestService.findById(id);
        model.addAttribute("request", tradeRequest);
        return "requestdetails";
    }

    @PostMapping("rejectrequest")
    public String rejectRequest(Model model, long rejectreq, RedirectAttributes redirectAttributes) {
        TradeRequest tradeRequest = tradeRequestService.findById(rejectreq);
        tradeRequest.setTradeRequestStatus(TradeRequestStatus.REJECTED);
        tradeRequestService.saveTradeRequest(tradeRequest);

        redirectAttributes.addFlashAttribute("message","You successfully rejected the request.");
        return "redirect:requests";
    }
}
