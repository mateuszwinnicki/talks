package pl.mateuszwinnicki.model2;

import pl.mateuszwinnicki.model.Person;

import java.util.Comparator;
import java.util.Objects;

public class PersonComparableNotConsistent extends Person implements Comparable<PersonComparableNotConsistent> {


    public PersonComparableNotConsistent(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonComparableNotConsistent that = (PersonComparableNotConsistent) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(PersonComparableNotConsistent p) {
        return this.getAge() - p.getAge();
    }
}
