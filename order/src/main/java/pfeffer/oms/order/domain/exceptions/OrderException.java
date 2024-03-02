package pfeffer.oms.order.domain.exceptions;

public class OrderException extends RuntimeException {

    public static OrderException NOT_FOUND = new OrderException("There is no order registered with the provided orderId for the specified channelId", 404);

    public static OrderException ALREADY_EXISTS = new OrderException("There is already a order registered with the provided orderId for the provided channelId", 400);

    private String message;

    private Integer statusCode;

    public OrderException(String message, Integer statusCode) {
        super(message);

        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
