package pl.mateuszwinnicki.equalsHashCode;

import java.util.Comparator;
import java.util.Objects;

class PersonConstantHashCodeComparable extends Person implements Comparable<PersonConstantHashCodeComparable> {

    PersonConstantHashCodeComparable(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonConstantHashCodeComparable that = (PersonConstantHashCodeComparable) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return 42; // technically correct
    }

    @Override
    public int compareTo(PersonConstantHashCodeComparable person) {
        return Comparator.comparing(Person::getAge)
            .thenComparing(Person::getName)
            .compare(this, person);
    }

}
