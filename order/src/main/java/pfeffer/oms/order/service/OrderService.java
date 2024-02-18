package pfeffer.oms.order.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.domain.exceptions.OrderException;
import pfeffer.oms.order.domain.repositories.IOrderRepository;
import pfeffer.oms.order.domain.usecases.CreateOrder;
import pfeffer.oms.order.infra.jakarta.repository.JakartaOrderRepository;

@Service
public class OrderService implements IOrderRepository {

    private final JakartaOrderRepository repository;

    @Autowired
    public OrderService(JakartaOrderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OrderDTO createOrder(OrderDTO dto) {
        CreateOrder createOrder = new CreateOrder(repository);

        return createOrder.execute(dto);
    }

    @Override
    public OrderDTO findOrderByOrderIdAndChannelId(String orderId, String channelId) {
        OrderDTO order = this.repository.findOrderByOrderIdAndChannelId(orderId, channelId);

        if (order == null) {
            throw new OrderException("There is no order registered with the provided orderId and channelId", 404);
        }

        return order;
    }

}
