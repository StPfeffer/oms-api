package pfeffer.oms.order.domain.usecases;

import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.domain.entities.OrderBO;
import pfeffer.oms.order.domain.mappers.OrderMapper;
import pfeffer.oms.order.domain.repositories.IOrderDataBaseRepository;

public class CreateOrder {

    private final IOrderDataBaseRepository repository;

    public CreateOrder(IOrderDataBaseRepository repository) {
        this.repository = repository;
    }

    public OrderDTO execute(OrderDTO dto) {
        OrderBO entity = repository.persist(OrderMapper.toBO(dto));

        return OrderMapper.toDTO(entity);
    }

}
