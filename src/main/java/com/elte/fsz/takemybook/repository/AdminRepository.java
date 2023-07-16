package com.elte.fsz.takemybook.repository;

import org.springframework.data.repository.CrudRepository;

import com.elte.fsz.takemybook.domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    public Admin findBycredentialsId(long long1);
}
