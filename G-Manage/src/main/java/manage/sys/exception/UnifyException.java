package manage.sys.exception;

import manage.sys.Result;
import manage.sys.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class UnifyException {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception ex){
        return Result.fail(ResultCode.SystemException, ex.getMessage());
    }
}
