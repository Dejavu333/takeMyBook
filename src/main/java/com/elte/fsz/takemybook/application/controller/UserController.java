package com.elte.fsz.takemybook.application.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.elte.fsz.takemybook.application.service.AuthenticationService;
import com.elte.fsz.takemybook.application.service.BookwormService;
import com.elte.fsz.takemybook.application.webdomain.RegisterForm;
import com.elte.fsz.takemybook.domain.Admin;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Credentials;
import com.elte.fsz.takemybook.domain.Location;

@Controller
public class UserController
{
	//* properties
	@Autowired
	private BookwormService bookwormService;
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	HttpSession session;

	@GetMapping("/")
	public String serveLogin(Model model)
	{
		model.addAttribute("registerForm", new RegisterForm());
		// response
		return "/login";
	}

	@PostMapping("/register")
	public String register(@Valid RegisterForm registerForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		if (bindingResult.hasErrors()) {
			//List<ObjectError> list = bindingResult.getAllErrors();
			redirectAttributes.addFlashAttribute("message", "Invalid registration");
			System.out.println("ifben");
			return "redirect:/";
		}
		System.out.println("registerbe érkezés");
		//model.addAttribute("registerForm", registerForm);
		// locals
		Credentials c = new Credentials();
		c.setLoginName(registerForm.getUsername());
		c.setPassword(registerForm.getPassword());
		Location location = new Location();
		location.setLongitude(registerForm.getInlon());
		location.setLatitude(registerForm.getInlat());
		// controlling
		bookwormService.register(c, registerForm.getNickName(), registerForm.getPhone(), registerForm.getEmail(),location);
			
		// response
		return "redirect:/";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public RedirectView login(String p_username, String p_password, HttpSession p_session)
	{
		// locals
		Credentials c = new Credentials();
		c.setLoginName(p_username);
		c.setPassword(p_password);
		RedirectView redirectView;

		// controlling
			// authentication
		try
		{
			authenticationService.authenticate(c).ifPresent(user -> {
				authenticationService.storeUserInSession(user,p_session);


			});

		}
		catch(Exception e)
		{
			return new RedirectView("login");
		}

		// success
		if (authenticationService.isUserInSession(p_session) && authenticationService.getUserFromSession(p_session) instanceof Bookworm)
		{
			redirectView = new RedirectView("navigation");
		}
		else if (authenticationService.isUserInSession(p_session) && authenticationService.getUserFromSession(p_session) instanceof Admin) {
			redirectView = new RedirectView("admin");
		}
		// failure
		else
		{

			redirectView = new RedirectView("login");
		}
		// response
		return redirectView;
	}

	@RequestMapping(path = "logout", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView serveLogout(Model model)
	{
		model.addAttribute("registerForm", new RegisterForm());
		authenticationService.removeUserFromSession(session);
		return new ModelAndView("/login");
	}




}