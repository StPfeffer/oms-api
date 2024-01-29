package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.AddressDTO;
import pfeffer.oms.inventory.domain.entities.AddressBO;

public class AddressMapper {

    public static AddressDTO toDTO(AddressBO bo) {
        AddressDTO dto = new AddressDTO();

        dto.setZip(bo.getZip());
        dto.setNumber(bo.getNumber());
        dto.setAddress(bo.getAddress());
        dto.setAddressComplement(bo.getAddressComplement());
        dto.setNeighbourhood(bo.getNeighbourhood());
        dto.setCity(bo.getCity());
        dto.setState(bo.getState());
        dto.setCountry(bo.getCountry());
        dto.setLatitude(bo.getLatitude());
        dto.setLongitude(bo.getLongitude());

        return dto;
    }

    public static AddressBO toBO(AddressDTO dto) {
        AddressBO bo = new AddressBO();

        bo.setZip(dto.getZip());
        bo.setNumber(dto.getNumber());
        bo.setAddress(dto.getAddress());
        bo.setAddressComplement(dto.getAddressComplement());
        bo.setNeighbourhood(dto.getNeighbourhood());
        bo.setCity(dto.getCity());
        bo.setState(dto.getState());
        bo.setCountry(dto.getCountry());
        bo.setLatitude(dto.getLatitude());
        bo.setLongitude(dto.getLongitude());

        return bo;
    }

}
