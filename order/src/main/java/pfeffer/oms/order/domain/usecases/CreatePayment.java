package pfeffer.oms.order.domain.usecases;

import pfeffer.oms.order.domain.dtos.PaymentDTO;
import pfeffer.oms.order.domain.entities.PaymentBO;
import pfeffer.oms.order.domain.mappers.PaymentMapper;
import pfeffer.oms.order.domain.repositories.IPaymentDataBaseRepository;

public class CreatePayment {

    private final IPaymentDataBaseRepository repository;

    public CreatePayment(IPaymentDataBaseRepository repository) {
        this.repository = repository;
    }

    public PaymentDTO execute(PaymentDTO dto) {
        PaymentBO entity = repository.persist(PaymentMapper.toBO(dto));

        return PaymentMapper.toDTO(entity);
    }

}
