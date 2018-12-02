package pl.mateuszwinnicki;

import org.junit.Test;
import pl.mateuszwinnicki.model.Person;
import pl.mateuszwinnicki.model.PersonWithoutEqualsAndHashcode;
import pl.mateuszwinnicki.model.PersonWithoutHashCode;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class JavaMistakes {

    @Test
    public void hashCodeAndEqualsNotImplemented() {
        Set<Person> set = new HashSet<>();
        Person p1 = new PersonWithoutEqualsAndHashcode("Mateusz", 25);
        Person p2 = new PersonWithoutEqualsAndHashcode("Mateusz", 25);

        System.out.println(p1.equals(p2)); // false

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size()); //false
    }

    @Test
    public void onlyEqualsIsImplemented() {
        Set<Person> set = new HashSet<>();
        Person p1 = new PersonWithoutHashCode("Mateusz", 25);
        Person p2 = new PersonWithoutHashCode("Mateusz", 25);

        assertEquals(p1, p2); // true

        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size()); //false
    }




}
