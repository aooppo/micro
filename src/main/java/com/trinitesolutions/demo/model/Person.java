/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo.model;

import javax.persistence.*;

@Entity
@Table(schema = "hr")
public class Person extends AbsEntity{

    private String name;

    private Integer age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
