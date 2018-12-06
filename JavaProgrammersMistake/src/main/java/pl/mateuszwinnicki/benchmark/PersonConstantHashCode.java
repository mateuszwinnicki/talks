package pl.mateuszwinnicki.benchmark;

import java.util.Objects;

class PersonConstantHashCode extends Person {

    PersonConstantHashCode(final String name, final Integer age) {
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
        final PersonConstantHashCode that = (PersonConstantHashCode) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return 42; // technically correct
    }
}
