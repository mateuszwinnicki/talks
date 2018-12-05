package pl.mateuszwinnicki.model2;

import pl.mateuszwinnicki.model.Person;

import java.util.Objects;

public class PersonComparableConstantHashCode extends Person implements Comparable<PersonComparableConstantHashCode> {

    public PersonComparableConstantHashCode(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonComparableConstantHashCode that = (PersonComparableConstantHashCode) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return 44;
    }

    public int compareTo(PersonComparableConstantHashCode p) {
        return this.getAge() - p.getAge();
    }

}
