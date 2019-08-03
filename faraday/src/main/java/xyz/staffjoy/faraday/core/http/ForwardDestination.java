package xyz.staffjoy.faraday.core.http;

import lombok.Getter;

import java.net.URI;

public class ForwardDestination {

    @Getter
    protected final URI uri;

    @Getter
    protected final String mappingName;

    @Getter
    protected final String mappingMetricsName;

    public ForwardDestination(URI uri, String mappingName, String mappingMetricsName) {
        this.uri = uri;
        this.mappingName = mappingName;
        this.mappingMetricsName = mappingMetricsName;
    }
}
