package com.offcn.dao;

import com.offcn.po.Person;
import com.offcn.service.PersonService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonDao extends JpaRepository<Person,Long> {
    //继承的JpaRepository<Person,Long>中的泛型第一个是实体类，第二个是主键的类型

    //可以根据接口中定义方法的名字，自动推导出用户要进行的操作
    public Person findByNameEquals(String name);

    public List<Person> findByNameLike(String name);

    //JPQL语句,若要使用原生sql语句，在JPQL加,nativeQuery = true,表示支持原生sql语句
    @Query(value = "select p from Person p where p.name=:name and p.password=:password")
    public Person login(@Param("name") String name,@Param("password") String password);
}
