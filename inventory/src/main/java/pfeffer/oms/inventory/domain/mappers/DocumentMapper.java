package pfeffer.oms.inventory.domain.mappers;

import pfeffer.oms.inventory.domain.dtos.DocumentDTO;
import pfeffer.oms.inventory.domain.entities.DocumentBO;

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
