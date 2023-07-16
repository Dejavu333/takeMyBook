package com.elte.fsz.takemybook.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class User {
	@Id
	@GeneratedValue
	protected long id;
	private String nickName;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	private Credentials credentials;
	private String email;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(credentials, email, id, nickName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		User other = (User) obj;
		return Objects.equals(credentials, other.credentials) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nickName, other.nickName);
	}
}
