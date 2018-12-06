package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

import java.util.Objects;

public class PersonWithHashCodeOnly extends Person {

    public PersonWithHashCodeOnly(final String name, final Integer age) {
        super(name, age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

}
