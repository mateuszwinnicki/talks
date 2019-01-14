package pl.mateuszwinnicki.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@Fork(value = 1)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 2)
@BenchmarkMode(Mode.All)
public class ComparisionBenchmark {

    @State(Scope.Benchmark)
    public static class FibonacciState {
        public final int iterations = 20;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public int fibonacciLoop(final FibonacciState state) {
        return loopFib(state.iterations);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public int fibonacciRecursive(final FibonacciState state) {
        return recursiveFibonacci(state.iterations);
    }

    public static int recursiveFibonacci(final int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }

    public static int loopFib(final int n) {
        int a = 0;
        int b = 1;
        int c;
        if (n == 0) {
            return a;
        }
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


}
