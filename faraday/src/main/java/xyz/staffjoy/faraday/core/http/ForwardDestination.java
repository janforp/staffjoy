package xyz.staffjoy.faraday.core.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URI;

@AllArgsConstructor
public class ForwardDestination {

    @Getter
    protected final URI uri;

    @Getter
    protected final String mappingName;

    @Getter
    protected final String mappingMetricsName;
}
