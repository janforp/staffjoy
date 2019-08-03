package xyz.staffjoy.faraday.core.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ResponseData {

    @Getter
    @Setter
    protected HttpStatus status;

    @Getter
    @Setter
    protected HttpHeaders headers;

    @Getter
    @Setter
    protected byte[] body;

    @Getter
    @Setter
    protected UnmodifiableRequestData requestData;
}
