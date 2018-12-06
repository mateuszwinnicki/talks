package pl.mateuszwinnicki.benchmark;

public abstract class Person {

    private final String name;
    private final Integer age;

    protected Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    protected String getName() {
        return name;
    }

    protected Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
