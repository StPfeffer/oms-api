package pfeffer.oms.order.domain.repositories;

import pfeffer.oms.order.domain.dtos.OrderDTO;

import java.util.List;

public interface IOrderRepository {

    OrderDTO findByOrderIdAndChannelId(String orderId, String channelId);

    List<OrderDTO> listAllByChannelId(String channelId);

}
