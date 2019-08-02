package xyz.staffjoy.faraday.core.trace;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

public class IncomingRequest extends HttpEntity {

    @Getter
    @Setter
    protected HttpMethod method;

    @Getter
    @Setter
    protected String uri;

    @Getter
    @Setter
    protected String host;
}
