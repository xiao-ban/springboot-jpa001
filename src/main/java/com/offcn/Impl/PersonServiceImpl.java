package com.offcn.Impl;

import com.offcn.dao.PersonDao;
import com.offcn.po.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonDao pd;
    @Override
    public void add(Person person) {
        pd.save(person);
    }

    @Override
    public void updata(Person person) {
        pd.saveAndFlush(person);
    }

    @Override
    public void delete(Long id) {
        pd.deleteById(id);
    }

    @Override
    public Person findOne(Long id) {
        return pd.findById(id).get();
    }

    @Override
    public List<Person> findAll() {
        return pd.findAll();
    }

    @Override
    public Person findByNameEquals(String name) {
        return pd.findByNameEquals(name);
    }

    @Override
    public List<Person> findByNameLike(String name) {
        return pd.findByNameLike("%"+name+"%");
    }

    @Override
    public Person login(String name, String password) {
        return pd.login(name,password);
    }
}
