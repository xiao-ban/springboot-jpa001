package com.offcn.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructorvf 
@AllArgsConstructor
@Entity                 //可以生成表
@Table(name = "tb_person") //自定义表名
public class Person {
    @Id          //主键
    @GeneratedValue//自增
    private Long id;
    @Column(name = "name",length = 255,nullable = true) //不为空，长度255,自定义名字，默认和属性名一致
    private String name;
    @Column(length = 255,nullable = true) //不为空，长度255
    private String password;
    @Column(length = 255,nullable = true) //不为空，长度255
    private Integer age;
}
