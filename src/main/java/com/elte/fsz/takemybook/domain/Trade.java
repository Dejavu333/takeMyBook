package com.elte.fsz.takemybook.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Trade {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
    private Location location;
	@ManyToOne
    private Bookworm giver;
	@ManyToOne
    private Book givenBook;
	@ManyToOne
    private Bookworm receiver;
	@ManyToOne
    private Book receivedBook;
    private boolean isCompleted;
    @OneToMany(mappedBy = "trade",orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<TradeRequest> requests;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Bookworm getGiver() {
        return giver;
    }

    public void setGiver(Bookworm giver) {
        this.giver = giver;
    }

    public Book getGivenBook() {
        return givenBook;
    }

    public void setGivenBook(Book givenBookId) {
        this.givenBook = givenBookId;
    }

    public Bookworm getReceiver() {
        return receiver;
    }

    public void setReceiver(Bookworm receiver) {
        this.receiver = receiver;
    }

    public Book getReceivedBook() {
        return receivedBook;
    }

    public void setReceivedBook(Book receivedBookId) {
        this.receivedBook = receivedBookId;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public List<TradeRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<TradeRequest> requests) {
        this.requests = requests;
    }

	@Override
	public int hashCode() {
		return Objects.hash(givenBook, giver, id, isCompleted, location, receivedBook, receiver, requests);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Trade other = (Trade) obj;
		return Objects.equals(givenBook, other.givenBook) && Objects.equals(giver, other.giver)
				&& Objects.equals(id, other.id) && isCompleted == other.isCompleted
				&& Objects.equals(location, other.location) && Objects.equals(receivedBook, other.receivedBook)
				&& Objects.equals(receiver, other.receiver) && Objects.equals(requests, other.requests);
	}

}
