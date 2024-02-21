package pfeffer.oms.order.domain.mappers;

import pfeffer.oms.inventory.domain.mappers.AddressMapper;
import pfeffer.oms.inventory.domain.mappers.CustomerMapper;
import pfeffer.oms.order.domain.dtos.OrderDTO;
import pfeffer.oms.order.domain.entities.OrderBO;

public class OrderMapper {

    public static OrderDTO toDTO(OrderBO bo) {
        OrderDTO dto = new OrderDTO();

        dto.setOrderId(bo.getOrderId());
        dto.setChannelId(bo.getChannelId());
        dto.setLocationId(bo.getLocationId());
        dto.setCreatedAt(bo.getCreatedAt());
        dto.setUpdatedAt(bo.getUpdatedAt());

        dto.setCustomer(CustomerMapper.toDTO(bo.getCustomer()));
        dto.setBillingAddress(AddressMapper.toDTO(bo.getBillingAddress()));

        dto.setPayments(bo.getPayments().stream().map(PaymentMapper::toDTO).toList());

        dto.setPrice(bo.getPrice());
        dto.setShippingPrice(bo.getShippingPrice());

        return dto;
    }

    public static OrderBO toBO(OrderDTO dto) {
        OrderBO bo = new OrderBO();

        bo.setOrderId(dto.getOrderId());
        bo.setChannelId(dto.getChannelId());
        bo.setLocationId(dto.getLocationId());
        bo.setCreatedAt(dto.getCreatedAt());
        bo.setUpdatedAt(dto.getUpdatedAt());

        bo.setCustomer(CustomerMapper.toBO(dto.getCustomer()));
        bo.setBillingAddress(AddressMapper.toBO(dto.getBillingAddress()));

        bo.setPayments(dto.getPayments().stream().map(PaymentMapper::toBO).toList());

        bo.setPrice(dto.getPrice());
        bo.setShippingPrice(dto.getShippingPrice());

        return bo;
    }

}
