package pfeffer.oms.core.domain.mappers;

import pfeffer.oms.core.domain.dtos.DocumentDTO;
import pfeffer.oms.core.domain.entities.DocumentBO;

public class DocumentMapper {

    public static DocumentDTO toDTO(DocumentBO bo) {
        DocumentDTO dto = new DocumentDTO();

        dto.setType(bo.getType());
        dto.setNumber(bo.getNumber());

        return dto;
    }

    public static DocumentBO toBO(DocumentDTO dto) {
        DocumentBO bo = new DocumentBO();

        bo.setType(dto.getType());
        bo.setNumber(dto.getNumber());

        return bo;
    }

}
