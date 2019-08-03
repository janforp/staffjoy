package xyz.staffjoy.faraday.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.NO_CLASS_NAME_STYLE;

public class MappingProperties {

    /**
     * Name of the mapping 路由名称
     */
    @Getter
    @Setter
    private String name;

    /**
     * Path for mapping incoming HTTP requests URIs. 主机头
     */
    @Getter
    @Setter
    private String host = "";

    /**
     * List of destination hosts where HTTP requests will be forwarded. 目标服务的地址
     */
    @Getter
    @Setter
    private List<String> destinations = new ArrayList<>();

    /**
     * Properties responsible for timeout while forwarding HTTP requests.
     */
    @Getter
    @Setter
    private TimeoutProperties timeout = new TimeoutProperties();

    /**
     * Custom properties placeholder.其他配置
     */
    @Getter
    @Setter
    private Map<String, Object> customConfiguration = new HashMap<>();

    public MappingProperties copy() {
        MappingProperties clone = new MappingProperties();
        clone.setName(name);
        clone.setHost(host);
        clone.setDestinations(destinations == null ? null : new ArrayList<>(destinations));
        clone.setTimeout(timeout);
        clone.setCustomConfiguration(customConfiguration == null ? null : new HashMap<>(customConfiguration));
        return clone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, NO_CLASS_NAME_STYLE).append("name", name)
            .append("host", host)
            .append("destinations", destinations)
            .append("timeout", timeout)
            .append("customConfiguration", customConfiguration)
            .toString();
    }

    @Data
    public static class TimeoutProperties {

        /**
         * Connect timeout for HTTP requests forwarding.
         */
        private int connect = 2000;

        /**
         * Read timeout for HTTP requests forwarding.
         */
        private int read = 20000;

        @Override
        public String toString() {
            return new ToStringBuilder(this, NO_CLASS_NAME_STYLE).append("connect", connect).append("read", read).toString();
        }
    }
}
