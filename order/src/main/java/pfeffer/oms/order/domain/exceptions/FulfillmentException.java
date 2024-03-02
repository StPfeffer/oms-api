package pfeffer.oms.order.domain.exceptions;

public class FulfillmentException extends OrderException {

    public static FulfillmentException NOT_FOUND = new FulfillmentException("There is no fulfillment registered with the provided orderId and fulfillmentId for the specified channelId", 404);

    public static FulfillmentException ALREADY_EXISTS = new FulfillmentException("There is already a fulfillment registered with the provided orderId, channelId and fulfillmentId", 400);

    public FulfillmentException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
