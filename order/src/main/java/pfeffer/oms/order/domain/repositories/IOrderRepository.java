package pfeffer.oms.order.domain.repositories;

import pfeffer.oms.order.domain.dtos.OrderDTO;

public interface IOrderRepository {

    OrderDTO findOrderByOrderIdAndChannelId(String orderId, String channelId);

}
