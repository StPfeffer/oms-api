package pfeffer.oms.logistic.domain.exceptions;

public class CarrierException extends LogisticException {

    public static CarrierException ALREADY_EXISTS = new CarrierException("There is already a carrier registered with the provided carrierId", 400);

    public CarrierException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
