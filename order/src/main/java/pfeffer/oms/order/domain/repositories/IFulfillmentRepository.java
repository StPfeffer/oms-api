package pfeffer.oms.order.domain.repositories;

import pfeffer.oms.order.domain.dtos.FulfillmentDTO;

import java.util.List;

public interface IFulfillmentRepository {

    FulfillmentDTO findByOrderIdChannelIdFulfillmentId(String orderId, String channelId, String fulfillmentId);

    List<FulfillmentDTO> listAllByOrderIdAndChannelid(String orderId, String channelId);

}
