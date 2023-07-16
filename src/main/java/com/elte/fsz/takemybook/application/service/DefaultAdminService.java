package com.elte.fsz.takemybook.application.service;
import org.springframework.beans.factory.annotation.Autowired;

import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.repository.BookwormRepository;

public class DefaultAdminService implements AdminService {
	@Autowired
    private BookwormRepository bookwormRepository;

	@Override
	public void modifyScore(Bookworm bookworm, int increase) {
		int score = bookworm.getScore();
		bookworm.setScore(score + increase);
		bookwormRepository.save(bookworm);
	}
}
