package pl.mateuszwinicki.resilience;

public class Response<T> {

    private final int status;
    private final T body;

    public Response(final int status, final T body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public T getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Response{" +
            "status=" + status +
            ", body=" + body +
            '}';
    }
}
