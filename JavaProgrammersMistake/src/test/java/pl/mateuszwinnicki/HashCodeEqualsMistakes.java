package pl.mateuszwinnicki;

import org.junit.Test;
import pl.mateuszwinnicki.model.Person;
import pl.mateuszwinnicki.model2.PersonInconsistent;
import pl.mateuszwinnicki.model2.PersonWithHashCodeOnly;
import pl.mateuszwinnicki.model2.PersonWithoutEqualsAndHashCode;
import pl.mateuszwinnicki.model2.PersonWithoutHashCode;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HashCodeEqualsMistakes {

    @Test
    public void hashCodeAndEqualsNotImplemented() {
        Set<Person> set = new HashSet<>();
        Person p1 = new PersonWithoutEqualsAndHashCode("Mateusz", 25);
        Person p2 = new PersonWithoutEqualsAndHashCode("Mateusz", 25);

        System.out.println(p1.equals(p2));

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

    @Test
    public void onlyEqualsIsImplemented() {
        Set<Person> set = new HashSet<>();
        Person p1 = new PersonWithoutHashCode("Mateusz", 25);
        Person p2 = new PersonWithoutHashCode("Mateusz", 25);

        assertEquals(p1, p2);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

    @Test
    public void onlyHashCodeIsImplemented() {
        Set<Person> set = new HashSet<>();
        Person p1 = new PersonWithHashCodeOnly("Mateusz", 25);
        Person p2 = new PersonWithHashCodeOnly("Mateusz", 25);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

    @Test
    public void hashCodeInconsistentWithEquals() {
        Set<Person> set = new HashSet<>();
        Person p1 = new PersonInconsistent("Mateusz", 30);
        Person p2 = new PersonInconsistent("Mateusz", 40);

        assertEquals(p1, p2);

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
    }

}
