package pfeffer.oms.order.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.domain.exceptions.OrderException;
import pfeffer.oms.order.domain.repositories.IOrderRepository;
import pfeffer.oms.order.domain.usecases.CreateOrder;
import pfeffer.oms.order.infra.jakarta.repository.JakartaOrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderRepository {

    private final JakartaOrderRepository repository;

    @Autowired
    public OrderService(JakartaOrderRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OrderDTO createOrder(String channelId, OrderDTO dto) {
        if (!channelId.equals(dto.getChannelId())) {
            throw OrderException.DIFF_CHANNEL;
        }

        CreateOrder createOrder = new CreateOrder(repository);

        return createOrder.execute(dto);
    }

    @Override
    public OrderDTO findByOrderIdAndChannelId(String orderId, String channelId) {
        OrderDTO order = this.repository.findByOrderIdAndChannelId(orderId, channelId);

        if (order == null) {
            throw OrderException.NOT_FOUND;
        }

        return order;
    }

    @Override
    public List<OrderDTO> listAllByChannelId(String channelId) {
        List<OrderDTO> orders = this.repository.listAllByChannelId(channelId);

        if (orders == null || orders.isEmpty()) {
            throw OrderException.NOT_FOUND;
        }

        return orders;
    }

}
