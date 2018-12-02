package pl.mateuszwinnicki.model2;

import pl.mateuszwinnicki.model.Person;

public class PersonWithoutEqualsAndHashCode extends Person {

    public PersonWithoutEqualsAndHashCode(String name, Integer age) {
        super(name, age);
    }

}
