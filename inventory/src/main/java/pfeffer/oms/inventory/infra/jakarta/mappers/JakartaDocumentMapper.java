package pfeffer.oms.inventory.infra.jakarta.mappers;

import pfeffer.oms.inventory.domain.entities.DocumentBO;
import pfeffer.oms.inventory.infra.jakarta.model.JakartaDocument;

public class JakartaDocumentMapper {

    public static JakartaDocument toEntity(DocumentBO bo) {
        JakartaDocument entity = new JakartaDocument();

        entity.setType(bo.getType());
        entity.setNumber(bo.getNumber());

        return entity;
    }

    public static DocumentBO toDomain(JakartaDocument entity) {
        DocumentBO bo = new DocumentBO();

        bo.setType(entity.getType());
        bo.setNumber(entity.getNumber());

        return bo;
    }

}