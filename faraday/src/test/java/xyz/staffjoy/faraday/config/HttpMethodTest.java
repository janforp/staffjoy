package xyz.staffjoy.faraday.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;

/**
 * 类说明：
 *
 * @author zhucj
 * @since 2019-08-03 - 08:20
 */
public class HttpMethodTest {

    @Test
    public void testEnum() {
        for (final HttpMethod httpMethod : HttpMethod.values()) {
            System.out.println(httpMethod.name());
        }
    }

    @Test
    public void testResolve() {
        HttpMethod get = HttpMethod.resolve("get");
        Assert.assertEquals(get, HttpMethod.GET);
    }
}
