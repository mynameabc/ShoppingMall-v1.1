package manage.sys;

import lombok.Data;
import java.io.Serializable;

/**
 * 返回对象
 */
@Data
public class Result<T> implements Serializable {

    //状态码
    private String code = ResultCode.SUCCESS.getCode();

    //信息
    private String message = ResultCode.SUCCESS.getMsg();

    //附带数据
    private T data = null;

    public Result() {}

    /**
     * 获取正确结果模板
     * @return Result
     */
    public static Result<Object> success() {
        return success(ResultCode.SUCCESS.getMsg(), null);
    }

    /**
     * 获取正确结果模板
     * @param obj 请求结果
     * @return Result
     */
    public static <T> Result<T> success(T obj) {
        Result result = new Result();
        result.setMessage(ResultCode.SUCCESS.getMsg());
        result.setData(obj);
        return result;
    }

    /**
     * 获取正确结果模板
     * @param message 请求返回信息
     * @return AjaxResult
     */
    public static <T> Result<T> success(String message) {
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    /**
     * 获取正确结果模板
     * @param message 请求返回信息
     * @param obj     请求结果
     * @return AjaxResult
     */
    public static <T> Result<T> success(String message, T obj) {
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setData(obj);
        return result;
    }

    /**
     * 获取错误结果模板
     * @param message 请求返回信息
     * @param obj     请求结果
     * @return AjaxResult
     */
    public static <T> Result<T> fail(ResultCode errorCode, String message, T obj) {
        Result<T> result = new Result<T>();
        result.setCode(errorCode.getCode());
        result.setMessage(message);
        result.setData(obj);
        return result;
    }

    /**
     * 获取错误结果模板
     * @return AjaxResult
     */
    public static Result<String> fail(ResultCode resultCode) {
        return fail(resultCode, resultCode.getMsg(), "");
    }

    public static Result<String> fail(ResultCode resultCode, String msg) {
        return fail(resultCode, msg, "");
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
