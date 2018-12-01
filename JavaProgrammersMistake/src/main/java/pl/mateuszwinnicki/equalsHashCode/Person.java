package pl.mateuszwinnicki.equalsHashCode;

abstract class Person {

    private String name;
    private Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    public abstract int hashCode();

    public abstract boolean equals(Object object);

}
