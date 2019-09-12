package manage.sys.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.exceptions.JWTDecodeException;
import lombok.extern.slf4j.Slf4j;
import manage.sys.Result;
import manage.sys.ResultCode;
import manage.sys.exception.userException.TokenNullException;
import manage.util.JWTUtil;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截前
        AuthenticationException failed = null;
        String token = request.getHeader(JWTUtil.TOKEN);

        try {

            //判断token是否为空
            if (StringUtils.isEmpty(token)) {
                throw new TokenNullException("无token, 请重新登陆!");
            }

            //判断token是否有效
            Long accountId = JWTUtil.getAccountId(token);
            if (null == accountId) {
                throw new JWTDecodeException("无效的token!");
            }

        } catch (TokenNullException e) {
            //token为空异常
            failed = new InsufficientAuthenticationException("无token, 请重新登陆!", failed);
        } catch (JWTDecodeException e) {
            //token解析异常
            failed = new InsufficientAuthenticationException("无效的token!", failed);
        }

        if (failed != null) {
            UnsuccessfulAuthentication(request, response, failed);
            return false;
        }

        return true;
    }

    private void UnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        log.error("token错误!");
        response.setHeader("content-type", "application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(Result.fail(ResultCode.USER_EXCEPTION, exception.getMessage())));
        out.flush();
        out.close();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //拦截中
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //拦截后
    }
}
