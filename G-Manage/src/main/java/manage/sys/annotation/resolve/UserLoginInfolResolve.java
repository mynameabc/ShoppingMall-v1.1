package manage.sys.annotation.resolve;

import manage.sys.annotation.UserLoginInfo;
import manage.util.JWTUtil;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import communal.user.IUserDetailInfo;
import communal.user.UserDetail;

@Component
public class UserLoginInfolResolve implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(UserLoginInfo.class);
    }

    @Override
    public IUserDetailInfo resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest
            webRequest, WebDataBinderFactory binderFactory) {

        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        long accountId = JWTUtil.getAccountId(servletRequest.getHeader(JWTUtil.TOKEN));
        return new UserDetail();
    }
}
