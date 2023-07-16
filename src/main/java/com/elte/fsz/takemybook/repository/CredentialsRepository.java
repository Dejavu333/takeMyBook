package com.elte.fsz.takemybook.repository;

import org.springframework.data.repository.CrudRepository;

import com.elte.fsz.takemybook.domain.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, Long>{
	public Credentials findByloginName(String loginName);
}
