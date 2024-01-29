package pfeffer.oms.inventory.domain.exceptions;

public class CustomerException extends InventoryException {

    public CustomerException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
