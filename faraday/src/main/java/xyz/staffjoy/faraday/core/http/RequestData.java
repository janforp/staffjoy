package xyz.staffjoy.faraday.core.http;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

import static xyz.staffjoy.faraday.core.utils.BodyConverter.convertStringToBody;

public class RequestData extends UnmodifiableRequestData {

    @Getter
    @Setter
    private boolean needRedirect;

    @Getter
    @Setter
    private String redirectUrl;

    public RequestData(HttpMethod method, String host, String uri, HttpHeaders headers, byte[] body, HttpServletRequest request) {
        super(method, host, uri, headers, body, request);
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public void setBody(String body) {
        this.body = convertStringToBody(body);
    }
}
