package xyz.staffjoy.faraday.core.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;

import static xyz.staffjoy.faraday.core.utils.BodyConverter.convertBodyToString;

/**
 * 实现一个无法修改的类，有时候主要不提供set方法就可以了
 */
@AllArgsConstructor
public class UnmodifiableRequestData {

    @Getter
    protected HttpMethod method;

    @Getter
    protected String host;

    @Getter
    protected String uri;

    @Getter
    protected HttpHeaders headers;

    @Getter
    protected byte[] body;

    @Getter
    protected HttpServletRequest originRequest;

    public UnmodifiableRequestData(RequestData requestData) {
        this(requestData.getMethod(), requestData.getHost(), requestData.getUri(), requestData.getHeaders(), requestData.getBody(),
             requestData.getOriginRequest());
    }

    @SuppressWarnings("unused")
    public String getBodyAsString() {
        return convertBodyToString(body);
    }
}
