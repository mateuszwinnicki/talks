package pl.mateuszwinnicki;


import org.openjdk.jmh.Main;

public class MicroBenchmark {

    public static void main(final String[] args) throws Exception {
        final String[] args2 = new String[2];
        args2[0] = "-rf";
        args2[1] = "CSV";
        Main.main(args2);
    }

}
