package pl.mateuszwinnicki.benchmark.jit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import java.util.DoubleSummaryStatistics;
import java.util.concurrent.TimeUnit;

@Fork(value = 1)
@Warmup(iterations = 2, time = 3)
@Measurement(iterations = 3, time = 2)
@BenchmarkMode(Mode.AverageTime)
public class DeadCodeTraps {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void emptyMethod() {

    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void addingWithoutReturning() {
        final int a = 10;
        final int b = 100;
        final int c = a + b;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void summaryStatistics_averageForFourNumbers() {
        final DoubleSummaryStatistics summaryStatistics = new DoubleSummaryStatistics();
        summaryStatistics.accept(10.0);
        summaryStatistics.accept(20.0);
        summaryStatistics.accept(30.0);
        summaryStatistics.accept(40.0);
        summaryStatistics.getAverage();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void summaryStatistics_averageForTenNumbers() {
        final DoubleSummaryStatistics summaryStatistics = new DoubleSummaryStatistics();
        summaryStatistics.accept(10.0);
        summaryStatistics.accept(20.0);
        summaryStatistics.accept(30.0);
        summaryStatistics.accept(40.0);
        summaryStatistics.accept(50.0);
        summaryStatistics.accept(60.0);
        summaryStatistics.accept(70.0);
        summaryStatistics.accept(80.0);
        summaryStatistics.accept(90.0);
        summaryStatistics.accept(100.0);
        summaryStatistics.getAverage();
    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    public int addingWithReturning() {
//        final int a = 10;
//        final int b = 100;
//        final int c = a + b;
//        return c;
//    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    public void addingWithBlackHole(final Blackhole bh) {
//        final int a = 10;
//        final int b = 100;
//        final int c = a + b;
//        bh.consume(c);
//    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    public double summaryStatistics_averageForFourNumbers_withReturn() {
//        final DoubleSummaryStatistics summaryStatistics = new DoubleSummaryStatistics();
//        summaryStatistics.accept(10.0);
//        summaryStatistics.accept(20.0);
//        summaryStatistics.accept(30.0);
//        summaryStatistics.accept(40.0);
//        return summaryStatistics.getAverage();
//    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    public double summaryStatistics_averageForTenNumbers_withReturn() {
//        final DoubleSummaryStatistics summaryStatistics = new DoubleSummaryStatistics();
//        summaryStatistics.accept(10.0);
//        summaryStatistics.accept(20.0);
//        summaryStatistics.accept(30.0);
//        summaryStatistics.accept(40.0);
//        summaryStatistics.accept(50.0);
//        summaryStatistics.accept(60.0);
//        summaryStatistics.accept(70.0);
//        summaryStatistics.accept(80.0);
//        summaryStatistics.accept(90.0);
//        summaryStatistics.accept(100.0);
//        return summaryStatistics.getAverage();
//    }

}
