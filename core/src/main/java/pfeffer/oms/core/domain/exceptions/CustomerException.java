package pfeffer.oms.core.domain.exceptions;

public class CustomerException extends CoreException {

    public CustomerException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
