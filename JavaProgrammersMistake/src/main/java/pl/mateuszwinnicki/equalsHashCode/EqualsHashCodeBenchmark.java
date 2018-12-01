package pl.mateuszwinnicki.equalsHashCode;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.util.HashSet;
import java.util.stream.IntStream;

@Fork(value = 1)
@Warmup(iterations = 1, time = 1)
@Measurement(iterations = 3, time = 3)
@BenchmarkMode(Mode.AverageTime)
public class EqualsHashCodeBenchmark {

    private static final int endExclusive = 100000;

    @Benchmark
    public HashSet<Person> constantHashCode() {
        var set = new HashSet<Person>();
        IntStream.range(1, endExclusive).mapToObj(
            i -> PersonFactory.createRandomPersonConstantHashCode()
        ).forEach(set::add);
        return set;
    }

    @Benchmark
    public HashSet<Person> lowQualiyHashCode() {
        var set = new HashSet<Person>();
        IntStream.range(1, endExclusive).mapToObj(
            i -> PersonFactory.createRandomPersonLowQualityHashCode()
        ).forEach(set::add);
        return set;
    }

    @Benchmark
    public HashSet<Person> fineHashCode() {
        var set = new HashSet<Person>();
        IntStream.range(1, endExclusive).mapToObj(
            i -> PersonFactory.createRandomPersonFineHashCode()
        ).forEach(set::add);
        return set;
    }

    @Benchmark
    public HashSet<Person> constantHashCodeWithComparable() {
        var set = new HashSet<Person>();
        IntStream.range(1, endExclusive).mapToObj(
            i -> PersonFactory.createRandomPersonWithConstantHashCodeAndComparable()
        ).forEach(set::add);
        return set;
    }

}
