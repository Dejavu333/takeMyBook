package com.elte.fsz.takemybook.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elte.fsz.takemybook.application.service.AuthenticationService;
import com.elte.fsz.takemybook.application.service.BookService;
import com.elte.fsz.takemybook.application.service.BookwormService;
import com.elte.fsz.takemybook.application.webdomain.BookList;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;

@Controller
public class ProfileController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookwormService bookwormService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private HttpSession session;

    @GetMapping("profile")
    public String listBooks(Model model) {
        List<BookList> bookLists = new ArrayList<>();
        Bookworm bw = bookwormService.findById(((Bookworm)authenticationService.getUserFromSession(session)).getId());

        List<Book> allBooks = bookService.findBooksByBookworm(bw);
        for (Book book :
                allBooks) {
            if (book.getObsolete() == null) {
                bookLists.add(new BookList(book.getId(), book.getTitle(), book.getAuthor(), book.getCondition(), book.isActiveTrade(), book.getGenre().stream().toList(), book.getDescription()));
            }

        }

        model.addAttribute("bookshelf", bookLists);
        model.addAttribute("bookworm", bw);

        return "profile";
    }


}
