package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.AddressBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaAddress;

public class JakartaAddressMapper {

    public static JakartaAddress toEntity(AddressBO bo) {
        JakartaAddress entity = new JakartaAddress();

        entity.setZip(bo.getZip());
        entity.setNumber(bo.getNumber());
        entity.setAddress(bo.getAddress());
        entity.setAddress2(bo.getAddressComplement());
        entity.setNeighbourhood(bo.getNeighbourhood());
        entity.setCity(bo.getCity());
        entity.setState(bo.getState());
        entity.setCountry(bo.getCountry());
        entity.setLatitude(bo.getLatitude());
        entity.setLongitude(bo.getLongitude());

        return entity;
    }

    public static AddressBO toDomain(JakartaAddress entity) {
        AddressBO bo = new AddressBO();

        bo.setZip(entity.getZip());
        bo.setNumber(entity.getNumber());
        bo.setAddress(entity.getAddress());
        bo.setAddressComplement(entity.getAddress2());
        bo.setNeighbourhood(entity.getNeighbourhood());
        bo.setCity(entity.getCity());
        bo.setState(entity.getState());
        bo.setCountry(entity.getCountry());
        bo.setLatitude(entity.getLatitude());
        bo.setLongitude(entity.getLongitude());

        return bo;
    }

}
