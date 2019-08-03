package xyz.staffjoy.faraday.core.mappings;

import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import xyz.staffjoy.faraday.config.FaradayProperties;
import xyz.staffjoy.faraday.config.MappingProperties;
import xyz.staffjoy.faraday.core.http.HttpClientProvider;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * 路由映射超类
 */
public abstract class MappingsProvider {

    private static final ILogger LOG = SLoggerFactory.getLogger(MappingsProvider.class);

    protected final ServerProperties serverProperties;

    protected final FaradayProperties faradayProperties;

    protected final MappingsValidator mappingsValidator;

    protected final HttpClientProvider httpClientProvider;

    protected List<MappingProperties> mappings;

    public MappingsProvider(ServerProperties serverProperties, FaradayProperties faradayProperties, MappingsValidator mappingsValidator,
        HttpClientProvider httpClientProvider) {
        this.serverProperties = serverProperties;
        this.faradayProperties = faradayProperties;
        this.mappingsValidator = mappingsValidator;
        this.httpClientProvider = httpClientProvider;
    }

    /**
     * 传主机头，解析出一个映射表
     *
     * @param originHost 主机头
     * @param request    请求对象
     * @return 映射表的值
     */
    public MappingProperties resolveMapping(String originHost, HttpServletRequest request) {
        if (shouldUpdateMappings(request)) {
            updateMappings();
        }
        List<MappingProperties> resolvedMappings = mappings.stream()
            //根据 originHost 在映射表中查询出对应的 MappingProperties
            .filter(mapping -> originHost.toLowerCase().equals(mapping.getHost().toLowerCase()))
            .collect(Collectors.toList());
        if (isEmpty(resolvedMappings)) {
            return null;
        }
        return resolvedMappings.get(0);
    }

    @PostConstruct
    protected synchronized void updateMappings() {
        List<MappingProperties> newMappings = retrieveMappings();
        //校验mapping
        mappingsValidator.validate(newMappings);
        this.mappings = newMappings;
        //mappings 更新，则 httpClientProvider 更新
        httpClientProvider.updateHttpClients(mappings);
        LOG.info("Destination mappings updated", mappings);
    }

    /**
     * 模版方法设计模式，由具体子类决定该函数的实现
     *
     * @param request 请求
     * @return 是否更新映射表
     */
    protected abstract boolean shouldUpdateMappings(HttpServletRequest request);

    protected abstract List<MappingProperties> retrieveMappings();
}
