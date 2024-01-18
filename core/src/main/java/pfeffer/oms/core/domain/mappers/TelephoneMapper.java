package pfeffer.oms.core.domain.mappers;

import pfeffer.oms.core.domain.dtos.TelephoneDTO;
import pfeffer.oms.core.domain.entities.TelephoneBO;

public class TelephoneMapper {

    public static TelephoneDTO toDTO(TelephoneBO bo) {
        TelephoneDTO dto = new TelephoneDTO();

        dto.setDdi(bo.getDdi());
        dto.setDdd(bo.getDdd());
        dto.setNumber(bo.getNumber());

        return dto;
    }

    public static TelephoneBO toBO(TelephoneDTO dto) {
        TelephoneBO bo = new TelephoneBO();

        bo.setDdi(dto.getDdi());
        bo.setDdd(dto.getDdd());
        bo.setNumber(dto.getNumber());

        return bo;
    }

}
