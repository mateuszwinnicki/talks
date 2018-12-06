package pl.mateuszwinnicki.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Fork(value = 1)
@Warmup(iterations = 2, time = 3)
@Measurement(iterations = 3, time = 2)
@BenchmarkMode(Mode.Throughput)
public class EqualsHashCodeContainsBenchmark {

    private static final int INITIAL_STATE_SIZE = 100_000;

    @State(Scope.Thread)
    public static class ConstantHashCodeState {

        final Set<Person> set = new HashSet<>();

        @Setup
        public void setup() {
            IntStream.range(1, INITIAL_STATE_SIZE).mapToObj(
                i -> PersonFactory.createRandomPerson(PersonHashCodeType.CONSTANT)
            ).forEach(set::add);
        }

        @TearDown
        public void tearDown() {
            set.clear();
        }

    }

    @State(Scope.Thread)
    public static class LowQualityHashCodeState {

        final Set<Person> set = new HashSet<>();

        @Setup
        public void setup() {
            IntStream.range(1, INITIAL_STATE_SIZE).mapToObj(
                i -> PersonFactory.createRandomPerson(PersonHashCodeType.VERY_LOW_QUALITY)
            ).forEach(set::add);
        }

        @TearDown
        public void tearDown() {
            set.clear();
        }

    }

    @State(Scope.Thread)
    public static class FineHashCodeState {

        final Set<Person> set = new HashSet<>();

        @Setup
        public void setup() {
            IntStream.range(1, INITIAL_STATE_SIZE).mapToObj(
                i -> PersonFactory.createRandomPerson(PersonHashCodeType.FINE)
            ).forEach(set::add);
        }

        @TearDown
        public void tearDown() {
            set.clear();
        }

    }

    @State(Scope.Thread)
    public static class ConstantHashCodeWithComparable {

        final Set<Person> set = new HashSet<>();

        @Setup
        public void setup() {
            IntStream.range(1, INITIAL_STATE_SIZE).mapToObj(
                i -> PersonFactory.createRandomPerson(PersonHashCodeType.CONSTANT_AND_COMPARABLE)
            ).forEach(set::add);
        }

        @TearDown
        public void tearDown() {
            set.clear();
        }

    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean constantHashCode(final ConstantHashCodeState state) {
        final Person person = new PersonConstantHashCode("Mateusz", 10);
        return state.set.contains(person);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean lowQualityHashCode(final LowQualityHashCodeState state) {
        final Person person = new PersonLowQualityHashCode("Mateusz", 10);
        return state.set.contains(person);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean fineHashCode(final FineHashCodeState state) {
        final Person person = new PersonFineHashCode("Mateusz", 10);
        return state.set.contains(person);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public boolean constantHashCodeWithComparable(final ConstantHashCodeWithComparable state) {
        final Person person = new PersonConstantHashCodeComparable("Mateusz", 10);
        return state.set.contains(person);
    }

}
