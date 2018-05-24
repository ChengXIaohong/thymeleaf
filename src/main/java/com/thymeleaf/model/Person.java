package com.thymeleaf.model;

import org.thymeleaf.util.StringUtils;

/**
 * @author chengxiaohong
 */
public class Person {
    private String name;
    private Integer age;
    private Integer sex;
    public Person()  {
        super();
    }
    public Person(String name,Integer gae) {
        super();
        this.name=name;
        this.age=gae;
    }

    public Person(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public Integer getAge() {
        return age;
    }

    public Integer setAge(Integer age) {
        return age;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    enum Sex{
        MAN(1,"男"),
        MAAM(0,"女"),
        UNKNOWN(3,"女");
        private Integer sexBiz;
        private String sex;

        Sex(Integer sexBiz, String sex) {
            this.sexBiz = sexBiz;
            this.sex = sex;
        }

        public Integer getSexBiz() {
            return sexBiz;
        }

        public void setSexBiz(Integer sexBiz) {
            this.sexBiz = sexBiz;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
        public static Sex getSexEnumByCode(Integer sexBiz){
            for(Sex sexEnum : Sex.values()){
                if(StringUtils.equals(sexBiz, sexEnum.getSexBiz())){
                    return sexEnum;
                }
            }
            return null;
        }
    };

}
