package com.elte.fsz.takemybook.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Transactional
public class Bookworm extends User{
	 @OneToMany(mappedBy = "bookworm",orphanRemoval = true, cascade = CascadeType.ALL)
	 @JsonManagedReference
	 private List<Book> currentBooks;
	 @OneToOne(cascade = CascadeType.ALL)
	 private Location location;
	 private int switchedBooks ;
	 private int score;
	 private Rank Rank;
	 private String phone;
	 @OneToMany(mappedBy = "bookworm", orphanRemoval = true)
	 private List<TradeRequest> tradeRequest;
	 @OneToMany(mappedBy = "giver", orphanRemoval = true)
	 private List<Trade> gTrade;
	 @OneToMany(mappedBy = "receiver", orphanRemoval = true)
	 private List<Trade> rTrade;

	 public List<Book> getCurrentBooks() {
		return currentBooks;
	 }

	public void setCurrentBooks(List<Book> currentBooks) {
		this.currentBooks = currentBooks;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getSwitchedBooks() {
		return switchedBooks;
	}
	public void setSwitchedBooks(int switchedBooks) {
		this.switchedBooks = switchedBooks;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Rank getRank() {
		return Rank;
	}
	public void setRank(Rank rank) {
		Rank = rank;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	 @Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(Rank, currentBooks, id, location, phone, score, switchedBooks);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj) || (getClass() != obj.getClass()))
				return false;
			Bookworm other = (Bookworm) obj;
			return Rank == other.Rank && Objects.equals(currentBooks, other.currentBooks) && Objects.equals(id, other.id)
					&& Objects.equals(location, other.location) && Objects.equals(phone, other.phone)
					&& score == other.score && switchedBooks == other.switchedBooks;
		}
}
