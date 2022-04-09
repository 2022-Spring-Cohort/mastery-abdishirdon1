package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    // Collection<Hashtag> findAll();

    // Hashtag findByName(String name);
}