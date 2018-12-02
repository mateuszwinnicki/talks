package pl.mateuszwinnicki.model;

import java.util.Objects;

public class PersonWithoutEqualsAndHashcode extends Person {

    public PersonWithoutEqualsAndHashcode(String name, Integer age) {
        super(name, age);
    }

}
