package pl.mateuszwinnicki.model2;

import pl.mateuszwinnicki.model.Person;

import java.util.Objects;

public class PersonComparableWithoutEquals extends Person implements Comparable<PersonComparableWithoutEquals> {

    public PersonComparableWithoutEquals(String name, Integer age) {
        super(name, age);
    }

    @Override
    public int compareTo(PersonComparableWithoutEquals p) {
        return this.getAge() - p.getAge();
    }

}
