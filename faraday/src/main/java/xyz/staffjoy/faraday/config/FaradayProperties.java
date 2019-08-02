package xyz.staffjoy.faraday.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/**
 * Faraday configuration properties
 */
@ConfigurationProperties("faraday")
public class FaradayProperties {

    /**
     * Faraday servlet filter order.
     */
    @Getter
    @Setter
    private int filterOrder = HIGHEST_PRECEDENCE + 100;

    /**
     * Enable programmatic mapping or not, false only in dev environment, in dev we use mapping via configuration file
     */
    @Setter
    @Getter
    private boolean enableProgrammaticMapping = true;

    /**
     * Properties responsible for collecting metrics during HTTP requests forwarding.
     */
    @Getter
    @Setter
    @NestedConfigurationProperty
    private MetricsProperties metrics = new MetricsProperties();

    /**
     * Properties responsible for tracing HTTP requests proxying processes.
     */
    @Getter
    @Setter
    @NestedConfigurationProperty
    private TracingProperties tracing = new TracingProperties();

    /**
     * List of proxy mappings.
     */
    @Getter
    @Setter
    @NestedConfigurationProperty
    private List<MappingProperties> mappings = new ArrayList<>();
}
