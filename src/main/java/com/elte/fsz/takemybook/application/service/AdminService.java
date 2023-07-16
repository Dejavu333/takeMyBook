package com.elte.fsz.takemybook.application.service;

import com.elte.fsz.takemybook.domain.Bookworm;

public interface AdminService {
	public void modifyScore(Bookworm bookworm, int increase);
}
