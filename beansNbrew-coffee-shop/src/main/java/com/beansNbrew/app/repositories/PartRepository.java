package com.beansNbrew.app.repositories;

import com.beansNbrew.app.domain.Part;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface PartRepository extends CrudRepository <Part,Long> {
    @Query("SELECT p FROM Part p WHERE p.name LIKE %?1%")
    public List<Part> search(String keyword);
}
