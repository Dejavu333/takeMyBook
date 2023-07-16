package com.elte.fsz.takemybook.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookwormController {
    @RequestMapping(path = "/navigation", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView mainNavigation(Model model) {
        return new ModelAndView("navigation");
    }

    @RequestMapping(path = "/tradelocationsettings", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView setTradeLocation(Model model) {
        return new ModelAndView("tradelocationsettings");
    }
}
