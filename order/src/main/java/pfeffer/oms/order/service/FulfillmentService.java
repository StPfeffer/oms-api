package pfeffer.oms.order.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pfeffer.oms.order.domain.dtos.FulfillmentDTO;
import pfeffer.oms.order.domain.exceptions.FulfillmentException;
import pfeffer.oms.order.domain.repositories.IFulfillmentRepository;
import pfeffer.oms.order.domain.usecases.CreateFulfillment;
import pfeffer.oms.order.infra.jakarta.repository.JakartaFulfillmentRepository;

import java.util.List;

@Service
public class FulfillmentService implements IFulfillmentRepository {

    private final JakartaFulfillmentRepository repository;

    public FulfillmentService(JakartaFulfillmentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FulfillmentDTO createFulfillment(FulfillmentDTO dto) {
        CreateFulfillment createFulfillment = new CreateFulfillment(repository);

        return createFulfillment.execute(dto);
    }

    @Override
    public FulfillmentDTO findByOrderIdChannelIdFulfillmentId(String orderId, String channelId, String fulfillmentId) {
        FulfillmentDTO fulfillment = this.repository.findByOrderIdChannelIdFulfillmentId(orderId, channelId, fulfillmentId);

        if (fulfillment == null) {
            throw FulfillmentException.NOT_FOUND;
        }

        return fulfillment;
    }

    @Override
    public List<FulfillmentDTO> listAllByOrderIdAndChannelid(String orderId, String channelId) {
        List<FulfillmentDTO> fulfillments = this.repository.listAllByOrderIdAndChannelid(orderId, channelId);

        if (fulfillments == null || fulfillments.isEmpty()) {
            throw FulfillmentException.NOT_FOUND;
        }

        return fulfillments;
    }

}
