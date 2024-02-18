package pfeffer.oms.inventory.domain.exceptions;

public class StockException extends InventoryException {

    public static StockException NOT_FOUND = new StockException("There is no stock registered for the provided skuId", 404);

    public static StockException NOT_FOUND_LOCATION = new StockException("There is no stock registered for the provided skuId and locationId", 404);

    public StockException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}