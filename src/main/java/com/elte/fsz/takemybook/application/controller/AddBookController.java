package com.elte.fsz.takemybook.application.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elte.fsz.takemybook.application.service.AuthenticationService;
import com.elte.fsz.takemybook.application.service.BookService;
import com.elte.fsz.takemybook.application.webdomain.BookForm;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;

@Controller
public class AddBookController {
    @Autowired
    HttpSession session;
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    BookService bookService;

    @GetMapping("addbook")
    public String book(Model model) {
        model.addAttribute("addBook", new Book());
        return "addbook";
    }

    @PostMapping("addbook")
    public String addBook(@Valid @ModelAttribute("addBook") BookForm addBook, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes,HttpSession p_session) {
        if (bindingResult.hasErrors()) {
            return "addbook";
        }

        Book book = new Book();
        book.setAuthor(addBook.getAuthor());
        book.setTitle(addBook.getTitle());
        book.setGenre(addBook.getGenre());
        book.setDescription(addBook.getDescription());
        book.setActiveTrade(addBook.isActiveTrade());
        book.setLanguage(addBook.getLanguage());
        book.setCondition(addBook.getCondition());

        book.setBookworm((Bookworm) p_session.getAttribute("user"));

        bookService.saveBook(book);
        model.addAttribute("addBook", addBook);
        redirectAttributes.addFlashAttribute("message", "Book successfully added.");
        return "redirect:profile";
    }

    @ModelAttribute("genre")
    public Genre[] getGenre() {
        return Genre.values();
    }

    @ModelAttribute("language")
    public Language[] getLanguages() {
        return Language.values();
    }
}
