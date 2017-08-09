/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo.dao;

import com.trinitesolutions.demo.model.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDAO extends JpaRepository<Person, String> {
//    @Cacheable("person")
    List<Person> findByName(String name);
//    @Cacheable("person")
    List<Person> findAll();
//    @CachePut("person")
    <S extends Person> S save(S s);
}
