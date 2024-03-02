package pfeffer.oms.order.domain.usecases;

import pfeffer.oms.order.domain.dtos.FulfillmentDTO;
import pfeffer.oms.order.domain.entities.FulfillmentBO;
import pfeffer.oms.order.domain.mappers.FulfillmentMapper;
import pfeffer.oms.order.domain.repositories.IFulfilmentDataBaseRepository;

public class CreateFulfillment {

    private final IFulfilmentDataBaseRepository repository;

    public CreateFulfillment(IFulfilmentDataBaseRepository repository) {
        this.repository = repository;
    }

    public FulfillmentDTO execute(FulfillmentDTO dto) {
        FulfillmentBO entity = repository.persist(FulfillmentMapper.toBO(dto));

        return FulfillmentMapper.toDTO(entity);
    }

}
