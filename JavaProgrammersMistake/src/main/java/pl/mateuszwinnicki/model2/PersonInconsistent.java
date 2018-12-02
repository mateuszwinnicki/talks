package pl.mateuszwinnicki.model2;

import pl.mateuszwinnicki.model.Person;

import java.util.Objects;

public class PersonInconsistent extends Person {

    /**
     * This will create Person with inconsistent hashCode and equals.
     * Equals is by name.
     * HashCode by age
     * @param name
     * @param age
     */
    public PersonInconsistent(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInconsistent that = (PersonInconsistent) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

}
