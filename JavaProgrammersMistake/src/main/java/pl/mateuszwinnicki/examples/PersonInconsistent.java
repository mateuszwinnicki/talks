package pl.mateuszwinnicki.examples;

import pl.mateuszwinnicki.benchmark.Person;

import java.util.Objects;

public class PersonInconsistent extends Person {

    /**
     * This will create Person with inconsistent hashCode and equals.
     * Equals is by name.
     * HashCode by age
     * @param name
     * @param age
     */
    public PersonInconsistent(final String name, final Integer age) {
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
        final PersonInconsistent that = (PersonInconsistent) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

}
