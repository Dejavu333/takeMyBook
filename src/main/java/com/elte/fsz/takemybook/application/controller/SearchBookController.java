package com.elte.fsz.takemybook.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elte.fsz.takemybook.application.service.BookService;
import com.elte.fsz.takemybook.application.webdomain.BookList;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;

@Controller
public class SearchBookController {
    @Autowired
    private BookService bookService;


    @GetMapping("booksearch")
    public String addBook(Model model) {
        model.addAttribute("genre", Genre.values());
        model.addAttribute("language", Language.values());
        model.addAttribute("condition", Condition.values());

        return "booksearch";
    }




    @RequestMapping(path = "booksearch", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchForBooks(Model model, String title, String author, Optional<Genre> genre, Optional<Language> language, Optional<Condition> condition, boolean anyCondition, HttpSession session) {
    	  model.addAttribute("genre", Genre.values());
          model.addAttribute("language", Language.values());
          model.addAttribute("condition", Condition.values());

          List<BookList> bookLists = new ArrayList<>();
          List<Book> books = bookService.sb(title, author, genre, language, condition, anyCondition, session);

          for (Book book :
                  books) {

              bookLists.add(new BookList(book.getId(), book.getTitle(), book.getAuthor(), book.getCondition(), book.isActiveTrade(), book.getGenre().stream().toList(), book.getDescription()));
          }


          model.addAttribute("searchedBooks", bookLists);
        return new ModelAndView("booksearch").addObject(model);
    }


    @RequestMapping(path = "bookSearchByBookWormId", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView searchForBooks(long bookWormId, Model model) {
        System.out.println("bookWormId: " + bookWormId);

        model.addAttribute("genre", Genre.values());
        model.addAttribute("language", Language.values());
        model.addAttribute("condition", Condition.values());


        //list books by bookworm id
        List<Book> books = (List<Book>) bookService.getAllBooks();
        books.removeIf(book -> book.getBookworm().getId() != bookWormId || !book.isActiveTrade());

        List<BookList> bookLists = new ArrayList<>();
        for (Book book :
                books) {
            bookLists.add(new BookList(book.getId(), book.getTitle(), book.getAuthor(), book.getCondition(), book.isActiveTrade(), book.getGenre().stream().toList(), book.getDescription()));
        }

        model.addAttribute("searchedBooks", bookLists);
      return new ModelAndView("booksearch").addObject(model);
  }
}