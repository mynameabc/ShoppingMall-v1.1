package manage.sys;

public enum ResultCode {

    /**
     * 成功. ErrorCode : 0
     */
    SUCCESS("0", "成功!"),
    /**
     * 未知异常. ErrorCode : 01
     */
    UnknownException("999", "未知异常"),
    /**
     * 系统异常. ErrorCode : 02
     */
    SystemException("500", "系统异常"),
    /**
     * 业务错误. ErrorCode : 03
     */
    BusinessException("502", "业务错误"),
    /**
     * 提示级错误. ErrorCode : 04
     */
    InfoException("04", "提示级错误"),
    /**
     * 数据库操作异常. ErrorCode : 020001
     */
    DBException("777", "数据库操作异常"),
    /**
     * 参数验证错误. ErrorCode : 040001
     */
    ParamException("410", "参数验证错误"),
    /**
     * token认证失败
     */
    AuthenticationFailure("401", "认证失败!"),
    /**
     * 权限不足
     */
    PermissionEeniedException("403", "权限不足!"),

    SystemMaintainException("111", "系统正在维护"),

    USER_EXCEPTION("401", "用户异常!");

    private String _code;
    private String _msg;

    private ResultCode(String code, String msg) {
        _code = code;
        _msg = msg;
    }

    public String getCode() {
        return _code;
    }

    public String getMsg() {
        return _msg;
    }

    public static ResultCode getByCode(String code) {
        for (ResultCode ec : ResultCode.values()) {
            if (ec.getCode().equals(code)) {
                return ec;
            }
        }
        return null;
    }
}
