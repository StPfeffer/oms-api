package pfeffer.oms.inventory.domain.exceptions;

public class InventoryException extends RuntimeException {

    private String message;

    private Integer statusCode;

    public InventoryException(String message, Integer statusCode) {
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