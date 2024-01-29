package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.TelephoneDTO;
import pfeffer.oms.inventory.domain.entities.TelephoneBO;

public class TelephoneMapper {

    public static TelephoneDTO toDTO(TelephoneBO bo) {
        TelephoneDTO dto = new TelephoneDTO();

        dto.setDdi(bo.getDdi());
        dto.setDdd(bo.getDdd());
        dto.setNumber(bo.getNumber());
        dto.setType(bo.getType());

        return dto;
    }

    public static TelephoneBO toBO(TelephoneDTO dto) {
        TelephoneBO bo = new TelephoneBO();

        bo.setDdi(dto.getDdi());
        bo.setDdd(dto.getDdd());
        bo.setNumber(dto.getNumber());
        bo.setType(dto.getType());

        return bo;
    }

}
