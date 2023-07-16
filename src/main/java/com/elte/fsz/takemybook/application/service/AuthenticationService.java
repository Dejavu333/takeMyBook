package com.elte.fsz.takemybook.application.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.elte.fsz.takemybook.domain.Credentials;
import com.elte.fsz.takemybook.domain.User;

public interface AuthenticationService
{
	public Optional<User> authenticate(Credentials credentials);

	public void storeUserInSession(User p_user, HttpSession p_session);

	public void removeUserFromSession(HttpSession p_session);

	public User getUserFromSession(HttpSession p_session);

	public boolean isUserInSession(HttpSession p_session);
}
