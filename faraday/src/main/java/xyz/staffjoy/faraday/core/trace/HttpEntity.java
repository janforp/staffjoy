package xyz.staffjoy.faraday.core.trace;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

public abstract class HttpEntity {

    @Getter
    @Setter
    protected HttpHeaders headers;
}
