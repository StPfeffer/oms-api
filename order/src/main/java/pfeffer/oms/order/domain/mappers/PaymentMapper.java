package pfeffer.oms.order.domain.mappers;

import pfeffer.oms.order.domain.dtos.PaymentDTO;
import pfeffer.oms.order.domain.entities.PaymentBO;

public class PaymentMapper {

    public static PaymentDTO toDTO(PaymentBO bo) {
        PaymentDTO dto = new PaymentDTO();

        dto.setType(bo.getType());
        dto.setAmount(bo.getAmount());
        dto.setAcquirer(bo.getAcquirer());
        dto.setCurrency(bo.getCurrency());
        dto.setInstallments(bo.getInstallments());
        dto.setPaymentNumber(bo.getPaymentNumber());
        dto.setTransactionNumber(bo.getTransactionNumber());
        dto.setTransactionDate(bo.getTransactionDate());
        dto.setPaymentDate(bo.getPaymentDate());

        return dto;
    }

    public static PaymentBO toBO(PaymentDTO dto) {
        PaymentBO bo = new PaymentBO();

        bo.setType(dto.getType());
        bo.setAmount(dto.getAmount());
        bo.setAcquirer(dto.getAcquirer());
        bo.setCurrency(dto.getCurrency());
        bo.setInstallments(dto.getInstallments());
        bo.setPaymentNumber(dto.getPaymentNumber());
        bo.setTransactionNumber(dto.getTransactionNumber());
        bo.setTransactionDate(dto.getTransactionDate());
        bo.setPaymentDate(dto.getPaymentDate());

        return bo;
    }

}
