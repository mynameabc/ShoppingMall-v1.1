package auxiliary.system.exception;

public class MoneyException extends RuntimeException {

    /**
     * 错误编码
     */
    private String errorCode;

    public MoneyException(String message) {
        super(message);
    }

    public MoneyException(String  errorCode, String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
