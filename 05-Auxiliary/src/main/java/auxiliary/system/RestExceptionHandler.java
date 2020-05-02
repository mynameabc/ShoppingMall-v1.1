package auxiliary.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import auxiliary.system.exception.DBException;

/**
 * @author LinShaoJun
 * @Date 2020/1/14 1:14
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response globalException(Exception e) {
        log.error("未知异常:{}", e.getCause().getMessage());
        return Response.get(ResponseCode.UnknownException);
    }

    @ExceptionHandler(DBException.class)
    public Response DBException(Exception e) {
        log.error("数据库异常:{}", e.getCause().getMessage());
        return Response.get(ResponseCode.DBException);
    }
}
