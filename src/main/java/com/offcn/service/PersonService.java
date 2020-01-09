package com.offcn.service;

import com.offcn.po.Person;

import java.util.List;

public interface PersonService {
    public void add(Person person);
    public void updata(Person person);
    public void delete(Long id);
    public Person findOne(Long id);
    public List<Person> findAll();
    public Person findByNameEquals(String name);
    public List<Person> findByNameLike(String name);
    public Person login(String name,String password);
}
