package pl.mateuszwinicki.resilience.bulkhead;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.Response;

import java.time.Duration;
import java.util.concurrent.Callable;

public class Main {

    public static void main(final String[] args) throws InterruptedException {
        final ExternalService service = new ExternalService();

        final BulkheadConfig config = BulkheadConfig.custom()
            .maxConcurrentCalls(3)
            .maxWaitDuration(Duration.ofSeconds(10))
            .build();

        final Bulkhead bulkhead = Bulkhead.of("Bulkhead", config);

        final Callable<Response<String>> callable = Bulkhead.decorateCallable(
            bulkhead, () -> service.getButWait(200, "OK", Duration.ofSeconds(3))
        );

        for(int i = 0; i < 20; i++){
            new Thread(() -> {
                try {
                    callable.call();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


        Thread.sleep(1000 * 15);
    }

}
