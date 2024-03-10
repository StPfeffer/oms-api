package pfeffer.oms.logistic.domain.mappers;


import pfeffer.oms.logistic.domain.dtos.CarrierDTO;
import pfeffer.oms.logistic.domain.entities.CarrierBO;

public class CarrierMapper {

    public static CarrierDTO toDTO(CarrierBO bo) {
        CarrierDTO dto = new CarrierDTO();

        dto.setCarrierId(bo.getCarrierId());
        dto.setName(bo.getName());

        return dto;
    }

    public static CarrierBO toBO(CarrierDTO dto) {
        CarrierBO bo = new CarrierBO();

        bo.setCarrierId(dto.getCarrierId());
        bo.setName(dto.getName());

        return bo;
    }

}
