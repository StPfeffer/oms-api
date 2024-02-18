package pfeffer.oms.order.domain.exceptions;

public class FulfillmentException extends OrderException {

    public FulfillmentException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
