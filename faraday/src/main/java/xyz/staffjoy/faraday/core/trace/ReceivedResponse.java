package xyz.staffjoy.faraday.core.trace;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import static xyz.staffjoy.faraday.core.utils.BodyConverter.convertBodyToString;

public class ReceivedResponse extends HttpEntity {

    @Getter
    @Setter
    protected HttpStatus status;

    @Getter
    @Setter
    protected byte[] body;

    public String getBodyAsString() { return convertBodyToString(body); }
}
