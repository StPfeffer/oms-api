package pfeffer.oms.inventory.domain.exceptions;

public class ChannelException extends InventoryException {

    public static ChannelException NOT_FOUND = new ChannelException("There is no channel registered with the provided id", 404);

    public static ChannelException ALREADY_EXISTS = new ChannelException("There is already a channel registered with the provided id", 400);

    public ChannelException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}