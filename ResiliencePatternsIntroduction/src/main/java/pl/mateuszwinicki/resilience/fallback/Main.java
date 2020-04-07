package pl.mateuszwinicki.resilience.fallback;

import io.vavr.control.Try;
import pl.mateuszwinicki.resilience.ExternalService;
import pl.mateuszwinicki.resilience.Response;

public class Main {

    public static void main(final String[] args) {
        final ExternalService service = new ExternalService();

        System.out.println("First scenario: Trying to fetch user logo, service response properly");
        final Response<String> normalResponse = Try.ofSupplier(() -> service.get(200, "/data/usr/123556/logo.png"))
            .recover(ex -> new Response<>(200, "/default/logo.png"))
            .get();

        System.out.println("Normal response: " + normalResponse);
        System.out.println();

        System.out.println("Second scenario: Trying to fetch user logo, service is unavailable, getting default fallback logo");
        final Response<String> fallbackResponse = Try.ofSupplier(() -> service.get(new IllegalStateException()))
            .recover(ex -> new Response<>(200, "/default/logo.png"))
            .get();

        System.out.println("Fallback response: " + fallbackResponse);
        System.out.println();
    }

}
