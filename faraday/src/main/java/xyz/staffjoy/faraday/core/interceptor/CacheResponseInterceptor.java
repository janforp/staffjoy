package xyz.staffjoy.faraday.core.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;
import xyz.staffjoy.faraday.config.MappingProperties;
import xyz.staffjoy.faraday.core.http.ResponseData;

import java.util.List;

/**
 * 不缓存响应
 */
public class CacheResponseInterceptor implements PostForwardResponseInterceptor {

    @Override
    public void intercept(ResponseData data, MappingProperties mapping) {
        HttpHeaders respHeaders = data.getHeaders();
        if (respHeaders.containsKey(HttpHeaders.CONTENT_TYPE)) {
            List<String> values = respHeaders.get(HttpHeaders.CONTENT_TYPE);
            if (!CollectionUtils.isEmpty(values) && values.contains("text/html")) {
                // insert header to prevent caching
                respHeaders.set(HttpHeaders.CACHE_CONTROL, "no-cache");
            }
        }
    }
}
