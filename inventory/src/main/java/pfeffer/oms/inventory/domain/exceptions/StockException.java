package pfeffer.oms.inventory.domain.exceptions;

public class StockException extends InventoryException {

    public StockException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}