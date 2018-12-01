package pl.mateuszwinnicki.equalsHashCode;

import java.util.Random;

final class PersonFactory {

    static Person createRandomPersonConstantHashCode() {
        return new PersonConstantHashCode(
            "Random",
            new Random().nextInt() % 100
        );
    }

    static Person createRandomPersonFineHashCode() {
        return new PersonFineHashCode(
            "Random",
            new Random().nextInt() % 100
        );
    }

    static Person createRandomPersonLowQualityHashCode() {
        return new PersonLowQualityHashCode(
            "Random",
            new Random().nextInt() % 100
        );
    }

    static Person createRandomPersonWithConstantHashCodeAndComparable() {
        return new PersonConstantHashCodeComparable(
            "Random",
            new Random().nextInt() % 100
        );
    }

}
