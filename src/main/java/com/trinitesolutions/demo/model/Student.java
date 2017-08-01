package com.trinitesolutions.demo.model;



import javax.persistence.*;

@Entity
@Table(schema = "hr")
public class Student extends AbsEntity{
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
