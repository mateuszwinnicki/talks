package pl.mateuszwinnicki;

import org.junit.Test;
import pl.mateuszwinnicki.benchmark.Person;
import pl.mateuszwinnicki.examples.PersonInconsistent;
import pl.mateuszwinnicki.examples.PersonWithHashCodeOnly;
import pl.mateuszwinnicki.examples.PersonWithoutEqualsAndHashCode;
import pl.mateuszwinnicki.examples.PersonWithoutHashCode;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HashCodeEqualsMistakes {

    @Test
    public void hashCodeAndEqualsNotImplemented() {
        final Set<Person> set = new HashSet<>();
        final Person p1 = new PersonWithoutEqualsAndHashCode("Mateusz", 25);
        final Person p2 = new PersonWithoutEqualsAndHashCode("Mateusz", 25);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

    @Test
    public void onlyEqualsIsImplemented() {
        final Set<Person> set = new HashSet<>();
        final Person p1 = new PersonWithoutHashCode("Mateusz", 25);
        final Person p2 = new PersonWithoutHashCode("Mateusz", 25);

        assertEquals(p1, p2);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

    @Test
    public void onlyHashCodeIsImplemented() {
        final Set<Person> set = new HashSet<>();
        final Person p1 = new PersonWithHashCodeOnly("Mateusz", 25);
        final Person p2 = new PersonWithHashCodeOnly("Mateusz", 25);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

    @Test
    public void hashCodeInconsistentWithEquals() {
        final Set<Person> set = new HashSet<>();
        final Person p1 = new PersonInconsistent("Mateusz", 30);
        final Person p2 = new PersonInconsistent("Mateusz", 40);

        assertEquals(p1, p2);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

}
