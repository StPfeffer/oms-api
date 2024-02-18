package pfeffer.oms.inventory.domain.exceptions;

public class LocationException extends InventoryException {

    public static LocationException NOT_FOUND = new LocationException("There is no branch registered with the provided id", 404);

    public static LocationException ALREADY_EXISTS = new LocationException("There is already a branch registered with the provided id", 400);

    public LocationException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}