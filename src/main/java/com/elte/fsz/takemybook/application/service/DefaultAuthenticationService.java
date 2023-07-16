package com.elte.fsz.takemybook.application.service;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elte.fsz.takemybook.domain.Admin;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Credentials;
import com.elte.fsz.takemybook.domain.User;
import com.elte.fsz.takemybook.repository.AdminRepository;
import com.elte.fsz.takemybook.repository.BookwormRepository;
import com.elte.fsz.takemybook.repository.CredentialsRepository;

@Component
public class DefaultAuthenticationService implements  AuthenticationService
{
	//* properties

	@Autowired
	private BookwormRepository bookwormRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CredentialsRepository credentialsRepository;

	//* methods
	@Override
	public Optional<User> authenticate(Credentials p_credentials)
	{

		Credentials c = credentialsRepository.findByloginName(p_credentials.getLoginName());
		if(c==null) return null;

		boolean isUser = c.getPassword().equals(p_credentials.getPassword());
		if(!isUser) return null;



		Bookworm b = bookwormRepository.findBycredentialsId(c.getId());
		Admin a = adminRepository.findBycredentialsId(c.getId());

		Optional <User> u = b == null ? Optional.ofNullable(a) : Optional.ofNullable(b);

		return u;
	}

	@Override
	public void storeUserInSession(User p_user, HttpSession p_session)
	{
		p_session.setAttribute("user", p_user);
	}

	@Override
	public void removeUserFromSession(HttpSession p_session)
	{
		p_session.removeAttribute("user");
	}

	@Override
	public User getUserFromSession(HttpSession p_session)
	{
		return (User)p_session.getAttribute("user");
	}

	@Override
	public boolean isUserInSession(HttpSession p_session)
	{
		return p_session.getAttribute("user") != null;
	}
}
