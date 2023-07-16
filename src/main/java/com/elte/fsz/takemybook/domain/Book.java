package com.elte.fsz.takemybook.domain;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Transactional
public class Book {
    //properties
	@Id
 	@GeneratedValue
	private long id;
	private String author;
    private String title;
    @ElementCollection(targetClass=Genre.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="Genre")
    private Collection<Genre> genre;
    @Column(length = 800)
    private String description;
    private boolean activeTrade;
    private Language language;
    @OneToOne(orphanRemoval = true)
    private Obsolete obsolete;
    private Condition condition;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Bookworm bookworm;

	 @OneToMany(mappedBy = "givenBook", orphanRemoval = true)
	 private List<Trade> gTrade;

	 @OneToMany(mappedBy = "receivedBook", orphanRemoval = true)
	 private List<Trade> rTrade;

	 @OneToMany(mappedBy = "book", orphanRemoval = true)
	 private List<TradeRequest> TradeRequest;
	//constructors
    public Book() {
    }
    //mutators, accessors
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Collection<Genre> getGenre() {
        return genre;
    }
    public void setGenre(Collection<Genre> genre) {
        this.genre = genre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActiveTrade() {
        return activeTrade;
    }

    public void setActiveTrade(boolean activeTrade) {
        this.activeTrade = activeTrade;
    }
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }
    public Obsolete getObsolete() {
        return obsolete;
    }
    public void setObsolete(Obsolete obsolete) {
        this.obsolete = obsolete;
    }
    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public Bookworm getBookworm() {
		return bookworm;
	}
	public void setBookworm(Bookworm bookworm) {
		this.bookworm = bookworm;
	}

	 @Override
		public int hashCode() {
			return Objects.hash(author, bookworm, condition, description, genre, id, activeTrade, language, obsolete,
					title);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if ((obj == null) || (getClass() != obj.getClass()))
				return false;
			Book other = (Book) obj;
			return Objects.equals(author, other.author) && Objects.equals(bookworm, other.bookworm)
					&& condition == other.condition && Objects.equals(description, other.description)
					&& Objects.equals(genre, other.genre) && id == other.id && activeTrade == other.activeTrade
					&& language == other.language && Objects.equals(obsolete, other.obsolete)
					&& Objects.equals(title, other.title);
		}
}
