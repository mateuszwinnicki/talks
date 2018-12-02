package pl.mateuszwinnicki.model;

import java.util.Random;

public final class PersonFactory {

    public static Person createRandomPerson(PersonHashCodeType type) {
        String name = "Mateusz";
        Integer age = new Random().nextInt() % 100;
        switch (type) {
            case CONSTANT: return new PersonConstantHashCode(name, age);
            case CONSTANT_AND_COMPARABLE: return new PersonConstantHashCodeComparable(name, age);
            case VERY_LOW_QUALITY: return new PersonLowQualityHashCode(name, age);
            case FINE: return new PersonFineHashCode(name, age);
        }
        throw new IllegalArgumentException("Factory cannot create object with type: " + type);
    }

}
