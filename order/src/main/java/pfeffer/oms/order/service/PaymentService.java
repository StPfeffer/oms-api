package pfeffer.oms.order.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.order.domain.dtos.PaymentDTO;
import pfeffer.oms.order.domain.usecases.CreatePayment;
import pfeffer.oms.order.infra.jakarta.repository.JakartaPaymentRepository;

@Service
public class PaymentService {

    private final JakartaPaymentRepository repository;

    @Autowired
    public PaymentService(JakartaPaymentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public PaymentDTO createPayment(PaymentDTO dto) {
        CreatePayment createPayment = new CreatePayment(repository);

        return createPayment.execute(dto);
    }

}
