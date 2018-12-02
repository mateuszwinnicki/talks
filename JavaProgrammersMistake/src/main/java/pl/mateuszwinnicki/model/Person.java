package pl.mateuszwinnicki.model;

public abstract class Person {

    private String name;
    private Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

}
