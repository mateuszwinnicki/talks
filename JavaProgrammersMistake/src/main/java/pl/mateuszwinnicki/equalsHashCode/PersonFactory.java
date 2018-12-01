package pl.mateuszwinnicki.equalsHashCode;

import java.util.Random;

final class PersonFactory {

    static Person createRandomPersonBadHashCode() {
        return new PersonBadHashCode(
            "Random",
            new Random().nextInt() % 100
        );
    }

    static Person createRandomPersonBetterHashCode() {
        return new PersonBetterHashCode(
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

}
