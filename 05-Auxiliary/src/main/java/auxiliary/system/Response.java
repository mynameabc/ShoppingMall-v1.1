package auxiliary.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author LinShaoJun
 * @Date 2020/1/14 0:43
 */
@Data
@ToString
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -4149726986568498605L;

    /**
     * 请求成功返回码为：0000
     */
    private static final String successCode = "0000";

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public static <T> Response<T> get(ResponseCode responseCode) {
        Response<T> response = new Response<T>();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setData("");
        return response;
    }

    public static <T> Response<T> get(ResponseCode responseCode, T data) {
        Response<T> response = new Response<T>();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        response.setData(data);
        return response;
    }
}
