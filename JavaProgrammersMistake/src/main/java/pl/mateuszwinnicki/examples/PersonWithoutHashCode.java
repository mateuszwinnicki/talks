package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

import java.util.Objects;

public class PersonWithoutHashCode extends Person {

    public PersonWithoutHashCode(final String name, final Integer age) {
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
        final PersonWithoutHashCode that = (PersonWithoutHashCode) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

}
