package pl.mateuszwinnicki.benchmark.jit;

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
public class LoopTraps {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int loop100000000iterations() {
        int sum = 0;
        for (int i = 0; i < 100_000_000; i++) {
            sum++;
        }
        return sum;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int loop100iterations() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum++;
        }
        return sum;
    }

}
