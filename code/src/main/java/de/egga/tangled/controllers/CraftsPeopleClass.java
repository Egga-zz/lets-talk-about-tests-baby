package de.egga.tangled.controllers;

/**
 * @author egga
 */
public class CraftsPeopleClass {

    private String name ;

    private Integer age;

    private String city;

    public CraftsPeopleClass(final String name, final Integer age, final String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }
}
