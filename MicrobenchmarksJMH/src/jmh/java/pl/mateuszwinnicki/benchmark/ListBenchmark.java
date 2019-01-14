package pl.mateuszwinnicki.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import pl.mateuszwinnicki.model.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@Fork(value = 1)
@Warmup(iterations = 2, time = 1, batchSize = 10000)
@Measurement(iterations = 3, time = 2, batchSize = 10000)
@BenchmarkMode(Mode.AverageTime)
public class ListBenchmark {

    @State(Scope.Benchmark)
    public static class ArrayListStateWithParam {
        public ArrayList<Person> list = new ArrayList<>();
        public Person person;

        @Param({"1", "50", "100", "500", "999"})
        public int index;

        @Setup(Level.Invocation)
        public void setup() {
            for(int i = 0; i < 1000; i++) {
                list.add(new Person());
            }
            person = new Person();
        }

        @TearDown(Level.Invocation)
        public void tearDown() {
            list.clear();
        }
    }

    @State(Scope.Benchmark)
    public static class LinkedListStateWithParam {
        public LinkedList<Person> list = new LinkedList<>();
        public Person person;

        @Param({"1", "50", "100", "500", "999"})
        public int index;

        @Setup(Level.Invocation)
        public void setup() {
            for(int i = 0; i < 1000; i++) {
                list.add(new Person());
            }
            person = new Person();
        }

        @TearDown(Level.Invocation)
        public void tearDown() {
            list.clear();
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Person arrayListRemoveIncrease(final ArrayListStateWithParam state) {
        return state.list.remove(state.index);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Person linkedListRemoveIncrease(final LinkedListStateWithParam state) {
        return state.list.remove(state.index);
    }

}
