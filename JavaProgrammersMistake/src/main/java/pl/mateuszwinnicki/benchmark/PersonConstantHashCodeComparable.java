package pl.mateuszwinnicki.benchmark;

import java.util.Comparator;
import java.util.Objects;

class PersonConstantHashCodeComparable extends Person implements Comparable<PersonConstantHashCodeComparable> {

    PersonConstantHashCodeComparable(final String name, final Integer age) {
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
        final PersonConstantHashCodeComparable that = (PersonConstantHashCodeComparable) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return 42; // technically correct
    }

    @Override
    public int compareTo(final PersonConstantHashCodeComparable person) {
        return Comparator.comparing(Person::getAge)
            .thenComparing(Person::getName)
            .compare(this, person);
    }

}
