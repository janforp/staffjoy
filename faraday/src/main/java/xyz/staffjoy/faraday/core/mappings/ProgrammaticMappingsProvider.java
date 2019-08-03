package xyz.staffjoy.faraday.core.mappings;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import xyz.staffjoy.common.env.EnvConfig;
import xyz.staffjoy.common.services.Service;
import xyz.staffjoy.common.services.ServiceDirectory;
import xyz.staffjoy.faraday.config.FaradayProperties;
import xyz.staffjoy.faraday.config.MappingProperties;
import xyz.staffjoy.faraday.core.http.HttpClientProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 通过变成实现的路由映射 如果真的需要实现，则需要服务发现等功能的配合
 */
public class ProgrammaticMappingsProvider extends MappingsProvider {

    protected final EnvConfig envConfig;

    public ProgrammaticMappingsProvider(EnvConfig envConfig, ServerProperties serverProperties, FaradayProperties faradayProperties,
        MappingsValidator mappingsValidator, HttpClientProvider httpClientProvider) {
        super(serverProperties, faradayProperties, mappingsValidator, httpClientProvider);
        this.envConfig = envConfig;
    }

    @Override
    protected boolean shouldUpdateMappings(HttpServletRequest request) {
        return false;
    }

    @Override
    protected List<MappingProperties> retrieveMappings() {
        List<MappingProperties> mappings = new ArrayList<>();
        Map<String, Service> serviceMap = ServiceDirectory.getMapping();
        for (String key : serviceMap.keySet()) {
            String subDomain = key.toLowerCase();
            Service service = serviceMap.get(key);
            MappingProperties mapping = new MappingProperties();
            mapping.setName(subDomain + "_route");
            mapping.setHost(subDomain + "." + envConfig.getExternalApex());
            // No security on backend right now :-(
            String dest = "http://" + service.getBackendDomain();
            mapping.setDestinations(Collections.singletonList(dest));
            mappings.add(mapping);
        }
        return mappings;
    }
}
