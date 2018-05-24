package com.thymeleaf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * person 对象转换器
 * @author chengxiaohong
 */
public class PersonConverter {
    private String name;
    private Integer age;
    private String sex;

    public PersonConverter() {
        super();
    }

    public PersonConverter(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public PersonConverter(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 简易转换
     * @param person
     * @return
     */
    public  static PersonConverter converter(Person person){
        PersonConverter desc = new PersonConverter();
        desc.setName(person.getName());
        desc.setAge(person.getAge());
        if (person.getSex() != null ) {
            desc.setSex(Person.Sex.getSexEnumByCode(person.getSex()).getSex());
        }
        return desc;
    }

    /**
     * 简易集合转换
     * @param persons
     * @return
     */
    public  static List<PersonConverter> converter(List<Person> persons){
        List<PersonConverter> personConverters = null;
        if (persons.size() > 0) {
            personConverters = new ArrayList<>();
            for (Person person : persons) {
                personConverters.add(PersonConverter.converter(person));
            }
        }
        return personConverters;
    }
}
