package pl.mateuszwinnicki.benchmark;

import java.util.Random;

public final class PersonFactory {

    public static Person createRandomPerson(final PersonHashCodeType type) {
        final String name = "Mateusz";
        final Integer age = new Random().nextInt() % 1_000;
        switch (type) {
            case CONSTANT: return new PersonConstantHashCode(name, age);
            case CONSTANT_AND_COMPARABLE: return new PersonConstantHashCodeComparable(name, age);
            case VERY_LOW_QUALITY: return new PersonLowQualityHashCode(name, age);
            case FINE: return new PersonFineHashCode(name, age);
        }
        throw new IllegalArgumentException("Factory cannot create object with type: " + type);
    }

}
