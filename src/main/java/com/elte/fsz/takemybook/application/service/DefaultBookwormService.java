package com.elte.fsz.takemybook.application.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Credentials;
import com.elte.fsz.takemybook.domain.Location;
import com.elte.fsz.takemybook.domain.Rank;
import com.elte.fsz.takemybook.domain.User;
import com.elte.fsz.takemybook.repository.BookwormRepository;
import com.elte.fsz.takemybook.repository.LocationRepository;

@Component
public class DefaultBookwormService implements BookwormService {
	@Autowired
	private BookwormRepository bookwormRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Override
	public void register(Credentials credentials, String nickname, String phoneNumber, String email,Location location) {
		Bookworm bookworm = new Bookworm();
		bookworm.setCredentials(credentials);
		bookworm.setNickName(nickname);
		bookworm.setPhone(phoneNumber);
		bookworm.setEmail(email);
		setInitialRank(bookworm);
		bookworm.setLocation(location);
		locationRepository.save(location);
		bookwormRepository.save(bookworm);
	}
	@Override
	public void deleteProfile(Bookworm bookworm, String password) {
		if (password.equals(bookworm.getCredentials().getPassword())) {
			bookwormRepository.delete(bookworm);
		}
	}
	@Override
	public void updateProfile(Bookworm bookworm, String email, String nickname, String phoneNumber, String username, String password) {
		bookworm.setEmail(email.length() < 0 ? bookworm.getEmail() : email);
		bookworm.setPhone(phoneNumber.length() < 0 ? bookworm.getPhone() : phoneNumber);
		bookworm.setNickName(nickname.length() < 0 ? bookworm.getNickName() : nickname);
		

		Credentials c = new Credentials();
		c.setLoginName(username.length() < 0 ? bookworm.getCredentials().getLoginName() : username);
		c.setPassword(username.length() < 0 ? bookworm.getCredentials().getPassword() : password);
		bookworm.setCredentials(c);

		bookwormRepository.save(bookworm);

	}
	
	@Override
	public void checkScoreForRank(Bookworm bookworm) {
		if (bookworm.getScore() > 0) return;

		Rank rank = switch (bookworm.getRank()) {
				case BRONZE_BOOKMARK ->
					Rank.SILVER_BOOKMARK;
				case SILVER_BOOKMARK ->
					Rank.GOLD_BOOKMARK;
				default -> Rank.GOLD_BOOKMARK;
		};

		boolean isRankedUp = !bookworm.getRank().equals(rank);
		if (isRankedUp) {
				bookworm.setRank(rank);
				bookworm.setScore(newScoreWhenRankedUp(rank));
			bookwormRepository.save(bookworm);
		}
	}

	private int newScoreWhenRankedUp(Rank rank) {
		return switch(rank) {
			case BRONZE_BOOKMARK ->
					50;
			case SILVER_BOOKMARK ->
					1000000;
			case GOLD_BOOKMARK ->
					0;
		};
	}

	private Bookworm setInitialRank(Bookworm bookworm) {
			bookworm.setRank(Rank.BRONZE_BOOKMARK);
			bookworm.setScore(newScoreWhenRankedUp(Rank.BRONZE_BOOKMARK));
			return bookworm;
	}

	@Override
	public List<Bookworm> getBookwormsByDistance(double distance, Bookworm bookworm) {
		List<Bookworm> tmp = new ArrayList<>();
		double x1 = bookworm.getLocation().getLongitude();
		double y1 = bookworm.getLocation().getLatitude();
		for (User user : bookwormRepository.findAll())
		{
			if(user instanceof Bookworm && !bookworm.getCredentials().equals(user.getCredentials()))
			{
				double x2 = ((Bookworm) user).getLocation().getLongitude();
				double y2 = ((Bookworm) user).getLocation().getLatitude();
				double result = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
				if(result <= distance)
				{
					tmp.add((Bookworm) user);
				}
			}
			/*else
			{
				throw new Exception("Exception message");
			}*/
		}
		return tmp;
	}
	@Override
	public Iterable<Bookworm> getAllBookworms() {
		return bookwormRepository.findAll();
	}
	@Override
	public void deleteById(long id) {
		bookwormRepository.deleteById(id);
	}
	@Override
	public void modifyScore(long id, int increase) {
		Bookworm b = bookwormRepository.findById(id).orElseThrow();
		b.setScore(increase + b.getScore());
		bookwormRepository.save(b);
	}

	@Override
	public Bookworm findById(long id) {
		return bookwormRepository.findById(id).get();
	}
}
