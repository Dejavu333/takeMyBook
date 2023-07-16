package com.elte.fsz.takemybook.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.elte.fsz.takemybook.application.service.BookService;
import com.elte.fsz.takemybook.application.service.BookwormService;
import com.elte.fsz.takemybook.application.webdomain.AllBookList;
import com.elte.fsz.takemybook.application.webdomain.AllBookworm;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;

@Controller
public class AdminController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookwormService bookwormService;

	@Autowired
	HttpSession session;

	@RequestMapping(path = "admin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(Model model,HttpSession p_session) {
		if(p_session.getAttribute("user") != null) {
			if(p_session.getAttribute("user").getClass().toString().equals("class com.elte.fsz.takemybook.domain.Admin")) {
			List<AllBookList> allBookList = new ArrayList<>();
			List<AllBookworm> allbooksworms = new ArrayList<>();
	        Iterable<Book> allBooks = bookService.getAllBooks();
	        for (Book book :
	                allBooks) {
	        	allBookList.add(new AllBookList(book.getId(), book.getTitle(), book.getAuthor(), book.isActiveTrade(), book.getGenre().stream().toList(), book.getDescription(),book.getBookworm().getCredentials().getLoginName()));
	        }

	        Iterable<Bookworm> allbooksworm = bookwormService.getAllBookworms();
	        for (Bookworm bookworm :
	        	allbooksworm) {
	        	allbooksworms.add(new AllBookworm(bookworm.getId(),bookworm.getNickName(),bookworm.getCredentials().getLoginName(),bookworm.getScore()));
	        }


	        model.addAttribute("bookshelf", allBookList);
	        model.addAttribute("booksworms", allbooksworms);
	        return new ModelAndView("admin").addObject(model);
		}
		}
		return new ModelAndView("login");
	}

		@RequestMapping(path = "/deletebook", method = RequestMethod.POST)
		@ResponseBody
		public RedirectView deletebook(long id,Model model)
		{
			bookService.deleteById(id);
	        return new RedirectView("admin");
		}

		@RequestMapping(path = "/deletebookworm", method = RequestMethod.POST)
		@ResponseBody
		public RedirectView deletebookworm(long id,Model model)
	    {
			bookwormService.deleteById(id);
			return new RedirectView("admin");
		}

		@RequestMapping(path = "/modifyscore", method = RequestMethod.POST)
		@ResponseBody
		public RedirectView modifyscore(long id,int score)
	    {
			bookwormService.modifyScore(id, score);
			return new RedirectView("admin");
		}


		@RequestMapping(path = "/deletebookworm", method = RequestMethod.GET)
		@ResponseBody
		public RedirectView deletebookworm()
	    {
			return new RedirectView("/");
		}

		@RequestMapping(path = "/deletebook", method = RequestMethod.GET)
		@ResponseBody
		public RedirectView deletebook()
	    {
			return new RedirectView("/");
		}

		@RequestMapping(path = "/modifyscore", method = RequestMethod.GET)
		@ResponseBody
		public RedirectView modifyscore()
	    {
			return new RedirectView("/");
		}
	}

