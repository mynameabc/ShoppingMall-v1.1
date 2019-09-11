package manage.sys.exception.userException;

import manage.sys.exception.BaseException;

public class TokenNullException extends BaseException {

    public TokenNullException(String message) {
        super(message, new Throwable(message));
    }

    public TokenNullException(Throwable cause) {
        super(cause);
    }

    public TokenNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
