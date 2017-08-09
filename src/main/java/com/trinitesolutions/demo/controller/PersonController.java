package com.trinitesolutions.demo.controller;

import com.trinitesolutions.demo.dao.PersonDAO;
import com.trinitesolutions.demo.exception.NormalException;
import com.trinitesolutions.demo.model.Person;
import com.trinitesolutions.demo.service.PersonService;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired PersonService personService;

    @PostMapping
    public Person save(@Valid @ModelAttribute Person person, BindingResult result) {
        return personService.save(person);
    }


    @GetMapping
    public List<Person> index() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public Person show(@PathVariable("id") String id) {
        if (id != null) {
            Person p = personService.findOne(id);
            return p;
        }
        return null;
    }
    @PutMapping
    public String update(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if(result.hasErrors()) {
            logger.error(result.toString());
        }
        personService.save(person);
        return "redirect:/person/" + person.getId();
    }


    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        try {
            if (id != null) {
                Person entity = personService.findOne(id);
                personService.delete(entity);
            }
        } catch (Exception e) {
            throw new NormalException(-1, e.getMessage());
        }
        return "redirect:/person/index";
    }

    @ModelAttribute("person")
    public Person buildPerson(@RequestParam(value = "id", required = false) String id) {
        if(StringUtils.isEmpty(id)) {
            return new Person();
        }else {
            return personService.findOne(id);
        }
    }


}
