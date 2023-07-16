package com.elte.fsz.takemybook.application.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elte.fsz.takemybook.domain.Admin;
import com.elte.fsz.takemybook.domain.Book;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Condition;
import com.elte.fsz.takemybook.domain.Credentials;
import com.elte.fsz.takemybook.domain.Genre;
import com.elte.fsz.takemybook.domain.Language;
import com.elte.fsz.takemybook.domain.Location;
import com.elte.fsz.takemybook.domain.Obsolete;
import com.elte.fsz.takemybook.domain.Rank;
import com.elte.fsz.takemybook.domain.Trade;
import com.elte.fsz.takemybook.domain.TradeRequest;
import com.elte.fsz.takemybook.domain.TradeRequestStatus;
import com.elte.fsz.takemybook.repository.AdminRepository;
import com.elte.fsz.takemybook.repository.BookRepository;
import com.elte.fsz.takemybook.repository.BookwormRepository;
import com.elte.fsz.takemybook.repository.CredentialsRepository;
import com.elte.fsz.takemybook.repository.LocationRepository;
import com.elte.fsz.takemybook.repository.ObsoleteRepository;
import com.elte.fsz.takemybook.repository.TradeRepository;
import com.elte.fsz.takemybook.repository.TradeRequestRepository;

@Component
public class TestDataGenerator {
	// Repositories
	@Autowired
	private BookwormRepository bookwormRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private TradeRequestRepository tradeRequestRepository;
	@Autowired
	private ObsoleteRepository obsoleteRepository;
	@Autowired
	private CredentialsRepository credentialsRepository;
	@Autowired
	private LocationRepository locationRepository;

	@Transactional
	public void ceateTestData() {

		Location user1loc = createLocation(48.25000,20.6209000);
		Location user2loc = createLocation(48.20000,21.6209000);
		Location user3loc = createLocation(41.20300,19.6209000);

		locationRepository.save(user1loc);
		locationRepository.save(user2loc);
		locationRepository.save(user3loc);

		/*
		Credentials adminc = createCredentials("admin","@D210M1n!");
		Credentials user1 = createCredentials("Norbi","N0rb1!");
		Credentials user2 = createCredentials("Boty","B0ty32!");
		Credentials user3 = createCredentials("Niki","N!k123");
		*/

		Credentials adminc = createCredentials("admin","ad123");
		Credentials user1 = createCredentials("user1","123");
		Credentials user2 = createCredentials("user2","123");
		Credentials user3 = createCredentials("user3","123");

		credentialsRepository.save(adminc);
		credentialsRepository.save(user1);
		credentialsRepository.save(user2);
		credentialsRepository.save(user3);

		Admin admin = createAdmin("Admin",adminc,"admin@a.admin");

		Bookworm Bworm1 = createBookworm(user1loc,10,10,Rank.BRONZE_BOOKMARK,"+36 1 1234567","MyNickName",user1,"norbi@email.book");
		Bookworm Bworm2 = createBookworm(user2loc,200,1,Rank.SILVER_BOOKMARK,"+36 1 1234567","Boty",user2,"boty@email.book");
		Bookworm Bworm3 = createBookworm(user3loc,1000,-5,Rank.GOLD_BOOKMARK,"+36 1 1234567","Niki",user3,"niki@email.book");

		adminRepository.save(admin);

		bookwormRepository.save(Bworm1);
		bookwormRepository.save(Bworm2);
		bookwormRepository.save(Bworm3);

		Collection<Genre> cG = new ArrayList<>();
		cG.add(Genre.FANTASY);
		cG.add(Genre.HISTORY);
		Collection<Genre> cG1 = new ArrayList<>();
		cG1.add(Genre.HUMOR);
		Collection<Genre> cG2 = new ArrayList<>();
		cG2.add(Genre.HUMOR);
		Collection<Genre> cG3 = new ArrayList<>();
		cG3.add(Genre.ADVENTURE);
		Collection<Genre> cG4 = new ArrayList<>();
		cG4.add(Genre.ADVENTURE);
		Collection<Genre> cG5 = new ArrayList<>();
		cG5.add(Genre.ADVENTURE);
		cG5.add(Genre.ROMANCE);
		cG5.add(Genre.DRAMA);

		Book testBook = createBook("Murakami Haruki","1q84",cG,"1 oldal szakadt, egyébként hibátlan",false,Language.ENGLISH,Condition.FACTORY_NEW,Bworm1);
		Book testBook2 = createBook("George Orwell","Állatfarm",cG1,"",false,Language.HUNGARIAN,Condition.FIELD_TESTED,Bworm3);
		Book testBook12 = createBook("Zsiráfbá","Ablak zsiráf",cG1,"",true,Language.ENGLISH,Condition.FIELD_TESTED,Bworm3);
		Book testBook8 = createBook("Suzanne Collins","Az éhezők viadala",cG5,"",false,Language.HUNGARIAN,Condition.FIELD_TESTED,Bworm3);
		Book testBook3 = createBook("Balázs Béla","igazi égszínkék",cG2,"Mi történik, ha a festett felhőből valódi eső zuhog? És ha a festett égbolt este igazán elsötétedik? Ferkó nem sejti, hogy amikor a búzavirág szirmaiból égszínkék festéket készít, kalamajkák sorát indítja el: a festéknek varázsereje van, és ez egyaránt felébreszti Cser Kari irigységét és Dán Zsuzsi csodálatát. Balázs Béla története nemcsak a három gyerek kalandjairól szól, hanem a művészet hatalmáról és a fantázia határtalanságáról is. A mára klasszikussá vált meseregény Reich Károly eredeti - és természetesen égszínkék - illusztrációival jelenik meg.",true,Language.HUNGARIAN,Condition.FIELD_TESTED,Bworm2);
		Book testBook4 = createBook("J. R. R. Tolkien","The Lord of the Rings I",cG3,"",true,Language.ENGLISH,Condition.MINIMAL_WEAR,Bworm2);
		Book testBook6 = createBook("J. R. R. Tolkien","The Lord of the Rings II",cG3,"",true,Language.ENGLISH,Condition.FIELD_TESTED,Bworm2);
		Book testBook7 = createBook("J. R. R. Tolkien","The Lord of the Rings III",cG3,"",true,Language.ENGLISH,Condition.WELL_WORN,Bworm2);
		Book testBook9 = createBook("E. L. James","A szürke ötven árnyalata",cG5,"",true,Language.ENGLISH,Condition.MINIMAL_WEAR,Bworm2);
		Book testBook10 = createBook("E. L. James","A szabadság ötven árnyalata ",cG5,"",true,Language.ENGLISH,Condition.FIELD_TESTED,Bworm2);
		Book testBook11 = createBook("E. L. James","A sötét ötven árnyalata",cG5,"",true,Language.ENGLISH,Condition.WELL_WORN,Bworm2);
		Book testBook5 = createBook("Dazai Oszamu","no longer human",cG4,"",false,Language.OTHER,Condition.FACTORY_NEW,Bworm1);

		Obsolete obsolete1 = createObsolete("Meg ette a kutya.");

		testBook5.setObsolete(obsolete1);

		Trade trade1 = createTrade(Bworm2.getLocation(),Bworm2,testBook4,false);
		Trade trade8 = createTrade(Bworm2.getLocation(),Bworm2,testBook3,false);
		Trade trade2 = createTrade(Bworm2.getLocation(),Bworm2,testBook6,false);
		Trade trade3 = createTrade(Bworm2.getLocation(),Bworm2,testBook7,false);

		Trade trade4 = createTrade(Bworm2.getLocation(),Bworm2,testBook9,false);
		Trade trade5 = createTrade(Bworm2.getLocation(),Bworm2,testBook10,false);
		Trade trade6 = createTrade(Bworm2.getLocation(),Bworm2,testBook11,false);

		Trade trade7 = createTrade(Bworm3.getLocation(),Bworm3,testBook12,false);


		TradeRequest TradeRequest1 = createTradeRequest(testBook2,TradeRequestStatus.PENDING,Bworm3,trade1);
		TradeRequest TradeRequest2 = createTradeRequest(testBook,TradeRequestStatus.REJECTED,Bworm1,trade1);
		TradeRequest TradeRequest3 = createTradeRequest(testBook,TradeRequestStatus.REJECTED,Bworm1,trade2);

		List<TradeRequest> tradeRequestList = new ArrayList<>();
		tradeRequestList.add(TradeRequest2);
		tradeRequestList.add(TradeRequest1);
		List<TradeRequest> tradeRequestList1 = new ArrayList<>();
		tradeRequestList.add(TradeRequest3);

		trade1.setRequests(tradeRequestList);
		trade2.setRequests(tradeRequestList1);

		tradeRepository.save(trade1);
		tradeRepository.save(trade2);
		tradeRepository.save(trade3);
		tradeRepository.save(trade4);
		tradeRepository.save(trade5);
		tradeRepository.save(trade6);
		tradeRepository.save(trade7);
		tradeRepository.save(trade8);

		tradeRequestRepository.save(TradeRequest1);
		tradeRequestRepository.save(TradeRequest2);
		tradeRequestRepository.save(TradeRequest3);

		bookRepository.save(testBook);
		bookRepository.save(testBook2);
		bookRepository.save(testBook3);
		bookRepository.save(testBook4);
		bookRepository.save(testBook5);
		bookRepository.save(testBook6);
		bookRepository.save(testBook7);
		bookRepository.save(testBook8);
		bookRepository.save(testBook9);
		bookRepository.save(testBook10);
		bookRepository.save(testBook11);
		bookRepository.save(testBook12);

		obsoleteRepository.save(obsolete1);

	}

	private Book createBook(String author,String title,Collection<Genre> genre,String description,boolean isActiveTrade, Language language,Condition condition,Bookworm bookworm) {
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setCondition(condition);
		book.setDescription(description);
		book.setActiveTrade(isActiveTrade);
		book.setGenre(genre);
		book.setBookworm(bookworm);
		book.setLanguage(language);
		book.setObsolete(null);
		return book;
	}

	private Obsolete createObsolete(String description) {
		Obsolete obsolete = new Obsolete();
		Date dNow = new Date();
		obsolete.setDateOfDeath(dNow);
		obsolete.setDescription(description);
		return obsolete;
	}

	private Bookworm createBookworm(Location location,int switchedBooks,int score,Rank Rank,String phone,String nickName,Credentials credentials, String email) {
		Bookworm bookworm = new Bookworm();
		bookworm.setNickName(nickName);
		bookworm.setEmail(email);
		bookworm.setCredentials(credentials);
		bookworm.setCurrentBooks(null);
		bookworm.setLocation(location);
		bookworm.setRank(Rank);
		bookworm.setScore(score);
		bookworm.setSwitchedBooks(switchedBooks);
		bookworm.setPhone(phone);
		return bookworm;
	}
	private Admin createAdmin(String nickName,Credentials credentials, String email) {
		Admin admin = new Admin();
		admin.setNickName(nickName);
		admin.setEmail(email);
		admin.setCredentials(credentials);
		return admin;
	}
	private Credentials createCredentials(String loginName,String password) {
		Credentials credentials = new Credentials();
		credentials.setLoginName(loginName);
		credentials.setPassword(password);
		return credentials;
	}
	private Location createLocation(double Latitude,double Longitude) {
		Location location = new Location();
		location.setLatitude(Latitude);
		location.setLongitude(Longitude);
		return location;
	}

	private Trade createTrade(Location location,Bookworm giver, Book givenBook,boolean isCompleted) {
		Trade trade = new Trade();
		trade.setGivenBook(givenBook);
		trade.setGiver(giver);
		trade.setIsCompleted(isCompleted);
		trade.setLocation(location);
		trade.setReceivedBook(null);
		trade.setReceiver(null);
		return trade;
	}

	private TradeRequest createTradeRequest(Book book,TradeRequestStatus tradeRequestStatus,Bookworm bookworm,Trade trade) {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setBook(book);
		tradeRequest.setBookworm(bookworm);
		tradeRequest.setTrade(trade);
		tradeRequest.setTradeRequestStatus(tradeRequestStatus);
		return tradeRequest;
	}
}
