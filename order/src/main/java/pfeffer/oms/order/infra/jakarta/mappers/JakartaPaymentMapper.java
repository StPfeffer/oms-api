package pfeffer.oms.order.infra.jakarta.mappers;

import pfeffer.oms.order.domain.entities.PaymentBO;
import pfeffer.oms.order.infra.jakarta.model.JakartaPayment;

public class JakartaPaymentMapper {

    public static JakartaPayment toEntity(PaymentBO domain) {
        JakartaPayment entity = new JakartaPayment();

        entity.setType(domain.getType());
        entity.setAmount(domain.getAmount());
        entity.setTariff(domain.getTariff());
        entity.setDiscount(domain.getDiscount());
        entity.setAcquirer(domain.getAcquirer());
        entity.setCurrency(domain.getCurrency());
        entity.setInstallments(domain.getInstallments());
        entity.setPaymentNumber(domain.getPaymentNumber());
        entity.setTransactionNumber(domain.getTransactionNumber());
        entity.setTransactionDate(domain.getTransactionDate());
        entity.setPaymentDate(domain.getPaymentDate());

        return entity;
    }

    public static PaymentBO toDomain(JakartaPayment entity) {
        PaymentBO domain = new PaymentBO();

        domain.setType(entity.getType());
        domain.setAmount(entity.getAmount());
        domain.setTariff(entity.getTariff());
        domain.setDiscount(entity.getDiscount());
        domain.setAcquirer(entity.getAcquirer());
        domain.setCurrency(entity.getCurrency());
        domain.setInstallments(entity.getInstallments());
        domain.setPaymentNumber(entity.getPaymentNumber());
        domain.setTransactionNumber(entity.getTransactionNumber());
        domain.setTransactionDate(entity.getTransactionDate());
        domain.setPaymentDate(entity.getPaymentDate());

        return domain;
    }

}
