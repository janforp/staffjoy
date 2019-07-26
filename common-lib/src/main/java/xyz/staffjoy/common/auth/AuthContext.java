package xyz.staffjoy.common.auth;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * A context holder class for holding the current userId and authz info
 *
 * @author bobo
 */
public class AuthContext {

    private static String getRequestHeader(String headerName) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            return request.getHeader(headerName);
        }
        return null;
    }

    public static String getUserId() {
        return getRequestHeader(AuthConstant.CURRENT_USER_HEADER);
    }

    public static String getAuthz() {
        return getRequestHeader(AuthConstant.AUTHORIZATION_HEADER);
    }

}
