package xyz.staffjoy.faraday.core.interceptor;

import xyz.staffjoy.faraday.config.MappingProperties;
import xyz.staffjoy.faraday.core.http.ResponseData;

/**
 * 转发之后的拦截器
 */
public interface PostForwardResponseInterceptor {

    void intercept(ResponseData data, MappingProperties mapping);
}
