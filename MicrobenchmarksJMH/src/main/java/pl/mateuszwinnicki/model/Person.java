package pl.mateuszwinnicki.model;

import java.util.Objects;
import java.util.Random;

public class Person {

    private final Integer id;
    private final Integer age;

    public Person() {
        final Random random = new Random();
        id = random.nextInt();
        age = random.nextInt(100);
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Person person = (Person) o;
        return Objects.equals(id, person.id) &&
            Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age);
    }
}
