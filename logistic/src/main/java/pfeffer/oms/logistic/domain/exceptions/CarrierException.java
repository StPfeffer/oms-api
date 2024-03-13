package pfeffer.oms.logistic.domain.exceptions;

public class CarrierException extends LogisticException {

    public static CarrierException ALREADY_EXISTS = new CarrierException("There is already a carrier registered with the provided carrierId", 400);

    public static CarrierException NOT_FOUND = new CarrierException("There is no carrier registered with the provided carrierId", 404);

    public CarrierException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
