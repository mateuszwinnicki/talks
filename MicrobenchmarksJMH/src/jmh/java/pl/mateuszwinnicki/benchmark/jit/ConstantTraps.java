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
public class ConstantTraps {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int withoutState() {
        final int a = 1;
        final int b = 2;
        final int c = 3;
        final int d = 4;
        final int sum = a + b + c + d;
        return sum;
    }

//    @State(Scope.Thread)
//    public static class MyState {
//        public int a = 1;
//        public int b = 2;
//        public int c = 3;
//        public int d = 4;
//    }
//
//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    public int withState(final MyState state) {
//        final int sum = state.a + state.b + state.c + state.d;
//        return sum;
//    }

}
