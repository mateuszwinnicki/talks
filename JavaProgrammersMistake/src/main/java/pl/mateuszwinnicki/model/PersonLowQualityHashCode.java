package pl.mateuszwinnicki.model;

import java.util.Objects;

class PersonLowQualityHashCode extends Person {

    PersonLowQualityHashCode(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonLowQualityHashCode that = (PersonLowQualityHashCode) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return getAge() % 2;
    }

}
