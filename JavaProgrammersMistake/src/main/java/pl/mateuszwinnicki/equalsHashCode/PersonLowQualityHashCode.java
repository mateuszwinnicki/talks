package pl.mateuszwinnicki.equalsHashCode;

import java.util.Objects;

class PersonLowQualityHashCode implements Person {

    private String name;
    private Integer age;

    PersonLowQualityHashCode(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonLowQualityHashCode that = (PersonLowQualityHashCode) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return age % 2;
    }

}
