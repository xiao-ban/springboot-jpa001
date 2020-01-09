package com.offcn.controller;


import com.offcn.po.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService ps;

    @PostMapping("/")
    public String add(@RequestBody Person person) {
        ps.add(person);
        return "add-ok";
    }

    @PutMapping("/{id}")
    public String updata(@PathVariable(name = "id") Long id,@RequestBody Person person) {
        person.setId(id);
        ps.updata(person);
        return "update-ok";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        ps.delete(id);
        return "delete-ok";
    }

    @GetMapping("/")
    public List<Person> findAll() {
        return ps.findAll();
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable(name = "id") Long id) {
        return ps.findOne(id);
    }

    @GetMapping("/name/{name}")
    public Person findByNameEquals(@PathVariable(name = "name") String name) {
        return ps.findByNameEquals(name);
    }

    @GetMapping("/namelike/{name}")
    public List<Person> findByNameLike(@PathVariable(name = "name") String name) {
        return ps.findByNameLike(name);
    }

    @GetMapping("/login/{name}/{password}")
    public Person login(@PathVariable(name = "name") String name,@PathVariable("password") String password) {
        return ps.login(name,password);
    }
}
