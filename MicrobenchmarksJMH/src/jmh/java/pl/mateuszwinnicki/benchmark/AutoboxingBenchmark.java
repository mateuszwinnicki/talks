package pl.mateuszwinnicki.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@Fork(value = 1)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 2)
@BenchmarkMode(Mode.AverageTime)

public class AutoboxingBenchmark {

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public Long allObjects() {
        Long sum = 0L;
        for (Integer i = 0; i < Integer.MAX_VALUE/20; i++) {
            sum += i;
        }
        return sum;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long primitiveAggregatorObjectAdder() {
        long sum = 0L;
        for (Integer i = 0; i < Integer.MAX_VALUE/20; i++) {
            sum += i;
        }
        return sum;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public Long objectAggregatorPrimitiveAdder() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE/20; i++) {
            sum += i;
        }
        return sum;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.SECONDS)
    public long allPrimitives() {
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE/20; i++) {
            sum += i;
        }
        return sum;
    }

}
