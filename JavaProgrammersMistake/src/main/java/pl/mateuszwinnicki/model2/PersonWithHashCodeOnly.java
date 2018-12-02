package pl.mateuszwinnicki.model2;

import pl.mateuszwinnicki.model.Person;

import java.util.Objects;

public class PersonWithHashCodeOnly extends Person {

    public PersonWithHashCodeOnly(String name, Integer age) {
        super(name, age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

}
