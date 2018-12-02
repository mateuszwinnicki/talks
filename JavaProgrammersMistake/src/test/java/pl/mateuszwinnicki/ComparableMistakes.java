package pl.mateuszwinnicki;

import org.junit.Test;
import pl.mateuszwinnicki.model.Person;
import pl.mateuszwinnicki.model2.PersonComparableNotConsistent;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ComparableMistakes {

    /**
     * Equals by name, but compareTo by age
     */
    @Test
    public void equalsNotConsistentWithCompareTo() {
        Person p1 = new PersonComparableNotConsistent("Mateusz", 25);
        Person p2 = new PersonComparableNotConsistent("Mateusz", 26);
        Person p3 = new PersonComparableNotConsistent("Mateusz", 27);

        Set<Person> tree = new TreeSet<>();

        tree.add(p1);
        tree.add(p2);
        tree.add(p3);

        System.out.println(tree);

        assertEquals(1, tree.size());
    }

    /**
     * Equals by name, but compareTo by age
     */
    @Test
    public void distinctStream() {
        Person p1 = new PersonComparableNotConsistent("Mateusz", 30);
        Person p2 = new PersonComparableNotConsistent("Mateusz", 20);
        Person p3 = new PersonComparableNotConsistent("Mateusz", 10);
        Person p4 = new PersonComparableNotConsistent("Kamil", 11);
        Person p5 = new PersonComparableNotConsistent("Kamil", 22);

        List<Person> result = Stream.of(p1, p2, p3, p4, p5)
            .distinct()
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    /**
     * Equals by name, but compareTo by age
     */
    @Test
    public void firstSortedThanDistinctStream() {
        Person p1 = new PersonComparableNotConsistent("Mateusz", 30);
        Person p2 = new PersonComparableNotConsistent("Mateusz", 20);
        Person p3 = new PersonComparableNotConsistent("Mateusz", 10);
        Person p4 = new PersonComparableNotConsistent("Kamil", 11);
        Person p5 = new PersonComparableNotConsistent("Kamil", 22);

        List<Person> result = Stream.of(p1, p2, p3, p4, p5)
            .sorted()
            .distinct()
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    /**
     * Equals by name, but compareTo by age
     */
    @Test
    public void firstDistinctThanSortedStream() {
        Person p1 = new PersonComparableNotConsistent("Mateusz", 30);
        Person p2 = new PersonComparableNotConsistent("Mateusz", 20);
        Person p3 = new PersonComparableNotConsistent("Mateusz", 10);
        Person p4 = new PersonComparableNotConsistent("Kamil", 11);
        Person p5 = new PersonComparableNotConsistent("Kamil", 22);

        List<Person> result = Stream.of(p1, p2, p3, p4, p5)
            .distinct()
            .sorted()
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

}
