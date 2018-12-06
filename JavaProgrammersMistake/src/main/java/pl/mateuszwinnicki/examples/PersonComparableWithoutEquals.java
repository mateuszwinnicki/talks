package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

public class PersonComparableWithoutEquals extends Person implements Comparable<PersonComparableWithoutEquals> {

    public PersonComparableWithoutEquals(final String name, final Integer age) {
        super(name, age);
    }

    @Override
    public int compareTo(final PersonComparableWithoutEquals p) {
        return this.getAge() - p.getAge();
    }

}
