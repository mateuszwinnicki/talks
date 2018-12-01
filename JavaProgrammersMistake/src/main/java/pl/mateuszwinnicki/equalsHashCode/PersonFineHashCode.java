package pl.mateuszwinnicki.equalsHashCode;

import java.util.Objects;

class PersonFineHashCode extends Person {

    PersonFineHashCode(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonFineHashCode that = (PersonFineHashCode) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

}
