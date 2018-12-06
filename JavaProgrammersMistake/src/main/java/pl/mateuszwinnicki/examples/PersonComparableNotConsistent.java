package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

import java.util.Objects;

public class PersonComparableNotConsistent extends Person implements Comparable<PersonComparableNotConsistent> {


    public PersonComparableNotConsistent(final String name, final Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PersonComparableNotConsistent that = (PersonComparableNotConsistent) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(final PersonComparableNotConsistent p) {
        return this.getAge() - p.getAge();
    }
}
