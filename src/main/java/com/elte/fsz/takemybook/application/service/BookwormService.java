package com.elte.fsz.takemybook.application.service;

import java.util.List;

import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Credentials;
import com.elte.fsz.takemybook.domain.Location;

public interface BookwormService {
	public void register(Credentials credentials,String nickname,String phoneNumber, String email,Location location);
	public void deleteProfile(Bookworm bookworm,String password);
	public void updateProfile(Bookworm bookworm,String email,String nickname,String phoneNumber, String username, String password);
	public void checkScoreForRank(Bookworm bookworm);
	public List<Bookworm> getBookwormsByDistance(double distance, Bookworm bookworm);
	public Iterable<Bookworm> getAllBookworms();
	public void deleteById(long id);
	public void modifyScore(long id, int increase);
	public Bookworm findById(long id);
}
