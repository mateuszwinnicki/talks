package pl.mateuszwinnicki.model;

public abstract class Person {

    private String name;
    private Integer age;

    protected Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    protected String getName() {
        return name;
    }

    protected Integer getAge() {
        return age;
    }

}
