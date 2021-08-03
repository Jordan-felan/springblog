package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findById(long id);

    @Query("FROM Ad a WHERE a.title LIKE %:term%")
    Ad findFirstByTitle(String term);

    Ad findByTitle(String ad_to_be_deleted);
}
