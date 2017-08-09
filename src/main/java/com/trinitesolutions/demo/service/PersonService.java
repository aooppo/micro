/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.trinitesolutions.demo.service;

import com.trinitesolutions.demo.dao.PersonDAO;
import com.trinitesolutions.demo.exception.NormalException;
import com.trinitesolutions.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

    public Person save(Person person) {
        return personDAO.save(person);
    }

    public void delete(Person person) {
        personDAO.delete(person);
    }

    public List<Person> findAll() {
        return personDAO.findAll();
    }
    public Person findOne(String id) {
        return personDAO.findOne(id);
    }
    @Transactional
    public void processPerson(Person p, int i) {
        save(p);
        if(i == 0) {
            throw new NormalException(100, "i cannot be 0.");
        }
        System.out.println("lol...");
    }

}
