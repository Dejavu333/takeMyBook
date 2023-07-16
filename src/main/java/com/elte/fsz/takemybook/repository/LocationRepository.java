package com.elte.fsz.takemybook.repository;

import org.springframework.data.repository.CrudRepository;

import com.elte.fsz.takemybook.domain.Location;

public interface LocationRepository extends CrudRepository<Location, Long>{
}
