package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

public class PersonWithoutEqualsAndHashCode extends Person {

    public PersonWithoutEqualsAndHashCode(final String name, final Integer age) {
        super(name, age);
    }

}
