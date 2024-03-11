package pfeffer.oms.logistic.infra.jakarta.mappers;

import pfeffer.oms.logistic.domain.entities.CarrierBO;
import pfeffer.oms.logistic.infra.jakarta.model.JakartaCarrier;

public class JakartaCarrierMapper {

    public static CarrierBO toDomain(JakartaCarrier entity) {
        CarrierBO domain = new CarrierBO();

        domain.setCarrierId(entity.getCarrierId());
        domain.setName(entity.getName());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());

        return domain;
    }

    public static JakartaCarrier toEntity(CarrierBO domain) {
        JakartaCarrier entity = new JakartaCarrier();

        entity.setCarrierId(domain.getCarrierId());
        entity.setName(domain.getName());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        return entity;
    }

}
