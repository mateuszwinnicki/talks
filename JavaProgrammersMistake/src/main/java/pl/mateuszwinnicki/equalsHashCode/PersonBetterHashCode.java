package pl.mateuszwinnicki.equalsHashCode;

import java.util.Objects;

class PersonBetterHashCode implements Person {

    private String name;
    private Integer age;

    PersonBetterHashCode(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBetterHashCode that = (PersonBetterHashCode) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
