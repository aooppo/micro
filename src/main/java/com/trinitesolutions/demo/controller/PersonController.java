package com.trinitesolutions.demo.controller;

import com.trinitesolutions.demo.dao.PersonDAO;
import com.trinitesolutions.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired private PersonDAO personDAO;

    @PostMapping("person")
    public Person save(Person person) {
        return personDAO.save(person);
    }

    @GetMapping("person")
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @GetMapping("person/{name}")
    public List<Person> findByName(@PathVariable String name) {
        return personDAO.findByName(name);
    }

    @PutMapping("person/{id}")
    public Person update(@PathVariable String id, @ModelAttribute Person person) {
        Person p = personDAO.getOne(id);
        p.setAge(person.getAge());
        p.setName(person.getName());
        return personDAO.save(p);
    }


}
