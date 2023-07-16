package com.elte.fsz.takemybook.application.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elte.fsz.takemybook.application.transformer.BookTransformer;
import com.elte.fsz.takemybook.application.webdomain.BookForm;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.repository.BookRepository;
import com.elte.fsz.takemybook.repository.TradeRepository;

@Controller
public class EditBookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EditBookController.class);
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookTransformer bookTransformer;
    @Autowired
    TradeRepository tradeRepository;

    @GetMapping("editbook/{id}")
    public String editForm(BookForm bookForm, @PathVariable("id") long id) {
        bookTransformer.transform(bookRepository.findById(bookForm.getId()).get(), bookForm);
        return "editbook";
    }

    @PostMapping("editbook")
    public String editBook(@Valid BookForm bookForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "editbook";
        }

        Book book = bookRepository.findById(bookForm.getId()).get();
        if (!book.isActiveTrade() && bookForm.isActiveTrade()) {
            Trade trade = new Trade();
            trade.setGiver(book.getBookworm());
            trade.setGivenBook(book);
            trade.setLocation(book.getBookworm().getLocation());
            trade.setIsCompleted(false);

            tradeRepository.save(trade);
        } else if (book.isActiveTrade() && !bookForm.isActiveTrade()) {
            tradeRepository.delete(tradeRepository.findByGivenBookAndIsCompleted(book, false));
        }
        bookTransformer.transform(bookForm, book);
        bookRepository.save(book);
        LOGGER.info("Book successfully saved.");
        redirectAttributes.addFlashAttribute("message", "Book successfully saved.");
        return "redirect:profile";
    }

    @ModelAttribute("genre")
    public Map<Genre, String> getGenre(){
        return Genre.toMap();
    }

    @ModelAttribute("language")
    public Language[] getLanguages() {
        return Language.values();
    }
}
