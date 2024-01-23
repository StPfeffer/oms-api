package pfeffer.oms.inventory.domain.exceptions;

public class LocationException extends InventoryException {

    public LocationException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}