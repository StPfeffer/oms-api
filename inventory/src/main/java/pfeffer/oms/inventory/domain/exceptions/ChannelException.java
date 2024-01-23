package pfeffer.oms.inventory.domain.exceptions;

public class ChannelException extends InventoryException {

    public ChannelException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}