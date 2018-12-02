package pl.mateuszwinnicki.model;

import java.util.Objects;

public class PersonWithoutHashCode extends Person {

    public PersonWithoutHashCode(String name, Integer age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithoutHashCode that = (PersonWithoutHashCode) o;
        return Objects.equals(getName(), that.getName()) &&
            Objects.equals(getAge(), that.getAge());
    }

}
