package manage.sys.annotation.resolve;

import manage.sys.UserDetail;
import manage.sys.annotation.UserLoginedInfo;
import manage.util.JWTUtil;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserLoginedInfolResolve implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(UserLoginedInfo.class);
    }

    @Override
    public UserDetail resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest
            webRequest, WebDataBinderFactory binderFactory) {

        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        long accountId = JWTUtil.getAccountId(servletRequest.getHeader(JWTUtil.TOKEN));
        return new UserDetail(accountId);
    }
}
