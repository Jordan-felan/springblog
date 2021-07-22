package com.codeup.springblog.controllers.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findById(long id);

    @Query("FROM Ad a WHERE a.title LIKE %:term%")
    Ad findFirstByTitle(String term);

}
