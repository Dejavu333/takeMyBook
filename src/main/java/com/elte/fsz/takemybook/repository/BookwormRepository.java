package com.elte.fsz.takemybook.repository;
import org.springframework.data.repository.CrudRepository;

import com.elte.fsz.takemybook.domain.Bookworm;

public interface BookwormRepository extends CrudRepository<Bookworm, Long> {
    //methods to be implemented
    public Bookworm findBycredentialsId(long long1);

}