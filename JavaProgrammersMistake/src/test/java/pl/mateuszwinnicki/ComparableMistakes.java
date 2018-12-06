package pl.mateuszwinnicki;

import org.junit.Test;
import pl.mateuszwinnicki.examples.PersonComparableConstantHashCode;
import pl.mateuszwinnicki.examples.PersonComparableNotConsistent;
import pl.mateuszwinnicki.examples.PersonComparableWithoutEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComparableMistakes {

    /**
     * Equals by name, but compareTo by age
     */
    @Test
    public void onlyCompareToIsImplemented() {
        final PersonComparableWithoutEquals p1 = new PersonComparableWithoutEquals("Mateusz", 25);
        final PersonComparableWithoutEquals p2 = new PersonComparableWithoutEquals("Mateusz", 25);
        final PersonComparableWithoutEquals p3 = new PersonComparableWithoutEquals("Mateusz", 25);

        final Set<PersonComparableWithoutEquals> tree = new TreeSet<>();

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
    public void equalsNotConsistentWithCompareTo() {
        final PersonComparableNotConsistent p1 = new PersonComparableNotConsistent("Mateusz", 25);
        final PersonComparableNotConsistent p2 = new PersonComparableNotConsistent("Mateusz", 26);
        final PersonComparableNotConsistent p3 = new PersonComparableNotConsistent("Mateusz", 27);

        final Set<PersonComparableNotConsistent> tree = new TreeSet<>();

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
        final PersonComparableNotConsistent p1 = new PersonComparableNotConsistent("Mateusz", 30);
        final PersonComparableNotConsistent p2 = new PersonComparableNotConsistent("Mateusz", 20);
        final PersonComparableNotConsistent p3 = new PersonComparableNotConsistent("Mateusz", 10);
        final PersonComparableNotConsistent p4 = new PersonComparableNotConsistent("Kamil", 11);
        final PersonComparableNotConsistent p5 = new PersonComparableNotConsistent("Kamil", 22);

        final List<PersonComparableNotConsistent> result = Stream.of(p1, p2, p3, p4, p5)
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
        final PersonComparableNotConsistent p1 = new PersonComparableNotConsistent("Mateusz", 30);
        final PersonComparableNotConsistent p2 = new PersonComparableNotConsistent("Mateusz", 20);
        final PersonComparableNotConsistent p3 = new PersonComparableNotConsistent("Mateusz", 10);
        final PersonComparableNotConsistent p4 = new PersonComparableNotConsistent("Kamil", 11);
        final PersonComparableNotConsistent p5 = new PersonComparableNotConsistent("Kamil", 22);

        final List<PersonComparableNotConsistent> result = Stream.of(p1, p2, p3, p4, p5)
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
        final PersonComparableNotConsistent p1 = new PersonComparableNotConsistent("Mateusz", 30);
        final PersonComparableNotConsistent p2 = new PersonComparableNotConsistent("Mateusz", 20);
        final PersonComparableNotConsistent p3 = new PersonComparableNotConsistent("Mateusz", 10);
        final PersonComparableNotConsistent p4 = new PersonComparableNotConsistent("Kamil", 11);
        final PersonComparableNotConsistent p5 = new PersonComparableNotConsistent("Kamil", 22);

        final List<PersonComparableNotConsistent> result = Stream.of(p1, p2, p3, p4, p5)
            .distinct()
            .sorted()
            .peek(System.out::println)
            .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    public void bigHashMapWhichBucketDoesntTransformToTree() {
        final Set<PersonComparableConstantHashCode> set = new HashSet<>();

        IntStream.range(1, 10).forEach(
            i -> set.add(new PersonComparableConstantHashCode("Mateusz"+i, 1))
        );

        assertTrue(
            set.contains(new PersonComparableConstantHashCode("Mateusz1", 2))
        );
    }

    @Test
    public void bigHashMapWhichBucketDoesTransformToTree() {
        final Set<PersonComparableConstantHashCode> set = new HashSet<>();

        IntStream.range(1, 1000).forEach(
            i -> set.add(new PersonComparableConstantHashCode("Mateusz"+i, 1))
        );

        assertTrue(
            set.contains(new PersonComparableConstantHashCode("Mateusz1", 2))
        );
    }

}
