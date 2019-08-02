package xyz.staffjoy.faraday.core.trace;

import lombok.Getter;
import lombok.Setter;

import static xyz.staffjoy.faraday.core.utils.BodyConverter.convertBodyToString;

public class ForwardRequest extends IncomingRequest {

    @Getter
    @Setter
    protected String mappingName;

    @Getter
    @Setter
    protected byte[] body;

    public String getBodyAsString() { return convertBodyToString(body); }
}
