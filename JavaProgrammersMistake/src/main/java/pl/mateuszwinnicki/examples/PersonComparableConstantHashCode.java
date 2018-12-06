package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

import java.util.Objects;

public class PersonComparableConstantHashCode extends Person implements Comparable<PersonComparableConstantHashCode> {

    public PersonComparableConstantHashCode(final String name, final Integer age) {
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
        final PersonComparableConstantHashCode that = (PersonComparableConstantHashCode) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return 44;
    }

    public int compareTo(final PersonComparableConstantHashCode p) {
        return this.getAge() - p.getAge();
    }

}
