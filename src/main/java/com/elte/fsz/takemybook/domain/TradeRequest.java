package com.elte.fsz.takemybook.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TradeRequest {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Book book;
    private TradeRequestStatus tradeRequestStatus;

    @ManyToOne
	private Bookworm bookworm;
    @ManyToOne
	private Trade trade;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public TradeRequestStatus getTradeRequestStatus() {
        return tradeRequestStatus;
    }

    public void setTradeRequestStatus(TradeRequestStatus tradeRequestStatus) {
        this.tradeRequestStatus = tradeRequestStatus;
    }

    public Bookworm getBookworm() {
		return bookworm;
	}

	public void setBookworm(Bookworm bookworm) {
		this.bookworm = bookworm;
	}

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    @Override
	public int hashCode() {
		return Objects.hash(book, bookworm, id, trade, tradeRequestStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		TradeRequest other = (TradeRequest) obj;
		return Objects.equals(book, other.book) && Objects.equals(bookworm, other.bookworm)
				&& Objects.equals(id, other.id) && Objects.equals(trade, other.trade)
				&& tradeRequestStatus == other.tradeRequestStatus;
	}

}
